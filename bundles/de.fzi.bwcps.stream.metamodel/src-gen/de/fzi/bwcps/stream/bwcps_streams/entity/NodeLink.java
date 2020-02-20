/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSource <em>Source</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getTarget <em>Target</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSecurityMeasure <em>Security Measure</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeLink()
 * @model abstract="true"
 * @generated
 */
public interface NodeLink extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeLink_Source()
	 * @model required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeLink_Target()
	 * @model required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Security Measure</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Measure</em>' attribute.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure
	 * @see #setSecurityMeasure(SecurityMeasure)
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeLink_SecurityMeasure()
	 * @model default="NONE"
	 * @generated
	 */
	SecurityMeasure getSecurityMeasure();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink#getSecurityMeasure <em>Security Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Measure</em>' attribute.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure
	 * @see #getSecurityMeasure()
	 * @generated
	 */
	void setSecurityMeasure(SecurityMeasure value);

} // NodeLink
