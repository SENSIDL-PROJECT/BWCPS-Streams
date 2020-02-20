/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

import de.fzi.sensidl.design.sensidl.dataRepresentation.Data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getRefines <em>Refines</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getInput <em>Input</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeType()
 * @model
 * @generated
 */
public interface NodeType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeType_Refines()
	 * @model
	 * @generated
	 */
	EList<NodeType> getRefines();

	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.sensidl.design.sensidl.dataRepresentation.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeType_Input()
	 * @model
	 * @generated
	 */
	EList<Data> getInput();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.sensidl.design.sensidl.dataRepresentation.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeType_Output()
	 * @model
	 * @generated
	 */
	EList<Data> getOutput();

} // NodeType
