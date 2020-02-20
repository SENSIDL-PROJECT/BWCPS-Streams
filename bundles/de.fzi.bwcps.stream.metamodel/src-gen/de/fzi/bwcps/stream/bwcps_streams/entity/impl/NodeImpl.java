/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.NamedElementImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import de.fzi.bwcps.stream.bwcps_streams.operations.Operation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeImpl#getNodetype <em>Nodetype</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeImpl#getOperational <em>Operational</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends NamedElementImpl implements Node {
	/**
	 * The cached value of the '{@link #getNodetype() <em>Nodetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodetype()
	 * @generated
	 * @ordered
	 */
	protected NodeType nodetype;

	/**
	 * The cached value of the '{@link #getOperational() <em>Operational</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperational()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operational;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return entityPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeType getNodetype() {
		if (nodetype != null && nodetype.eIsProxy()) {
			InternalEObject oldNodetype = (InternalEObject) nodetype;
			nodetype = (NodeType) eResolveProxy(oldNodetype);
			if (nodetype != oldNodetype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, entityPackage.NODE__NODETYPE, oldNodetype,
							nodetype));
			}
		}
		return nodetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType basicGetNodetype() {
		return nodetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNodetype(NodeType newNodetype) {
		NodeType oldNodetype = nodetype;
		nodetype = newNodetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, entityPackage.NODE__NODETYPE, oldNodetype, nodetype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getOperational() {
		if (operational == null) {
			operational = new EObjectResolvingEList<Operation>(Operation.class, this, entityPackage.NODE__OPERATIONAL);
		}
		return operational;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case entityPackage.NODE__NODETYPE:
			if (resolve)
				return getNodetype();
			return basicGetNodetype();
		case entityPackage.NODE__OPERATIONAL:
			return getOperational();
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
		case entityPackage.NODE__NODETYPE:
			setNodetype((NodeType) newValue);
			return;
		case entityPackage.NODE__OPERATIONAL:
			getOperational().clear();
			getOperational().addAll((Collection<? extends Operation>) newValue);
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
		case entityPackage.NODE__NODETYPE:
			setNodetype((NodeType) null);
			return;
		case entityPackage.NODE__OPERATIONAL:
			getOperational().clear();
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
		case entityPackage.NODE__NODETYPE:
			return nodetype != null;
		case entityPackage.NODE__OPERATIONAL:
			return operational != null && !operational.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
