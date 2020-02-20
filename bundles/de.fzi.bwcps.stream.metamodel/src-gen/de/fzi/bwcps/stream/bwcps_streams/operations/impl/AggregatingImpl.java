/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations.impl;

import de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating;
import de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregating</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.AggregatingImpl#getSize <em>Size</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.AggregatingImpl#getStep <em>Step</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.AggregatingImpl#getJoinOperation <em>Join Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AggregatingImpl extends PropertyImpl implements Aggregating {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected int step = STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getJoinOperation() <em>Join Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinOperation()
	 * @generated
	 * @ordered
	 */
	protected static final JoinOperation JOIN_OPERATION_EDEFAULT = JoinOperation.SUM;

	/**
	 * The cached value of the '{@link #getJoinOperation() <em>Join Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinOperation()
	 * @generated
	 * @ordered
	 */
	protected JoinOperation joinOperation = JOIN_OPERATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return operationsPackage.Literals.AGGREGATING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, operationsPackage.AGGREGATING__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStep() {
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStep(int newStep) {
		int oldStep = step;
		step = newStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, operationsPackage.AGGREGATING__STEP, oldStep, step));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JoinOperation getJoinOperation() {
		return joinOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJoinOperation(JoinOperation newJoinOperation) {
		JoinOperation oldJoinOperation = joinOperation;
		joinOperation = newJoinOperation == null ? JOIN_OPERATION_EDEFAULT : newJoinOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, operationsPackage.AGGREGATING__JOIN_OPERATION,
					oldJoinOperation, joinOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case operationsPackage.AGGREGATING__SIZE:
			return getSize();
		case operationsPackage.AGGREGATING__STEP:
			return getStep();
		case operationsPackage.AGGREGATING__JOIN_OPERATION:
			return getJoinOperation();
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
		case operationsPackage.AGGREGATING__SIZE:
			setSize((Integer) newValue);
			return;
		case operationsPackage.AGGREGATING__STEP:
			setStep((Integer) newValue);
			return;
		case operationsPackage.AGGREGATING__JOIN_OPERATION:
			setJoinOperation((JoinOperation) newValue);
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
		case operationsPackage.AGGREGATING__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case operationsPackage.AGGREGATING__STEP:
			setStep(STEP_EDEFAULT);
			return;
		case operationsPackage.AGGREGATING__JOIN_OPERATION:
			setJoinOperation(JOIN_OPERATION_EDEFAULT);
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
		case operationsPackage.AGGREGATING__SIZE:
			return size != SIZE_EDEFAULT;
		case operationsPackage.AGGREGATING__STEP:
			return step != STEP_EDEFAULT;
		case operationsPackage.AGGREGATING__JOIN_OPERATION:
			return joinOperation != JOIN_OPERATION_EDEFAULT;
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
		result.append(" (size: ");
		result.append(size);
		result.append(", step: ");
		result.append(step);
		result.append(", joinOperation: ");
		result.append(joinOperation);
		result.append(')');
		return result.toString();
	}

} //AggregatingImpl
