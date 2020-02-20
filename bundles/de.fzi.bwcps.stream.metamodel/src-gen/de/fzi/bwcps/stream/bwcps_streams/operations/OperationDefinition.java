/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition#getDomains <em>Domains</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperationDefinition()
 * @model
 * @generated
 */
public interface OperationDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperationDefinition_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domains</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperationDefinition_Domains()
	 * @model containment="true"
	 * @generated
	 */
	EList<Domain> getDomains();

} // OperationDefinition
