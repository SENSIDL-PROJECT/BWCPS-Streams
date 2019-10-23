package bw_cps_code_generator.generator.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.io.FileDeleteStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl;
import bw_cps_code_generator.exception.NoBwcpsFileException;
import bw_cps_code_generator.ui.handler.GenerationHandler;

/**
 * This class checks, if the generators generate just the desired files.
 * 
 * @author Max Peters
 * 
 */
public class FileGenerationTest {
	private static File generationDirectory;
	private static Map<String, Boolean> map;
	private static String[] nodes = {"SensorCOM1", "Preprocessing" };

	/**
	 * Creates or empties the test generation directory.
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	static public void setUp() throws IOException {
		entityPackageImpl.init();
		generationDirectory = new File("test-gen/generator");
		if (!generationDirectory.exists()) {
			generationDirectory.mkdir();
		} else {
			deleteGen();
		}
		map = new HashMap<String, Boolean>();
	}

	@Before
	public void addFiles() {
		map.put("sidlTestCode.sensidl", false);
		map.put("EMeter.txt", false);
	}

	/**
	 * test class for java generator
	 * 
	 * @throws IOException
	 * @throws NoSidlFileException
	 */
	@Test
	public void javaFilesGenerationTest() throws IOException, NoBwcpsFileException {
		for (int i = 0; i < nodes.length; i++) {
			map.put(nodes[i] + ".java", false);
		}
		map.put("eMeterUtility.java", false);
		GenerationHandler.generate(generationDirectory.getPath(), "resource/generator/sidlTestCode.sidl", "Java", null);
		checkGeneratedFiles();
	}


	/**
	 * Checks if the generators generated just the desired files.
	 */
	private void checkGeneratedFiles() {
		for (String file : generationDirectory.list()) {
			if (map.containsKey(file)) {
				map.put(file, true);
			} else {
				throw new AssertionError(file + " should not get generated");
			}
		}
		for (Entry<String, Boolean> entry : map.entrySet()) {
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
}