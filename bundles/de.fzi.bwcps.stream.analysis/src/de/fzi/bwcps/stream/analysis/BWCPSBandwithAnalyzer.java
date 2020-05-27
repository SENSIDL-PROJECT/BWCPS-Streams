package de.fzi.bwcps.stream.analysis;

import static de.fzi.bwcps.stream.analysis.util.BWCPSEcoreUtils.getInverseReferences;
import static de.fzi.bwcps.stream.analysis.util.BWCPSEcoreUtils.applyECrossReferenceAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReportImpl;
import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReportType;
import de.fzi.bwcps.stream.analysis.util.BWCPSDataInterpreter;
import de.fzi.bwcps.stream.analysis.util.BWCPSDataInterpreterImpl;
import de.fzi.bwcps.stream.analysis.util.BWCPSEcoreUtils;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

public class BWCPSBandwithAnalyzer implements BWCPSAnalysis<Node>, BWCPSSingleElementAnalysis<Node> {

BWCPSDataInterpreter dataInterpreter;	
	
	public BWCPSBandwithAnalyzer() {
		dataInterpreter = new BWCPSDataInterpreterImpl();
	}
	
	public BWCPSBandwithAnalyzer(BWCPSDataInterpreter customDataInterpreter) {
		this.dataInterpreter = customDataInterpreter;
	}
	
	
	/**
	 * Analyzes a BWCPS node based on three qualities and returns an error message if any of them are not fulfilled:
	 * * 1. If input size > 0 and at least one incoming connection exists
	 * * 2. Total output size per second <= bandwidth of outgoing links
	 * * 3. Overall output size <= input size for connected outgoing link targets
	 * If all qualities are fulfilled the method returns null.
	 *  
	 * @param node
	 * @return BWCPSAnalysisReport or null
	 */
	public BWCPSAnalysisReport run(Node element) {
		applyECrossReferenceAdapter(element);
		return analyzeNode_internal(element);
	}

	/**
	 * Analyzes all BWCPS nodes in the given list based on three qualities and returns a warning if any of them are not fulfilled:
	 * * 1. If input size > 0 and at least one incoming connection exists
	 * * 2. Total output size per second <= bandwidth of outgoing links
	 * * 3. Overall output size <= input size for connected outgoing link targets
	 * If all qualities are fulfilled the method returns null.
	 *  
	 * @param node
	 * @return BWCPSAnalysisReport or null
	 */
	public List<BWCPSAnalysisReport> run(Collection<Node> elements) {
		if(elements == null || elements.isEmpty())
			return Collections.emptyList();
		
		// Add cross references adapter to resource set to resolve inverse cross references
		applyECrossReferenceAdapter(elements.iterator().next());
		
		/* Validate 3 points for each Node: 
		 * 1. If input size > 0 and at least one incoming connection exists
		 * 2. Total output size per second <= bandwidth of outgoing links
		 * 3. Overall output size <= input size for connected outgoing link targets
		 */
		List<BWCPSAnalysisReport> results = new ArrayList<>();
		for(Node node: elements) {
			BWCPSAnalysisReport report = analyzeNode_internal(node);
			if (report != null)
				results.add(report);
		}
		return results;
	}
	
	/**
	 * Analyzes a BWCPS node based on three qualities and returns an error message if any of them are not fulfilled:
	 * * 1. If input size > 0 and at least one incoming connection exists
	 * * 2. Total output size per second <= bandwidth of outgoing links
	 * * 3. Overall output size <= input size for connected outgoing link targets
	 * If all qualities are fulfilled the method returns null.
	 *  
	 * @param node
	 * @return Error message or null
	 */
	private BWCPSAnalysisReport analyzeNode_internal(Node node) {
		NodeType type = node.getNodetype();
		if(type == null ) return buildReportNodeTypeNotSet(node);
		int inputSize = determineInputSize(type);
		if (inputSize > 0 && getIncomingLinks(node).isEmpty())
			return buildReportPoint1(node, inputSize);
		
		if(type.eClass().equals(entityPackage.eINSTANCE.getSinkNodeType())) return null;
		int frequency = ((SourceNodeType)type).getFrequency();
		int outputSize = determineOutputSize(type);
		int outBandwith = getOutgoingLinks(node).stream().mapToInt(n->n.getBandwith()).sum();
		
		if (outBandwith < outputSize * frequency)
			return buildReportPoint2(node, outputSize * frequency, outBandwith);
		
		int linkedNodesInput = getOutgoingLinks(node).stream().mapToInt(link -> {
			if(link.getTarget() != null && link.getTarget().getNodetype() != null)
				return determineInputSize(link.getTarget().getNodetype());
			return 0;
		}).sum();
		if (outputSize > 0 && linkedNodesInput < outputSize)
			return buildReportPoint3(node, outputSize, linkedNodesInput);
		return null;
	}	
	
	/**
	 * Calculate input size for a NodeType while also regarding refining types
	 * @param type
	 * @return
	 */
	private int determineInputSize(NodeType type) {
		return type.getRefines().stream().mapToInt(t->determineInputSize(t)).sum()
				+ dataInterpreter.determineSizeOfData(type.getInput());
	}
	
	/**
	 * Calculate output size for a NodeType while also regarding refining types
	 * @param type
	 * @return
	 */
	private int determineOutputSize(NodeType type) {
		return type.getRefines().stream().mapToInt(t->determineOutputSize(t)).sum()
				+ dataInterpreter.determineSizeOfData(type.getOutput());
	}
	
	private Collection<PrimitiveNodeLink> getOutgoingLinks(Node node) {
		ArrayList<PrimitiveNodeLink> result = new ArrayList<>();
		for(Setting ref : getInverseReferences(node)) {
			EObject o = ref.getEObject();
			if(o instanceof PrimitiveNodeLink && ((PrimitiveNodeLink) o).getSource().equals(node))
				result.add((PrimitiveNodeLink) o);
		}
		return result;
	}
	
	private Collection<PrimitiveNodeLink> getIncomingLinks(Node node) {
		ArrayList<PrimitiveNodeLink> result = new ArrayList<>();
		for(Setting ref : getInverseReferences(node)) {
			EObject o = ref.getEObject();
			if(o instanceof PrimitiveNodeLink && ((PrimitiveNodeLink) o).getTarget().equals(node))
				result.add((PrimitiveNodeLink) o);
		}
		return result;
	}
	
	private BWCPSAnalysisReport buildReportNodeTypeNotSet(Node node) {
		return new BWCPSAnalysisReportImpl()
				.message("NodeType not set!")
				.target(node)
				.type(BWCPSAnalysisReportType.ERROR);
	}
	
	private BWCPSAnalysisReport buildReportPoint1(Node node, int inputSize) {		
		return new BWCPSAnalysisReportImpl()
				.message(String.format("Point 1 voilated: Input size %s > 0 with no existing incoming connection.", inputSize))
				.target(node)
				.type(BWCPSAnalysisReportType.WARNING);
	}

	private BWCPSAnalysisReport buildReportPoint2(Node node, int outputSize, int outBandwith) {
		return new BWCPSAnalysisReportImpl()
				.message(String.format("Point 2 violated: Total output size per second %s >= bandwith %s of outgoing links",outputSize, outBandwith))
				.target(node)
				.type(BWCPSAnalysisReportType.WARNING);
	}
	
	private BWCPSAnalysisReport buildReportPoint3(Node node, int outputSize, int linkedInputSize) {
		return new BWCPSAnalysisReportImpl()
				.message(String.format("Point 3 violated: Overall output size %s > input size %s for connected outgoing link targets",
						outputSize, linkedInputSize))
				.target(node)
				.type(BWCPSAnalysisReportType.WARNING);
	}

}
