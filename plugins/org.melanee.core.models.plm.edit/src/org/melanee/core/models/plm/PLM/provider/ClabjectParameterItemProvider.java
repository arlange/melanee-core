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

import org.melanee.core.models.plm.PLM.ClabjectParameter;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * This is the item provider adapter for a
 * {@link org.melanee.core.models.plm.PLM.ClabjectParameter} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ClabjectParameterItemProvider extends ParameterItemProvider {
  /**
   * This constructs an instance from a factory and a notifier. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ClabjectParameterItemProvider(AdapterFactory adapterFactory) {
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

      addDatatypePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Datatype feature.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   */
  protected void addDatatypePropertyDescriptor(Object object) {
  itemPropertyDescriptors.add
      (new org.eclipse.emf.edit.provider.ItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ClabjectParameter_datatype_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ClabjectParameter_datatype_feature", "_UI_ClabjectParameter_type"),
         PLMPackage.Literals.CLABJECT_PARAMETER__DATATYPE,
         true,
         false,
         true,
         null,
         null,
         null) {
      @Override
      public Collection<?> getChoiceOfValues(Object object) {
        if (object instanceof org.melanee.core.models.plm.PLM.Feature)
            return ((org.melanee.core.models.plm.PLM.Feature)object).getClabject().getDeepModel().getAllDatatypes();
        if (object instanceof org.melanee.core.models.plm.PLM.PrimitiveParameter)
          return ((org.melanee.core.models.plm.PLM.PrimitiveParameter)object).getClabject().getDeepModel().getAllDatatypes();
        
        return new java.util.ArrayList<Object>();
      }
    });
  }

  /**
   * This returns ClabjectParameter.gif. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ClabjectParameter"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {


    String label = ((ClabjectParameter)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_ClabjectParameter_type") :
      getString("_UI_ClabjectParameter_type") + " " + label;
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

}
