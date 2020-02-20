/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.NamedElementImpl;

import de.fzi.bwcps.stream.bwcps_streams.operations.Domain;
import de.fzi.bwcps.stream.bwcps_streams.operations.Operation;
import de.fzi.bwcps.stream.bwcps_streams.operations.OperationType;
import de.fzi.bwcps.stream.bwcps_streams.operations.Property;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OperationImpl extends NamedElementImpl implements Operation {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected Property properties;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected OperationType type;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain domain;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected Domain range;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return operationsPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(Property newProperties, NotificationChain msgs) {
		Property oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					operationsPackage.OPERATION__PROPERTIES, oldProperties, newProperties);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperties(Property newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject) properties).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - operationsPackage.OPERATION__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject) newProperties).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - operationsPackage.OPERATION__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, operationsPackage.OPERATION__PROPERTIES,
					newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(OperationType newType, NotificationChain msgs) {
		OperationType oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					operationsPackage.OPERATION__TYPE, oldType, newType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(OperationType newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject) type).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - operationsPackage.OPERATION__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject) newType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - operationsPackage.OPERATION__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, operationsPackage.OPERATION__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Domain getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject) domain;
			domain = (Domain) eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, operationsPackage.OPERATION__DOMAIN,
							oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomain(Domain newDomain) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, operationsPackage.OPERATION__DOMAIN, oldDomain,
					domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Domain getRange() {
		if (range != null && range.eIsProxy()) {
			InternalEObject oldRange = (InternalEObject) range;
			range = (Domain) eResolveProxy(oldRange);
			if (range != oldRange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, operationsPackage.OPERATION__RANGE,
							oldRange, range));
			}
		}
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRange(Domain newRange) {
		Domain oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, operationsPackage.OPERATION__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case operationsPackage.OPERATION__PROPERTIES:
			return basicSetProperties(null, msgs);
		case operationsPackage.OPERATION__TYPE:
			return basicSetType(null, msgs);
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
		case operationsPackage.OPERATION__PROPERTIES:
			return getProperties();
		case operationsPackage.OPERATION__TYPE:
			return getType();
		case operationsPackage.OPERATION__DOMAIN:
			if (resolve)
				return getDomain();
			return basicGetDomain();
		case operationsPackage.OPERATION__RANGE:
			if (resolve)
				return getRange();
			return basicGetRange();
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
		case operationsPackage.OPERATION__PROPERTIES:
			setProperties((Property) newValue);
			return;
		case operationsPackage.OPERATION__TYPE:
			setType((OperationType) newValue);
			return;
		case operationsPackage.OPERATION__DOMAIN:
			setDomain((Domain) newValue);
			return;
		case operationsPackage.OPERATION__RANGE:
			setRange((Domain) newValue);
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
		case operationsPackage.OPERATION__PROPERTIES:
			setProperties((Property) null);
			return;
		case operationsPackage.OPERATION__TYPE:
			setType((OperationType) null);
			return;
		case operationsPackage.OPERATION__DOMAIN:
			setDomain((Domain) null);
			return;
		case operationsPackage.OPERATION__RANGE:
			setRange((Domain) null);
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
		case operationsPackage.OPERATION__PROPERTIES:
			return properties != null;
		case operationsPackage.OPERATION__TYPE:
			return type != null;
		case operationsPackage.OPERATION__DOMAIN:
			return domain != null;
		case operationsPackage.OPERATION__RANGE:
			return range != null;
		}
		return super.eIsSet(featureID);
	}

} //OperationImpl
