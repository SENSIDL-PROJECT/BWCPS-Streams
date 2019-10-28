package bw_cps_code_generator.generator.factory.java

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import de.fzi.bwcps.stream.bwcps_streams.entity.Node

class JavaNodeGenerator extends JavaEntityGenerator {
	static val Logger logger = Logger.getLogger(JavaNodeGenerator)
	val List<Node> nodes

	new(List<Node> nodes) {
		this.nodes = nodes
	}

	override generate() {
		logger.info("Generate node.")
		val filesToGenerate = new HashMap
		filesToGenerate.put("Node.java", generateInterfaceBody(nodes))
		logger.info("File: Node.java was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		for (node : nodes) {
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(node)),
			generateClassBody(GenerationUtil.getEntityUpperName(node), node))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(node)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}
		filesToGenerate
	}
	
	def generateInterfaceBody(List nodes) {
		'''
			package nodes;
			import nodes.Node;
						
			/**
			* NodeLink Interface
			*
			* @generated
			*/
			public interface Node {
				
				public Node getNodetype();
				
				public Node getOperation();
				

			}
		'''
	}
	
	def generateClassBody(String entityName, NamedElement stream) {
		'''
			package nodes;
			
			import nodes.Node;
			/**
			* NodeLink: «entityName»
			*
			* @generated
			*/
				
			public class «entityName» implements Node {
										
				private static final long serialVersionUID = 1L;
				
				«generateDataFields(stream)»
				
				«generateConstructor(stream, entityName)»
				
				
				«stream.generateMethods»
				
				«generateDataMethods(stream)»
				
			}
		'''
	}

	def generateDataMethods(NamedElement entity) {
		//
	}
	def generateConstructor(NamedElement entity, String className) {
		'''
				
			public «className»(NodeType nodeType, Operation operational) {
				this.nodeType = nodeType;
				this.operational = operational;
			}
		'''
	}

	/** 
	 * Generates Methods
	 * 
	 */
	def generateMethods(StreamRepository repo) {
	}
	
	def generateDataFields(NamedElement entity) {
		'''
			private Node source;
			
			private Node target;
		'''
	}
	
	def generateMethods(NamedElement entity) {
	//	throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
