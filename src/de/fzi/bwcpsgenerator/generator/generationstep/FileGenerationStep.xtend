package de.fzi.bwcpsgenerator.generator.generationstep

import java.util.Arrays
import java.util.List
import org.apache.commons.io.FilenameUtils
import org.apache.log4j.Logger
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * The FileGenerationStep is a concrete subclass of the GenerationStep class. 
 * The main task of the class encapsulate the responsibility of the actual code generation.
 */
class FileGenerationStep extends GenerationStep {
	val static logger = Logger.getLogger(FileGenerationStep)
	val static DEFAUL_FILE_PATH = ""
	val static TEXT_FILE_EXTENSION = "txt"
	val static XML_FILE_EXTENSION = "xml"
	val IFileSystemAccess fsa;

	public static var String filePath;

	

	/**
	 * The constructor is used to initialize a new IFileSystemAccess-object.
	 * @param newFsa Corresponds to the IFileSystemAccess-object which is needed to generate the different files.
	 */
	new(IFileSystemAccess newFsa) {
		fsa = newFsa
		filePath = DEFAUL_FILE_PATH
	}

//	
//	public static def setFilePath(String newFilePath) {
//		
//		filePath = newFilePath
//		
//	}
//	
	/**
	 * @see GenerationStep#startGenerationTask()
	 */
	override startGenerationTask() {
		if (!skipProject) {
			for (file : filesToGenerate.keySet) {
				logger.info("Start with code-generation of file " + file)
//			
//			insertVersioningCommentTo(file)
//			
				fsa.generateFile(getFilePathOf(file), getContentOf(file))
				logger.info("File " + file + " was successfully generated")

			}

			refreshWorkspace

		}
	}

	private def refreshWorkspace() {
		// Don't refresh the workspace if not executed in an Eclipse Environment
		try {
			Class.forName("org.eclipse.core.resources.ResourcesPlugin")
		} catch (Exception e) {
			return
		}
		if (isJUnitTest) {
			return
		}
		ResourcesPlugin.getWorkspace().getRoot().getProjects().forEach [ eachProject |
			eachProject.refreshLocal(IResource.DEPTH_INFINITE, null)
		]

	}

	private def boolean isJUnitTest() {
		var StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace()
		var List<StackTraceElement> list = Arrays.asList(stackTrace)
		for (StackTraceElement element : list) {
			if (element.getClassName().startsWith("org.junit.")) {
				return true
			}
		}
		return false
	}

	private def getContentOf(String file) {

		filesToGenerate.get(file)

	}

	private def getFilePathOf(String file) {

		if (isTextFile(file)) {

			return file

		} else if (isXmlFile(file)) {
			return "OSGI-INF/metatype/" + file
		}

		filePath + file

	}

	def isTextFile(String file) {

		FilenameUtils.getExtension(file).equals(TEXT_FILE_EXTENSION)

	}
	def isXmlFile(String file) {

		FilenameUtils.getExtension(file).equals(XML_FILE_EXTENSION)

	}
}
