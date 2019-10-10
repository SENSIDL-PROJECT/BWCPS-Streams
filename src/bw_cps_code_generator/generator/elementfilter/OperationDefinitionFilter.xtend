package bw_cps_code_generator.generator.elementfilter

import de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition
import org.eclipse.emf.ecore.resource.Resource

class OperationDefinitionFilter extends ElementFilter {

	/**
 	* Implements the abstract method of the base-class and filters the SensorInterface-elements.
	* @see ElementFilter#filterData()
 	*/
	
	new(Resource input) {
		super(input)
	}
	
	override OperationDefinition filterData() {
		//Exception
		input.contents.filter(OperationDefinition).get(0)		  	
	}
}
