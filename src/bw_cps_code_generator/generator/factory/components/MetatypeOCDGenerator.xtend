package bw_cps_code_generator.generator.factory.components

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import bw_cps_code_generator.generator.factory.IDTOGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.Node
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger

class MetatypeOCDGenerator implements IDTOGenerator{
	static val Logger logger = Logger.getLogger(MetatypeOCDGenerator)
	val List<Node> nodes
	val List<NodeLink> nodelinks
	val String projectName
	
	val String packagePrefix
	
	new(String projectName, List<Node> nodes, List<NodeLink> nodelinks, String newPackagePrefix) {
		this.projectName = projectName
		this.nodes = nodes
		this.nodelinks = nodelinks
		packagePrefix = newPackagePrefix
	}

	override generate() {
		logger.info("Generate nodes.")

		val filesToGenerate = new HashMap
		for (node : nodes) {
			val inputNodelinks = nodelinks.filter[n|n.target.equals(node)].toList
			val componentId = packagePrefix + projectName.replaceAll(" ", "").toLowerCase + "." + GenerationUtil.getEntityUpperName(node)
			filesToGenerate.put(addFileExtensionTo(componentId),
			generateBody(GenerationUtil.getEntityUpperName(node), node, inputNodelinks))
			logger.info("File: " + addFileExtensionTo(componentId) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}
		filesToGenerate
	}
	
	
	def generateBody(String entityName, Node node, List<NodeLink> inputNodelinks) {
		'''	
			<?xml version="1.0" encoding="UTF-8"?>
			<MetaData xmlns="http://www.osgi.org/xmlns/metatype/v1.2.0" localization="en_us">
			    <OCD id="«packagePrefix»«projectName.replaceAll(" ", "").toLowerCase».«entityName»"
			        name="«entityName»"
			        description="This is a sample metatype file for a simple configurable component">
			
			        <AD id="param1.string"
			            name="param1.string"
			            type="String"
			            cardinality="0"
			            required="true"
			            default="Some Text"
			            description="String configuration parameter"/>
			
			        <AD id="param2.float"
			            name="param2.float"
			            type="Float"
			            cardinality="0"
			            required="false"
			            default="20.5"
			            min="5.0"
			            max="40.0"
			            description="Float configuration parameter"/>
			
			        <AD id="param3.integer"
			            name="param3.integer"
			            type="Integer"
			            cardinality="0"
			            required="true"
			            default="2"
			            min="1"
			            description="Integer configuration parameter"/>
			    </OCD>
			
			    <Designate pid="«packagePrefix»«projectName.replaceAll(" ", "").toLowerCase».«entityName»">
			        <Object ocdref="«packagePrefix»«projectName.replaceAll(" ", "").toLowerCase».«entityName»"/>
			    </Designate>
			</MetaData>

		'''
	}
	
	override addFileExtensionTo(String className) {
		return className + ".xml"
	}

}
