package bw_cps_code_generator.generator.elementfilter

import de.fzi.bwcps.stream.bwcps_streams.entity.Stream

class StreamFilter extends ElementFilter {


	override Stream filterData() {
		input.contents.filter(Stream).get(0)				  	
	}
}
