/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.NamedElementImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeLinkImpl#getSource <em>Source</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeLinkImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeLinkImpl#getSecurityMeasure <em>Security Measure</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NodeLinkImpl extends NamedElementImpl implements NodeLink {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The default value of the '{@link #getSecurityMeasure() <em>Security Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final SecurityMeasure SECURITY_MEASURE_EDEFAULT = SecurityMeasure.NONE;

	/**
	 * The cached value of the '{@link #getSecurityMeasure() <em>Security Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityMeasure()
	 * @generated
	 * @ordered
	 */
	protected SecurityMeasure securityMeasure = SECURITY_MEASURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return entityPackage.Literals.NODE_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Node) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, entityPackage.NODE_LINK__SOURCE,
							oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(Node newSource) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, entityPackage.NODE_LINK__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (Node) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, entityPackage.NODE_LINK__TARGET,
							oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(Node newTarget) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, entityPackage.NODE_LINK__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SecurityMeasure getSecurityMeasure() {
		return securityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecurityMeasure(SecurityMeasure newSecurityMeasure) {
		SecurityMeasure oldSecurityMeasure = securityMeasure;
		securityMeasure = newSecurityMeasure == null ? SECURITY_MEASURE_EDEFAULT : newSecurityMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, entityPackage.NODE_LINK__SECURITY_MEASURE,
					oldSecurityMeasure, securityMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case entityPackage.NODE_LINK__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case entityPackage.NODE_LINK__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		case entityPackage.NODE_LINK__SECURITY_MEASURE:
			return getSecurityMeasure();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case entityPackage.NODE_LINK__SOURCE:
			setSource((Node) newValue);
			return;
		case entityPackage.NODE_LINK__TARGET:
			setTarget((Node) newValue);
			return;
		case entityPackage.NODE_LINK__SECURITY_MEASURE:
			setSecurityMeasure((SecurityMeasure) newValue);
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
		case entityPackage.NODE_LINK__SOURCE:
			setSource((Node) null);
			return;
		case entityPackage.NODE_LINK__TARGET:
			setTarget((Node) null);
			return;
		case entityPackage.NODE_LINK__SECURITY_MEASURE:
			setSecurityMeasure(SECURITY_MEASURE_EDEFAULT);
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
		case entityPackage.NODE_LINK__SOURCE:
			return source != null;
		case entityPackage.NODE_LINK__TARGET:
			return target != null;
		case entityPackage.NODE_LINK__SECURITY_MEASURE:
			return securityMeasure != SECURITY_MEASURE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (securityMeasure: ");
		result.append(securityMeasure);
		result.append(')');
		return result.toString();
	}

} //NodeLinkImpl
