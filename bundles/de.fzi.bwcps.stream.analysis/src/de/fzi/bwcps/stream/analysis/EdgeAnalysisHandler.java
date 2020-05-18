package de.fzi.bwcps.stream.analysis;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

public class EdgeAnalysisHandler extends AbstractHandler implements IHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Get Model Instance
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(!selection.isEmpty() && selection instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection)selection;
			if (ts.getFirstElement() instanceof NamedElement)
				new BWCPSAnalyzer().start((NamedElement)ts.getFirstElement());
		}
		return null;
	}
}
