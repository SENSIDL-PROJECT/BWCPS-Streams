package bw_cps_code_generator.generator

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import org.eclipse.emf.ecore.EObject
import bw_cps_code_generator.exception.NamedElementException

/**
 * The GenerationUtil-class is used to implement common methods, which are 
 * used in different generation-classes.
 */
class GenerationUtil {

	static private def getResourceName(NamedElement e) {
			e.class.simpleName.substring(0, e.class.simpleName.length - 4)

	}
	
	static def getEntityUpperName(NamedElement e) {
		if(e.name == "" || e.name == null) {
			e.resourceName
		} else {
			e.name.toFirstUpper
		}
	}
	
	static def getEntityLowerName(NamedElement e) {
		if(e.name == "" || e.name == null) {
			e.resourceName
		} else {
			e.name.toFirstLower
		}
	}
	
	static def NamedElement getNamedElement(EObject currentElement) {
		if (currentElement instanceof NamedElement) {
			return (currentElement as NamedElement);
		}
		throw new NamedElementException(currentElement);
	}

}
