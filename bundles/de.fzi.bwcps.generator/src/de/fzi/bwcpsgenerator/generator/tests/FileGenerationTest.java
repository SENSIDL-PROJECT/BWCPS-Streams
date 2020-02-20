package de.fzi.bwcpsgenerator.generator.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileDeleteStrategy;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;

import de.fzi.bwcpsgenerator.exception.MetamodelException;
import de.fzi.bwcpsgenerator.generator.generationstep.FileGenerationStep;
import de.fzi.sensidl.language.ui.exception.NoSidlFileException;

/**
 * This class checks, if the generators generate just the desired files.
 * 
 * @author Max Peters
 * 
 */
public class FileGenerationTest {
	private static File generationDirectory;
	private static Map<String, Boolean> fileIsGenerated;
	private HashMap<String, CharSequence> filesToGenerate;
	private static String[] nodes = { "SensorCOM1", "Preprocessing" };
	private static String PATH = "test-gen/generator/";
	
	static FileGenerationStep fileGenerationStep;
	/**
	 * Creates or empties the test generation directory.
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	static public void setUp() throws IOException {
		generationDirectory = new File("test-gen/generator");
		if (!generationDirectory.exists()) {
			generationDirectory.mkdir();
		} else {
			deleteGen();
		}

		final JavaIoFileSystemAccess fsa = new JavaIoFileSystemAccess();
		
		fsa.setOutputPath(System.getProperty("user.dir"));
		
		
		// inject fsa
		Guice.createInjector(new AbstractGenericModule() {
			@SuppressWarnings("unused")
			public Class<? extends IEncodingProvider> bindIEncodingProvider() {
				return IEncodingProvider.Runtime.class;
			}
		}).injectMembers(fsa);
		
		fileGenerationStep = new FileGenerationStep(fsa);
	}

	@Before
	public void addFiles() {
		fileIsGenerated = new HashMap<String, Boolean>();
		filesToGenerate = new HashMap<String, CharSequence>();
		resetGenerationSettings();

	}

	/**
	 * test class for java generator
	 * 
	 * @throws IOException
	 * @throws MetamodelException
	 * @throws NoSidlFileException
	 */
	@Test
	public void javaFilesGenerationTest() {
		for (int i = 0; i < nodes.length; i++) {
			filesToGenerate.put(nodes[i] + ".java", nodes[i] + ".java");
			fileIsGenerated.put(nodes[i] + ".java", false);
		}		

		FileGenerationStep.setFilesToGenerate(filesToGenerate);
		fileGenerationStep.startGenerationTask();
		checkGeneratedFiles();
	}

	@After
	public void tearDown() throws IOException {
		deleteGen();
		fileIsGenerated.clear();
		filesToGenerate.clear();
	}
	@AfterClass
	static public void deleteDir() throws IOException {
		File file = generationDirectory.getParentFile();
		FileDeleteStrategy.FORCE.delete(generationDirectory);
		FileDeleteStrategy.FORCE.delete(file);
	}	
	/**
	 * Checks if the generators generated just the desired files.
	 */
	private void checkGeneratedFiles() {
		for (String file : generationDirectory.list()) {
			if (fileIsGenerated.containsKey(file)) {
				fileIsGenerated.put(file, true);
			} else {
				throw new AssertionError(file + " should not get generated");
			}
		}
		for (Entry<String, Boolean> entry : fileIsGenerated.entrySet()) {
			if (!entry.getValue()) {
				throw new AssertionError(entry.getKey() + " is missing");
			}
		}
	}

	/**
	 * Removes all files in the test generation directory.
	 * 
	 * @throws IOException
	 */
	private static void deleteGen() throws IOException {
		for (File file : generationDirectory.listFiles()) {
			FileDeleteStrategy.FORCE.delete(file);
		}
	}

	private void resetGenerationSettings() {
		FileGenerationStep.filePath = PATH;
		FileGenerationStep.resetFilesToGenerate();
	}
}