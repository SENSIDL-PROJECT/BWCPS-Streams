package de.fzi.bwcpsgenerator.generator.factory.java

import de.fzi.bwcpsgenerator.generator.BwcpsOutputConfigurationProvider
import de.fzi.bwcpsgenerator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer

class JavaNodeContainerGenerator extends JavaEntityGenerator {
	static val Logger logger = Logger.getLogger(JavaNodeContainerGenerator)
	val List<NodeContainer> containers

	new(List<NodeContainer> containers) {
		this.containers = containers
	}

	override generate() {
		logger.info("Generate node containers.")
		val filesToGenerate = new HashMap
		filesToGenerate.put("NodeContainer.java", generateInterfaceBody(containers))
		logger.info("File: NodeContainer.java was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		for (container : containers) {
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(container)),
			generateClassBody(GenerationUtil.getEntityUpperName(container), container))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(container)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}

		filesToGenerate
	}
	
	def generateInterfaceBody(List<NodeContainer> containers) {
		'''
			package nodes;
			import nodes.Node;
			import java.util.List;
						
			/**
			* NodeContainer Interface
			*
			* @generated
			*/
			public interface NodeContainer {
				
				java.util.List<Node> getNodes();
				
			}
		'''
	}
	
	def generateClassBody(String entityName, NamedElement stream) {
		'''
			package nodes;
			
			import nodes.NodeContainer;
			import java.util.List;
			/**
			* NodeContainer: «entityName»
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

	def generateDataMethods(NamedElement entity) {
		//
	}
	def generateConstructor(NamedElement entity, String className) {
		'''
				
			public «className»(List<Node> nodes) {
				this.nodes = nodes;
			}
		'''
	}
	
	def generateDataFields(NamedElement entity) {
	//	throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def generateMethods(NamedElement entity) {
	//	throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
