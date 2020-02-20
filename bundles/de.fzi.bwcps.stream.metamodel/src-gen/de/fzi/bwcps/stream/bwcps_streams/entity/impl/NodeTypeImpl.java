/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.NamedElementImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import de.fzi.sensidl.design.sensidl.dataRepresentation.Data;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeTypeImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeTypeImpl#getInput <em>Input</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.NodeTypeImpl#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeTypeImpl extends NamedElementImpl implements NodeType {
	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeType> refines;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> output;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return entityPackage.Literals.NODE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeType> getRefines() {
		if (refines == null) {
			refines = new EObjectResolvingEList<NodeType>(NodeType.class, this, entityPackage.NODE_TYPE__REFINES);
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Data> getInput() {
		if (input == null) {
			input = new EObjectResolvingEList<Data>(Data.class, this, entityPackage.NODE_TYPE__INPUT);
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Data> getOutput() {
		if (output == null) {
			output = new EObjectResolvingEList<Data>(Data.class, this, entityPackage.NODE_TYPE__OUTPUT);
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case entityPackage.NODE_TYPE__REFINES:
			return getRefines();
		case entityPackage.NODE_TYPE__INPUT:
			return getInput();
		case entityPackage.NODE_TYPE__OUTPUT:
			return getOutput();
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
		case entityPackage.NODE_TYPE__REFINES:
			getRefines().clear();
			getRefines().addAll((Collection<? extends NodeType>) newValue);
			return;
		case entityPackage.NODE_TYPE__INPUT:
			getInput().clear();
			getInput().addAll((Collection<? extends Data>) newValue);
			return;
		case entityPackage.NODE_TYPE__OUTPUT:
			getOutput().clear();
			getOutput().addAll((Collection<? extends Data>) newValue);
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
		case entityPackage.NODE_TYPE__REFINES:
			getRefines().clear();
			return;
		case entityPackage.NODE_TYPE__INPUT:
			getInput().clear();
			return;
		case entityPackage.NODE_TYPE__OUTPUT:
			getOutput().clear();
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
		case entityPackage.NODE_TYPE__REFINES:
			return refines != null && !refines.isEmpty();
		case entityPackage.NODE_TYPE__INPUT:
			return input != null && !input.isEmpty();
		case entityPackage.NODE_TYPE__OUTPUT:
			return output != null && !output.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeTypeImpl
