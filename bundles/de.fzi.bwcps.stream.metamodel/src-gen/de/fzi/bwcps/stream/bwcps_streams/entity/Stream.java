/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stream</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.Stream#getNodelinks <em>Nodelinks</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStream()
 * @model
 * @generated
 */
public interface Stream extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Nodelinks</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodelinks</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStream_Nodelinks()
	 * @model required="true"
	 * @generated
	 */
	EList<NodeLink> getNodelinks();

} // Stream
