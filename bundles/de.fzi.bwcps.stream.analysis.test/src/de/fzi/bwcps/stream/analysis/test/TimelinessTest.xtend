package de.fzi.bwcps.stream.analysis.test

import de.fzi.bwcps.stream.analysis.BWCPSBandwithAnalyzer
import de.fzi.bwcps.stream.analysis.util.BWCPSDataInterpreterImpl
import de.fzi.bwcps.stream.bwcps_streams.entity.entityFactory
import de.fzi.sensidl.design.sensidl.dataRepresentation.Data
import de.fzi.sensidl.design.sensidl.dataRepresentation.DataRepresentationFactory
import de.fzi.sensidl.design.sensidl.dataRepresentation.DataType
import java.util.ArrayList
import java.util.List
import org.junit.jupiter.api.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.Is.is
import static org.hamcrest.core.IsNull.notNullValue
import static org.hamcrest.core.StringContains.containsString

class TimelinessTest extends BWCPSAnalysisTest {
	
	@Test
	def void SimpleValidBandwidthModel_noResultExpected() {
		var root = loadStreamModel("./models/SimpleBandwidth.entity")
		var result = new BWCPSBandwithAnalyzer().run(root.nodes)
		
		assertThat(result.size(), is(0))
	}
	
	@Test
	def void SimpleBandwidthModel_BandwidthTooSmall() {
		var root = loadStreamModel("./models/SimpleBandwidth.entity")
		root.nodelinks.findFirst[name=="Device1-Gateway"].bandwith=7000;
		var result = new BWCPSBandwithAnalyzer().run(root.nodes)
		
		/* Assert a report is generated and the correct minimum bandwidth is calculated according to the default data sizes:
		 * int16 (16), int64 (64), frequency (100)
		 * 100*(16+64) == 8000
		 */
		assertThat(result.size(), is(1));
		assertThat(result.get(0).message, containsString("8000 >="))
	}
	
	@Test
	def void SimpleBadwidthModel_AdaptedDataInterpretation() {
		var root = loadStreamModel("./models/SimpleBandwidth.entity")
		root.nodelinks.findFirst[name=="Device1-Gateway"].bandwith=7000;
		var result = new BWCPSBandwithAnalyzer(new BWCPSDataInterpreterImpl() {			
			override determineSizeOfData(Data data) {
				switch data.dataType {
					case INT16: 1
					case INT64: 1
					default: super.determineSizeOfData(data)
				}
			}			
		}).run(root.nodes)
		/* Assert algorithm uses adapted sizes correctly and generates no report: 100*(1+1) < 7000 */
		assertThat(result.size, is(0));
	}
	
	@Test
	def void SimpleBandwidthModel_InputNotMatchingOutput() {
		var root = loadStreamModel("./models/SimpleBandwidth.entity")
		assertThat(root.nodeTypes.findFirst[name=="StoreData"].input.removeIf[name=="Time"],is(true))
		var result = new BWCPSBandwithAnalyzer().run(root.nodes.findFirst[name=="Receive"]);
		assertThat(result, notNullValue());
		assertThat(result.message, containsString("Point 3 violated"))
	}
	
	@Test
	def void SimpleInOutModel_OutputNotMatchingInput() {
		var root = loadStreamModel("./models/SimpleOutputNotMatching.entity")
		var result = new BWCPSBandwithAnalyzer().run(root.nodes.findFirst[name=="InputWithoutLink"]);
		assertThat(result, notNullValue);
		assertThat(result.message, containsString("Point 1 violated"))
	}
	
	@Test
	def void DataInterpretationTest_ReportMessageContainsCorrectBandwidth() {
		var stream = createStreamModel()
		var sourceNode = entityFactory.eINSTANCE.createNode
		var sourceNodeType = entityFactory.eINSTANCE.createSourceNodeType
		sourceNodeType.frequency = 1
		sourceNode.nodetype = sourceNodeType
		
		var targetNode = entityFactory.eINSTANCE.createNode		
		targetNode.nodetype = entityFactory.eINSTANCE.createSinkSourceNodeType
		
		var link = entityFactory.eINSTANCE.createPrimitiveNodeLink
		link.source = sourceNode
		link.target = targetNode
		
		var measurementData = createAllDataTypes
		sourceNode.nodetype.output.addAll(measurementData)
		targetNode.nodetype.input.addAll(measurementData)
		
		stream.nodelinks.add(link)
		stream.nodes.add(sourceNode)
		stream.nodes.add(targetNode)
		
		var result = new BWCPSBandwithAnalyzer(new BWCPSDataInterpreterImpl() {			
			override determineSizeOfData(Data data) {
				switch data.dataType {
					case BOOLEAN: 2
					case DOUBLE: 4
					case FLOAT: 8
					case INT16: 16
					case INT32: 32
					case INT64: 64
					case INT8: 128
					case STRING: 256
					case UINT16: 512
					case UINT32: 1024
					case UINT64: 2048
					case UINT8: 4096
					case UNDEFINED: 8192
					default: throw new AssertionError("Unknown data type!")
				}
			}			
		}).run(sourceNode)
		
		assertThat(result, notNullValue);
		// bandwidth = frequency * sum(DataType.size)
		var bandwidth = 1 * (2+4+8+16+32+64+128+256+512+1024+2048+4096+8192)
		assertThat(result.message, containsString(bandwidth.toString))
	}
	
	def List<Data> createAllDataTypes() {
		var list = new ArrayList<Data>()
		for (DataType type : DataType.values)
			list.add(createMeasurementData(type))
		list
	}
	
	def Data createMeasurementData(DataType type) {
		var data = DataRepresentationFactory.eINSTANCE.createMeasurementData
		data.name = type.getName
		data.dataType = type
		data
	}	
}