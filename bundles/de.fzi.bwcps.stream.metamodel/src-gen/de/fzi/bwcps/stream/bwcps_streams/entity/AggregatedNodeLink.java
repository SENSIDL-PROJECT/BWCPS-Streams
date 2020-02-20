/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregated Node Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink#getAggregatedLinks <em>Aggregated Links</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getAggregatedNodeLink()
 * @model
 * @generated
 */
public interface AggregatedNodeLink extends NodeLink {
	/**
	 * Returns the value of the '<em><b>Aggregated Links</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Links</em>' reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getAggregatedNodeLink_AggregatedLinks()
	 * @model required="true"
	 * @generated
	 */
	EList<NodeLink> getAggregatedLinks();

} // AggregatedNodeLink
