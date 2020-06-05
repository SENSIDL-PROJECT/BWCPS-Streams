package de.fzi.bwcps.stream.analysis;

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
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReportType;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

public class EdgeAnalysisHandler extends AbstractHandler implements IHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Get Model Instance
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		// Determine analysis to run
		String tasks = event.getParameter("de.fzi.bwcps.stream.analysis.name");
		if(!selection.isEmpty() && selection instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection)selection;
			if (ts.getFirstElement() instanceof NamedElement) {
				NamedElement selectedElement = (NamedElement)ts.getFirstElement();
				Notifier rootObj = EcoreUtil.getRootContainer(selectedElement, true);		
				if (rootObj instanceof StreamRepository) {
					StreamRepository root = (StreamRepository) rootObj;
					
					//Run Bandwidth and/or Timeliness analysis and display analysis results
					List<BWCPSAnalysisReport> result = runAnalysis(tasks, root);
					clearResourceMarkers(root.eResource().getURI());
					for(BWCPSAnalysisReport r : result) {
						handleResult(r);
					}
				}
			}
		}
		return null;
	}
	
	private List<BWCPSAnalysisReport> runAnalysis(String tasks, StreamRepository root) {
		List<BWCPSAnalysisReport> result = new LinkedList<>();
		switch(tasks) {
			case "throughput":
				Collection<Node> nodes = EcoreUtil.getObjectsByType(root.getNodes(),
						entityPackage.eINSTANCE.getNode());
				result = new BWCPSBandwithAnalyzer().run(nodes);
				break;
			case "timeliness":
				Collection<Stream> streams = EcoreUtil.getObjectsByType(root.getStreams(),
						entityPackage.eINSTANCE.getStream());
				result = new BWCPSTimelinessAnalyzer().run(streams);
				break;
			case "all":
				result.addAll(runAnalysis("throughput", root));
				result.addAll(runAnalysis("timeliness", root));
				break;
		}
		return result;
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
}
