package de.fzi.bwcps.stream.analysis.extensions;

import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

/**
 * Menu contribution that populates the 'BWCPS Analysis' context menu dynamically with
 * algorithms provided at the 'de.fzi.bwcps.stream.analysis.extension' extension point.
 * 
 * @author Fabian Scehytt
 */
public class AnalysisMenuContributions extends CompoundContributionItem {

	public AnalysisMenuContributions() {
	}

	public AnalysisMenuContributions(String id) {
		super(id);
	}

	@Override
	protected IContributionItem[] getContributionItems() {
		List<IConfigurationElement> extensions = BWCPSExtensionsHandler.getExtensions();
		IContributionItem[] contributions = new IContributionItem[extensions.size()];
		
		for (int i = 0; i < extensions.size(); i++) {
			if(extensions.get(i) == null) continue;
			HashMap<String, String> commandParams = new HashMap<>();
			commandParams.put("de.fzi.bwcps.stream.analysis.name", extensions.get(i).getAttribute("id"));
			CommandContributionItemParameter params = new CommandContributionItemParameter(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),	//Service Locator
					extensions.get(i).getAttribute("id"), 	//id
					"de.fzi.bwcps.stream.analysis.start", 	//commandId
					commandParams, 	//parameters
					null, 			//icon
					null, 			//disabledIcon
					null, 			//hoverIcon
					extensions.get(i).getAttribute("menu_label"), 		//label
					extensions.get(i).getAttribute("menu_mnemonic"), 	//mnemonic
					extensions.get(i).getAttribute("menu_tooltip"), 	//tooltip
					CommandContributionItem.STYLE_PUSH, 				//style
					null, 	//helpContextId
					true 	//visibleEnabled
			);
			contributions[i] = new CommandContributionItem(params);
		}
		return contributions;
	}
	
	

}
