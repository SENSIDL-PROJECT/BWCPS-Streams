package bw_cps_code_generator.generator.factory.kuracomponents

import bw_cps_code_generator.generator.BwCPSConstants
import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import bw_cps_code_generator.generator.factory.IDTOGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.Node
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger

class NodeComponentsGenerator implements IDTOGenerator{
	static val Logger logger = Logger.getLogger(NodeComponentsGenerator)
	val List<Node> nodes
	val List<NodeLink> nodelinks
	val String projectName
	
	int count = 0
	
	private val String packagePrefix
	
	new(String projectName, List<Node> nodes, List<NodeLink> nodelinks, String newPackagePrefix) {
		this.projectName = projectName
		this.nodes = nodes
		this.nodelinks = nodelinks
		packagePrefix = newPackagePrefix
	}

	override generate() {
		logger.info("Generate node.")

		val filesToGenerate = new HashMap
		for (node : nodes) {
			//TODO if no name + number
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(node)),
			generateClassBody(GenerationUtil.getEntityUpperName(node), node))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(node)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}
		filesToGenerate
	}
	
	def generateClassBody(String entityName, Node node) {
		'''	
			package «packagePrefix»«projectName.toLowerCase»;
«««			package «packagePrefix»«GenerationUtil.getEntityLowerName(GenerationUtil.getNamedElement(nodes.get(0).eContainer))»;
			import org.osgi.service.component.ComponentContext;
			import org.osgi.service.component.annotations.Activate;
			import org.osgi.service.component.annotations.Component;
			import org.osgi.service.component.annotations.Deactivate;
			import org.slf4j.Logger;
			import org.slf4j.LoggerFactory;
			
			/**
			* Node: «entityName»
			*
			* @generated
			*/
			
			@Service
			@Component	
			public class «entityName» {

				«generateDataFields(entityName, node)»
				
				«node.generateMethods»
				
				
			}
		'''
	}

	/** 
	 * Generates DataFields
	 * 
	 */
	def generateDataFields(String entityName, Node node) {
		val sourceReferences = nodelinks.filter[n|n.target.equals(node)]
		val targetReferences = nodelinks.filter[n|n.source.equals(node)]
		'''		
			private static final Logger s_logger = LoggerFactory.getLogger(«entityName».class);
			
			private static final String APP_ID = "«projectName»";
			
			private static final long serialVersionUID = 1L;
			
			private static final NodeType nodeType = new «GenerationUtil.getEntityUpperName(node.nodetype)»();	
		'''	
	}
	/** 
	 * Generates Methods
	 * 
	 */
	def generateMethods(Node node) {
		'''		
			@Activate
			protected void activate(ComponentContext componentContext) {

			s_logger.info("Bundle " + APP_ID + " has started!");

			s_logger.debug(APP_ID + ": This is a debug message.");
			
			//TODO This is an auto-generated method 
			
			}

			@Deactivate
			protected void deactivate(ComponentContext componentContext) {

			s_logger.info("Bundle " + APP_ID + " has stopped!");
			
			//TODO This is an auto-generated method 
			
			}
			«MethodGenerator.generateMethods(node.operational)»

		'''	
	}
	
	
	
	override addFileExtensionTo(String className) {
		return className + BwCPSConstants.JAVA_EXTENSION
	}
	def toTypeName(String name){
		return switch (name) {
			case "INT8": "byte"
			case "UINT8": "byte"
			case "INT16": "short"
			case "UINT16": "short"
			case "INT32": "int"
			case "UINT32": "int"
			case "INT64": "long"
			case "UINT64": "long"
			case "FLOAT": "float"
			case "DOUBLE": "double"
			case "BOOLEAN": "boolean"
			case "STRING": "String"
			default: ""
		}
	}

}
