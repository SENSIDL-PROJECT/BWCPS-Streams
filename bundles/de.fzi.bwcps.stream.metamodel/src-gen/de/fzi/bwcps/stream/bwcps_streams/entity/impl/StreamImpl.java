/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.NamedElementImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stream</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.StreamImpl#getNodelinks <em>Nodelinks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StreamImpl extends NamedElementImpl implements Stream {
	/**
	 * The cached value of the '{@link #getNodelinks() <em>Nodelinks</em>}' reference list.
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
	protected StreamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return entityPackage.Literals.STREAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeLink> getNodelinks() {
		if (nodelinks == null) {
			nodelinks = new EObjectResolvingEList<NodeLink>(NodeLink.class, this, entityPackage.STREAM__NODELINKS);
		}
		return nodelinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case entityPackage.STREAM__NODELINKS:
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
		case entityPackage.STREAM__NODELINKS:
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
		case entityPackage.STREAM__NODELINKS:
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
		case entityPackage.STREAM__NODELINKS:
			return nodelinks != null && !nodelinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StreamImpl
