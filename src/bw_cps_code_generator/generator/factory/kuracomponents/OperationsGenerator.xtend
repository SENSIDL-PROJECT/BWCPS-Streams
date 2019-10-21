package bw_cps_code_generator.generator.factory.kuracomponents

import bw_cps_code_generator.generator.GenerationUtil
import org.eclipse.emf.ecore.util.EcoreUtil
import de.fzi.bwcps.stream.bwcps_streams.operations.Operation
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import java.util.HashMap
import org.eclipse.emf.common.util.URI
import de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition
import bw_cps_code_generator.generator.elementfilter.OperationDefinitionFilter
import java.util.ArrayList
import java.util.List

class OperationsGenerator {
	static HashMap<URI,OperationDefinition> loadedOps = new HashMap
	
	def public static generateDataOperations(List<Operation> operational) {
		var count = 0 as int

		'''
					«FOR o: getOperations(operational)»
						public void «GenerationUtil.getEntityLowerName(o)» («IF ! (o.domain === null) »«FOR d: o.domain.dimensions SEPARATOR ', '»
									«d.valueSpace.getName.toTypeName» param«count++»«ENDFOR»«ENDIF»«{count = 0; "" }») {
							//TODO This is an auto-generated method 
						}
					«ENDFOR»
		'''
	}

	def public static generateSecureDataOperations(List<Operation> operational) {
		var count = 0 as int

		'''
					«FOR o: getOperations(operational)»
						public String «GenerationUtil.getEntityLowerName(o)» (SecurableNode serviceRequester, «IF ! (o.domain === null) »«FOR d: o.domain
						.dimensions SEPARATOR ', '»«d.valueSpace.getName.toTypeName» param«count++»«ENDFOR»«ENDIF»«{count = 0; "" }») throws NotConnectedException {
«««							data should be from type the output dataset
							Object data = null;
							
							//TODO This is an auto-generated method
						
							return securityManager.secureData(data, serviceRequester);
						}
					«ENDFOR»
		'''
	}
	
	def private static getOperations(List<Operation> operational) {
		var opDef = null as OperationDefinition
		var ops = new ArrayList<Operation>()
		for(o: operational) {
			val uri = EcoreUtil.getURI(o)
			opDef = loadedOps.get(uri)
			if (opDef == null) {
				//TODO Exception: Metamodel
				opDef = (new OperationDefinitionFilter(GenerationUtil.loadResource(uri.devicePath))).filterData
				loadedOps.put(uri, opDef)
			}
			ops.add(opDef.operations
				.findFirst[e|EcoreUtil.getURI(e).fragment == uri.fragment])
		}
		ops
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