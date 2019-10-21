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

class ProjectGenerationStep extends GenerationStep {
	
	private static val PATH_SEPERATOR = "/"
	
	private val String projectName
	private val IFileSystemAccess fsa;
	
	/**
	 * The constructor calls the needed data filtered by a
	 * concrete element-filter.
	 * @param filter - represents a base filter which can be substituted by a specific
	 * 				   subclass that filters a particular set of elements.	
	 */
	new(ElementFilter filter, IFileSystemAccess newFsa) {
		this.projectName = (filter.filterData() as StreamRepository).name
		this.fsa = newFsa
	}
	
	new(NamedElement element, IFileSystemAccess newFsa) {
		this.projectName = GenerationUtil.getEntityUpperName(element)
		this.fsa = newFsa
	}
	
	override startGenerationTask() {
		
		this.resourcesToGenerateMapping.get(generationLanguage).execute
		
	}
	
	// This have to be done because a java-plugin-project requires java sources.
	private def resetGenerationSettings(String projectPath, String path, String projectName) {
		
		javaPackagePrefix = BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX;
		FileGenerationStep.filePath = getFilePathOf(path, projectName)
		(fsa as JavaIoFileSystemAccess).outputPath = projectPath
		
	}
	
	private def getFilePathOf(String path, String projectName) {
		
		val builder = new StringBuilder(path)
		builder.append(PATH_SEPERATOR)
		builder.append(projectName.replaceAll(" ", "").toLowerCase)
		builder.append(PATH_SEPERATOR)
		
		builder.toString
		
	}
	
	/**
	 * Initializes a HashMap that maps each {@link GenerationLanguage} to a
	 * {@link IExecuter} object.
	 * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
	 */
	private def getResourcesToGenerateMapping() {
		
		val kuraGenerator = new KuraProjectGenerator(projectName) 
		
		return new HashMap<GenerationLanguage, IExecuter> => [
			
			put(GenerationLanguage.KURA_PROJECT, [
				
				kuraGenerator.createProject
				resetGenerationSettings(kuraGenerator.getProjectPath, BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH, projectName)
				
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
