package bw_cps_code_generator.generator.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage;
import bw_cps_code_generator.generator.generationstep.DTOGenerationStep;
import bw_cps_code_generator.generator.generationstep.GenerationStep;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityFactory;
import de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl;
import de.fzi.bwcps.stream.bwcps_streams.operations.Operation;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsFactory;
import de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl;
import de.fzi.sensidl.design.sensidl.dataRepresentation.DataRepresentationFactory;
import de.fzi.sensidl.design.sensidl.dataRepresentation.MeasurementData;
import de.fzi.sensidl.design.sensidl.dataRepresentation.impl.DataRepresentationPackageImpl;

public class DTOGenerationTest {
	DTOGenerationStep step;
	NodeContainer nodeContainer;
	List<Node> nodes;
	
	private static Map<String, Boolean> fileIsGenerated;
	private List<NodeLink> nodelinks;
	
	
	@Before
	public void setUp() {
		createmodel();
		step = new DTOGenerationStep(nodeContainer, nodelinks);
		GenerationStep.setGlobalSettings(GenerationLanguage.OSGI_BUNDLES);
		fileIsGenerated = new HashMap<>();
	}
	@Test
	public void dtoGenerationTest() {
		for(String nodeName : nodes.stream().map(Node::getName).collect(Collectors.toList())) {
			fileIsGenerated.put(nodeName + ".java", false);
		}
		fileIsGenerated.put("NodeType.java", false);
		fileIsGenerated.put("SinkSource.java", false);
		fileIsGenerated.put("SinkSourceInputDataSet.sidl", false);
		fileIsGenerated.put("SinkSourceOutputDataSet.sidl", false);
		step.startGenerationTask();
		
		checkGeneratedFiles();
		
	}
	private void createmodel() {
		entityPackageImpl.init();
		operationsPackageImpl.init();
		DataRepresentationPackageImpl.init();
		Node preprocessor = entityFactory.eINSTANCE.createNode();
		Node publisher = entityFactory.eINSTANCE.createNode();
		
		preprocessor.setName("Preprocessor");
		publisher.setName("Publisher");
		
		Operation op = operationsFactory.eINSTANCE.createAtomicOperation();
		op.setName("op");
		op.setDomain(operationsFactory.eINSTANCE.createDomain());
		op.setRange(operationsFactory.eINSTANCE.createDomain());
		
		preprocessor.getOperational().add(op);
		publisher.getOperational().add(op);
		
		NodeType nodetype = entityFactory.eINSTANCE.createSinkSourceNodeType();
		nodetype.setName("SinkSource");
		MeasurementData data = DataRepresentationFactory.eINSTANCE.createMeasurementData();
		data.getName();
		nodetype.getInput().add(data);
		nodetype.getOutput().add(data);
		
		preprocessor.setNodetype(nodetype);
		publisher.setNodetype(nodetype);
		nodes = new ArrayList<>();
		nodes.add(preprocessor);
		nodes.add(publisher);
		
		NodeLink nodelink = entityFactory.eINSTANCE.createPrimitiveNodeLink();
		nodelink.setSource(preprocessor);
		nodelink.setTarget(publisher);
		nodelink.setSecurityMeasure(SecurityMeasure.ENC_THEN_AUTH);
		nodelinks = new ArrayList<NodeLink>();
		nodelinks.add(nodelink);
		
		nodeContainer = entityFactory.eINSTANCE.createEdgeGateway();
		
		nodeContainer.setName("Gateway");
		
		nodeContainer.getNodes().addAll(nodes);
	}
	private void checkGeneratedFiles() {
		for (String file : GenerationStep.getFilesToGenerate().keySet()) {
			if (fileIsGenerated.containsKey(file)) {
				fileIsGenerated.put(file, true);
			} else {
				throw new AssertionError(file + " should not get generated");
			}
		}
		for (Entry<String, Boolean> entry : fileIsGenerated.entrySet()) {
			if (!entry.getValue()) {
				throw new AssertionError(entry.getKey() + " is missing");
			}
		}
	}
}
