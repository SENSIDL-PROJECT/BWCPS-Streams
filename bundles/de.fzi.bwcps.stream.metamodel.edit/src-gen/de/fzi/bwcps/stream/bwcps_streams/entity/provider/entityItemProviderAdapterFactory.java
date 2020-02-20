/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity.provider;

import de.fzi.bwcps.stream.bwcps_streams.entity.util.entityAdapterFactory;

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
public class entityItemProviderAdapterFactory extends entityAdapterFactory
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
	public entityItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeDevice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeDeviceItemProvider edgeDeviceItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeDevice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEdgeDeviceAdapter() {
		if (edgeDeviceItemProvider == null) {
			edgeDeviceItemProvider = new EdgeDeviceItemProvider(this);
		}

		return edgeDeviceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedNodeLinkItemProvider aggregatedNodeLinkItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.AggregatedNodeLink}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAggregatedNodeLinkAdapter() {
		if (aggregatedNodeLinkItemProvider == null) {
			aggregatedNodeLinkItemProvider = new AggregatedNodeLinkItemProvider(this);
		}

		return aggregatedNodeLinkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamRepositoryItemProvider streamRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStreamRepositoryAdapter() {
		if (streamRepositoryItemProvider == null) {
			streamRepositoryItemProvider = new StreamRepositoryItemProvider(this);
		}

		return streamRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.Stream} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamItemProvider streamItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.Stream}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStreamAdapter() {
		if (streamItemProvider == null) {
			streamItemProvider = new StreamItemProvider(this);
		}

		return streamItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveNodeLinkItemProvider primitiveNodeLinkItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.PrimitiveNodeLink}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPrimitiveNodeLinkAdapter() {
		if (primitiveNodeLinkItemProvider == null) {
			primitiveNodeLinkItemProvider = new PrimitiveNodeLinkItemProvider(this);
		}

		return primitiveNodeLinkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.Node} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeItemProvider nodeItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeAdapter() {
		if (nodeItemProvider == null) {
			nodeItemProvider = new NodeItemProvider(this);
		}

		return nodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkSourceNodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SinkSourceNodeTypeItemProvider sinkSourceNodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkSourceNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSinkSourceNodeTypeAdapter() {
		if (sinkSourceNodeTypeItemProvider == null) {
			sinkSourceNodeTypeItemProvider = new SinkSourceNodeTypeItemProvider(this);
		}

		return sinkSourceNodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeGateway} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeGatewayItemProvider edgeGatewayItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.EdgeGateway}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEdgeGatewayAdapter() {
		if (edgeGatewayItemProvider == null) {
			edgeGatewayItemProvider = new EdgeGatewayItemProvider(this);
		}

		return edgeGatewayItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.DataSink} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSinkItemProvider dataSinkItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.DataSink}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataSinkAdapter() {
		if (dataSinkItemProvider == null) {
			dataSinkItemProvider = new DataSinkItemProvider(this);
		}

		return dataSinkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceNodeTypeItemProvider sourceNodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.SourceNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSourceNodeTypeAdapter() {
		if (sourceNodeTypeItemProvider == null) {
			sourceNodeTypeItemProvider = new SourceNodeTypeItemProvider(this);
		}

		return sourceNodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkNodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SinkNodeTypeItemProvider sinkNodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.SinkNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSinkNodeTypeAdapter() {
		if (sinkNodeTypeItemProvider == null) {
			sinkNodeTypeItemProvider = new SinkNodeTypeItemProvider(this);
		}

		return sinkNodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeTypeItemProvider nodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.bwcps.stream.bwcps_streams.entity.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeTypeAdapter() {
		if (nodeTypeItemProvider == null) {
			nodeTypeItemProvider = new NodeTypeItemProvider(this);
		}

		return nodeTypeItemProvider;
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
		if (edgeDeviceItemProvider != null)
			edgeDeviceItemProvider.dispose();
		if (aggregatedNodeLinkItemProvider != null)
			aggregatedNodeLinkItemProvider.dispose();
		if (streamRepositoryItemProvider != null)
			streamRepositoryItemProvider.dispose();
		if (streamItemProvider != null)
			streamItemProvider.dispose();
		if (primitiveNodeLinkItemProvider != null)
			primitiveNodeLinkItemProvider.dispose();
		if (nodeItemProvider != null)
			nodeItemProvider.dispose();
		if (sinkSourceNodeTypeItemProvider != null)
			sinkSourceNodeTypeItemProvider.dispose();
		if (edgeGatewayItemProvider != null)
			edgeGatewayItemProvider.dispose();
		if (dataSinkItemProvider != null)
			dataSinkItemProvider.dispose();
		if (sourceNodeTypeItemProvider != null)
			sourceNodeTypeItemProvider.dispose();
		if (sinkNodeTypeItemProvider != null)
			sinkNodeTypeItemProvider.dispose();
		if (nodeTypeItemProvider != null)
			nodeTypeItemProvider.dispose();
	}

}