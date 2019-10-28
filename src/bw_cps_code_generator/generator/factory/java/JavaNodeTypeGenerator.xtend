package bw_cps_code_generator.generator.factory.java

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType
import de.fzi.sensidl.design.sensidl.SensorInterface

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
	
	def generateClassBody(String entityName, NodeType nodeType) {
		'''
			package «packagePrefix»«projectName.toLowerCase»;

			/**
			* NodeType: «entityName»
			*
			* @generated
			*/
			
			«generateImports(nodeType)»
			
			public abstract class «entityName» {
									
				«generateDataFields(nodeType)»
				
				«generateDataMethods(nodeType)»
				
			}
		'''
	}

	def generateDataMethods(NodeType nodetype) {
		
	}

	
// ------------------------------ Data Fields ------------------------------
	
	def generateDataFields(NodeType nodetype) {
		'''
			«nodetype.input.get(0).dataSet.name» input = new «nodetype.input.get(0).dataSet.name»();
			«nodetype.output.get(0).dataSet.name» output = new «nodetype.output.get(0).dataSet.name»();
		'''
	}
	
	def generateImports(NodeType nodetype) {
		'''
			import «(nodetype.input.get(0).dataSet.eContainer.eContainer as SensorInterface)
					.name».«nodetype.input.get(0).dataSet.name»;
			«IF nodetype.input.get(0).dataSet.name != nodetype.output.get(0).dataSet.name»
				import «(nodetype.output.get(0).dataSet.eContainer.eContainer as SensorInterface)
					.name».«nodetype.output.get(0).dataSet.name»;
			«ENDIF»
		'''
	}
	

}
