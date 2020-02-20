package de.fzi.bwcpsgenerator.generator

import org.eclipse.xtext.generator.OutputConfigurationProvider

/*
 * By now this class implements the same behaviour like the default
 * implementation of the OutputConfigurationProvider. It defines the
 * an entry to specify a different generation location. 
 */
class BwcpsOutputConfigurationProvider extends OutputConfigurationProvider {
	public static val BWCPS_GEN = "./src-gen"
	
	override getOutputConfigurations() {
		super.getOutputConfigurations() => [
			head.outputDirectory = BWCPS_GEN
		]
	}	
}
