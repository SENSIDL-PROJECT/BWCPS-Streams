package bw_cps_code_generator.generator.elementfilter

import org.eclipse.emf.ecore.resource.Resource

/**
 * This class represents the superclass for particular element-filters.
 */
abstract class ElementFilter {
	protected var Resource input;

	new(Resource input) {
		this.input = input
	}
	/**
	 * This abstract method has to be implemented by a subclass which is 
	 * up to filter a particular collection of sensidl-elements.
	 * @return the list of the filtered data.
	 */
	abstract def <T> T filterData()
}
