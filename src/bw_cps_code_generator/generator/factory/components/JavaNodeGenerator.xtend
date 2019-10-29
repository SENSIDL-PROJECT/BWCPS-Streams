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

class JavaNodeGenerator implements IDTOGenerator{
	static val Logger logger = Logger.getLogger(JavaNodeGenerator)
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
			val outputNodelinks = nodelinks.filter[n|n.source.equals(node)].toList
			val securable = inputNodelinks.exists[n|!n.securityMeasure.equals(SecurityMeasure.NONE)] 
				|| outputNodelinks.exists[n|!n.securityMeasure.equals(SecurityMeasure.NONE)] 
			
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(node) + "OperationService"), 
				generateOperationService(GenerationUtil.getEntityUpperName(node), node, securable))
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(node)),
			generateClassBody(GenerationUtil.getEntityUpperName(node), node, securable, inputNodelinks, outputNodelinks))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(node)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}
		filesToGenerate
	}
	
	def generateOperationService(String entityName, Node node, boolean securable) {
		'''	
			package «packagePrefix»«projectName.replaceAll(" ", "").toLowerCase»;

			
			«IF securable »
				import de.fzi.bwcps.generator.nodeconfiguration.security.NotConnectedException;
				import de.fzi.bwcps.generator.nodeconfiguration.security.SecurableNode;
			«ENDIF»
			
			/**
			* Operation Service of Node: «entityName»
			*
			* @generated
			*/

			public interface «entityName»OperationService {
				
				«IF securable »	
					«OperationsGenerator.generateSecureDataOperationDeclarations(node.operational)»
				«ENDIF»
				«OperationsGenerator.generateDataOperationDeclarations(node.operational)»
			}
		'''
	}
	
	def generateClassBody(String entityName, Node node, boolean securable, List<NodeLink> inputNodelinks, List<NodeLink> outputNodelinks) {
		'''	
			package «packagePrefix»«projectName.replaceAll(" ", "").toLowerCase»;
«««			package «packagePrefix»«GenerationUtil.getEntityLowerName(GenerationUtil.getNamedElement(nodes.get(0).eContainer))»;

			import org.osgi.service.component.ComponentContext;
			import org.osgi.service.component.annotations.Component;
			import org.osgi.service.component.annotations.ConfigurationPolicy;
			import org.osgi.service.component.annotations.Activate;
			import org.osgi.service.component.annotations.Deactivate;
			import org.osgi.service.component.annotations.Modified;
			import org.osgi.service.component.annotations.Reference;
			import org.osgi.service.component.annotations.ReferenceCardinality;
			import org.osgi.service.component.annotations.ReferencePolicy;
			
			import org.slf4j.Logger;
			import org.slf4j.LoggerFactory;
			
			import java.util.ArrayList;
			import java.util.List;
			«IF securable »
				import java.security.PublicKey;
				
				import de.fzi.bwcps.generator.nodeconfiguration.security.NotConnectedException;
				import de.fzi.bwcps.generator.nodeconfiguration.security.SecurableNode;
				import de.fzi.bwcps.generator.nodeconfiguration.security.SecurityManager;
				import de.fzi.bwcps.generator.nodeconfiguration.security.SecurityMeasure;
			«ENDIF»
			import de.fzi.bwcps.generator.nodeconfiguration.Node;
			import de.fzi.bwcps.generator.nodeconfiguration.«GenerationUtil.getEntityUpperName(node.nodetype)»;
			
			/**
			* Node: «entityName»
			*
			* @generated
			*/
			
			@Component(immediate = true,
						enabled = true,
						configurationPolicy = ConfigurationPolicy.REQUIRE,
						property = "service.pid:String=de.fzi.bwcps.generator.azure.AzureNode")	
			public class «entityName» extends «GenerationUtil.getEntityUpperName(node.nodetype)» implements «IF securable »SecurableNode«ELSE»Node«ENDIF», «entityName»OperationService {
				
				«generateDataFields(entityName, node, securable, inputNodelinks, outputNodelinks)»
				
				public «entityName»() {
					«IF securable »
						securityManager = new SecurityManager();
					«ENDIF»
					neededServices = new ArrayList<>();
				}
				
				protected void removeService(Node node) {
					neededServices.remove(node);
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
			
			private Map<String, Object> properties;
			
			«IF securable »
				private SecurityManager securityManager;
				
			«ENDIF»
			@Reference(cardinality = ReferenceCardinality.MULTIPLE,
						policy = ReferencePolicy.DYNAMIC,
						bind = "addService",
						unbind = "removeService")
			List<Node> neededServices;
			
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
			
			@Modified	
			public void updated(Map<String, Object> properties) {
			    this.properties = properties;
				if(properties != null && !properties.isEmpty()) {
					Iterator<Entry<String, Object>> it = properties.entrySet().iterator();
					while (it.hasNext()) {
						Entry<String, Object> entry = it.next();
						s_logger.info("New property - " + entry.getKey() + " = " +
						entry.getValue() + " of type " + entry.getValue().getClass().toString());
					}
				}
			}
			
			protected void addService(Node node) {
				neededServices.add(node);
			}
			
			public String getName() {
				return NAME;
			}
			
			«IF securable »	
				public PublicKey getPublicKey() {
					return securityManager.getPublicKey();
				}
				
				public void establishConnection(SecurityMeasure securityMeasure, SecurableNode serviceProvider) {
					securityManager.addConnection(securityMeasure, this, serviceProvider);
					addService(serviceProvider);
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
