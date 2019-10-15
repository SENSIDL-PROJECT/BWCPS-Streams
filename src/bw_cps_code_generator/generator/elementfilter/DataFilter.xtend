package bw_cps_code_generator.generator.elementfilter

import java.util.List
import de.fzi.sensidl.design.sensidl.dataRepresentation.Data
import org.eclipse.emf.ecore.resource.Resource

class DataFilter extends ElementFilter {

	/**
 	* Implements the abstract method of the base-class and filters the SensorInterface-elements.
	* @see ElementFilter#filterData()
 	*/
	
	new(Resource input) {
		super(input)
	}
	
	override List<Data> filterData() {
		//Exception
		input.contents.filter(Data).toList		  	
	}
}
