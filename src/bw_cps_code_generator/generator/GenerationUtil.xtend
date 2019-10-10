package bw_cps_code_generator.generator

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import org.eclipse.emf.ecore.EObject
import bw_cps_code_generator.exception.NamedElementException
import bw_cps_code_generator.exception.NoBwcpsFileException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.io.File
import java.io.FileNotFoundException
import org.apache.commons.io.FilenameUtils

/**
 * The GenerationUtil-class is used to implement common methods, which are 
 * used in different generation-classes.
 */
class GenerationUtil {

	static private def getResourceName(NamedElement e) {
			e.class.simpleName.substring(0, e.class.simpleName.length - 4)

	}
	
	static def getEntityUpperName(NamedElement e) {
		if(e.name == "" || e.name === null) {
			e.resourceName
		} else {
			e.name.toFirstUpper
		}
	}
	
	static def getEntityLowerName(NamedElement e) {
		if(e.name == "" || e.name === null) {
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
	
	static def loadResource(String modelPath) {
		// get resource
		val rs = new ResourceSetImpl();
		val file = new File(modelPath);

		// Exception handling for not existing input files
		if (!file.exists()) {
			throw new FileNotFoundException("File with path "+ modelPath + " not found");
		}
		// Exception handling for input files in the wrong format
		if (!BwCPSExtentions.contains(FilenameUtils.getExtension(modelPath))) {
			throw new NoBwcpsFileException("No BWCPS file found");
		}

			rs.getResource(URI.createURI(file.toURI().toString()), true);
	}
}
