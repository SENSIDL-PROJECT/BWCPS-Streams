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
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer

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
			val inputNodelinks = nodelinks.filter[n|n.target.equals(node)].toList
			val outputNodelinks = nodelinks.filter[n|n.source.equals(node)].toList
			//TODO if no name + number
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(node)),
			generateClassBody(GenerationUtil.getEntityUpperName(node), node, inputNodelinks, outputNodelinks))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(node)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}
		filesToGenerate
	}
	
	def generateClassBody(String entityName, Node node, List<NodeLink> inputNodelinks, List<NodeLink> outputNodelinks) {
		val securable = !inputNodelinks.empty || !outputNodelinks.empty 
		'''	
			package «packagePrefix»«projectName.toLowerCase»;
«««			package «packagePrefix»«GenerationUtil.getEntityLowerName(GenerationUtil.getNamedElement(nodes.get(0).eContainer))»;

			import org.osgi.service.component.ComponentContext;
			import org.osgi.service.component.annotations.Component;
			import org.osgi.service.component.annotations.Activate;
			import org.osgi.service.component.annotations.Deactivate;
			import org.osgi.service.component.annotations.Reference;
			import org.osgi.service.component.annotations.ReferenceCardinality;
			
			import org.slf4j.Logger;
			import org.slf4j.LoggerFactory;
			
			«IF securable »
				import java.security.PublicKey;
				
				import de.fzi.bwcps.generator.nodeconfiguration.security.NotConnectedException;
				import de.fzi.bwcps.generator.nodeconfiguration.security.SecurableNode;
				import de.fzi.bwcps.generator.nodeconfiguration.security.SecurityManager;
				import de.fzi.bwcps.generator.nodeconfiguration.security.SecurityMeasure;
			«ENDIF»
			
			/**
			* Node: «entityName»
			*
			* @generated
			*/
			
			@Component	
			public class «entityName» «IF securable »implements SecurableNode «ENDIF»{
				
				«generateDataFields(entityName, node, inputNodelinks, outputNodelinks)»
				
				protected «entityName»() {
					«IF securable »
						securityManager = new SecurityManager();
					«ENDIF»
				}
				
				«generateMethods(node, inputNodelinks, outputNodelinks)»
				
				
			}
		'''
	}

	/** 
	 * Generates DataFields
	 * 
	 */
	def generateDataFields(String entityName, Node node, List<NodeLink> inputNodelinks, List<NodeLink> outputNodelinks) {
		'''		
			private static final Logger s_logger = LoggerFactory.getLogger(«entityName».class);
			
			private static final String NAME = «entityName».class.getSimpleName();
			
			private static final long serialVersionUID = 1L;
			
«««			TODO NEXT
			private static final NodeType nodeType = new «GenerationUtil.getEntityUpperName(node.nodetype)»();	
			
			«IF !inputNodelinks.empty || !outputNodelinks.empty »
				private SecurityManager securityManager;
			«ENDIF»
			
			
		'''	
	}
	
	/** 
	 * Generates Methods
	 * 
	 */
	def generateMethods(Node node, List<NodeLink> inputNodelinks, List<NodeLink> outputNodelinks) {
		'''		
			@Activate
			protected void activate(ComponentContext componentContext) {

			s_logger.info("Component " + NAME + " has started!");

			s_logger.debug(NAME + ": This is a debug message.");
			
			//TODO This is an auto-generated method 
			
			}

			@Deactivate
			protected void deactivate(ComponentContext componentContext) {

			s_logger.info("Component " + NAME + " has stopped!");
			
			//TODO This is an auto-generated method 
			
			}
			public String getName() {
				return NAME;
			}
			
			«IF !inputNodelinks.empty || !outputNodelinks.empty »	
				public PublicKey getPublicKey() {
					return securityManager.getPublicKey();
				}
				
				@Reference(cardinality = ReferenceCardinality.MULTIPLE)
				public void establishConnection(SecurityMeasure securityMeasure, SecurableNode serviceRequester) {
					securityManager.addConnection(securityMeasure, serviceRequester, this);
					
				}
				
				public void receiveEncryptedKey(SecurityMeasure securityMeasure, SecurableNode node, byte[] key) {
					securityManager.decryptAndStoreKey(securityMeasure, node, key);
				}
				
				«OperationsGenerator.generateSecureDataOperations(node.operational)»
			«ENDIF»
			
			«OperationsGenerator.generateDataOperations(node.operational)»
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
