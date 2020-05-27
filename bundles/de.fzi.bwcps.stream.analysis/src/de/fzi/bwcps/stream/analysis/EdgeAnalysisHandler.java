package de.fzi.bwcps.stream.analysis;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

public class EdgeAnalysisHandler extends AbstractHandler implements IHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Get Model Instance
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(!selection.isEmpty() && selection instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection)selection;
			if (ts.getFirstElement() instanceof NamedElement) {
				NamedElement selectedElement = (NamedElement)ts.getFirstElement();
				Notifier rootObj = EcoreUtil.getRootContainer(selectedElement, true);		
				if (rootObj instanceof StreamRepository) {
					StreamRepository root = (StreamRepository) rootObj;
					Collection<Node> nodes = EcoreUtil.getObjectsByType(root.getNodes(),
							entityPackage.eINSTANCE.getNode());
					//Run Bandwidth and Timeliness analysis
					List<BWCPSAnalysisReport> result = new BWCPSBandwithAnalyzer().run(nodes);
					result.addAll(new BWCPSTimelinessAnalyzer().run(root.getStreams()));
					// TODO: correctly display analysis results
					for(BWCPSAnalysisReport r : result) {
						System.out.println(r.toString());
					}
				}
			}
		}
		return null;
	}
}
