package bw_cps_code_generator.generator

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement

/**
 * The GenerationUtil-class is used to implement common methods, which are 
 * used in different generation-classes.
 */
class GenerationUtil {

	/**
	 * Ensures that the first letter is capitalized.
	 * @param d Represents the Data-object.
	 * @return the name of the Data-object with an upper first letter. 
	 */
	static def toNameUpper(NamedElement e) {
		e.name.toFirstUpper
	}

	/**
	 * Ensures that the first letter of the DataSet-object is lower case.
	 * @return d Represents the DataSet-object.
	 * @return the name of the DataSet with a lower first letter
	 */
	static def toNameLower(NamedElement e) {
		e.name.toFirstLower
	}
	
	static def getEntityName(NamedElement e) {
//		(d.name == "" || d.name == null) ? d.class.simpleName.substring(0,
//			d.class.simpleName.length - 4) : toNameUpper(d)
		if(e.name == "" || e.name == null) {
			e.class.simpleName.substring(0, e.class.simpleName.length - 4)
		} else {
			toNameUpper(e)
		}
	}
		static def getClassName(NamedElement e) {
			e.class.simpleName.substring(0, e.class.simpleName.length - 4)

	}
}
