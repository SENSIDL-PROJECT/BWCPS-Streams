package bw_cps_code_generator.generator.generationstep

import java.util.HashMap
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static bw_cps_code_generator.generator.generationstep.FileGenerationStep.*
import bw_cps_code_generator.generator.elementfilter.ElementFilter
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import bw_cps_code_generator.generator.BwCPSConstants
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import bw_cps_code_generator.generator.IExecuter
import bw_cps_code_generator.generator.GenerationUtil
import bw_cps_code_generator.generator.factory.projects.KuraProjectGenerator
import java.util.List
import java.util.ArrayList
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import bw_cps_code_generator.generator.factory.projects.NodeConfigurationProjectGenerator

class NodeConfigurationGenerationStep extends GenerationStep {
	

	

	private val IFileSystemAccess fsa;
	private boolean needsSecurityPackage;
	
	new(IFileSystemAccess newFsa, boolean needsSecurityPackage) {
		this.fsa = newFsa
		this.needsSecurityPackage = needsSecurityPackage
	}
	
	override startGenerationTask() {
		
		this.resourcesToGenerateMapping.get(generationLanguage).execute
		
	}
	
	/**
	 * Initializes a HashMap that maps each {@link GenerationLanguage} to a
	 * {@link IExecuter} object.
	 * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
	 */
	private def getResourcesToGenerateMapping() {
		
		val secGenerator = new NodeConfigurationProjectGenerator(needsSecurityPackage) 
		
		return new HashMap<GenerationLanguage, IExecuter> => [
			
			put(GenerationLanguage.KURA_PROJECT, [
				
				secGenerator.createProject()
				
			])
			
//				put(GenerationLanguage.MAVEN_PROJECT, [
//				
//				mavenGenerator.createProject
//				resetGenerationSettings(mavenGenerator.projectPath, BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH)
//				
//			])
						
		]
	}
	
}
