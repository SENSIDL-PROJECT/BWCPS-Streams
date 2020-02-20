/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.util;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

import de.fzi.bwcps.stream.bwcps_streams.entity.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage
 * @generated
 */
public class entitySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static entityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public entitySwitch() {
		if (modelPackage == null) {
			modelPackage = entityPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case entityPackage.EDGE_DEVICE: {
			EdgeDevice edgeDevice = (EdgeDevice) theEObject;
			T result = caseEdgeDevice(edgeDevice);
			if (result == null)
				result = caseNodeContainer(edgeDevice);
			if (result == null)
				result = caseNamedElement(edgeDevice);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.AGGREGATED_NODE_LINK: {
			AggregatedNodeLink aggregatedNodeLink = (AggregatedNodeLink) theEObject;
			T result = caseAggregatedNodeLink(aggregatedNodeLink);
			if (result == null)
				result = caseNodeLink(aggregatedNodeLink);
			if (result == null)
				result = caseNamedElement(aggregatedNodeLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.STREAM_REPOSITORY: {
			StreamRepository streamRepository = (StreamRepository) theEObject;
			T result = caseStreamRepository(streamRepository);
			if (result == null)
				result = caseNamedElement(streamRepository);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.STREAM: {
			Stream stream = (Stream) theEObject;
			T result = caseStream(stream);
			if (result == null)
				result = caseNamedElement(stream);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.PRIMITIVE_NODE_LINK: {
			PrimitiveNodeLink primitiveNodeLink = (PrimitiveNodeLink) theEObject;
			T result = casePrimitiveNodeLink(primitiveNodeLink);
			if (result == null)
				result = caseNodeLink(primitiveNodeLink);
			if (result == null)
				result = caseNamedElement(primitiveNodeLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.NODE: {
			Node node = (Node) theEObject;
			T result = caseNode(node);
			if (result == null)
				result = caseNamedElement(node);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.SINK_SOURCE_NODE_TYPE: {
			SinkSourceNodeType sinkSourceNodeType = (SinkSourceNodeType) theEObject;
			T result = caseSinkSourceNodeType(sinkSourceNodeType);
			if (result == null)
				result = caseSourceNodeType(sinkSourceNodeType);
			if (result == null)
				result = caseSinkNodeType(sinkSourceNodeType);
			if (result == null)
				result = caseNodeType(sinkSourceNodeType);
			if (result == null)
				result = caseNamedElement(sinkSourceNodeType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.NODE_LINK: {
			NodeLink nodeLink = (NodeLink) theEObject;
			T result = caseNodeLink(nodeLink);
			if (result == null)
				result = caseNamedElement(nodeLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.EDGE_GATEWAY: {
			EdgeGateway edgeGateway = (EdgeGateway) theEObject;
			T result = caseEdgeGateway(edgeGateway);
			if (result == null)
				result = caseNodeContainer(edgeGateway);
			if (result == null)
				result = caseNamedElement(edgeGateway);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.DATA_SINK: {
			DataSink dataSink = (DataSink) theEObject;
			T result = caseDataSink(dataSink);
			if (result == null)
				result = caseNodeContainer(dataSink);
			if (result == null)
				result = caseNamedElement(dataSink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.SOURCE_NODE_TYPE: {
			SourceNodeType sourceNodeType = (SourceNodeType) theEObject;
			T result = caseSourceNodeType(sourceNodeType);
			if (result == null)
				result = caseNodeType(sourceNodeType);
			if (result == null)
				result = caseNamedElement(sourceNodeType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.SINK_NODE_TYPE: {
			SinkNodeType sinkNodeType = (SinkNodeType) theEObject;
			T result = caseSinkNodeType(sinkNodeType);
			if (result == null)
				result = caseNodeType(sinkNodeType);
			if (result == null)
				result = caseNamedElement(sinkNodeType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.NODE_CONTAINER: {
			NodeContainer nodeContainer = (NodeContainer) theEObject;
			T result = caseNodeContainer(nodeContainer);
			if (result == null)
				result = caseNamedElement(nodeContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case entityPackage.NODE_TYPE: {
			NodeType nodeType = (NodeType) theEObject;
			T result = caseNodeType(nodeType);
			if (result == null)
				result = caseNamedElement(nodeType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeDevice(EdgeDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregated Node Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregated Node Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregatedNodeLink(AggregatedNodeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stream Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStreamRepository(StreamRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stream</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStream(Stream object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Node Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Node Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveNodeLink(PrimitiveNodeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sink Source Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sink Source Node Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSinkSourceNodeType(SinkSourceNodeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeLink(NodeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeGateway(EdgeGateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Sink</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Sink</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSink(DataSink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Node Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceNodeType(SourceNodeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sink Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sink Node Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSinkNodeType(SinkNodeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeContainer(NodeContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeType(NodeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //entitySwitch
