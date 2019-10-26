package bw_cps_code_generator.generator.factory.components

import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.operations.Operation
import java.util.List

class OperationsGenerator {
	
	def static generateDataOperations(List<Operation> operational) {
		var count = 0 as int

		'''
			«FOR o: operational»
				public void «GenerationUtil.getEntityLowerName(o)» («IF ! (o.domain === null) »«FOR d: o.domain.dimensions SEPARATOR ', '»
							«d.valueSpace.getName.toTypeName» param«count++»«ENDFOR»«ENDIF»«{count = 0; "" }») {
					//TODO This is an auto-generated method 
				}
			«ENDFOR»
		'''
	}

	def static generateSecureDataOperations(List<Operation> operational) {
		var count = 0 as int

		'''
			«FOR o: operational»
				public String «GenerationUtil.getEntityLowerName(o)» (SecurableNode serviceRequester, «IF ! (o.domain === null) »«FOR d: o.domain
					.dimensions SEPARATOR ', '»«d.valueSpace.getName.toTypeName» param«count++»«ENDFOR»«ENDIF»«{count = 0; "" }») throws NotConnectedException {
«««					TODO data should be from type the output dataset
					Object data = null;
					
					//TODO This is an auto-generated method
				
					return securityManager.secureData(data, serviceRequester);
				}
					«ENDFOR»
		'''
	}
		
	def private static toTypeName(String name){
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