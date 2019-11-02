package de.fzi.bwcpsgenerator.generator.generationstep

import java.util.HashMap
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static de.fzi.bwcpsgenerator.generator.generationstep.FileGenerationStep.*
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import de.fzi.bwcpsgenerator.generator.BwCPSConstants
import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import de.fzi.bwcpsgenerator.generator.IExecuter
import de.fzi.bwcpsgenerator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcpsgenerator.generator.factory.projects.OsgiBundleGenerator
import de.fzi.bwcpsgenerator.generator.metamodel.ElementManager
import org.apache.log4j.Logger
import de.fzi.bwcpsgenerator.exception.ExistingProjectException
import java.util.List

class ProjectGenerationStep extends GenerationStep {
	
	val static logger = Logger.getLogger(ProjectGenerationStep)
	static val PATH_SEPERATOR = "/"
	
	val String projectName
	val IFileSystemAccess fsa
	List<String> neededBundles
	
	/**
	 * The constructor calls the needed data filtered by a
	 * concrete element-filter.
	 * @param filter - represents a base filter which can be substituted by a specific
	 * 				   subclass that filters a particular set of elements.	
	 */
	new(ElementManager filter, IFileSystemAccess newFsa) {
		this.projectName = (filter.filterData() as StreamRepository).name
		this.fsa = newFsa
		skipProject = false
	}
	
	new(NamedElement element, IFileSystemAccess newFsa, List<String> neededBundles) {
		this.projectName = GenerationUtil.getEntityUpperName(element)
		this.fsa = newFsa
		skipProject = false
		this.neededBundles = neededBundles
	}
	
	override startGenerationTask() {
		
		this.resourcesToGenerateMapping.get(generationLanguage).execute
		
	}
	
	// This has to be done because a java-plugin-project requires java sources.
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
		
		val bundleGenerator = new OsgiBundleGenerator(projectName, kuraAdapted, neededBundles) 
		
		return new HashMap<GenerationLanguage, IExecuter> => [
			
			put(GenerationLanguage.OSGI_BUNDLES, [
				try {
					bundleGenerator.createProject
				} catch (ExistingProjectException e) {
					skipProject = true
					logger.info(e.message);
				}
				
				resetGenerationSettings(OsgiBundleGenerator.projectPath, BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH, projectName)
				
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
