/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.entity.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class entityFactoryImpl extends EFactoryImpl implements entityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static entityFactory init() {
		try {
			entityFactory theentityFactory = (entityFactory) EPackage.Registry.INSTANCE
					.getEFactory(entityPackage.eNS_URI);
			if (theentityFactory != null) {
				return theentityFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new entityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public entityFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case entityPackage.EDGE_DEVICE:
			return createEdgeDevice();
		case entityPackage.AGGREGATED_NODE_LINK:
			return createAggregatedNodeLink();
		case entityPackage.STREAM_REPOSITORY:
			return createStreamRepository();
		case entityPackage.STREAM:
			return createStream();
		case entityPackage.PRIMITIVE_NODE_LINK:
			return createPrimitiveNodeLink();
		case entityPackage.NODE:
			return createNode();
		case entityPackage.SINK_SOURCE_NODE_TYPE:
			return createSinkSourceNodeType();
		case entityPackage.EDGE_GATEWAY:
			return createEdgeGateway();
		case entityPackage.DATA_SINK:
			return createDataSink();
		case entityPackage.SOURCE_NODE_TYPE:
			return createSourceNodeType();
		case entityPackage.SINK_NODE_TYPE:
			return createSinkNodeType();
		case entityPackage.NODE_TYPE:
			return createNodeType();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case entityPackage.SECURITY_MEASURE:
			return createSecurityMeasureFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case entityPackage.SECURITY_MEASURE:
			return convertSecurityMeasureToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdgeDevice createEdgeDevice() {
		EdgeDeviceImpl edgeDevice = new EdgeDeviceImpl();
		return edgeDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AggregatedNodeLink createAggregatedNodeLink() {
		AggregatedNodeLinkImpl aggregatedNodeLink = new AggregatedNodeLinkImpl();
		return aggregatedNodeLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StreamRepository createStreamRepository() {
		StreamRepositoryImpl streamRepository = new StreamRepositoryImpl();
		return streamRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stream createStream() {
		StreamImpl stream = new StreamImpl();
		return stream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveNodeLink createPrimitiveNodeLink() {
		PrimitiveNodeLinkImpl primitiveNodeLink = new PrimitiveNodeLinkImpl();
		return primitiveNodeLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SinkSourceNodeType createSinkSourceNodeType() {
		SinkSourceNodeTypeImpl sinkSourceNodeType = new SinkSourceNodeTypeImpl();
		return sinkSourceNodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdgeGateway createEdgeGateway() {
		EdgeGatewayImpl edgeGateway = new EdgeGatewayImpl();
		return edgeGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSink createDataSink() {
		DataSinkImpl dataSink = new DataSinkImpl();
		return dataSink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceNodeType createSourceNodeType() {
		SourceNodeTypeImpl sourceNodeType = new SourceNodeTypeImpl();
		return sourceNodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SinkNodeType createSinkNodeType() {
		SinkNodeTypeImpl sinkNodeType = new SinkNodeTypeImpl();
		return sinkNodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeType createNodeType() {
		NodeTypeImpl nodeType = new NodeTypeImpl();
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityMeasure createSecurityMeasureFromString(EDataType eDataType, String initialValue) {
		SecurityMeasure result = SecurityMeasure.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSecurityMeasureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public entityPackage getentityPackage() {
		return (entityPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static entityPackage getPackage() {
		return entityPackage.eINSTANCE;
	}

} //entityFactoryImpl
