package de.fzi.bwcpsgenerator.generator.generationstep

import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import de.fzi.bwcpsgenerator.generator.BwCPSConstants
import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import de.fzi.bwcpsgenerator.generator.GenerationUtil
import de.fzi.bwcpsgenerator.generator.IExecuter
import de.fzi.bwcpsgenerator.generator.metamodel.ElementManager
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static de.fzi.bwcpsgenerator.generator.generationstep.FileGenerationStep.*

class DeploymentPackageGenerationStep extends GenerationStep {
	
	static val PATH_SEPERATOR = "/"
	
	val String projectName
	val IFileSystemAccess fsa;
	StreamRepository streamRepo
	
	/**
	 * The constructor calls the needed data filtered by a
	 * concrete element-filter.
	 * @param filter - represents a base filter which can be substituted by a specific
	 * 				   subclass that filters a particular set of elements.	
	 */
	new(ElementManager filter, IFileSystemAccess newFsa) {
		this.streamRepo = filter.filterData()
		this.projectName = GenerationUtil.getEntityUpperName(streamRepo)
		this.fsa = newFsa
	}
	
	override startGenerationTask() {
		
//		this.resourcesToGenerateMapping.get(generationLanguage).execute
		
	}
	
	// This have to be done because a java-plugin-project requires java sources.
	private def resetGenerationSettings(String projectPath, String path) {
		
		javaPackagePrefix = BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX;
		FileGenerationStep.filePath = getFilePathOf(path)
		(fsa as JavaIoFileSystemAccess).outputPath = projectPath
		
	}
	
	private def getFilePathOf(String path) {
		
		val builder = new StringBuilder(path)
		builder.append(PATH_SEPERATOR)
		builder.append(this.projectName)
		builder.append(PATH_SEPERATOR)
		
		builder.toString
		
	}
	
	/**
	 * Initializes a HashMap that maps each {@link GenerationLanguage} to a
	 * {@link IExecuter} object.
	 * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
	 */
	private def getResourcesToGenerateMapping() {
		//TODO
	}
	
}
