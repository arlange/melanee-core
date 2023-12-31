/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.plm.PLM.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.melanee.core.models.plm.PLM.Multiplicity;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * This is the item provider adapter for a
 * {@link org.melanee.core.models.plm.PLM.Multiplicity} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MultiplicityItemProvider extends ItemProviderAdapter
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
    IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public MultiplicityItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addLowerPropertyDescriptor(object);
      addUpperPropertyDescriptor(object);
      addPotencyPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Lower feature.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   */
  protected void addLowerPropertyDescriptor(Object object) {
  itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Multiplicity_lower_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Multiplicity_lower_feature", "_UI_Multiplicity_type"),
         PLMPackage.Literals.MULTIPLICITY__LOWER,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Upper feature.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   */
  protected void addUpperPropertyDescriptor(Object object) {
  itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Multiplicity_upper_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Multiplicity_upper_feature", "_UI_Multiplicity_type"),
         PLMPackage.Literals.MULTIPLICITY__UPPER,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Potency feature.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   */
  protected void addPotencyPropertyDescriptor(Object object) {
  itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Multiplicity_potency_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Multiplicity_potency_feature", "_UI_Multiplicity_type"),
         PLMPackage.Literals.MULTIPLICITY__POTENCY,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This returns Multiplicity.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Multiplicity"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {


    Multiplicity multiplicity = (Multiplicity)object;
    return getString("_UI_Multiplicity_type") + " " + multiplicity.getLower();
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(Multiplicity.class)) {
      case PLMPackage.MULTIPLICITY__LOWER:
      case PLMPackage.MULTIPLICITY__UPPER:
      case PLMPackage.MULTIPLICITY__POTENCY:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

  /**
   * Return the resource locator for this item provider's resources. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return PLMEditPlugin.INSTANCE;
  }

}
