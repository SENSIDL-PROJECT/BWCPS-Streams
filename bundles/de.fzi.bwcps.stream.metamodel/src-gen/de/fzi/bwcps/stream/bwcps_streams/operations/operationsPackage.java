/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations;

import de.fzi.bwcps.stream.bwcps_streams.commons.commonsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsFactory
 * @model kind="package"
 * @generated
 */
public interface operationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.fzi.de/bwcps/stream/operations/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "operations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	operationsPackage eINSTANCE = de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.DomainImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Sub Domain</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__SUB_DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__DIMENSIONS = 1;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.PropertyImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = commonsPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PROPERTIES = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DOMAIN = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__RANGE = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PROCESSING_UNITS = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = commonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = commonsPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.AggregatingImpl <em>Aggregating</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.AggregatingImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getAggregating()
	 * @generated
	 */
	int AGGREGATING = 3;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING__SIZE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING__STEP = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Join Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING__JOIN_OPERATION = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Aggregating</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Aggregating</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.CompositionellOperationImpl <em>Compositionell Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.CompositionellOperationImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getCompositionellOperation()
	 * @generated
	 */
	int COMPOSITIONELL_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION__NAME = OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION__PROPERTIES = OPERATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION__TYPE = OPERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION__DOMAIN = OPERATION__DOMAIN;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION__RANGE = OPERATION__RANGE;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION__PROCESSING_UNITS = OPERATION__PROCESSING_UNITS;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION__OPERATION = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compositionell Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compositionell Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITIONELL_OPERATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationTypeImpl <em>Operation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationTypeImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getOperationType()
	 * @generated
	 */
	int OPERATION_TYPE = 11;

	/**
	 * The number of structural features of the '<em>Operation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Operation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.MappingImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 5;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = OPERATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = OPERATION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.DimensionImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 6;

	/**
	 * The feature id for the '<em><b>Value Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__VALUE_SPACE = 0;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationDefinitionImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getOperationDefinition()
	 * @generated
	 */
	int OPERATION_DEFINITION = 7;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__OPERATIONS = 0;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__DOMAINS = 1;

	/**
	 * The number of structural features of the '<em>Operation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Operation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.SelectingImpl <em>Selecting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.SelectingImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getSelecting()
	 * @generated
	 */
	int SELECTING = 8;

	/**
	 * The number of structural features of the '<em>Selecting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTING_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Selecting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTING_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.AtomicOperationImpl <em>Atomic Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.AtomicOperationImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getAtomicOperation()
	 * @generated
	 */
	int ATOMIC_OPERATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION__NAME = OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION__PROPERTIES = OPERATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION__TYPE = OPERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION__DOMAIN = OPERATION__DOMAIN;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION__RANGE = OPERATION__RANGE;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION__PROCESSING_UNITS = OPERATION__PROCESSING_UNITS;

	/**
	 * The number of structural features of the '<em>Atomic Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Atomic Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.ProjectionImpl <em>Projection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.ProjectionImpl
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getProjection()
	 * @generated
	 */
	int PROJECTION = 10;

	/**
	 * The number of structural features of the '<em>Projection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECTION_FEATURE_COUNT = OPERATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Projection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECTION_OPERATION_COUNT = OPERATION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation <em>Join Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getJoinOperation()
	 * @generated
	 */
	int JOIN_OPERATION = 12;

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain#getSubDomain <em>Sub Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Domain</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Domain#getSubDomain()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_SubDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dimensions</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Domain#getDimensions()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_Dimensions();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProperties()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getType()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Type();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getDomain()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Domain();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getRange()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Range();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProcessingUnits <em>Processing Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processing Units</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Operation#getProcessingUnits()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_ProcessingUnits();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating <em>Aggregating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregating</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating
	 * @generated
	 */
	EClass getAggregating();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getSize()
	 * @see #getAggregating()
	 * @generated
	 */
	EAttribute getAggregating_Size();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getStep()
	 * @see #getAggregating()
	 * @generated
	 */
	EAttribute getAggregating_Step();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getJoinOperation <em>Join Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Join Operation</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating#getJoinOperation()
	 * @see #getAggregating()
	 * @generated
	 */
	EAttribute getAggregating_JoinOperation();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation <em>Compositionell Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compositionell Operation</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation
	 * @generated
	 */
	EClass getCompositionellOperation();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation#getOperation()
	 * @see #getCompositionellOperation()
	 * @generated
	 */
	EReference getCompositionellOperation_Operation();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Dimension#getValueSpace <em>Value Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Space</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Dimension#getValueSpace()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_ValueSpace();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition <em>Operation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Definition</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition
	 * @generated
	 */
	EClass getOperationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition#getOperations()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domains</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition#getDomains()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_Domains();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Selecting <em>Selecting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selecting</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Selecting
	 * @generated
	 */
	EClass getSelecting();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.AtomicOperation <em>Atomic Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Operation</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.AtomicOperation
	 * @generated
	 */
	EClass getAtomicOperation();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.Projection <em>Projection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Projection</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.Projection
	 * @generated
	 */
	EClass getProjection();

	/**
	 * Returns the meta object for class '{@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationType <em>Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Type</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.OperationType
	 * @generated
	 */
	EClass getOperationType();

	/**
	 * Returns the meta object for enum '{@link de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation <em>Join Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Join Operation</em>'.
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation
	 * @generated
	 */
	EEnum getJoinOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	operationsFactory getoperationsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.DomainImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Sub Domain</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__SUB_DOMAIN = eINSTANCE.getDomain_SubDomain();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__DIMENSIONS = eINSTANCE.getDomain_Dimensions();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.PropertyImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PROPERTIES = eINSTANCE.getOperation_Properties();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__TYPE = eINSTANCE.getOperation_Type();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__DOMAIN = eINSTANCE.getOperation_Domain();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__RANGE = eINSTANCE.getOperation_Range();

		/**
		 * The meta object literal for the '<em><b>Processing Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__PROCESSING_UNITS = eINSTANCE.getOperation_ProcessingUnits();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.AggregatingImpl <em>Aggregating</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.AggregatingImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getAggregating()
		 * @generated
		 */
		EClass AGGREGATING = eINSTANCE.getAggregating();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATING__SIZE = eINSTANCE.getAggregating_Size();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATING__STEP = eINSTANCE.getAggregating_Step();

		/**
		 * The meta object literal for the '<em><b>Join Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATING__JOIN_OPERATION = eINSTANCE.getAggregating_JoinOperation();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.CompositionellOperationImpl <em>Compositionell Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.CompositionellOperationImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getCompositionellOperation()
		 * @generated
		 */
		EClass COMPOSITIONELL_OPERATION = eINSTANCE.getCompositionellOperation();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITIONELL_OPERATION__OPERATION = eINSTANCE.getCompositionellOperation_Operation();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.MappingImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.DimensionImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Value Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__VALUE_SPACE = eINSTANCE.getDimension_ValueSpace();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationDefinitionImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getOperationDefinition()
		 * @generated
		 */
		EClass OPERATION_DEFINITION = eINSTANCE.getOperationDefinition();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__OPERATIONS = eINSTANCE.getOperationDefinition_Operations();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__DOMAINS = eINSTANCE.getOperationDefinition_Domains();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.SelectingImpl <em>Selecting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.SelectingImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getSelecting()
		 * @generated
		 */
		EClass SELECTING = eINSTANCE.getSelecting();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.AtomicOperationImpl <em>Atomic Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.AtomicOperationImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getAtomicOperation()
		 * @generated
		 */
		EClass ATOMIC_OPERATION = eINSTANCE.getAtomicOperation();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.ProjectionImpl <em>Projection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.ProjectionImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getProjection()
		 * @generated
		 */
		EClass PROJECTION = eINSTANCE.getProjection();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationTypeImpl <em>Operation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.OperationTypeImpl
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getOperationType()
		 * @generated
		 */
		EClass OPERATION_TYPE = eINSTANCE.getOperationType();

		/**
		 * The meta object literal for the '{@link de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation <em>Join Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation
		 * @see de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsPackageImpl#getJoinOperation()
		 * @generated
		 */
		EEnum JOIN_OPERATION = eINSTANCE.getJoinOperation();

	}

} //operationsPackage
