package de.fzi.bwcpsgenerator.generator.metamodelmanager

import de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition
import org.eclipse.emf.ecore.resource.Resource
import de.fzi.bwcpsgenerator.exception.MetamodelException

class OperationDefinitionManager extends ElementManager {

	/**
 	* Implements the abstract method of the base-class and filters the SensorInterface-elements.
	* @see ElementFilter#filterData()
 	*/
	
	new(Resource input) {
		super(input)
	}
	
	override OperationDefinition filterData() {
		val opDefs = input.contents.filter(OperationDefinition)
		if (opDefs.length <= 0) {
			throw new MetamodelException("A Bwcps-metamodel should contain at least one stream repository")
		}
		if (opDefs.length > 1) {
			if (!displayWarning("operation definitions")) {
				throw new MetamodelException("Multiple operation definitions. Generation Process aborted.")
			}
		}
		input.contents.filter(OperationDefinition).get(0)		  	
	}
}
