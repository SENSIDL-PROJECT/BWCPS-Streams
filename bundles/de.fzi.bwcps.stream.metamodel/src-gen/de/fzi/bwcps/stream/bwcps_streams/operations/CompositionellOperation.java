/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compositionell Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getCompositionellOperation()
 * @model
 * @generated
 */
public interface CompositionellOperation extends Operation {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getCompositionellOperation_Operation()
	 * @model required="true"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // CompositionellOperation
