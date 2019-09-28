package bw_cps_code_generator.generator.factory.java

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import dataRepresentation.Data
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType

class JavaNodeTypeGenerator extends JavaEntityGenerator {
	static val Logger logger = Logger.getLogger(JavaNodeTypeGenerator)
	val List<NodeType> nodetypes

		String projectName
		
	private val String packagePrefix 
	
	new(String projectName, List<NodeType> nodetypes, String packagePrefix) {
		this.projectName = projectName
		this.nodetypes = nodetypes
		this.packagePrefix = packagePrefix
	}

	override generate() {
		logger.info("Generate node types.")
		val c = Data;
		val filesToGenerate = new HashMap
		filesToGenerate.put("NodeType.java", generateInterfaceBody())
		logger.info("File: NodeType.java was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		for (nodetype : nodetypes) { 
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(nodetype)),
			generateClassBody(GenerationUtil.getEntityUpperName(nodetype), nodetype))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(nodetype)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}

		filesToGenerate
	}
	
	def generateInterfaceBody() {
		'''
			package «packagePrefix»«projectName.toLowerCase»;
			
			/**
			* NodeType Iterface
			*
			* @generated
			*/
			public interface NodeType {
				
				
			}
		'''
	}
	
	override generateClassBody(String entityName, NamedElement stream) {
		'''
			package nodes;
			
			import nodes.NodeType;
			/**
			* NodeType: «entityName»
			*
			* @generated
			*/
				
			public class «entityName» implements Stream {
										
				private static final long serialVersionUID = 1L;
				
				«generateDataFields(stream)»
				
				«generateConstructor(stream, entityName)»
				
				
				«stream.generateMethods»
				
				«generateDataMethods(stream)»
				
			}
		'''
	}

	override generateDataMethods(NamedElement entity) {
		//
	}
	override generateConstructor(NamedElement entity, String className) {
		'''
				
			public «className»(Node source, Node target) {
				this.source = source;
				this.target = target;
			}
		'''
	}

	/** 
	 * Generates Methods
	 * 
	 */
	def generateMethods(StreamRepository repo) {
	}
	
// ------------------------------ Data Fields ------------------------------
	
	override generateDataFields(NamedElement entity) {
		'''
			«(new JavaDataRepresentaionGenerator).generateDataFields(entity)»

		'''
	}
	
	
	override generateMethods(NamedElement entity) {
	//	throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	

}
