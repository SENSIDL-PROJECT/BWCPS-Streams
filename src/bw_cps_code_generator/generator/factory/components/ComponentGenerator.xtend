package bw_cps_code_generator.generator.factory.components

import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import java.util.HashMap
import java.util.List

/**
 * The JavaGenerator represents a concrete implementation of The ICodeGenerator and implements the 
 * code-generator for the language Java.
 * 
 */
class ComponentGenerator  {
	//implements ICodeGenerator
	var String packagePrefix
	val boolean kuraAdapted	
	
	new (String packagePrefix, boolean kuraAdapted) {
		
		this.packagePrefix = packagePrefix
		this.kuraAdapted = kuraAdapted
	} 
	
//	override generateDTO(NamedElement nodeContainer) {
//		val container = nodeContainer as NodeContainer
	def generateDTO(NodeContainer container, List<NodeLink> nodelinks) {
		var filesToGenerate = new HashMap
		filesToGenerate.putAll(new JavaNodeGenerator(GenerationUtil.getEntityUpperName(container), 
			container.nodes, nodelinks, packagePrefix, kuraAdapted)
			.generate)
		filesToGenerate.putAll(new MetatypeOCDGenerator(GenerationUtil.getEntityUpperName(container), 
			container.nodes, nodelinks, packagePrefix)
			.generate)		
		return filesToGenerate
	}

}
