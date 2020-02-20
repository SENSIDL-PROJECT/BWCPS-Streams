/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain#getSubDomain <em>Sub Domain</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Domain</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Domain</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getDomain_SubDomain()
	 * @model
	 * @generated
	 */
	EList<Domain> getSubDomain();

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.operations.Dimension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getDomain_Dimensions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Dimension> getDimensions();

} // Domain
