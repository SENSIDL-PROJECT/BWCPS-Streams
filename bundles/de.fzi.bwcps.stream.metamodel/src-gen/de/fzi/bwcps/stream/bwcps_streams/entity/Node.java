/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

import de.fzi.bwcps.stream.bwcps_streams.operations.Operation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.Node#getNodetype <em>Nodetype</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.Node#getOperational <em>Operational</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Nodetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodetype</em>' reference.
	 * @see #setNodetype(NodeType)
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNode_Nodetype()
	 * @model required="true"
	 * @generated
	 */
	NodeType getNodetype();

	/**
	 * Sets the value of the '{@link de.fzi.bwcps.stream.bwcps_streams.entity.Node#getNodetype <em>Nodetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nodetype</em>' reference.
	 * @see #getNodetype()
	 * @generated
	 */
	void setNodetype(NodeType value);

	/**
	 * Returns the value of the '<em><b>Operational</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operational</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNode_Operational()
	 * @model
	 * @generated
	 */
	EList<Operation> getOperational();

} // Node
