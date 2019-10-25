package bw_cps_code_generator.generator.generationstep

import java.util.ArrayList
import java.util.HashMap
import org.apache.commons.io.FilenameUtils
import org.apache.log4j.Logger
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.core.resources.IResource
import bw_cps_code_generator.generator.generationstep.GenerationStep
import bw_cps_code_generator.generator.factory.sidl.SensIDLInvoker
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import bw_cps_code_generator.generator.GenerationUtil
import java.util.List
import java.util.Arrays

/**
 * The FileGenerationStep is a concrete subclass of the GenerationStep class. 
 * The main task of the class encapsulate the responsibility of the actual code generation.
 */
class FileGenerationStep extends GenerationStep {
	private val static logger = Logger.getLogger(FileGenerationStep)
//	private val static LINE_LENGTH = 80; 
//	private val static SEPARATION_STRING = ", "
//	private val static UNIFIED_TAB_DISTANCE = "\t\t\t\t\t\t\t\t"
//	private val static START_SYMBOL = "*"
	private val static DEFAUL_FILE_PATH = ""
	private val static TEXT_FILE_EXTENSION = "txt"
	private val static SIDL_FILE_EXTENSION = "sidl"

	private String projectName = ""
	val IFileSystemAccess fsa;

	public static var String filePath;

	private var HashMap<String, ArrayList<String>> fileCache;

	/**
	 * The constructor is used to initialize a new IFileSystemAccess-object.
	 * @param newFsa Corresponds to the IFileSystemAccess-object which is needed to generate the different files.
	 */
	new(IFileSystemAccess newFsa) {
		fsa = newFsa
		fileCache = new HashMap
		filePath = DEFAUL_FILE_PATH
	}

	new(NamedElement element, IFileSystemAccess newFsa) {
		this.projectName = GenerationUtil.getEntityUpperName(element)
		this.fsa = newFsa
		fileCache = new HashMap
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
		for (file : filesToGenerate.keySet) {
			logger.info("Start with code-generation of file " + file)
//			
//			insertVersioningCommentTo(file)
//			
			fsa.generateFile(getFilePathOf(file), getContentOf(file))
			logger.info("File " + file + " was successfully generated")
			if (file.isSidlFile) {
				// SensIDL Call TODO checks
				logger.info("Invoke SensIDL GenerationHandler")
				SensIDLInvoker.generate(
					ResourcesPlugin.workspace.root.location + "/" + projectName + "/src/" +
						file.substring(0, file.length - (SIDL_FILE_EXTENSION.length + 1)).toLowerCase,
					ResourcesPlugin.workspace.root.location + "/" + projectName + "/" + getFilePathOf(file)
				)
			}

		}

		refreshWorkspace
	}

	private def refreshWorkspace() {
		// Don't refresh the workspace if not executed in an Eclipse Environment
		try {
			Class.forName("org.eclipse.core.resources.ResourcesPlugin")
		} catch (Exception e) {
			return
		}
		if(isJUnitTest) {
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

		} // TODO check
		else if (isSidlFile(file)) {
			return "resource/" + file
		}

		filePath + file

	}

	def isTextFile(String file) {

		FilenameUtils.getExtension(file).equals(TEXT_FILE_EXTENSION)

	}

	def isSidlFile(String file) {

		FilenameUtils.getExtension(file).equals(SIDL_FILE_EXTENSION)

	}

}
