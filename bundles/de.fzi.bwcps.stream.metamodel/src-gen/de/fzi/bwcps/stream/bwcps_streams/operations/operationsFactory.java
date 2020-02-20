/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage
 * @generated
 */
public interface operationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	operationsFactory eINSTANCE = de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain</em>'.
	 * @generated
	 */
	Domain createDomain();

	/**
	 * Returns a new object of class '<em>Aggregating</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregating</em>'.
	 * @generated
	 */
	Aggregating createAggregating();

	/**
	 * Returns a new object of class '<em>Compositionell Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compositionell Operation</em>'.
	 * @generated
	 */
	CompositionellOperation createCompositionellOperation();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension</em>'.
	 * @generated
	 */
	Dimension createDimension();

	/**
	 * Returns a new object of class '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Definition</em>'.
	 * @generated
	 */
	OperationDefinition createOperationDefinition();

	/**
	 * Returns a new object of class '<em>Selecting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selecting</em>'.
	 * @generated
	 */
	Selecting createSelecting();

	/**
	 * Returns a new object of class '<em>Atomic Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Operation</em>'.
	 * @generated
	 */
	AtomicOperation createAtomicOperation();

	/**
	 * Returns a new object of class '<em>Projection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Projection</em>'.
	 * @generated
	 */
	Projection createProjection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	operationsPackage getoperationsPackage();

} //operationsFactory
