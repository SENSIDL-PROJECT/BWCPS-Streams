/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.util;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

import de.fzi.bwcps.stream.bwcps_streams.entity.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage
 * @generated
 */
public class entityAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static entityPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public entityAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = entityPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected entitySwitch<Adapter> modelSwitch = new entitySwitch<Adapter>() {
		@Override
		public Adapter caseEdgeDevice(EdgeDevice object) {
			return createEdgeDeviceAdapter();
		}

		@Override
		public Adapter caseAggregatedNodeLink(AggregatedNodeLink object) {
			return createAggregatedNodeLinkAdapter();
		}

		@Override
		public Adapter caseStreamRepository(StreamRepository object) {
			return createStreamRepositoryAdapter();
		}

		@Override
		public Adapter caseStream(Stream object) {
			return createStreamAdapter();
		}

		@Override
		public Adapter casePrimitiveNodeLink(PrimitiveNodeLink object) {
			return createPrimitiveNodeLinkAdapter();
		}

		@Override
		public Adapter caseNode(Node object) {
			return createNodeAdapter();
		}

		@Override
		public Adapter caseSinkSourceNodeType(SinkSourceNodeType object) {
			return createSinkSourceNodeTypeAdapter();
		}

		@Override
		public Adapter caseNodeLink(NodeLink object) {
			return createNodeLinkAdapter();
		}

		@Override
		public Adapter caseEdgeGateway(EdgeGateway object) {
			return createEdgeGatewayAdapter();
		}

		@Override
		public Adapter caseDataSink(DataSink object) {
			return createDataSinkAdapter();
		}

		@Override
		public Adapter caseSourceNodeType(SourceNodeType object) {
			return createSourceNodeTypeAdapter();
		}

		@Override
		public Adapter caseSinkNodeType(SinkNodeType object) {
			return createSinkNodeTypeAdapter();
		}

		@Override
		public Adapter caseNodeContainer(NodeContainer object) {
			return createNodeContainerAdapter();
		}

		@Override
		public Adapter caseNodeType(NodeType object) {
			return createNodeTypeAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeDevice <em>Edge Device</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.EdgeDevice
	 * @generated
	 */
	public Adapter createEdgeDeviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink <em>Aggregated Node Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink
	 * @generated
	 */
	public Adapter createAggregatedNodeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository <em>Stream Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
	 * @generated
	 */
	public Adapter createStreamRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Stream <em>Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.Stream
	 * @generated
	 */
	public Adapter createStreamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink <em>Primitive Node Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink
	 * @generated
	 */
	public Adapter createPrimitiveNodeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkSourceNodeType <em>Sink Source Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SinkSourceNodeType
	 * @generated
	 */
	public Adapter createSinkSourceNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink <em>Node Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
	 * @generated
	 */
	public Adapter createNodeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeGateway <em>Edge Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.EdgeGateway
	 * @generated
	 */
	public Adapter createEdgeGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.DataSink <em>Data Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.DataSink
	 * @generated
	 */
	public Adapter createDataSinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType <em>Source Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType
	 * @generated
	 */
	public Adapter createSourceNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkNodeType <em>Sink Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SinkNodeType
	 * @generated
	 */
	public Adapter createSinkNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer <em>Node Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
	 * @generated
	 */
	public Adapter createNodeContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.NodeType
	 * @generated
	 */
	public Adapter createNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //entityAdapterFactory
