package bw_cps_code_generator.generator.factory.components

import java.util.List
import org.eclipse.emf.ecore.EObject
import bw_cps_code_generator.generator.factory.ICodeGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import java.util.HashMap
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure

/**
 * The JavaGenerator represents a concrete implementation of The ICodeGenerator and implements the 
 * code-generator for the language Java.
 * 
 */
class ComponentGenerator  {
	//implements ICodeGenerator
	private var String packagePrefix

	
	new (String packagePrefix) {
		
		this.packagePrefix = packagePrefix
		
	} 
	
//	override generateDTO(NamedElement nodeContainer) {
//		val container = nodeContainer as NodeContainer
	def generateDTO(NodeContainer container, List<NodeLink> nodelinks) {
		var filesToGenerate = new HashMap
		filesToGenerate.putAll(new JavaNodeGenerator(GenerationUtil.getEntityUpperName(container), container.nodes, nodelinks, packagePrefix).generate)
		
		return filesToGenerate
	}

}
