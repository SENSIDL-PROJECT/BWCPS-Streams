package bw_cps_code_generator.generator.factory.java

import java.util.List
import org.eclipse.emf.ecore.EObject
import bw_cps_code_generator.generator.factory.ICodeGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import java.util.HashMap
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import java.util.stream.Collectors
import bw_cps_code_generator.generator.GenerationUtil

/**
 * The JavaGenerator represents a concrete implementation of The ICodeGenerator and implements the 
 * code-generator for the language Java.
 * 
 */
class JavaGenerator implements ICodeGenerator {
	
	GenerationLanguage generationlanguage
	private var String packagePrefix
	
	new (GenerationLanguage generationLanguage, String packagePrefix) {
		this.packagePrefix = packagePrefix
		this.generationlanguage = generationLanguage	
	}
	override generateDTO(NamedElement element) {
		val filesToGenerate = new HashMap
		switch generationlanguage {
			case GenerationLanguage.OSGI_BUNDLES:
			{
				val container = element as NodeContainer
				val nodeTypes = container.nodes.map(node| node.nodetype)
						.stream.distinct.collect(Collectors.toList())
				if (nodeTypes != null && !nodeTypes.empty)
					filesToGenerate.putAll(new JavaNodeTypeGenerator(GenerationUtil.getEntityUpperName(container), nodeTypes, packagePrefix).generate)
			}
			
			default:			
			{
				val streamRepo = element as StreamRepository
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
			}

		}
		filesToGenerate


	}

}
