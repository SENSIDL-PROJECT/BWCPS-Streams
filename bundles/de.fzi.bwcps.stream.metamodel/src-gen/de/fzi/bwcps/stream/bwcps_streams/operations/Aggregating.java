/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregating</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getSize <em>Size</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getStep <em>Step</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getJoinOperation <em>Join Operation</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getAggregating()
 * @model
 * @generated
 */
public interface Aggregating extends Property {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getAggregating_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' attribute.
	 * @see #setStep(int)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getAggregating_Step()
	 * @model
	 * @generated
	 */
	int getStep();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getStep <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' attribute.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(int value);

	/**
	 * Returns the value of the '<em><b>Join Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Operation</em>' attribute.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation
	 * @see #setJoinOperation(JoinOperation)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getAggregating_JoinOperation()
	 * @model required="true"
	 * @generated
	 */
	JoinOperation getJoinOperation();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getJoinOperation <em>Join Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Operation</em>' attribute.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation
	 * @see #getJoinOperation()
	 * @generated
	 */
	void setJoinOperation(JoinOperation value);

} // Aggregating
