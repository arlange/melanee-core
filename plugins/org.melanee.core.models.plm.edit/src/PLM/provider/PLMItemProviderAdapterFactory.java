/**
 */
package PLM.provider;

import PLM.util.PLMAdapterFactory;

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
public class PLMItemProviderAdapterFactory extends PLMAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
  public PLMItemProviderAdapterFactory() {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Domain} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DomainItemProvider domainItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Domain}.
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
   * This keeps track of the one adapter used for all {@link PLM.Level} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LevelItemProvider levelItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Level}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLevelAdapter() {
    if (levelItemProvider == null) {
      levelItemProvider = new LevelItemProvider(this);
    }

    return levelItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.DeepModel} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeepModelItemProvider deepModelItemProvider;

  /**
   * This creates an adapter for a {@link PLM.DeepModel}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createDeepModelAdapter() {
    if (deepModelItemProvider == null) {
      deepModelItemProvider = new DeepModelItemProvider(this);
    }

    return deepModelItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Inheritance} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InheritanceItemProvider inheritanceItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Inheritance}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createInheritanceAdapter() {
    if (inheritanceItemProvider == null) {
      inheritanceItemProvider = new InheritanceItemProvider(this);
    }

    return inheritanceItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Supertype} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SupertypeItemProvider supertypeItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Supertype}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createSupertypeAdapter() {
    if (supertypeItemProvider == null) {
      supertypeItemProvider = new SupertypeItemProvider(this);
    }

    return supertypeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Subtype} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubtypeItemProvider subtypeItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Subtype}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createSubtypeAdapter() {
    if (subtypeItemProvider == null) {
      subtypeItemProvider = new SubtypeItemProvider(this);
    }

    return subtypeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Classification} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationItemProvider classificationItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Classification}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createClassificationAdapter() {
    if (classificationItemProvider == null) {
      classificationItemProvider = new ClassificationItemProvider(this);
    }

    return classificationItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Entity} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntityItemProvider entityItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Entity}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createEntityAdapter() {
    if (entityItemProvider == null) {
      entityItemProvider = new EntityItemProvider(this);
    }

    return entityItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Connection} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectionItemProvider connectionItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Connection}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createConnectionAdapter() {
    if (connectionItemProvider == null) {
      connectionItemProvider = new ConnectionItemProvider(this);
    }

    return connectionItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.ConnectionEnd} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectionEndItemProvider connectionEndItemProvider;

  /**
   * This creates an adapter for a {@link PLM.ConnectionEnd}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createConnectionEndAdapter() {
    if (connectionEndItemProvider == null) {
      connectionEndItemProvider = new ConnectionEndItemProvider(this);
    }

    return connectionEndItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.LMLVisualizer} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LMLVisualizerItemProvider lmlVisualizerItemProvider;

  /**
   * This creates an adapter for a {@link PLM.LMLVisualizer}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLMLVisualizerAdapter() {
    if (lmlVisualizerItemProvider == null) {
      lmlVisualizerItemProvider = new LMLVisualizerItemProvider(this);
    }

    return lmlVisualizerItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Attribute} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeItemProvider attributeItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createAttributeAdapter() {
    if (attributeItemProvider == null) {
      attributeItemProvider = new AttributeItemProvider(this);
    }

    return attributeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Method} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MethodItemProvider methodItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Method}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createMethodAdapter() {
    if (methodItemProvider == null) {
      methodItemProvider = new MethodItemProvider(this);
    }

    return methodItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Enumeration} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumerationItemProvider enumerationItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Enumeration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createEnumerationAdapter() {
    if (enumerationItemProvider == null) {
      enumerationItemProvider = new EnumerationItemProvider(this);
    }

    return enumerationItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.ClabjectParameter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClabjectParameterItemProvider clabjectParameterItemProvider;

  /**
   * This creates an adapter for a {@link PLM.ClabjectParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createClabjectParameterAdapter() {
    if (clabjectParameterItemProvider == null) {
      clabjectParameterItemProvider = new ClabjectParameterItemProvider(this);
    }

    return clabjectParameterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.PrimitiveParameter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimitiveParameterItemProvider primitiveParameterItemProvider;

  /**
   * This creates an adapter for a {@link PLM.PrimitiveParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPrimitiveParameterAdapter() {
    if (primitiveParameterItemProvider == null) {
      primitiveParameterItemProvider = new PrimitiveParameterItemProvider(this);
    }

    return primitiveParameterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Multiplicity} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiplicityItemProvider multiplicityItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Multiplicity}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createMultiplicityAdapter() {
    if (multiplicityItemProvider == null) {
      multiplicityItemProvider = new MultiplicityItemProvider(this);
    }

    return multiplicityItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link PLM.Package} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageItemProvider packageItemProvider;

  /**
   * This creates an adapter for a {@link PLM.Package}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPackageAdapter() {
    if (packageItemProvider == null) {
      packageItemProvider = new PackageItemProvider(this);
    }

    return packageItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory() {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
      if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
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
  public void addListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public void dispose() {
    if (domainItemProvider != null) domainItemProvider.dispose();
    if (levelItemProvider != null) levelItemProvider.dispose();
    if (deepModelItemProvider != null) deepModelItemProvider.dispose();
    if (inheritanceItemProvider != null) inheritanceItemProvider.dispose();
    if (supertypeItemProvider != null) supertypeItemProvider.dispose();
    if (subtypeItemProvider != null) subtypeItemProvider.dispose();
    if (classificationItemProvider != null) classificationItemProvider.dispose();
    if (entityItemProvider != null) entityItemProvider.dispose();
    if (connectionItemProvider != null) connectionItemProvider.dispose();
    if (connectionEndItemProvider != null) connectionEndItemProvider.dispose();
    if (lmlVisualizerItemProvider != null) lmlVisualizerItemProvider.dispose();
    if (attributeItemProvider != null) attributeItemProvider.dispose();
    if (methodItemProvider != null) methodItemProvider.dispose();
    if (enumerationItemProvider != null) enumerationItemProvider.dispose();
    if (clabjectParameterItemProvider != null) clabjectParameterItemProvider.dispose();
    if (primitiveParameterItemProvider != null) primitiveParameterItemProvider.dispose();
    if (multiplicityItemProvider != null) multiplicityItemProvider.dispose();
    if (packageItemProvider != null) packageItemProvider.dispose();
  }

}
