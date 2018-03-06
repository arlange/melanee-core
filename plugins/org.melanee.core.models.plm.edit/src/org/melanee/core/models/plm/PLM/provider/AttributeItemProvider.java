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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * This is the item provider adapter for a
 * {@link org.melanee.core.models.plm.PLM.Attribute} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AttributeItemProvider extends FeatureItemProvider {
  /**
   * This constructs an instance from a factory and a notifier. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AttributeItemProvider(AdapterFactory adapterFactory) {
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

      addValuePropertyDescriptor(object);
      addMutabilityPropertyDescriptor(object);
      addDatatypePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Value feature. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addValuePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new org.eclipse.emf.edit.provider.ItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Attribute_value_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_Attribute_value_feature",
            "_UI_Attribute_type"),
        PLMPackage.Literals.ATTRIBUTE__VALUE, true, false, false,
        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null) {
      @Override
      public Collection<?> getChoiceOfValues(Object object) {
        // First call of method is on EAttribute, second call on Attribute only happens
        // in case empty collection is returned.
        if (!(object instanceof org.melanee.core.models.plm.PLM.Attribute))
          return new java.util.ArrayList<String>();

        List<String> enumerations = new java.util.ArrayList<String>();
        org.melanee.core.models.plm.PLM.Attribute attribute = (org.melanee.core.models.plm.PLM.Attribute) object;

        for (org.melanee.core.models.plm.PLM.Enumeration e : attribute.getClabject().getDeepModel()
            .getEnumeration())
          enumerations.add(e.getName());

        if (enumerations.contains(attribute.getDatatype())) {
          List<String> choices = new java.util.ArrayList<String>();

          for (org.melanee.core.models.plm.PLM.Enumeration e : ((org.melanee.core.models.plm.PLM.Feature) object)
              .getClabject().getDeepModel().getEnumeration())
            if (e.getName().equals(attribute.getDatatype())) {
              choices.addAll(e.getLiteral());
              break;
            }

          return choices;
        } else
          return null;
      }
    });
  }

  /**
   * This adds a property descriptor for the Mutability feature. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addMutabilityPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Attribute_mutability_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_Attribute_mutability_feature",
            "_UI_Attribute_type"),
        PLMPackage.Literals.ATTRIBUTE__MUTABILITY, true, false, false,
        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Datatype feature. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addDatatypePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new org.eclipse.emf.edit.provider.ItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Attribute_datatype_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_Attribute_datatype_feature",
            "_UI_Attribute_type"),
        PLMPackage.Literals.ATTRIBUTE__DATATYPE, true, false, false,
        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null) {
      @Override
      public Collection<?> getChoiceOfValues(Object object) {
        if (object instanceof org.melanee.core.models.plm.PLM.Feature)
          return ((org.melanee.core.models.plm.PLM.Feature) object).getClabject().getDeepModel()
              .getAllDatatypes();
        if (object instanceof org.melanee.core.models.plm.PLM.PrimitiveParameter)
          return ((org.melanee.core.models.plm.PLM.PrimitiveParameter) object).getClabject()
              .getDeepModel().getAllDatatypes();

        return new java.util.ArrayList<Object>();
      }
    });
  }

  /**
   * This returns Attribute.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Attribute"));
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getText(Object object) {

    String label = ((Attribute) object).getName();
    return label == null || label.length() == 0 ? getString("_UI_Attribute_type")
        : getString("_UI_Attribute_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update
   * any cached children and by creating a viewer notification, which it passes to
   * {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(Attribute.class)) {
    case PLMPackage.ATTRIBUTE__VALUE:
    case PLMPackage.ATTRIBUTE__MUTABILITY:
    case PLMPackage.ATTRIBUTE__DATATYPE:
      fireNotifyChanged(
          new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing
   * the children that can be created under this object. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

}
