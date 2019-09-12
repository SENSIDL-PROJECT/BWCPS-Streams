package bw_cps_code_generator.generator

/**
* Represents a helper interface with the responsibility
* to encapsulate the method calls for generating a data
* transfer-, encoder- and decoder-object.
*/
interface IExecuter {
	
	/**
 	* Defines the method which invokes the method calls 
 	* for generation.
 	*/
	def void execute();
}
