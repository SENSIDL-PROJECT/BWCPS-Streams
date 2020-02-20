/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations.impl;

import de.fzi.bwcps.stream.bwcps_streams.operations.Domain;
import de.fzi.bwcps.stream.bwcps_streams.operations.Operation;
import de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationDefinitionImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationDefinitionImpl#getDomains <em>Domains</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationDefinitionImpl extends MinimalEObjectImpl.Container implements OperationDefinition {
	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<Domain> domains;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return operationsPackage.Literals.OPERATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<Operation>(Operation.class, this,
					operationsPackage.OPERATION_DEFINITION__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Domain> getDomains() {
		if (domains == null) {
			domains = new EObjectContainmentEList<Domain>(Domain.class, this,
					operationsPackage.OPERATION_DEFINITION__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case operationsPackage.OPERATION_DEFINITION__OPERATIONS:
			return ((InternalEList<?>) getOperations()).basicRemove(otherEnd, msgs);
		case operationsPackage.OPERATION_DEFINITION__DOMAINS:
			return ((InternalEList<?>) getDomains()).basicRemove(otherEnd, msgs);
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
		case operationsPackage.OPERATION_DEFINITION__OPERATIONS:
			return getOperations();
		case operationsPackage.OPERATION_DEFINITION__DOMAINS:
			return getDomains();
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
		case operationsPackage.OPERATION_DEFINITION__OPERATIONS:
			getOperations().clear();
			getOperations().addAll((Collection<? extends Operation>) newValue);
			return;
		case operationsPackage.OPERATION_DEFINITION__DOMAINS:
			getDomains().clear();
			getDomains().addAll((Collection<? extends Domain>) newValue);
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
		case operationsPackage.OPERATION_DEFINITION__OPERATIONS:
			getOperations().clear();
			return;
		case operationsPackage.OPERATION_DEFINITION__DOMAINS:
			getDomains().clear();
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
		case operationsPackage.OPERATION_DEFINITION__OPERATIONS:
			return operations != null && !operations.isEmpty();
		case operationsPackage.OPERATION_DEFINITION__DOMAINS:
			return domains != null && !domains.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationDefinitionImpl
