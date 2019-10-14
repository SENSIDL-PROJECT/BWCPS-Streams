package bw_cps_code_generator.generator.elementfilter

import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import org.eclipse.emf.ecore.resource.Resource
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import java.util.stream.Collectors

class StreamRepositoryFilter extends ElementFilter {
	
	/**
 	* Implements the abstract method of the base-class and filters the SensorInterface-elements.
	* @see ElementFilter#filterData()
 	*/
	
	new(Resource input) {
		super(input)
	}
	
	override StreamRepository filterData() {
		//Exception
		input.contents.filter(StreamRepository).get(0)		  	
	}
	//TODO method gehört nicht hier
	public static def filterNodelinks(StreamRepository streamRepo, NodeContainer nodeContainer) {
		streamRepo.streams.stream
							.map(stream|stream.nodelinks
								.filter[nodelink|nodeContainer.nodes.contains(nodelink.source) || nodeContainer.nodes.contains(nodelink.target)])
								.flatMap(l| l.toList.stream)
       							.collect(Collectors.toList());
	}
}
