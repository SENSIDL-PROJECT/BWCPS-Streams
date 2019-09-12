package bw_cps_code_generator.generator.factory.java

import bw_cps_code_generator.generator.BwCPSConstants
import bw_cps_code_generator.generator.factory.IDTOGenerator
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.sensidl.design.sensidl.dataRepresentation.Data
import java.util.List
import bw_cps_code_generator.generator.GenerationUtil

abstract class JavaEntityGenerator implements IDTOGenerator {
	
	def CharSequence generateClassBody(String className, NamedElement entity);
	
	def CharSequence generateConstructor(NamedElement entity, String className);

	def CharSequence generateDataFields(NamedElement entity);
	
	def CharSequence generateDataMethods(NamedElement entity);
	
	def CharSequence generateMethods(NamedElement entity);

	def generateInterfaceBody(List entities, String packageName) {
		'''
			package «packageName»;
			import streamrepository.NodeLink;
						
						/**
						* Stream Interface
						*
						* @generated
						*/
			public interface Stream {
				
				java.util.List<NodeLink> getNodelinks;
				
			}
		'''
	}
	override addFileExtensionTo(String className) {
		return className + BwCPSConstants.JAVA_EXTENSION
	}
	override toTypeName(Data data) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

//	/**
//	 * Generates the constructor for this data set including used data sets.
//	 */
//	def generateConstructor(NamedElement entity, String className) {
//
//		if (entity.eAllContents.size > 0) {
//		'''
//			/**
//			 * Constructor for the Data transfer object
//			 */
//			public «className»(«entity.generateConstructorArgumentsIncludeusedDataSetss») {
//				«FOR e : entity.eContents»
//«««					«IF data.hasLinearDataConversionWithInterval»
//«««						«IF data.excludedMethods.contains("setter")»
//«««							//set«GenerationUtil.toNameUpper(data)»(«GenerationUtil.toNameLower(data)»); // no setter was generated
//«««						«ELSE»
//«««							set«GenerationUtil.toNameUpper(data)»(«GenerationUtil.toNameLower(data)»);
//«««						«ENDIF»
//«««					«ELSE»
//						this.«GenerationUtil.toNameLower(e)» = «GenerationUtil.toNameLower(e)»;
//«««					«ENDIF»
//				«ENDFOR»
//			}
//		'''
//		} else {
//			''''''
//		}
//	}
//	
//	/**
//	 * Generates the Constructor arguments
//	 */
//	def generateConstructorArgumentsIncludeusedDataSetss(DataSet d) {
//		var dataList = d.getNonConstantData
//		if (dataList.size > 0) {
//			var firstElement = dataList.get(0).toTypeName + " " + GenerationUtil.toNameLower(dataList.get(0))
//			dataList.remove(0)
//			if(d.usedDataSets.size > 0){
//				'''«firstElement»«FOR data : dataList», «data.toTypeName» «GenerationUtil.toNameLower(data)»«ENDFOR»«FOR pdataSet : d.usedDataSets», «GenerationUtil.toNameUpper(pdataSet)» «GenerationUtil.toNameLower(pdataSet)»«ENDFOR»'''
//			} else {
//				'''«firstElement»«FOR data :dataList», «data.toTypeName» «GenerationUtil.toNameLower(data)»«ENDFOR»'''
//			}
//		} else {
//			''''''
//		}
//	}
}
