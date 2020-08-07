/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getType <em>Type</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getDomain <em>Domain</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getRange <em>Range</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProcessingUnits <em>Processing Units</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperation()
 * @model abstract="true"
 * @generated
 */
public interface Operation extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(Property)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperation_Properties()
	 * @model containment="true"
	 * @generated
	 */
	Property getProperties();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(Property value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(OperationType)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperation_Type()
	 * @model containment="true"
	 * @generated
	 */
	OperationType getType();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(OperationType value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(Domain)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperation_Domain()
	 * @model required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(Domain)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperation_Range()
	 * @model required="true"
	 * @generated
	 */
	Domain getRange();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(Domain value);

	/**
	 * Returns the value of the '<em><b>Processing Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Units</em>' attribute.
	 * @see #setProcessingUnits(int)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getOperation_ProcessingUnits()
	 * @model
	 * @generated
	 */
	int getProcessingUnits();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProcessingUnits <em>Processing Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Units</em>' attribute.
	 * @see #getProcessingUnits()
	 * @generated
	 */
	void setProcessingUnits(int value);

} // Operation
