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

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * This is the item provider adapter for a {@link org.melanee.core.models.plm.PLM.Clabject} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClabjectItemProvider extends OwnedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClabjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addPotencyPropertyDescriptor(object);
			addLevelIndexPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Potency feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPotencyPropertyDescriptor(Object object) {
	itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Clabject_potency_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Clabject_potency_feature", "_UI_Clabject_type"),
				 PLMPackage.Literals.CLABJECT__POTENCY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Level Index feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLevelIndexPropertyDescriptor(Object object) {
	itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Clabject_levelIndex_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Clabject_levelIndex_feature", "_UI_Clabject_type"),
				 PLMPackage.Literals.CLABJECT__LEVEL_INDEX,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PLMPackage.Literals.CLABJECT__CONTENT);
			childrenFeatures.add(PLMPackage.Literals.CLABJECT__FEATURE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {


		String label = ((Clabject)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Clabject_type") :
			getString("_UI_Clabject_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Clabject.class)) {
			case PLMPackage.CLABJECT__POTENCY:
			case PLMPackage.CLABJECT__LEVEL_INDEX:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PLMPackage.CLABJECT__CONTENT:
			case PLMPackage.CLABJECT__FEATURE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(PLMPackage.Literals.CLABJECT__CONTENT,
				 PLMFactory.eINSTANCE.createInheritance()));

		newChildDescriptors.add
			(createChildParameter
				(PLMPackage.Literals.CLABJECT__CONTENT,
				 PLMFactory.eINSTANCE.createClassification()));

		newChildDescriptors.add
			(createChildParameter
				(PLMPackage.Literals.CLABJECT__CONTENT,
				 PLMFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(PLMPackage.Literals.CLABJECT__CONTENT,
				 PLMFactory.eINSTANCE.createConnection()));

		newChildDescriptors.add
			(createChildParameter
				(PLMPackage.Literals.CLABJECT__CONTENT,
				 PLMFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add
			(createChildParameter
				(PLMPackage.Literals.CLABJECT__FEATURE,
				 PLMFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(PLMPackage.Literals.CLABJECT__FEATURE,
				 PLMFactory.eINSTANCE.createMethod()));
	}

}
