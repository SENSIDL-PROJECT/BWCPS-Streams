/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stream Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getStreams <em>Streams</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getContainer <em>Container</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodeTypes <em>Node Types</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository#getNodelinks <em>Nodelinks</em>}</li>
 * </ul>
 *
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStreamRepository()
 * @model
 * @generated
 */
public interface StreamRepository extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Streams</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.Stream}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Streams</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStreamRepository_Streams()
	 * @model containment="true"
	 * @generated
	 */
	EList<Stream> getStreams();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStreamRepository_Container()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeContainer> getContainer();

	/**
	 * Returns the value of the '<em><b>Node Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Types</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStreamRepository_NodeTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeType> getNodeTypes();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStreamRepository_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Nodelinks</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodelinks</em>' containment reference list.
	 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getStreamRepository_Nodelinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeLink> getNodelinks();

} // StreamRepository
