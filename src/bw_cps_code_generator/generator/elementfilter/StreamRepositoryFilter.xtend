package bw_cps_code_generator.generator.elementfilter

import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository

class StreamRepositoryFilter extends ElementFilter {

	/**
 	* Implements the abstract method of the base-class and filters the SensorInterface-elements.
	* @see ElementFilter#filterData()
 	*/
	override StreamRepository filterData() {
		//Exception
		input.contents.filter(StreamRepository).get(0)		  	
	}
}
