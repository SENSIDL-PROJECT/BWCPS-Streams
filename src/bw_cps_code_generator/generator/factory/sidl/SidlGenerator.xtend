package bw_cps_code_generator.generator.factory.sidl

import bw_cps_code_generator.generator.factory.ICodeGenerator
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import java.util.HashMap
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import java.util.stream.Collectors
import bw_cps_code_generator.generator.GenerationUtil
import bw_cps_code_generator.exception.MetamodelException

/**
 * 
 *  The SidlGenerator represents a concrete implementation of The ICodeGenerator and implements the 
 * code-generator for the sidl file.
 * @author Sven Eckhardt
 */
 
class SidlGenerator implements ICodeGenerator {

	private var String packagePrefix
	new (String packagePrefix) {
		this.packagePrefix = packagePrefix
	}
	
	/**
	 * @see ICodeGenerator#generateDTO()
	 */
	override generateDTO(NamedElement element) {
		val container = element as NodeContainer
		val nodeTypes = container.nodes.map(node| node.nodetype)
						.stream.distinct.collect(Collectors.toList())
		if (nodeTypes != null && !nodeTypes.empty) 
			new SidlDTOGenerator(GenerationUtil.getEntityUpperName(container), nodeTypes, packagePrefix).generate
		else throw new MetamodelException("NodeContainer " + GenerationUtil.getEntityUpperName(container) + "doesn't have any node with a node type.")
	}

}
