package de.fzi.bwcps.stream.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.fzi.bwcps.stream.analysis.extensions.BWCPSExtensionsHandler;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReportType;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;

/**
 * Handler for the de.fzi.bwcps.stream.analysis.start command.
 * Runs BWCPS analyses from the tree view and reports results in the problem marker view.
 * 
 * @author Fabian Scheytt
 *
 */
public class EdgeAnalysisHandler extends AbstractHandler implements IHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Determine analysis to run
		String task = event.getParameter("de.fzi.bwcps.stream.analysis.name");
		
		// Get Model Instance
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if(!selection.isEmpty() && selection instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection)selection;
			if (ts.getFirstElement() instanceof NamedElement) {
				NamedElement selectedElement = (NamedElement)ts.getFirstElement();
				Notifier rootObj = EcoreUtil.getRootContainer(selectedElement, true);		
				if (rootObj instanceof StreamRepository) {
					StreamRepository root = (StreamRepository) rootObj;
					
					//Run analysis and display analysis results
					List<BWCPSAnalysisReport> result = runAnalysis(task, root);
					clearResourceMarkers(root.eResource().getURI());
					for(BWCPSAnalysisReport r : result) {
						handleResult(r);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Run analysis on root element of StreamRepository
	 * @param task 'all' or the id of an BWCPS analysis algorithm
	 * @param root Root stream repository
	 * @return BWCPSAnalysisReports
	 */
	private List<BWCPSAnalysisReport> runAnalysis(String task, StreamRepository root) {
		List<BWCPSAnalysisReport> result = new LinkedList<>();
		List<IConfigurationElement> extensions = BWCPSExtensionsHandler.getExtensions();
		if(task.equals("all")) {
			for (IConfigurationElement ext: extensions) {
				try {
					result.addAll(runAnalysis(
							instantiateAlgorithm(ext),
							root)
					);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		} else {
			IConfigurationElement ext = extensions.stream()
					.filter((e) -> task.equals(e.getAttribute("id"))).findFirst().orElse(null);
			if (ext != null) {
				try {
					result.addAll(runAnalysis(
							instantiateAlgorithm(ext),
							root)
					);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}			
		}
		return result;
	}
	
	/**
	 * Runs analysis on root element of StreamRepository with the given BWCPSAnalysis algorithm
	 * @param <T>
	 * @param analysis Concrete algorithm
	 * @param root Root stream repository
	 * @return BWCPSAnalysisReports
	 */
	@SuppressWarnings("unchecked")
	private <T extends NamedElement> List<BWCPSAnalysisReport> runAnalysis(BWCPSAnalysis<T> analysis, StreamRepository root) {
		Collection<T> elements = new ArrayList<>();
		EClass type = analysis.getBWCPSElementType();
		root.eAllContents().forEachRemaining((e) -> {if(type.isInstance(e)) elements.add((T) e);});
		return analysis.run(elements);
		
	}
	
	private void clearResourceMarkers(URI resourceURI) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourceURI.toPlatformString(true)));
		int depth = IResource.DEPTH_INFINITE;
	   try {
		   file.deleteMarkers(EValidator.MARKER, true, depth);
	   } catch (CoreException e) {}
	}
 
	/**
	 * Creates problem markers for analysis results
	 * @param r
	 */
	private void handleResult(BWCPSAnalysisReport r) {
		String targetPath = r.getTarget().eResource().getURI().toPlatformString(true);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(targetPath));
		IMarker marker;
		try {
			marker = file.createMarker(EValidator.MARKER);
			if (marker.exists()) {
			         marker.setAttribute(IMarker.MESSAGE, r.getMessage());
			         marker.setAttribute(IMarker.SEVERITY, mapReportToMarkerSevertiy(r.getType()));
			         marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			         marker.setAttribute(IMarker.LOCATION,
			        		 r.getTarget().eClass().getName() + "::" + r.getTarget().getName());
			         marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(r.getTarget()).toString());
			}
		} catch (CoreException e) {}
		if (r.getDetailedReports() != null && !r.getDetailedReports().isEmpty()) {
			for(BWCPSAnalysisReport detailedReport : r.getDetailedReports()) {
				handleResult(detailedReport);
			}
		}
	}
	
	private int mapReportToMarkerSevertiy(BWCPSAnalysisReportType type) {
		switch (type) {
		case INFO:
			return IMarker.SEVERITY_INFO;
		case WARNING:
			return IMarker.SEVERITY_WARNING;
		case ERROR:
		default:
			return IMarker.SEVERITY_ERROR;
		}
	}
	
	/**
	 * Instantiates BWCPS analysis algorithm from an extension IConfigurationElement
	 * @param <T> generic type for BWCPS analysis algorithm
	 * @param extension
	 * @return Instantiated algorithm
	 * @throws CoreException
	 */
	@SuppressWarnings({"unchecked"})
	private <T extends NamedElement> BWCPSAnalysis<T> instantiateAlgorithm(IConfigurationElement extension) throws CoreException {
			return (BWCPSAnalysis<T>) extension.createExecutableExtension("algorithm");
	}
}
