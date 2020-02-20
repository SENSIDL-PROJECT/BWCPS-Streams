/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations.impl;

import de.fzi.bwcps.stream.bwcps_streams.commons.commonsPackage;

import de.fzi.bwcps.stream.bwcps_streams.commons.impl.commonsPackageImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;

import de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityPackageImpl;

import de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating;
import de.fzi.bwcps.stream.bwcps_streams.operations.AtomicOperation;
import de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation;
import de.fzi.bwcps.stream.bwcps_streams.operations.Dimension;
import de.fzi.bwcps.stream.bwcps_streams.operations.Domain;
import de.fzi.bwcps.stream.bwcps_streams.operations.JoinOperation;
import de.fzi.bwcps.stream.bwcps_streams.operations.Mapping;
import de.fzi.bwcps.stream.bwcps_streams.operations.Operation;
import de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition;
import de.fzi.bwcps.stream.bwcps_streams.operations.OperationType;
import de.fzi.bwcps.stream.bwcps_streams.operations.Projection;
import de.fzi.bwcps.stream.bwcps_streams.operations.Property;
import de.fzi.bwcps.stream.bwcps_streams.operations.Selecting;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsFactory;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage;

import de.fzi.sensidl.design.sensidl.dataRepresentation.DataRepresentationPackage;

import de.fzi.sensidl.design.sensidl.sensidlPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class operationsPackageImpl extends EPackageImpl implements operationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositionellOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum joinOperationEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private operationsPackageImpl() {
		super(eNS_URI, operationsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link operationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static operationsPackage init() {
		if (isInited)
			return (operationsPackage) EPackage.Registry.INSTANCE.getEPackage(operationsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredoperationsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		operationsPackageImpl theoperationsPackage = registeredoperationsPackage instanceof operationsPackageImpl
				? (operationsPackageImpl) registeredoperationsPackage
				: new operationsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		sensidlPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(entityPackage.eNS_URI);
		entityPackageImpl theentityPackage = (entityPackageImpl) (registeredPackage instanceof entityPackageImpl
				? registeredPackage
				: entityPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(commonsPackage.eNS_URI);
		commonsPackageImpl thecommonsPackage = (commonsPackageImpl) (registeredPackage instanceof commonsPackageImpl
				? registeredPackage
				: commonsPackage.eINSTANCE);

		// Create package meta-data objects
		theoperationsPackage.createPackageContents();
		theentityPackage.createPackageContents();
		thecommonsPackage.createPackageContents();

		// Initialize created meta-data
		theoperationsPackage.initializePackageContents();
		theentityPackage.initializePackageContents();
		thecommonsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theoperationsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(operationsPackage.eNS_URI, theoperationsPackage);
		return theoperationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomain_SubDomain() {
		return (EReference) domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomain_Dimensions() {
		return (EReference) domainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Properties() {
		return (EReference) operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Type() {
		return (EReference) operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Domain() {
		return (EReference) operationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Range() {
		return (EReference) operationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAggregating() {
		return aggregatingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregating_Size() {
		return (EAttribute) aggregatingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregating_Step() {
		return (EAttribute) aggregatingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregating_JoinOperation() {
		return (EAttribute) aggregatingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositionellOperation() {
		return compositionellOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositionellOperation_Operation() {
		return (EReference) compositionellOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDimension() {
		return dimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDimension_ValueSpace() {
		return (EAttribute) dimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationDefinition() {
		return operationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationDefinition_Operations() {
		return (EReference) operationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationDefinition_Domains() {
		return (EReference) operationDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSelecting() {
		return selectingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAtomicOperation() {
		return atomicOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProjection() {
		return projectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationType() {
		return operationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getJoinOperation() {
		return joinOperationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public operationsFactory getoperationsFactory() {
		return (operationsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		domainEClass = createEClass(DOMAIN);
		createEReference(domainEClass, DOMAIN__SUB_DOMAIN);
		createEReference(domainEClass, DOMAIN__DIMENSIONS);

		propertyEClass = createEClass(PROPERTY);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__PROPERTIES);
		createEReference(operationEClass, OPERATION__TYPE);
		createEReference(operationEClass, OPERATION__DOMAIN);
		createEReference(operationEClass, OPERATION__RANGE);

		aggregatingEClass = createEClass(AGGREGATING);
		createEAttribute(aggregatingEClass, AGGREGATING__SIZE);
		createEAttribute(aggregatingEClass, AGGREGATING__STEP);
		createEAttribute(aggregatingEClass, AGGREGATING__JOIN_OPERATION);

		compositionellOperationEClass = createEClass(COMPOSITIONELL_OPERATION);
		createEReference(compositionellOperationEClass, COMPOSITIONELL_OPERATION__OPERATION);

		mappingEClass = createEClass(MAPPING);

		dimensionEClass = createEClass(DIMENSION);
		createEAttribute(dimensionEClass, DIMENSION__VALUE_SPACE);

		operationDefinitionEClass = createEClass(OPERATION_DEFINITION);
		createEReference(operationDefinitionEClass, OPERATION_DEFINITION__OPERATIONS);
		createEReference(operationDefinitionEClass, OPERATION_DEFINITION__DOMAINS);

		selectingEClass = createEClass(SELECTING);

		atomicOperationEClass = createEClass(ATOMIC_OPERATION);

		projectionEClass = createEClass(PROJECTION);

		operationTypeEClass = createEClass(OPERATION_TYPE);

		// Create enums
		joinOperationEEnum = createEEnum(JOIN_OPERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		commonsPackage thecommonsPackage = (commonsPackage) EPackage.Registry.INSTANCE
				.getEPackage(commonsPackage.eNS_URI);
		DataRepresentationPackage theDataRepresentationPackage = (DataRepresentationPackage) EPackage.Registry.INSTANCE
				.getEPackage(DataRepresentationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		operationEClass.getESuperTypes().add(thecommonsPackage.getNamedElement());
		aggregatingEClass.getESuperTypes().add(this.getProperty());
		compositionellOperationEClass.getESuperTypes().add(this.getOperation());
		mappingEClass.getESuperTypes().add(this.getOperationType());
		selectingEClass.getESuperTypes().add(this.getProperty());
		atomicOperationEClass.getESuperTypes().add(this.getOperation());
		projectionEClass.getESuperTypes().add(this.getOperationType());

		// Initialize classes, features, and operations; add parameters
		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomain_SubDomain(), this.getDomain(), null, "subDomain", null, 0, -1, Domain.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomain_Dimensions(), this.getDimension(), null, "dimensions", null, 1, -1, Domain.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationEClass, Operation.class, "Operation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Properties(), this.getProperty(), null, "properties", null, 0, 1, Operation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Type(), this.getOperationType(), null, "type", null, 0, 1, Operation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Domain(), this.getDomain(), null, "domain", null, 1, 1, Operation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Range(), this.getDomain(), null, "range", null, 1, 1, Operation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregatingEClass, Aggregating.class, "Aggregating", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregating_Size(), ecorePackage.getEInt(), "size", null, 0, 1, Aggregating.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregating_Step(), ecorePackage.getEInt(), "step", null, 0, 1, Aggregating.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregating_JoinOperation(), this.getJoinOperation(), "joinOperation", null, 1, 1,
				Aggregating.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(compositionellOperationEClass, CompositionellOperation.class, "CompositionellOperation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositionellOperation_Operation(), this.getOperation(), null, "operation", null, 1, 1,
				CompositionellOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimension_ValueSpace(), theDataRepresentationPackage.getDataType(), "valueSpace", null, 1, 1,
				Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(operationDefinitionEClass, OperationDefinition.class, "OperationDefinition", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationDefinition_Operations(), this.getOperation(), null, "operations", null, 0, -1,
				OperationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationDefinition_Domains(), this.getDomain(), null, "domains", null, 0, -1,
				OperationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectingEClass, Selecting.class, "Selecting", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(atomicOperationEClass, AtomicOperation.class, "AtomicOperation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(projectionEClass, Projection.class, "Projection", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationTypeEClass, OperationType.class, "OperationType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(joinOperationEEnum, JoinOperation.class, "JoinOperation");
		addEEnumLiteral(joinOperationEEnum, JoinOperation.SUM);
		addEEnumLiteral(joinOperationEEnum, JoinOperation.PRODUCT);
		addEEnumLiteral(joinOperationEEnum, JoinOperation.MIN);
		addEEnumLiteral(joinOperationEEnum, JoinOperation.MAX);

		// Create resource
		createResource(eNS_URI);
	}

} //operationsPackageImpl
