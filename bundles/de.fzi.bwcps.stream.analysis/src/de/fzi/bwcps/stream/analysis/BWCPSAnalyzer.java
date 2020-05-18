package de.fzi.bwcps.stream.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import static de.fzi.bwcps.stream.analysis.util.BWCPSDataInterpreter.determineSizeOfData;

public class BWCPSAnalyzer {
	
	public void start(NamedElement startingPoint) {
		// Add cross references adapter to resource set resolve inverse cross references
		startingPoint.eResource().getResourceSet()
			.eAdapters().add(new ECrossReferenceAdapter());
		
		Notifier rootObj = EcoreUtil.getRootContainer(startingPoint, true);		
		if (rootObj instanceof StreamRepository) {
			StreamRepository root = (StreamRepository) rootObj;
			
			/* Validate 3 points for each Node: 
			 * 1. If input size > 0 and at least one incoming connection exists
			 * 2. Total output size per second <= bandwidth of outgoing links
			 * 3. Overall output size <= input size for connected outgoing link targets
			 */
			
			Collection<Node> nodes = EcoreUtil.getObjectsByType(root.getNodes(),
					entityPackage.eINSTANCE.getNode());
			for(Node node: nodes) {
				String result = analyzeNode_internal(node);
				if(result != null) System.err.println(result);
			}
		}		
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
	private String analyzeNode_internal(Node node) {
		NodeType type = node.getNodetype();
		if(type == null ) return String.format("NodeType for Node %s not set!", node);
		int inputSize = determineInputSize(type);
		if (inputSize > 0 && getIncomingLinks(node).isEmpty())
			return String.format("Point 1 voilated at %s:\n Input size %s > 0 with no existing incoming connection.",
					node, inputSize);
		
		if(type.eClass().equals(entityPackage.eINSTANCE.getSinkNodeType())) return null;
		int frequency = ((SourceNodeType)type).getFrequency();
		int outputSize = determineOutputSize(type);
		int outBandwith = getOutgoingLinks(node).stream().mapToInt(n->n.getBandwith()).sum();
		
		if (outBandwith < outputSize * frequency)
			return String.format("Point 2 violated at %s:\n Total output size per second %s >= bandwith %s of outgoing links", 
					node, outputSize * frequency, outBandwith);
		
		int linkedNodesInput = getOutgoingLinks(node).stream().mapToInt(link -> {
			if(link.getTarget() != null && link.getTarget().getNodetype() != null)
				return determineInputSize(link.getTarget().getNodetype());
			return 0;
		}).sum();
		if (outputSize > 0 && linkedNodesInput < outputSize)
			return String.format("Point 3 violated at %s:\\n\"\n"
					+" Overall output size %s > input size %s for connected outgoing link targets",
					node, outputSize, linkedNodesInput);
		return null;
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
	public String analyzeNode(Node node) {		
		if (ECrossReferenceAdapter.getCrossReferenceAdapter(node) == null)
		// Add cross references adapter to resource set resolve inverse cross references
		node.eResource().getResourceSet()
			.eAdapters().add(new ECrossReferenceAdapter());
		return analyzeNode_internal(node);
	}
	
	
	/**
	 * Calculate input size for a NodeType while also regarding refining types
	 * @param type
	 * @return
	 */
	private int determineInputSize(NodeType type) {
		return type.getRefines().stream().mapToInt(t->determineInputSize(t)).sum()
				+ determineSizeOfData(type.getInput());
	}
	
	/**
	 * Calculate output size for a NodeType while also regarding refining types
	 * @param type
	 * @return
	 */
	private int determineOutputSize(NodeType type) {
		return type.getRefines().stream().mapToInt(t->determineOutputSize(t)).sum()
				+ determineSizeOfData(type.getOutput());
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
	
	private static Collection<Setting> getInverseReferences(EObject eObject) {
		  ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter
		    .getCrossReferenceAdapter(eObject);
		  return crossReferenceAdapter == null
		    ? Collections.<Setting> emptyList()
		    : crossReferenceAdapter.getInverseReferences(eObject, true);
		}
}
