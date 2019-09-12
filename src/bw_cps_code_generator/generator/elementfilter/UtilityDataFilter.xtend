package bw_cps_code_generator.generator.elementfilter

import java.util.List
import org.eclipse.emf.ecore.EObject
import java.util.ArrayList
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository

/**
 * Implements the ElementFilter-class.
 */
class UtilityDataFilter extends ElementFilter {
	
	/**
	 * Implements the abstract method of the base-class and filters 
	 * all MeasurementData-elements.
	 * @see ElementFilter#filterData()
	 */
	override List<EObject> filterData() {	
//		var data = new ArrayList<EObject> (input.contents.filter(StreamRepository).head.eAllContents
//					  							.filter(SensorDataDescription).head.eAllContents.toIterable
//					  							.filter(MeasurementData)
//					  							.filter[mData | mData.isAdjusted].toList
//					  					  )
//					  
//		data.addAll(new ArrayList<EObject> (new DataSetFilter().filterData))
//					  
//		data.add(input.contents.filter(SensorInterface).get(0));
//		
//		data
	}
	

}
