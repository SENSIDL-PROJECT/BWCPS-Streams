package bw_cps_code_generator.generator.generationstep

import bw_cps_code_generator.exception.ExistingProjectException
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import bw_cps_code_generator.generator.IExecuter
import bw_cps_code_generator.generator.factory.projects.NodeConfigurationProjectGenerator
import java.util.HashMap
import org.apache.log4j.Logger
import bw_cps_code_generator.generator.factory.java.JavaGenerator
import java.util.List
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import bw_cps_code_generator.generator.factory.sidl.SidlGenerator
import bw_cps_code_generator.generator.metamodelmanager.StreamRepositoryManager
import bw_cps_code_generator.generator.BwCPSConstants
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess

class NodeConfigurationGenerationStep extends GenerationStep {

	val static logger = Logger.getLogger(NodeConfigurationGenerationStep)
	private static val PATH_SEPERATOR = "/"
	private val IFileSystemAccess fsa;
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

		val generator = new NodeConfigurationProjectGenerator(StreamRepositoryManager.needsSecurityPackage(streamRepo))
		val JavaGenerator jgenerator = new JavaGenerator(GenerationLanguage.OSGI_BUNDLES, javaPackagePrefix)
		val SidlGenerator sgenerator = new SidlGenerator()
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
				setGenerationSettings(NodeConfigurationProjectGenerator.projectPath, BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH, BwCPSConstants.NODECONFIG_Project_NAME)
				
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
