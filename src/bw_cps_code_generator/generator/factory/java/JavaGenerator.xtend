package bw_cps_code_generator.generator.factory.java

import java.util.List
import org.eclipse.emf.ecore.EObject
import bw_cps_code_generator.generator.factory.ICodeGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import java.util.HashMap

/**
 * The JavaGenerator represents a concrete implementation of The ICodeGenerator and implements the 
 * code-generator for the language Java.
 * 
 */
class JavaGenerator implements ICodeGenerator {
	
	override generateDTO(StreamRepository streamRepo) {
		val filesToGenerate = new HashMap

		filesToGenerate.putAll(new JavaStreamRepositoryGenerator(streamRepo).generate)
		if (streamRepo.streams != null) {
			filesToGenerate.putAll(new JavaStreamGenerator(streamRepo.streams).generate);
		}
		if (streamRepo.nodelinks != null) {
		//	generateNodelinks();
		}
				if (streamRepo.nodes != null) {
		//	generateNodes();
		}
				if (streamRepo.nodeTypes != null) {
		//	generateNodetypes();
		}
				if (streamRepo.container != null) {
		//	generateContainer();
		}
		filesToGenerate
	}

}
