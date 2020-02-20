/**
 */
package de.fzi.bwcps.stream.bwcps_streams.operations.provider;

import de.fzi.bwcps.stream.bwcps_streams.operations.util.operationsAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class operationsItemProviderAdapterFactory extends operationsAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public operationsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainItemProvider domainItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.Domain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDomainAdapter() {
		if (domainItemProvider == null) {
			domainItemProvider = new DomainItemProvider(this);
		}

		return domainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatingItemProvider aggregatingItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.Aggregating}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAggregatingAdapter() {
		if (aggregatingItemProvider == null) {
			aggregatingItemProvider = new AggregatingItemProvider(this);
		}

		return aggregatingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositionellOperationItemProvider compositionellOperationItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.CompositionellOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositionellOperationAdapter() {
		if (compositionellOperationItemProvider == null) {
			compositionellOperationItemProvider = new CompositionellOperationItemProvider(this);
		}

		return compositionellOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.Mapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingItemProvider mappingItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappingAdapter() {
		if (mappingItemProvider == null) {
			mappingItemProvider = new MappingItemProvider(this);
		}

		return mappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.Dimension} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DimensionItemProvider dimensionItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.Dimension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDimensionAdapter() {
		if (dimensionItemProvider == null) {
			dimensionItemProvider = new DimensionItemProvider(this);
		}

		return dimensionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationDefinitionItemProvider operationDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.OperationDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperationDefinitionAdapter() {
		if (operationDefinitionItemProvider == null) {
			operationDefinitionItemProvider = new OperationDefinitionItemProvider(this);
		}

		return operationDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.Selecting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectingItemProvider selectingItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.Selecting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSelectingAdapter() {
		if (selectingItemProvider == null) {
			selectingItemProvider = new SelectingItemProvider(this);
		}

		return selectingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.AtomicOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicOperationItemProvider atomicOperationItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.AtomicOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAtomicOperationAdapter() {
		if (atomicOperationItemProvider == null) {
			atomicOperationItemProvider = new AtomicOperationItemProvider(this);
		}

		return atomicOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.operations.Projection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectionItemProvider projectionItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.operations.Projection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProjectionAdapter() {
		if (projectionItemProvider == null) {
			projectionItemProvider = new ProjectionItemProvider(this);
		}

		return projectionItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (domainItemProvider != null)
			domainItemProvider.dispose();
		if (aggregatingItemProvider != null)
			aggregatingItemProvider.dispose();
		if (compositionellOperationItemProvider != null)
			compositionellOperationItemProvider.dispose();
		if (mappingItemProvider != null)
			mappingItemProvider.dispose();
		if (dimensionItemProvider != null)
			dimensionItemProvider.dispose();
		if (operationDefinitionItemProvider != null)
			operationDefinitionItemProvider.dispose();
		if (selectingItemProvider != null)
			selectingItemProvider.dispose();
		if (atomicOperationItemProvider != null)
			atomicOperationItemProvider.dispose();
		if (projectionItemProvider != null)
			projectionItemProvider.dispose();
	}

}
