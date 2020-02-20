/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage
 * @generated
 */
public interface entityFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	entityFactory eINSTANCE = de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Edge Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Device</em>'.
	 * @generated
	 */
	EdgeDevice createEdgeDevice();

	/**
	 * Returns a new object of class '<em>Aggregated Node Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregated Node Link</em>'.
	 * @generated
	 */
	AggregatedNodeLink createAggregatedNodeLink();

	/**
	 * Returns a new object of class '<em>Stream Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stream Repository</em>'.
	 * @generated
	 */
	StreamRepository createStreamRepository();

	/**
	 * Returns a new object of class '<em>Stream</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stream</em>'.
	 * @generated
	 */
	Stream createStream();

	/**
	 * Returns a new object of class '<em>Primitive Node Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Node Link</em>'.
	 * @generated
	 */
	PrimitiveNodeLink createPrimitiveNodeLink();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	Node createNode();

	/**
	 * Returns a new object of class '<em>Sink Source Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sink Source Node Type</em>'.
	 * @generated
	 */
	SinkSourceNodeType createSinkSourceNodeType();

	/**
	 * Returns a new object of class '<em>Edge Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Gateway</em>'.
	 * @generated
	 */
	EdgeGateway createEdgeGateway();

	/**
	 * Returns a new object of class '<em>Data Sink</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Sink</em>'.
	 * @generated
	 */
	DataSink createDataSink();

	/**
	 * Returns a new object of class '<em>Source Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Node Type</em>'.
	 * @generated
	 */
	SourceNodeType createSourceNodeType();

	/**
	 * Returns a new object of class '<em>Sink Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sink Node Type</em>'.
	 * @generated
	 */
	SinkNodeType createSinkNodeType();

	/**
	 * Returns a new object of class '<em>Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Type</em>'.
	 * @generated
	 */
	NodeType createNodeType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	entityPackage getentityPackage();

} //entityFactory
