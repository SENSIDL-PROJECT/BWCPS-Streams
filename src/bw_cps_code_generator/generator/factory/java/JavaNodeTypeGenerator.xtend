package bw_cps_code_generator.generator.factory.java

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType
//TODO in Nodeconfiguration
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
	
	override generateClassBody(String entityName, NamedElement nodeType) {
		'''
			package «packagePrefix»«projectName.toLowerCase»;

			/**
			* NodeType: «entityName»
			*
			* @generated
			*/
			
			«generateImports(nodeType)»
			
			public class «entityName» implements NodeType {
									
				«generateDataFields(nodeType)»
				
				«generateConstructor(nodeType, entityName)»
				
				«nodeType.generateMethods»
				
				«generateDataMethods(nodeType)»
				
			}
		'''
	}

	override generateDataMethods(NamedElement nodetype) {
		
	}
	
	override generateConstructor(NamedElement nodetype, String className) {

	}
	
// ------------------------------ Data Fields ------------------------------
	
	override generateDataFields(NamedElement nodetype) {
		'''
			«GenerationUtil.getEntityUpperName(nodetype)»InputDataSet input = new «GenerationUtil.getEntityUpperName(nodetype)»InputDataSet();
			«GenerationUtil.getEntityUpperName(nodetype)»OutputDataSet output = new «GenerationUtil.getEntityUpperName(nodetype)»OutputDataSet();
		'''
	}
	
	def generateImports(NamedElement nodetype) {
		'''
			import «GenerationUtil.getEntityLowerName(nodetype).toLowerCase»inputdataset.«GenerationUtil.getEntityUpperName(nodetype)»InputDataSet;
			import «GenerationUtil.getEntityLowerName(nodetype).toLowerCase»outputdataset.«GenerationUtil.getEntityUpperName(nodetype)»OutputDataSet;
		'''
	}
	
	
	override generateMethods(NamedElement entity) {
	}
	

}
