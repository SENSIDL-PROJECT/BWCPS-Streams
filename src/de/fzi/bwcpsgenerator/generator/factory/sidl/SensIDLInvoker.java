package de.fzi.bwcpsgenerator.generator.factory.sidl;
import java.io.FileNotFoundException;

import de.fzi.sensidl.language.ui.exception.NoSidlFileException;

public class SensIDLInvoker {
	public static void generate(String filePath, String file) {
		 try {
			de.fzi.sensidl.language.ui.handler.GenerationHandler.generate(filePath, file, "Java", null);
		} catch (FileNotFoundException | NoSidlFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
