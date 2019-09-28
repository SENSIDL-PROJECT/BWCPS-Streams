package bw_cps_code_generator.generator.elementfilter

import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import java.util.List

class NodeContainerFilter extends ElementFilter {

	/**
 	* Implements the abstract method of the base-class and filters the SensorInterface-elements.
	* @see ElementFilter#filterData()
 	*/
	override List<NodeContainer> filterData() {
		//Exception
		input.contents.filter(NodeContainer).toList		  	
	}
}
