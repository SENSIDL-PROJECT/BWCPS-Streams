package de.fzi.bwcpsgenerator.generator.factory.components

import de.fzi.bwcpsgenerator.generator.BwCPSConstants
import de.fzi.bwcpsgenerator.generator.BwcpsOutputConfigurationProvider
import de.fzi.bwcpsgenerator.generator.GenerationUtil
import de.fzi.bwcpsgenerator.generator.factory.IDTOGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.Node
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure
import de.fzi.bwcpsgenerator.generator.metamodel.StreamRepositoryManager

class JavaNodeGenerator implements IDTOGenerator{
	static val Logger logger = Logger.getLogger(JavaNodeGenerator)
	val List<Node> nodes
	val List<NodeLink> nodelinks
	val String projectName

	val boolean kuraAdapted	
	val String packagePrefix
	
	new(String projectName, List<Node> nodes, List<NodeLink> nodelinks, String newPackagePrefix, boolean kuraAdapted) {
		this.projectName = projectName
		this.nodes = nodes
		this.nodelinks = nodelinks
		packagePrefix = newPackagePrefix
		this.kuraAdapted = kuraAdapted
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
			generateClassBody(GenerationUtil.getEntityUpperName(node), node, securable, inputNodelinks))
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
	
	def generateClassBody(String entityName, Node node, boolean securable, List<NodeLink> inputNodelinks) {
		'''	
			package «packagePrefix»«projectName.replaceAll(" ", "").toLowerCase»;
«««			package «packagePrefix»«GenerationUtil.getEntityLowerName(GenerationUtil.getNamedElement(nodes.get(0).eContainer))»;
			
			import org.osgi.service.component.ComponentContext;
			import org.osgi.service.component.annotations.Component;
			import org.osgi.service.component.annotations.ConfigurationPolicy;
			import org.osgi.service.component.annotations.Activate;
			import org.osgi.service.component.annotations.Deactivate;
			import org.osgi.service.component.annotations.Modified;
			«IF !inputNodelinks.empty»
				import org.osgi.service.component.annotations.Reference;
				import org.osgi.service.component.annotations.ReferenceCardinality;
				import org.osgi.service.component.annotations.ReferencePolicy;
			«ENDIF»
			
			«FOR i : inputNodelinks »
				import «packagePrefix»«GenerationUtil.getEntityLowerName(
					StreamRepositoryManager.getNodeContainerOfNode(i.source)
				).toLowerCase».«GenerationUtil.getEntityUpperName(i.source)»;				
			«ENDFOR»
			import org.slf4j.Logger;
			import org.slf4j.LoggerFactory;
			
			import java.util.Iterator;
			import java.util.Map;
			import java.util.Map.Entry;
			
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
			
			@Component(immediate = true,
						enabled = true,
						configurationPolicy = ConfigurationPolicy.REQUIRE,
						property = "service.pid:String=de.fzi.bwcps.generator.azure.AzureNode")	
						
			public class «entityName» 
						extends «GenerationUtil.getEntityUpperName(node.nodetype)» 
						implements «entityName»OperationService, 
							       «IF securable »SecurableNode«ELSE»Node«ENDIF»«IF kuraAdapted», 
								   org.eclipse.kura.configuration.ConfigurableComponent«ENDIF» {
						
				«generateDataFields(entityName, node, securable, inputNodelinks)»
				
				public «entityName»() {
					«IF securable »
						securityManager = new SecurityManager();
					«ENDIF»
				}
				
				«generateMethods(node, securable, inputNodelinks)»
				
				
			}
		'''
	}

	/** 
	 * Generates DataFields
	 * 
	 */
	def generateDataFields(String entityName, Node node, boolean securable, List<NodeLink> inputNodelinks) {
		'''		
			private static final Logger s_logger = LoggerFactory.getLogger(«entityName».class);
			
			private static final String NAME = «entityName».class.getSimpleName();
			
			private static final long serialVersionUID = 1L;
			
			private Map<String, Object> properties;
			
			«IF securable »
				private SecurityManager securityManager;
				
			«ENDIF»
			
			«FOR i : inputNodelinks »
				private «GenerationUtil.getEntityUpperName(i.source)» «GenerationUtil.getEntityLowerName(i.source)»;
				
			«ENDFOR»
		'''	
	}
	
	/** 
	 * Generates Methods
	 * 
	 */
	def generateMethods(Node node, boolean securable, List<NodeLink> inputNodelinks) {
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

			«FOR i : inputNodelinks »
				@Reference(cardinality = ReferenceCardinality.OPTIONAL,
							policy = ReferencePolicy.DYNAMIC,
							unbind = "unset«GenerationUtil.getEntityUpperName(i.source)»")
				protected void set«GenerationUtil.getEntityUpperName(i.source)»(«GenerationUtil.getEntityUpperName(i.source)» «GenerationUtil.getEntityLowerName(i.source)») {
					this.«GenerationUtil.getEntityLowerName(i.source)» = «GenerationUtil.getEntityLowerName(i.source)»;
					«IF i.securityMeasure != SecurityMeasure.NONE»	
						establishConnection(SecurityMeasure.«i.securityMeasure.literal», «GenerationUtil.getEntityLowerName(i.source)»);
					«ENDIF»	
				}
				
				protected void unset«GenerationUtil.getEntityUpperName(i.source)»(«GenerationUtil.getEntityUpperName(i.source)» «GenerationUtil.getEntityLowerName(i.source)») {
					«GenerationUtil.getEntityLowerName(i.source)» = null;
				}
			«ENDFOR»
			
			public String getName() {
				return NAME;
			}
			
			«IF securable »	
				public PublicKey getPublicKey() {
					return securityManager.getPublicKey();
				}
				
				private void establishConnection(SecurityMeasure securityMeasure, SecurableNode serviceProvider) {
					securityManager.addConnection(securityMeasure, this, serviceProvider);
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
