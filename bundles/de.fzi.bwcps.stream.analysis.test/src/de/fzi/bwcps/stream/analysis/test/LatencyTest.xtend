package de.fzi.bwcps.stream.analysis.test

import java.util.List
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.Is.is
import static org.hamcrest.core.IsEqual.equalTo
import org.junit.jupiter.api.Test
import de.fzi.bwcps.stream.analysis.BWCPSTimelinessAnalyzer
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository

class LatencyTest extends BWCPSAnalysisTest {
	
	@Test
	def void simpleLatency_valid() {
		var StreamRepository root = loadStreamModel("./models/SimpleLatency.entity")
		var List<BWCPSAnalysisReport> result = new BWCPSTimelinessAnalyzer().run(root.streams)
		assertThat(result.size(), is(1))
		var BWCPSAnalysisReport streamReport = result.get(0)
		assertThat(streamReport.getMessage(), equalTo("Latency: 5020.0"))
		assertThat(streamReport.getDetailedReports().size(), is(3))
	}

	@Test
	def void simpleLatencyUpgradedComputing_valid() {
		var StreamRepository root = loadStreamModel("./models/SimpleLatency.entity")
		root.container.findFirst[it.name.equals("SimpleEdge")].processingSpeed = 1000;
		var List<BWCPSAnalysisReport> result = new BWCPSTimelinessAnalyzer().run(root.getStreams())
		assertThat(result.size(), is(1))
		var BWCPSAnalysisReport streamReport = result.get(0)
		assertThat(streamReport.getMessage(), equalTo("Latency: 15.01"))
		assertThat(streamReport.getDetailedReports().size(), is(3))
	}
}
