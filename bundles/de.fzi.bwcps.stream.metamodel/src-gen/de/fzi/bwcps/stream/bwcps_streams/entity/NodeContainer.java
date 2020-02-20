/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeContainer()
 * @model abstract="true"
 * @generated
 */
public interface NodeContainer extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getNodeContainer_Nodes()
	 * @model required="true"
	 * @generated
	 */
	EList<Node> getNodes();

} // NodeContainer
