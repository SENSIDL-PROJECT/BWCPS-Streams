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

class SecurityServiceGenerationStep extends GenerationStep {
	

	

	private val IFileSystemAccess fsa;
	
	
	new( IFileSystemAccess newFsa) {
		this.fsa = newFsa
	}
	
	override startGenerationTask() {
		
		this.resourcesToGenerateMapping.get(generationLanguage).execute
		
	}
	
	// This have to be done because a java-plugin-project requires java sources.
//	private def resetGenerationSettings(String projectPath, String path, String projectName) {
//		
//		javaPackagePrefix = BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX;
//		FileGenerationStep.filePath = getFilePathOf(path, projectName)
//		(fsa as JavaIoFileSystemAccess).outputPath = projectPath
//		
//	}
//	
//	private def getFilePathOf(String path, String projectName) {
//		
//		val builder = new StringBuilder(path)
//		builder.append(PATH_SEPERATOR)
//		builder.append(projectName.toLowerCase)
//		builder.append(PATH_SEPERATOR)
//		
//		builder.toString
//		
//	}
	
	/**
	 * Initializes a HashMap that maps each {@link GenerationLanguage} to a
	 * {@link IExecuter} object.
	 * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
	 */
	private def getResourcesToGenerateMapping() {
		
		val secGenerator = new NodeConfigurationProjectGenerator() 
		
		return new HashMap<GenerationLanguage, IExecuter> => [
			
			put(GenerationLanguage.KURA_PROJECT, [
				
				secGenerator.createProject
//				resetGenerationSettings(secGenerator.getProjectPath, BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH, "")
				
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
