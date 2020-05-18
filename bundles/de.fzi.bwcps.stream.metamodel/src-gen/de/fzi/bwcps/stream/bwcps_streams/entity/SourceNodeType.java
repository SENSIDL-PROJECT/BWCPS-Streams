/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType#getFrequency <em>Frequency</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getSourceNodeType()
 * @model
 * @generated
 */
public interface SourceNodeType extends NodeType {
	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see #setFrequency(int)
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getSourceNodeType_Frequency()
	 * @model
	 * @generated
	 */
	int getFrequency();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType#getFrequency <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency</em>' attribute.
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(int value);

} // SourceNodeType
