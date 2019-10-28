package bw_cps_code_generator.generator.factory.components

import bw_cps_code_generator.generator.BwCPSConstants
import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import bw_cps_code_generator.generator.factory.IDTOGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.Node
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure

class NodeComponentsGenerator implements IDTOGenerator{
	static val Logger logger = Logger.getLogger(NodeComponentsGenerator)
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
		logger.info("Generate node.")

		val filesToGenerate = new HashMap
		for (node : nodes) {
			val inputNodelinks = nodelinks.filter[n|n.target.equals(node)].toList
			val outputNodelinks = nodelinks.filter[n|n.source.equals(node)].toList
			val securable = inputNodelinks.exists[n|!n.securityMeasure.equals(SecurityMeasure.NONE)] 
				|| outputNodelinks.exists[n|!n.securityMeasure.equals(SecurityMeasure.NONE)] 

			//TODO if no name + number
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(node)),
			generateClassBody(GenerationUtil.getEntityUpperName(node), node, securable, inputNodelinks, outputNodelinks))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(node)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}
		filesToGenerate
	}
	
	def generateClassBody(String entityName, Node node, boolean securable, List<NodeLink> inputNodelinks, List<NodeLink> outputNodelinks) {
		'''	
			package «packagePrefix»«projectName.replaceAll(" ", "").toLowerCase»;
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
			«ELSE»
				import de.fzi.bwcps.generator.nodeconfiguration.Node;
			«ENDIF»
			import de.fzi.bwcps.generator.nodeconfiguration.«GenerationUtil.getEntityUpperName(node.nodetype)»;
			
			/**
			* Node: «entityName»
			*
			* @generated
			*/
			
			@Component	
			public class «entityName» extends «GenerationUtil.getEntityUpperName(node.nodetype)» «IF securable »implements SecurableNode «ELSE»implements Node «ENDIF»{
				
				«generateDataFields(entityName, node, securable, inputNodelinks, outputNodelinks)»
				
				protected «entityName»() {
					«IF securable »
						securityManager = new SecurityManager();
					«ENDIF»
				}
				
				«generateMethods(node, securable, inputNodelinks, outputNodelinks)»
				
				
			}
		'''
	}

	/** 
	 * Generates DataFields
	 * 
	 */
	def generateDataFields(String entityName, Node node, boolean securable, List<NodeLink> inputNodelinks, List<NodeLink> outputNodelinks) {
		'''		
			private static final Logger s_logger = LoggerFactory.getLogger(«entityName».class);
			
			private static final String NAME = «entityName».class.getSimpleName();
			
			private static final long serialVersionUID = 1L;
						
			«IF securable »
				private SecurityManager securityManager;
			«ENDIF»
			
		'''	
	}
	
	/** 
	 * Generates Methods
	 * 
	 */
	def generateMethods(Node node, boolean securable, List<NodeLink> inputNodelinks, List<NodeLink> outputNodelinks) {
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
			
			«IF securable »	
				public PublicKey getPublicKey() {
					return securityManager.getPublicKey();
				}
				
				@Reference(cardinality = ReferenceCardinality.MULTIPLE)
				public void establishConnection(SecurityMeasure securityMeasure, SecurableNode serviceRequester, PublicKey requestersPK) {
					securityManager.addConnection(securityMeasure, serviceRequester, this, requestersPK);
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

}
