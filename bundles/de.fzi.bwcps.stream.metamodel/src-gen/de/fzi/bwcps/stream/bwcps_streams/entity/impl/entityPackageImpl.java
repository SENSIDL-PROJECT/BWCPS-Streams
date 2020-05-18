/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.commonsPackage;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.commonsPackageImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.DataSink;
import de.fzi.bwcps.stream.bwcps_streams.entity.EdgeDevice;
import de.fzi.bwcps.stream.bwcps_streams.entity.EdgeGateway;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure;
import de.fzi.bwcps.stream.bwcps_streams.entity.SinkNodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.SinkSourceNodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityFactory;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl;

import de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage;

import de.fzi.sensidl.design.sensidl.dataRepresentation.DataRepresentationPackage;

import de.fzi.sensidl.design.sensidl.sensidlPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class entityPackageImpl extends EPackageImpl implements entityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatedNodeLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveNodeLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sinkSourceNodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeGatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceNodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sinkNodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum securityMeasureEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private entityPackageImpl() {
		super(eNS_URI, entityFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link entityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static entityPackage init() {
		if (isInited)
			return (entityPackage) EPackage.Registry.INSTANCE.getEPackage(entityPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredentityPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		entityPackageImpl theentityPackage = registeredentityPackage instanceof entityPackageImpl
				? (entityPackageImpl) registeredentityPackage
				: new entityPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		sensidlPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(operationsPackage.eNS_URI);
		operationsPackageImpl theoperationsPackage = (operationsPackageImpl) (registeredPackage instanceof operationsPackageImpl
				? registeredPackage
				: operationsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(commonsPackage.eNS_URI);
		commonsPackageImpl thecommonsPackage = (commonsPackageImpl) (registeredPackage instanceof commonsPackageImpl
				? registeredPackage
				: commonsPackage.eINSTANCE);

		// Create package meta-data objects
		theentityPackage.createPackageContents();
		theoperationsPackage.createPackageContents();
		thecommonsPackage.createPackageContents();

		// Initialize created meta-data
		theentityPackage.initializePackageContents();
		theoperationsPackage.initializePackageContents();
		thecommonsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theentityPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(entityPackage.eNS_URI, theentityPackage);
		return theentityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeDevice() {
		return edgeDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAggregatedNodeLink() {
		return aggregatedNodeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregatedNodeLink_AggregatedLinks() {
		return (EReference) aggregatedNodeLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStreamRepository() {
		return streamRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStreamRepository_Streams() {
		return (EReference) streamRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStreamRepository_Container() {
		return (EReference) streamRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStreamRepository_NodeTypes() {
		return (EReference) streamRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStreamRepository_Nodes() {
		return (EReference) streamRepositoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStreamRepository_Nodelinks() {
		return (EReference) streamRepositoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStream() {
		return streamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStream_Nodelinks() {
		return (EReference) streamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveNodeLink() {
		return primitiveNodeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Nodetype() {
		return (EReference) nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Operational() {
		return (EReference) nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSinkSourceNodeType() {
		return sinkSourceNodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeLink() {
		return nodeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeLink_Source() {
		return (EReference) nodeLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeLink_Target() {
		return (EReference) nodeLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNodeLink_SecurityMeasure() {
		return (EAttribute) nodeLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNodeLink_Bandwith() {
		return (EAttribute) nodeLinkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeGateway() {
		return edgeGatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSink() {
		return dataSinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSourceNodeType() {
		return sourceNodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSourceNodeType_Frequency() {
		return (EAttribute) sourceNodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSinkNodeType() {
		return sinkNodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeContainer() {
		return nodeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeContainer_Nodes() {
		return (EReference) nodeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeType() {
		return nodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeType_Refines() {
		return (EReference) nodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeType_Input() {
		return (EReference) nodeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeType_Output() {
		return (EReference) nodeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSecurityMeasure() {
		return securityMeasureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public entityFactory getentityFactory() {
		return (entityFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		edgeDeviceEClass = createEClass(EDGE_DEVICE);

		aggregatedNodeLinkEClass = createEClass(AGGREGATED_NODE_LINK);
		createEReference(aggregatedNodeLinkEClass, AGGREGATED_NODE_LINK__AGGREGATED_LINKS);

		streamRepositoryEClass = createEClass(STREAM_REPOSITORY);
		createEReference(streamRepositoryEClass, STREAM_REPOSITORY__STREAMS);
		createEReference(streamRepositoryEClass, STREAM_REPOSITORY__CONTAINER);
		createEReference(streamRepositoryEClass, STREAM_REPOSITORY__NODE_TYPES);
		createEReference(streamRepositoryEClass, STREAM_REPOSITORY__NODES);
		createEReference(streamRepositoryEClass, STREAM_REPOSITORY__NODELINKS);

		streamEClass = createEClass(STREAM);
		createEReference(streamEClass, STREAM__NODELINKS);

		primitiveNodeLinkEClass = createEClass(PRIMITIVE_NODE_LINK);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__NODETYPE);
		createEReference(nodeEClass, NODE__OPERATIONAL);

		sinkSourceNodeTypeEClass = createEClass(SINK_SOURCE_NODE_TYPE);

		nodeLinkEClass = createEClass(NODE_LINK);
		createEReference(nodeLinkEClass, NODE_LINK__SOURCE);
		createEReference(nodeLinkEClass, NODE_LINK__TARGET);
		createEAttribute(nodeLinkEClass, NODE_LINK__SECURITY_MEASURE);
		createEAttribute(nodeLinkEClass, NODE_LINK__BANDWITH);

		edgeGatewayEClass = createEClass(EDGE_GATEWAY);

		dataSinkEClass = createEClass(DATA_SINK);

		sourceNodeTypeEClass = createEClass(SOURCE_NODE_TYPE);
		createEAttribute(sourceNodeTypeEClass, SOURCE_NODE_TYPE__FREQUENCY);

		sinkNodeTypeEClass = createEClass(SINK_NODE_TYPE);

		nodeContainerEClass = createEClass(NODE_CONTAINER);
		createEReference(nodeContainerEClass, NODE_CONTAINER__NODES);

		nodeTypeEClass = createEClass(NODE_TYPE);
		createEReference(nodeTypeEClass, NODE_TYPE__REFINES);
		createEReference(nodeTypeEClass, NODE_TYPE__INPUT);
		createEReference(nodeTypeEClass, NODE_TYPE__OUTPUT);

		// Create enums
		securityMeasureEEnum = createEEnum(SECURITY_MEASURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		commonsPackage thecommonsPackage = (commonsPackage) EPackage.Registry.INSTANCE
				.getEPackage(commonsPackage.eNS_URI);
		operationsPackage theoperationsPackage = (operationsPackage) EPackage.Registry.INSTANCE
				.getEPackage(operationsPackage.eNS_URI);
		DataRepresentationPackage theDataRepresentationPackage = (DataRepresentationPackage) EPackage.Registry.INSTANCE
				.getEPackage(DataRepresentationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		edgeDeviceEClass.getESuperTypes().add(this.getNodeContainer());
		aggregatedNodeLinkEClass.getESuperTypes().add(this.getNodeLink());
		streamRepositoryEClass.getESuperTypes().add(thecommonsPackage.getNamedElement());
		streamEClass.getESuperTypes().add(thecommonsPackage.getNamedElement());
		primitiveNodeLinkEClass.getESuperTypes().add(this.getNodeLink());
		nodeEClass.getESuperTypes().add(thecommonsPackage.getNamedElement());
		sinkSourceNodeTypeEClass.getESuperTypes().add(this.getSourceNodeType());
		sinkSourceNodeTypeEClass.getESuperTypes().add(this.getSinkNodeType());
		nodeLinkEClass.getESuperTypes().add(thecommonsPackage.getNamedElement());
		edgeGatewayEClass.getESuperTypes().add(this.getNodeContainer());
		dataSinkEClass.getESuperTypes().add(this.getNodeContainer());
		sourceNodeTypeEClass.getESuperTypes().add(this.getNodeType());
		sinkNodeTypeEClass.getESuperTypes().add(this.getNodeType());
		nodeContainerEClass.getESuperTypes().add(thecommonsPackage.getNamedElement());
		nodeTypeEClass.getESuperTypes().add(thecommonsPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(edgeDeviceEClass, EdgeDevice.class, "EdgeDevice", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(aggregatedNodeLinkEClass, AggregatedNodeLink.class, "AggregatedNodeLink", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregatedNodeLink_AggregatedLinks(), this.getNodeLink(), null, "aggregatedLinks", null, 1,
				-1, AggregatedNodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(streamRepositoryEClass, StreamRepository.class, "StreamRepository", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStreamRepository_Streams(), this.getStream(), null, "streams", null, 0, -1,
				StreamRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStreamRepository_Container(), this.getNodeContainer(), null, "container", null, 0, -1,
				StreamRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStreamRepository_NodeTypes(), this.getNodeType(), null, "nodeTypes", null, 0, -1,
				StreamRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStreamRepository_Nodes(), this.getNode(), null, "nodes", null, 0, -1, StreamRepository.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStreamRepository_Nodelinks(), this.getNodeLink(), null, "nodelinks", null, 0, -1,
				StreamRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(streamEClass, Stream.class, "Stream", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStream_Nodelinks(), this.getNodeLink(), null, "nodelinks", null, 1, -1, Stream.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveNodeLinkEClass, PrimitiveNodeLink.class, "PrimitiveNodeLink", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_Nodetype(), this.getNodeType(), null, "nodetype", null, 1, 1, Node.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getNode_Operational(), theoperationsPackage.getOperation(), null, "operational", null, 0, -1,
				Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sinkSourceNodeTypeEClass, SinkSourceNodeType.class, "SinkSourceNodeType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodeLinkEClass, NodeLink.class, "NodeLink", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeLink_Source(), this.getNode(), null, "source", null, 1, 1, NodeLink.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getNodeLink_Target(), this.getNode(), null, "target", null, 1, 1, NodeLink.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getNodeLink_SecurityMeasure(), this.getSecurityMeasure(), "securityMeasure", "NONE", 0, 1,
				NodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeLink_Bandwith(), ecorePackage.getEInt(), "bandwith", null, 0, 1, NodeLink.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeGatewayEClass, EdgeGateway.class, "EdgeGateway", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataSinkEClass, DataSink.class, "DataSink", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceNodeTypeEClass, SourceNodeType.class, "SourceNodeType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceNodeType_Frequency(), ecorePackage.getEInt(), "frequency", null, 0, 1,
				SourceNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(sinkNodeTypeEClass, SinkNodeType.class, "SinkNodeType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodeContainerEClass, NodeContainer.class, "NodeContainer", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeContainer_Nodes(), this.getNode(), null, "nodes", null, 1, -1, NodeContainer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeTypeEClass, NodeType.class, "NodeType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeType_Refines(), this.getNodeType(), null, "refines", null, 0, -1, NodeType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeType_Input(), theDataRepresentationPackage.getData(), null, "input", null, 0, -1,
				NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeType_Output(), theDataRepresentationPackage.getData(), null, "output", null, 0, -1,
				NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(securityMeasureEEnum, SecurityMeasure.class, "SecurityMeasure");
		addEEnumLiteral(securityMeasureEEnum, SecurityMeasure.ENCRYPT);
		addEEnumLiteral(securityMeasureEEnum, SecurityMeasure.AUTHENTICATE);
		addEEnumLiteral(securityMeasureEEnum, SecurityMeasure.ENC_THEN_AUTH);
		addEEnumLiteral(securityMeasureEEnum, SecurityMeasure.NONE);

		// Create resource
		createResource(eNS_URI);
	}

} //entityPackageImpl
