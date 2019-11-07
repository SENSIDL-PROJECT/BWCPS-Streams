package de.fzi.bwcpsgenerator.generator.generationstep

import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import de.fzi.bwcpsgenerator.exception.ExistingProjectException
import de.fzi.bwcpsgenerator.generator.BwCPSConstants
import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import de.fzi.bwcpsgenerator.generator.IExecuter
import de.fzi.bwcpsgenerator.generator.factory.java.JavaGenerator
import de.fzi.bwcpsgenerator.generator.factory.projects.NodeConfigProjectGenerator
import de.fzi.bwcpsgenerator.generator.metamodel.StreamRepositoryManager
import java.util.HashMap
import org.apache.log4j.Logger
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static de.fzi.bwcpsgenerator.generator.generationstep.FileGenerationStep.*
import de.fzi.bwcpsgenerator.generator.factory.sidl.DataTypeGenerator

class NodeConfigGenerationStep extends GenerationStep {

	val static logger = Logger.getLogger(NodeConfigGenerationStep)
	static val PATH_SEPERATOR = "/"
	val IFileSystemAccess fsa;
	StreamRepository streamRepo;


	new(StreamRepository streamRepo, IFileSystemAccess newFsa) {
		this.fsa = newFsa
		this.streamRepo = streamRepo
	}

		// This has to be done because a java-plugin-project requires java sources.
	private def setGenerationSettings(String projectPath, String path, String projectName) {
		
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
	override startGenerationTask() {

		this.resourcesToGenerateMapping.get(generationLanguage).execute

	}

	/**
	 * Initializes a HashMap that maps each {@link GenerationLanguage} to a
	 * {@link IExecuter} object.
	 * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
	 */
	private def getResourcesToGenerateMapping() {

		val generator = new NodeConfigProjectGenerator(StreamRepositoryManager.needsSecurityPackage(streamRepo))
		val JavaGenerator jgenerator = new JavaGenerator(GenerationLanguage.OSGI_BUNDLES, javaPackagePrefix)
		val DataTypeGenerator sgenerator = new DataTypeGenerator()
		return new HashMap<GenerationLanguage, IExecuter> => [

			put(GenerationLanguage.OSGI_BUNDLES, [
				try {
					generator.createProject
				} catch (ExistingProjectException e) {
					logger.info(e.message);
				}
				filesToGenerate => [
					putAll(jgenerator.generateDTO(streamRepo))
				]
				sgenerator.generate(streamRepo)
				setGenerationSettings(NodeConfigProjectGenerator.projectPath, BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH, BwCPSConstants.NODECONFIG_Project_NAME)
				
			])

		]
	}

}
