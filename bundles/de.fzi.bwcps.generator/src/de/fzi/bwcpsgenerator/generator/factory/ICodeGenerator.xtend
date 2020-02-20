package de.fzi.bwcpsgenerator.generator.factory

import java.util.HashMap
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement

/**
 * Main interface to create a new generation family
 * for a specific programming language.
 */
interface ICodeGenerator {
	
	/**
 	* Defines the method which calls the implementation
 	* for a language specific data transfer object.
 	* @param dataSet Contains all needed elements for the generation.
 	* @return a HashMap which maps the filename to generation-code 
 	* 		  represented as CharSequence.
 	*/
	def HashMap<String, CharSequence> generateDTO(NamedElement element); 
	
	
}
