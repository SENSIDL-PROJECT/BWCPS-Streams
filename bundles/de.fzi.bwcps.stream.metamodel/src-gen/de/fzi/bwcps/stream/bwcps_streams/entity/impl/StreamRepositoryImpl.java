/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.NamedElementImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stream Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl#getStreams <em>Streams</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl#getNodeTypes <em>Node Types</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamRepositoryImpl#getNodelinks <em>Nodelinks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StreamRepositoryImpl extends NamedElementImpl implements StreamRepository {
	/**
	 * The cached value of the '{@link #getStreams() <em>Streams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreams()
	 * @generated
	 * @ordered
	 */
	protected EList<Stream> streams;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeContainer> container;

	/**
	 * The cached value of the '{@link #getNodeTypes() <em>Node Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeType> nodeTypes;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getNodelinks() <em>Nodelinks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodelinks()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeLink> nodelinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return entityPackage.Literals.STREAM_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Stream> getStreams() {
		if (streams == null) {
			streams = new EObjectContainmentEList<Stream>(Stream.class, this, entityPackage.STREAM_REPOSITORY__STREAMS);
		}
		return streams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeContainer> getContainer() {
		if (container == null) {
			container = new EObjectContainmentEList<NodeContainer>(NodeContainer.class, this,
					entityPackage.STREAM_REPOSITORY__CONTAINER);
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeType> getNodeTypes() {
		if (nodeTypes == null) {
			nodeTypes = new EObjectContainmentEList<NodeType>(NodeType.class, this,
					entityPackage.STREAM_REPOSITORY__NODE_TYPES);
		}
		return nodeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, entityPackage.STREAM_REPOSITORY__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeLink> getNodelinks() {
		if (nodelinks == null) {
			nodelinks = new EObjectContainmentEList<NodeLink>(NodeLink.class, this,
					entityPackage.STREAM_REPOSITORY__NODELINKS);
		}
		return nodelinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case entityPackage.STREAM_REPOSITORY__STREAMS:
			return ((InternalEList<?>) getStreams()).basicRemove(otherEnd, msgs);
		case entityPackage.STREAM_REPOSITORY__CONTAINER:
			return ((InternalEList<?>) getContainer()).basicRemove(otherEnd, msgs);
		case entityPackage.STREAM_REPOSITORY__NODE_TYPES:
			return ((InternalEList<?>) getNodeTypes()).basicRemove(otherEnd, msgs);
		case entityPackage.STREAM_REPOSITORY__NODES:
			return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
		case entityPackage.STREAM_REPOSITORY__NODELINKS:
			return ((InternalEList<?>) getNodelinks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case entityPackage.STREAM_REPOSITORY__STREAMS:
			return getStreams();
		case entityPackage.STREAM_REPOSITORY__CONTAINER:
			return getContainer();
		case entityPackage.STREAM_REPOSITORY__NODE_TYPES:
			return getNodeTypes();
		case entityPackage.STREAM_REPOSITORY__NODES:
			return getNodes();
		case entityPackage.STREAM_REPOSITORY__NODELINKS:
			return getNodelinks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case entityPackage.STREAM_REPOSITORY__STREAMS:
			getStreams().clear();
			getStreams().addAll((Collection<? extends Stream>) newValue);
			return;
		case entityPackage.STREAM_REPOSITORY__CONTAINER:
			getContainer().clear();
			getContainer().addAll((Collection<? extends NodeContainer>) newValue);
			return;
		case entityPackage.STREAM_REPOSITORY__NODE_TYPES:
			getNodeTypes().clear();
			getNodeTypes().addAll((Collection<? extends NodeType>) newValue);
			return;
		case entityPackage.STREAM_REPOSITORY__NODES:
			getNodes().clear();
			getNodes().addAll((Collection<? extends Node>) newValue);
			return;
		case entityPackage.STREAM_REPOSITORY__NODELINKS:
			getNodelinks().clear();
			getNodelinks().addAll((Collection<? extends NodeLink>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case entityPackage.STREAM_REPOSITORY__STREAMS:
			getStreams().clear();
			return;
		case entityPackage.STREAM_REPOSITORY__CONTAINER:
			getContainer().clear();
			return;
		case entityPackage.STREAM_REPOSITORY__NODE_TYPES:
			getNodeTypes().clear();
			return;
		case entityPackage.STREAM_REPOSITORY__NODES:
			getNodes().clear();
			return;
		case entityPackage.STREAM_REPOSITORY__NODELINKS:
			getNodelinks().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case entityPackage.STREAM_REPOSITORY__STREAMS:
			return streams != null && !streams.isEmpty();
		case entityPackage.STREAM_REPOSITORY__CONTAINER:
			return container != null && !container.isEmpty();
		case entityPackage.STREAM_REPOSITORY__NODE_TYPES:
			return nodeTypes != null && !nodeTypes.isEmpty();
		case entityPackage.STREAM_REPOSITORY__NODES:
			return nodes != null && !nodes.isEmpty();
		case entityPackage.STREAM_REPOSITORY__NODELINKS:
			return nodelinks != null && !nodelinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StreamRepositoryImpl
