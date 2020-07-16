package de.fzi.bwcps.stream.analysis.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;

import de.fzi.bwcps.stream.analysis.BWCPSAnalysis;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Utility class for the 'de.fzi.bwcps.stream.analysis.extension' extension point
 * 
 * @author Fabian Scheytt
 */
public class BWCPSExtensionsHandler {
	
	private static String extensionID = "de.fzi.bwcps.stream.analysis.extension";
	
	/**
	 * Iterates all extensions at the bwcps analysis extension point and returns
	 * a list of valid extensions as IConfigurationElements.
	 * @return List of IConfigurationElements
	 */
	public static List<IConfigurationElement> getExtensions() {		
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IExtensionPoint ep = reg.getExtensionPoint(extensionID);
		IExtension[] extensions = ep.getExtensions();
		ArrayList<IConfigurationElement> contributors = new ArrayList<>();
		for (int i = 0; i < extensions.length; i++) {
			IExtension ext = extensions[i];
			IConfigurationElement[] ce = ext.getConfigurationElements();
			for(IConfigurationElement c : ce) {
				if( c == null || c.getName() != "algorithm")
					continue;
				
				try {
					if(c.getAttribute("id") == null || 
							c.getAttribute("menu_label") == null ||
							!(c.createExecutableExtension("algorithm") instanceof BWCPSAnalysis))
						continue;		    
				} catch (CoreException e) {
					// Algorithm not set correctly
					continue;
				}
				contributors.add(c);
			}
		}
		return contributors;
	}
}
