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
		EcoreUtil.getRootContainer(startingPoint).eResource().getResourceSet()
			.eAdapters().add(new ECrossReferenceAdapter());
		
		Notifier rootObj = EcoreUtil.getRootContainer(startingPoint, true);		
		if (rootObj instanceof StreamRepository) {
			StreamRepository root = (StreamRepository) rootObj;
			
			/* Validate 3 points for each Node: 
			 * 1. If input size > 0 at least one incoming connection exists
			 * 2. total output size per second <= bandwith of outgoing links
			 * 3. overall output size matches input size for connected outgoing link targets
			 */
			
			Collection<Node> nodes = EcoreUtil.getObjectsByType(root.getNodes(),
					entityPackage.eINSTANCE.getNode());
			for(Node node: nodes) {
				NodeType type = node.getNodetype();
				if(type == null ) continue;
				int inputSize = determineSizeOfData(type.getInput());
				if (inputSize > 0 && getIncomingLinks(node).isEmpty())
					System.err.println("Point 1 voilated at" + node);
				
				if(type.eClass().equals(entityPackage.eINSTANCE.getSinkNodeType())) continue;
				int frequency = ((SourceNodeType)type).getFrequency();
				int outputSize = determineSizeOfData(type.getOutput());
				int outBandwith = getOutgoingLinks(node).stream().map(n->n.getBandwith()).reduce(0, (s,n) -> s+n);
				if (outBandwith < outputSize * frequency)
					System.err.println("Point 2 violated at " + node);
				
				int linkedNodesInput = getOutgoingLinks(node).stream().map(link -> {
					if(link.getTarget() != null && link.getTarget().getNodetype() != null)
						return determineSizeOfData(link.getTarget().getNodetype().getInput());
					return 0;
				}).reduce(0, (s,n) -> s+n);
				if (outputSize > 0 && linkedNodesInput != outputSize)
					System.err.println("Point 3 violated at " + node);
					
			}
		}		
	}
	
	private static Collection<PrimitiveNodeLink> getOutgoingLinks(Node node) {
		ArrayList<PrimitiveNodeLink> result = new ArrayList<>();
		for(Setting ref : getInverseReferences(node)) {
			EObject o = ref.getEObject();
			if(o instanceof PrimitiveNodeLink && ((PrimitiveNodeLink) o).getSource().equals(node))
				result.add((PrimitiveNodeLink) o);
		}
		return result;
	}
	
	private static Collection<PrimitiveNodeLink> getIncomingLinks(Node node) {
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
