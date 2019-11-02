package de.fzi.bwcpsgenerator.generator.factory.java

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import de.fzi.bwcpsgenerator.generator.BwCPSConstants
import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import de.fzi.bwcpsgenerator.generator.factory.ICodeGenerator
import java.util.HashMap

/**
 * The JavaGenerator represents a concrete implementation of The ICodeGenerator and implements the 
 * code-generator for the language Java.
 * 
 */
class JavaGenerator implements ICodeGenerator {
	
	GenerationLanguage generationlanguage
	var String packagePrefix
	
	new (GenerationLanguage generationLanguage, String packagePrefix) {
		this.packagePrefix = packagePrefix
		this.generationlanguage = generationLanguage	
	}
	override generateDTO(NamedElement element) {
		val filesToGenerate = new HashMap
		switch generationlanguage {
			case GenerationLanguage.OSGI_BUNDLES:
			{
				val nodeTypes = (element as StreamRepository).nodeTypes
				if (nodeTypes !== null && !nodeTypes.empty)
					filesToGenerate.putAll(new JavaNodeTypeGenerator(BwCPSConstants.NODECONFIG_Project_NAME, nodeTypes, packagePrefix).generate)
			}
			
			default:			
			{
				val streamRepo = element as StreamRepository
				filesToGenerate.putAll(new JavaStreamRepositoryGenerator(streamRepo).generate)
				if (streamRepo.streams !== null) {
				filesToGenerate.putAll(new JavaStreamGenerator(streamRepo.streams).generate);
				}
				if (streamRepo.nodelinks !== null) {
				//	generateNodelinks();
				}
				if (streamRepo.nodes !== null) {
				//	generateNodes();
				}
				if (streamRepo.nodeTypes !== null) {
				//	generateNodetypes();
				}
				if (streamRepo.container !== null) {
				//	generateContainer();
				}
			}

		}
		filesToGenerate


	}

}
