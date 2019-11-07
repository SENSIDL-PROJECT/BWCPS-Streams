package de.fzi.bwcpsgenerator.generator.generationstep

import java.util.HashMap
import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import de.fzi.bwcpsgenerator.generator.BwCPSConstants

/**
 * The GenerationStep-class is the superclass of different generation steps. 
 * There exist a couple of subclasses which forms together the general generation-process.
 */
abstract class GenerationStep {	
	protected static var HashMap<String, CharSequence> filesToGenerate
	protected static var GenerationLanguage generationLanguage
	protected static var String javaPackagePrefix
	protected static var boolean skipProject = false
	protected static var boolean kuraAdapted = false

	/**
	 * This static method is used to reset the generation configurations for a new generation task.
	 * @param newGenerationLanguage Corresponds to the desired language that you want to generate.
	 */
	def static void setGlobalSettings(GenerationLanguage newGenerationLanguage) {
		
		resetFilesToGenerate
		if(newGenerationLanguage == GenerationLanguage.KURA_BUNDLES) {
			generationLanguage = GenerationLanguage.OSGI_BUNDLES
			kuraAdapted = true
		} else {
			generationLanguage = newGenerationLanguage
			kuraAdapted = false
		}
		javaPackagePrefix = BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX
		
	}
	
	protected def static void setJavaPackagePrefix(String newJavaPackagePrefix) {
		
		javaPackagePrefix = newJavaPackagePrefix
		
	}
	
	def static resetFilesToGenerate() {
		
		if (filesToGenerate === null) {
			filesToGenerate = new HashMap
		} else {
			filesToGenerate.clear
		}

	}
	
	def static setFilesToGenerate(HashMap<String, CharSequence> newFilesToGenerate) {
		
		filesToGenerate = newFilesToGenerate

	}
	def static getFilesToGenerate() {
		
		filesToGenerate 

	}
	/**
	 * Starts the generation task.
	 */
	abstract def void startGenerationTask()
	
}
