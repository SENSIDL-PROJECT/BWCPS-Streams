/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import de.fzi.bwcps.stream.bwcps_streams.commons.commonsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityFactory
 * @model kind="package"
 * @generated
 */
public interface entityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "entity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.fzi.de/bwcps/stream/entity/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "entity";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	entityPackage eINSTANCE = de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeContainerImpl <em>Node Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeContainerImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNodeContainer()
	 * @generated
	 */
	int NODE_CONTAINER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONTAINER__NAME = commonsPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONTAINER__NODES = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONTAINER_FEATURE_COUNT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Node Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONTAINER_OPERATION_COUNT = commonsPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeDeviceImpl <em>Edge Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeDeviceImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getEdgeDevice()
	 * @generated
	 */
	int EDGE_DEVICE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEVICE__NAME = NODE_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEVICE__NODES = NODE_CONTAINER__NODES;

	/**
	 * The number of structural features of the '<em>Edge Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEVICE_FEATURE_COUNT = NODE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DEVICE_OPERATION_COUNT = NODE_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeLinkImpl <em>Node Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeLinkImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNodeLink()
	 * @generated
	 */
	int NODE_LINK = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LINK__NAME = commonsPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LINK__SOURCE = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LINK__TARGET = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Security Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LINK__SECURITY_MEASURE = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bandwith</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LINK__BANDWITH = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Node Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LINK_FEATURE_COUNT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Node Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LINK_OPERATION_COUNT = commonsPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.AggregatedNodeLinkImpl <em>Aggregated Node Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.AggregatedNodeLinkImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getAggregatedNodeLink()
	 * @generated
	 */
	int AGGREGATED_NODE_LINK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK__NAME = NODE_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK__SOURCE = NODE_LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK__TARGET = NODE_LINK__TARGET;

	/**
	 * The feature id for the '<em><b>Security Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK__SECURITY_MEASURE = NODE_LINK__SECURITY_MEASURE;

	/**
	 * The feature id for the '<em><b>Bandwith</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK__BANDWITH = NODE_LINK__BANDWITH;

	/**
	 * The feature id for the '<em><b>Aggregated Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK__AGGREGATED_LINKS = NODE_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aggregated Node Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK_FEATURE_COUNT = NODE_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Aggregated Node Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_NODE_LINK_OPERATION_COUNT = NODE_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl <em>Stream Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getStreamRepository()
	 * @generated
	 */
	int STREAM_REPOSITORY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY__NAME = commonsPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Streams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY__STREAMS = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY__CONTAINER = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY__NODE_TYPES = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY__NODES = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Nodelinks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY__NODELINKS = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Stream Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY_FEATURE_COUNT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Stream Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_REPOSITORY_OPERATION_COUNT = commonsPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamImpl <em>Stream</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getStream()
	 * @generated
	 */
	int STREAM = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM__NAME = commonsPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Nodelinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM__NODELINKS = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_FEATURE_COUNT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_OPERATION_COUNT = commonsPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.PrimitiveNodeLinkImpl <em>Primitive Node Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.PrimitiveNodeLinkImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getPrimitiveNodeLink()
	 * @generated
	 */
	int PRIMITIVE_NODE_LINK = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NODE_LINK__NAME = NODE_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NODE_LINK__SOURCE = NODE_LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NODE_LINK__TARGET = NODE_LINK__TARGET;

	/**
	 * The feature id for the '<em><b>Security Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NODE_LINK__SECURITY_MEASURE = NODE_LINK__SECURITY_MEASURE;

	/**
	 * The feature id for the '<em><b>Bandwith</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NODE_LINK__BANDWITH = NODE_LINK__BANDWITH;

	/**
	 * The number of structural features of the '<em>Primitive Node Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NODE_LINK_FEATURE_COUNT = NODE_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Node Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NODE_LINK_OPERATION_COUNT = NODE_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = commonsPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Nodetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODETYPE = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operational</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OPERATIONAL = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = commonsPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeTypeImpl <em>Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeTypeImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNodeType()
	 * @generated
	 */
	int NODE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__NAME = commonsPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__REFINES = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__INPUT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__OUTPUT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_FEATURE_COUNT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_OPERATION_COUNT = commonsPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.SourceNodeTypeImpl <em>Source Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.SourceNodeTypeImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSourceNodeType()
	 * @generated
	 */
	int SOURCE_NODE_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_NODE_TYPE__NAME = NODE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_NODE_TYPE__REFINES = NODE_TYPE__REFINES;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_NODE_TYPE__INPUT = NODE_TYPE__INPUT;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_NODE_TYPE__OUTPUT = NODE_TYPE__OUTPUT;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_NODE_TYPE__FREQUENCY = NODE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_NODE_TYPE_FEATURE_COUNT = NODE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Source Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_NODE_TYPE_OPERATION_COUNT = NODE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkSourceNodeTypeImpl <em>Sink Source Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkSourceNodeTypeImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSinkSourceNodeType()
	 * @generated
	 */
	int SINK_SOURCE_NODE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_SOURCE_NODE_TYPE__NAME = SOURCE_NODE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_SOURCE_NODE_TYPE__REFINES = SOURCE_NODE_TYPE__REFINES;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_SOURCE_NODE_TYPE__INPUT = SOURCE_NODE_TYPE__INPUT;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_SOURCE_NODE_TYPE__OUTPUT = SOURCE_NODE_TYPE__OUTPUT;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_SOURCE_NODE_TYPE__FREQUENCY = SOURCE_NODE_TYPE__FREQUENCY;

	/**
	 * The number of structural features of the '<em>Sink Source Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_SOURCE_NODE_TYPE_FEATURE_COUNT = SOURCE_NODE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sink Source Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_SOURCE_NODE_TYPE_OPERATION_COUNT = SOURCE_NODE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeGatewayImpl <em>Edge Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeGatewayImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getEdgeGateway()
	 * @generated
	 */
	int EDGE_GATEWAY = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_GATEWAY__NAME = NODE_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_GATEWAY__NODES = NODE_CONTAINER__NODES;

	/**
	 * The number of structural features of the '<em>Edge Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_GATEWAY_FEATURE_COUNT = NODE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_GATEWAY_OPERATION_COUNT = NODE_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.DataSinkImpl <em>Data Sink</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.DataSinkImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getDataSink()
	 * @generated
	 */
	int DATA_SINK = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SINK__NAME = NODE_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SINK__NODES = NODE_CONTAINER__NODES;

	/**
	 * The number of structural features of the '<em>Data Sink</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SINK_FEATURE_COUNT = NODE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Sink</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SINK_OPERATION_COUNT = NODE_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkNodeTypeImpl <em>Sink Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkNodeTypeImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSinkNodeType()
	 * @generated
	 */
	int SINK_NODE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_NODE_TYPE__NAME = NODE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_NODE_TYPE__REFINES = NODE_TYPE__REFINES;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_NODE_TYPE__INPUT = NODE_TYPE__INPUT;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_NODE_TYPE__OUTPUT = NODE_TYPE__OUTPUT;

	/**
	 * The number of structural features of the '<em>Sink Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_NODE_TYPE_FEATURE_COUNT = NODE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sink Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_NODE_TYPE_OPERATION_COUNT = NODE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure <em>Security Measure</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSecurityMeasure()
	 * @generated
	 */
	int SECURITY_MEASURE = 14;

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeDevice <em>Edge Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Device</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.EdgeDevice
	 * @generated
	 */
	EClass getEdgeDevice();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink <em>Aggregated Node Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Node Link</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink
	 * @generated
	 */
	EClass getAggregatedNodeLink();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink#getAggregatedLinks <em>Aggregated Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Aggregated Links</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink#getAggregatedLinks()
	 * @see #getAggregatedNodeLink()
	 * @generated
	 */
	EReference getAggregatedNodeLink_AggregatedLinks();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository <em>Stream Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Repository</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
	 * @generated
	 */
	EClass getStreamRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getStreams <em>Streams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Streams</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getStreams()
	 * @see #getStreamRepository()
	 * @generated
	 */
	EReference getStreamRepository_Streams();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Container</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getContainer()
	 * @see #getStreamRepository()
	 * @generated
	 */
	EReference getStreamRepository_Container();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodeTypes <em>Node Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node Types</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodeTypes()
	 * @see #getStreamRepository()
	 * @generated
	 */
	EReference getStreamRepository_NodeTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodes()
	 * @see #getStreamRepository()
	 * @generated
	 */
	EReference getStreamRepository_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodelinks <em>Nodelinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodelinks</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodelinks()
	 * @see #getStreamRepository()
	 * @generated
	 */
	EReference getStreamRepository_Nodelinks();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Stream <em>Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.Stream
	 * @generated
	 */
	EClass getStream();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Stream#getNodelinks <em>Nodelinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodelinks</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.Stream#getNodelinks()
	 * @see #getStream()
	 * @generated
	 */
	EReference getStream_Nodelinks();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink <em>Primitive Node Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Node Link</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink
	 * @generated
	 */
	EClass getPrimitiveNodeLink();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Node#getNodetype <em>Nodetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Nodetype</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.Node#getNodetype()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Nodetype();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Node#getOperational <em>Operational</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operational</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.Node#getOperational()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Operational();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkSourceNodeType <em>Sink Source Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sink Source Node Type</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SinkSourceNodeType
	 * @generated
	 */
	EClass getSinkSourceNodeType();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink <em>Node Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Link</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
	 * @generated
	 */
	EClass getNodeLink();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSource()
	 * @see #getNodeLink()
	 * @generated
	 */
	EReference getNodeLink_Source();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getTarget()
	 * @see #getNodeLink()
	 * @generated
	 */
	EReference getNodeLink_Target();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSecurityMeasure <em>Security Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Security Measure</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSecurityMeasure()
	 * @see #getNodeLink()
	 * @generated
	 */
	EAttribute getNodeLink_SecurityMeasure();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getBandwith <em>Bandwith</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bandwith</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getBandwith()
	 * @see #getNodeLink()
	 * @generated
	 */
	EAttribute getNodeLink_Bandwith();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeGateway <em>Edge Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Gateway</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.EdgeGateway
	 * @generated
	 */
	EClass getEdgeGateway();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.DataSink <em>Data Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Sink</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.DataSink
	 * @generated
	 */
	EClass getDataSink();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType <em>Source Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Node Type</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType
	 * @generated
	 */
	EClass getSourceNodeType();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType#getFrequency()
	 * @see #getSourceNodeType()
	 * @generated
	 */
	EAttribute getSourceNodeType_Frequency();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkNodeType <em>Sink Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sink Node Type</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SinkNodeType
	 * @generated
	 */
	EClass getSinkNodeType();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer <em>Node Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Container</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
	 * @generated
	 */
	EClass getNodeContainer();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodes</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer#getNodes()
	 * @see #getNodeContainer()
	 * @generated
	 */
	EReference getNodeContainer_Nodes();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Type</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeType
	 * @generated
	 */
	EClass getNodeType();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refines</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getRefines()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Refines();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getInput()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Input();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getOutput()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Output();

	/**
	 * Returns the meta object for enum '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure <em>Security Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Security Measure</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure
	 * @generated
	 */
	EEnum getSecurityMeasure();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	entityFactory getentityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeDeviceImpl <em>Edge Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeDeviceImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getEdgeDevice()
		 * @generated
		 */
		EClass EDGE_DEVICE = eINSTANCE.getEdgeDevice();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.AggregatedNodeLinkImpl <em>Aggregated Node Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.AggregatedNodeLinkImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getAggregatedNodeLink()
		 * @generated
		 */
		EClass AGGREGATED_NODE_LINK = eINSTANCE.getAggregatedNodeLink();

		/**
		 * The meta object literal for the '<em><b>Aggregated Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_NODE_LINK__AGGREGATED_LINKS = eINSTANCE.getAggregatedNodeLink_AggregatedLinks();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl <em>Stream Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getStreamRepository()
		 * @generated
		 */
		EClass STREAM_REPOSITORY = eINSTANCE.getStreamRepository();

		/**
		 * The meta object literal for the '<em><b>Streams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_REPOSITORY__STREAMS = eINSTANCE.getStreamRepository_Streams();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_REPOSITORY__CONTAINER = eINSTANCE.getStreamRepository_Container();

		/**
		 * The meta object literal for the '<em><b>Node Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_REPOSITORY__NODE_TYPES = eINSTANCE.getStreamRepository_NodeTypes();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_REPOSITORY__NODES = eINSTANCE.getStreamRepository_Nodes();

		/**
		 * The meta object literal for the '<em><b>Nodelinks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_REPOSITORY__NODELINKS = eINSTANCE.getStreamRepository_Nodelinks();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamImpl <em>Stream</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getStream()
		 * @generated
		 */
		EClass STREAM = eINSTANCE.getStream();

		/**
		 * The meta object literal for the '<em><b>Nodelinks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM__NODELINKS = eINSTANCE.getStream_Nodelinks();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.PrimitiveNodeLinkImpl <em>Primitive Node Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.PrimitiveNodeLinkImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getPrimitiveNodeLink()
		 * @generated
		 */
		EClass PRIMITIVE_NODE_LINK = eINSTANCE.getPrimitiveNodeLink();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Nodetype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__NODETYPE = eINSTANCE.getNode_Nodetype();

		/**
		 * The meta object literal for the '<em><b>Operational</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OPERATIONAL = eINSTANCE.getNode_Operational();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkSourceNodeTypeImpl <em>Sink Source Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkSourceNodeTypeImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSinkSourceNodeType()
		 * @generated
		 */
		EClass SINK_SOURCE_NODE_TYPE = eINSTANCE.getSinkSourceNodeType();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeLinkImpl <em>Node Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeLinkImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNodeLink()
		 * @generated
		 */
		EClass NODE_LINK = eINSTANCE.getNodeLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_LINK__SOURCE = eINSTANCE.getNodeLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_LINK__TARGET = eINSTANCE.getNodeLink_Target();

		/**
		 * The meta object literal for the '<em><b>Security Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LINK__SECURITY_MEASURE = eINSTANCE.getNodeLink_SecurityMeasure();

		/**
		 * The meta object literal for the '<em><b>Bandwith</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LINK__BANDWITH = eINSTANCE.getNodeLink_Bandwith();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeGatewayImpl <em>Edge Gateway</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.EdgeGatewayImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getEdgeGateway()
		 * @generated
		 */
		EClass EDGE_GATEWAY = eINSTANCE.getEdgeGateway();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.DataSinkImpl <em>Data Sink</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.DataSinkImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getDataSink()
		 * @generated
		 */
		EClass DATA_SINK = eINSTANCE.getDataSink();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.SourceNodeTypeImpl <em>Source Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.SourceNodeTypeImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSourceNodeType()
		 * @generated
		 */
		EClass SOURCE_NODE_TYPE = eINSTANCE.getSourceNodeType();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_NODE_TYPE__FREQUENCY = eINSTANCE.getSourceNodeType_Frequency();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkNodeTypeImpl <em>Sink Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.SinkNodeTypeImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSinkNodeType()
		 * @generated
		 */
		EClass SINK_NODE_TYPE = eINSTANCE.getSinkNodeType();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeContainerImpl <em>Node Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeContainerImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNodeContainer()
		 * @generated
		 */
		EClass NODE_CONTAINER = eINSTANCE.getNodeContainer();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CONTAINER__NODES = eINSTANCE.getNodeContainer_Nodes();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeTypeImpl <em>Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeTypeImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getNodeType()
		 * @generated
		 */
		EClass NODE_TYPE = eINSTANCE.getNodeType();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__REFINES = eINSTANCE.getNodeType_Refines();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__INPUT = eINSTANCE.getNodeType_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__OUTPUT = eINSTANCE.getNodeType_Output();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure <em>Security Measure</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure
		 * @see de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl#getSecurityMeasure()
		 * @generated
		 */
		EEnum SECURITY_MEASURE = eINSTANCE.getSecurityMeasure();

	}

} //entityPackage
