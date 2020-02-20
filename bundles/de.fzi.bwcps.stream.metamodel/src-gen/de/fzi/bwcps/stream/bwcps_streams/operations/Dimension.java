/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

import de.fzi.sensidl.design.sensidl.dataRepresentation.DataType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.operations.Dimension#getValueSpace <em>Value Space</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getDimension()
 * @model
 * @generated
 */
public interface Dimension extends EObject {
	/**
	 * Returns the value of the '<em><b>Value Space</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fzi.sensidl.design.sensidl.dataRepresentation.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Space</em>' attribute.
	 * @see de.fzi.sensidl.design.sensidl.dataRepresentation.DataType
	 * @see #setValueSpace(DataType)
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#getDimension_ValueSpace()
	 * @model required="true"
	 * @generated
	 */
	DataType getValueSpace();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Dimension#getValueSpace <em>Value Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Space</em>' attribute.
	 * @see de.fzi.sensidl.design.sensidl.dataRepresentation.DataType
	 * @see #getValueSpace()
	 * @generated
	 */
	void setValueSpace(DataType value);

} // Dimension
