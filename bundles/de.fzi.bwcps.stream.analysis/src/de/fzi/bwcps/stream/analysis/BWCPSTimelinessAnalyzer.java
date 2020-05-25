package de.fzi.bwcps.stream.analysis;

import static de.fzi.bwcps.stream.analysis.util.BWCPSEcoreUtils.getInverseReferences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;

import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReportImpl;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReportType;
import de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;
import de.fzi.bwcps.stream.bwcps_streams.operations.Operation;

public class BWCPSTimelinessAnalyzer implements BWCPSAnalysis<Stream>, BWCPSSingleElementAnalysis<Stream>{

	public List<BWCPSAnalysisReport> run(List<Stream> elements) {
		List<BWCPSAnalysisReport> results = new ArrayList<>();
		for (Stream s : elements) {
			results.add(analyzeStreamTimeliness(s));
		}
		return results;
	}
	
	public BWCPSAnalysisReport run(Stream element) {
		return analyzeStreamTimeliness(element);
	}
	
	/**
	 * Analyzes each Stream for timeliness based on executed operations and their duration on
	 * the deployed edge devices.
	 * @param s
	 * @return
	 */
	private BWCPSAnalysisReport analyzeStreamTimeliness(Stream stream) {
		Set<Node> nodes = collectNodes(stream.getNodelinks());
		Map<BWCPSAnalysisReport, Float> latencies = calculateNodeLatencies(nodes);		
		return buildReport(stream, latencies);
	}
	
	private BWCPSAnalysisReport buildReport(Stream stream, Map<BWCPSAnalysisReport, Float> latencies) {
		Collection<BWCPSAnalysisReport> nodeReports = new LinkedList<>();
		int streamLatency = 0;
		for (Map.Entry<BWCPSAnalysisReport, Float> pair : latencies.entrySet()) {
			nodeReports.add(pair.getKey());
			streamLatency += pair.getValue();
		}
		return new BWCPSAnalysisReportImpl()
				.type(BWCPSAnalysisReportType.INFO)
				.target(stream)
				.message("Latency: " + streamLatency)
				.detailedReports(nodeReports);
	}
	
	

	private BWCPSAnalysisReport buildReport(Node node, float latency) {
		return new BWCPSAnalysisReportImpl()
				.type(BWCPSAnalysisReportType.INFO)
				.target(node)
				.message("Latency: " + latency);
	}
	
	private BWCPSAnalysisReport buildReportNotDeployed(Node node) {
		return new BWCPSAnalysisReportImpl()
				.type(BWCPSAnalysisReportType.ERROR)
				.target(node)
				.message("Node is not deployed but part of a stream!");
	}
	
	private BWCPSAnalysisReport buildReportMultipleDeployments(Node node) {
		return new BWCPSAnalysisReportImpl()
				.type(BWCPSAnalysisReportType.ERROR)
				.target(node)
				.message("Node is deployed on multiple edge devices!");
	}
	
	private BWCPSAnalysisReport buildReportNoComputingPower(Node node) {
		return new BWCPSAnalysisReportImpl()
				.type(BWCPSAnalysisReportType.ERROR)
				.target(node)
				.message("Node is deployed on an edge device without computing power!");
	}

	private Map<BWCPSAnalysisReport, Float> calculateNodeLatencies(Set<Node> nodes) {
		Map<BWCPSAnalysisReport, Float> map = new HashMap<>();
		for(Node node : nodes) {
			int nodeOps = aggregateOperationDurations(node);
			float duration = 0;
			try {
				int edgePower = determineEdgeProcessing(node);
				if (edgePower == 0) {
					map.put(buildReportNoComputingPower(node), 0f);
				} else {
					duration = nodeOps / (float) edgePower;
					map.put(buildReport(node, duration), duration);
				}
			} catch (NodeNotDeployedException e) {
				map.put(buildReportNotDeployed(node), 0f);
			} catch (NodeDeployedOnMultipleEdgesException e) {
				map.put(buildReportMultipleDeployments(node), 0f);
			}			
		}
		return map;
	}

	private int determineEdgeProcessing(Node node) {
		ArrayList<NodeContainer> deployedOn = new ArrayList<>();
		for(Setting ref : getInverseReferences(node)) {
			EObject o = ref.getEObject();
			if(o instanceof NodeContainer && ((NodeContainer) o).getNodes().contains(node))
				deployedOn.add((NodeContainer)o);
		}
		if(deployedOn.size() > 1) {
			throw new NodeDeployedOnMultipleEdgesException();
		} else if (deployedOn.size() == 0) {
			throw new NodeNotDeployedException();
		} else {
			return deployedOn.get(0).getProcessingSpeed();
		}
	}

	private Set<Node> collectNodes(List<NodeLink> links) {
		if(links != null) {
			return links.stream().map(nl -> {
				if (nl.eClass().equals(entityPackage.eINSTANCE.getAggregatedNodeLink())) {
						return collectNodes(((AggregatedNodeLink)nl).getAggregatedLinks());
					} else {
						return List.of(nl.getSource(), nl.getTarget());
					}
				})
				.flatMap(Collection::stream).collect(Collectors.toSet());
		}
		return Collections.emptySet();
	}
	
	private static int aggregateOperationDurations(Node node) {
		int aggregatedDuration = 0;
		EList<Operation> operations = node.getOperational();		
		if (operations != null) {
			for (Operation o : operations) {
				aggregatedDuration = o.getProcessingUnits();
			}
		}
		return aggregatedDuration;
	}
	
	private class NodeNotDeployedException extends RuntimeException {		
		private static final long serialVersionUID = -5104246542861747581L;
	}
	
	private class NodeDeployedOnMultipleEdgesException extends RuntimeException {
		private static final long serialVersionUID = -917369879840970730L;
	}
}
