/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.impl;

import de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Node Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.impl.AggregatedNodeLinkImpl#getAggregatedLinks <em>Aggregated Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AggregatedNodeLinkImpl extends NodeLinkImpl implements AggregatedNodeLink {
	/**
	 * The cached value of the '{@link #getAggregatedLinks() <em>Aggregated Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeLink> aggregatedLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedNodeLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return entityPackage.Literals.AGGREGATED_NODE_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeLink> getAggregatedLinks() {
		if (aggregatedLinks == null) {
			aggregatedLinks = new EObjectResolvingEList<NodeLink>(NodeLink.class, this,
					entityPackage.AGGREGATED_NODE_LINK__AGGREGATED_LINKS);
		}
		return aggregatedLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case entityPackage.AGGREGATED_NODE_LINK__AGGREGATED_LINKS:
			return getAggregatedLinks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case entityPackage.AGGREGATED_NODE_LINK__AGGREGATED_LINKS:
			getAggregatedLinks().clear();
			getAggregatedLinks().addAll((Collection<? extends NodeLink>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case entityPackage.AGGREGATED_NODE_LINK__AGGREGATED_LINKS:
			getAggregatedLinks().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case entityPackage.AGGREGATED_NODE_LINK__AGGREGATED_LINKS:
			return aggregatedLinks != null && !aggregatedLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AggregatedNodeLinkImpl
