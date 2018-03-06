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
package org.melanee.core.models.plm.PLM.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Method;
import org.melanee.core.models.plm.PLM.OwnedElement;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Clabject</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.plm.PLM.impl.ClabjectImpl#getPotency
 * <em>Potency</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.impl.ClabjectImpl#getLevelIndex
 * <em>Level Index</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.impl.ClabjectImpl#getContent
 * <em>Content</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.impl.ClabjectImpl#getFeature
 * <em>Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClabjectImpl extends OwnedElementImpl implements Clabject {
  /**
   * The default value of the '{@link #getPotency() <em>Potency</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getPotency()
   * @generated
   * @ordered
   */
  protected static final int POTENCY_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getPotency() <em>Potency</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getPotency()
   * @generated
   * @ordered
   */
  protected int potency = POTENCY_EDEFAULT;

  /**
   * The cached setting delegate for the '{@link #getLevelIndex() <em>Level
   * Index</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLevelIndex()
   * @generated
   * @ordered
   */
  protected EStructuralFeature.Internal.SettingDelegate LEVEL_INDEX__ESETTING_DELEGATE = ((EStructuralFeature.Internal) PLMPackage.Literals.CLABJECT__LEVEL_INDEX)
      .getSettingDelegate();

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment
   * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<OwnedElement> content;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment
   * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected EList<Feature> feature;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ClabjectImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.CLABJECT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public int getPotency() {
    return potency;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setPotency(int newPotency) {
    int oldPotency = potency;
    potency = newPotency;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CLABJECT__POTENCY,
          oldPotency, potency));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public int getLevelIndex() {
    return (Integer) LEVEL_INDEX__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isSetLevelIndex() {
    return LEVEL_INDEX__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<OwnedElement> getContent() {
    if (content == null) {
      content = new EObjectContainmentEList<OwnedElement>(OwnedElement.class, this,
          PLMPackage.CLABJECT__CONTENT);
    }
    return content;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<Feature> getFeature() {
    if (feature == null) {
      feature = new EObjectContainmentEList<Feature>(Feature.class, this,
          PLMPackage.CLABJECT__FEATURE);
    }
    return feature;
  }

  /**
   * The cached invocation delegate for the '{@link #getDeepModel() <em>Get Deep
   * Model</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDeepModel()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEEP_MODEL__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEEP_MODEL)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public DeepModel getDeepModel() {
    try {
      return (DeepModel) GET_DEEP_MODEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getSupertypes() <em>Get
   * Supertypes</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSupertypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_SUPERTYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_SUPERTYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getSupertypes() {
    try {
      return (EList<Clabject>) GET_SUPERTYPES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getSupertypes(org.eclipse.emf.common.util.EList) <em>Get
   * Supertypes</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSupertypes(org.eclipse.emf.common.util.EList)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_SUPERTYPES_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_SUPERTYPES__ELIST)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getSupertypes(EList<Clabject> immediateResult) {
    try {
      return (EList<Clabject>) GET_SUPERTYPES_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this,
          new BasicEList.UnmodifiableEList<Object>(1, new Object[] { immediateResult }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDirectSupertypes() <em>Get
   * Direct Supertypes</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getDirectSupertypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DIRECT_SUPERTYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DIRECT_SUPERTYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDirectSupertypes() {
    try {
      return (EList<Clabject>) GET_DIRECT_SUPERTYPES__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getSubtypes() <em>Get
   * Subtypes</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSubtypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_SUBTYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_SUBTYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getSubtypes() {
    try {
      return (EList<Clabject>) GET_SUBTYPES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getHollowSubtypes() <em>Get
   * Hollow Subtypes</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getHollowSubtypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_HOLLOW_SUBTYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_HOLLOW_SUBTYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getHollowSubtypes() {
    try {
      return (EList<Clabject>) GET_HOLLOW_SUBTYPES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getHollowSupertypes() <em>Get
   * Hollow Supertypes</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getHollowSupertypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_HOLLOW_SUPERTYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_HOLLOW_SUPERTYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getHollowSupertypes() {
    try {
      return (EList<Clabject>) GET_HOLLOW_SUPERTYPES__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getClassificationsAsInstance() <em>Get Classifications As
   * Instance</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getClassificationsAsInstance()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFICATIONS_AS_INSTANCE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_CLASSIFICATIONS_AS_INSTANCE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Classification> getClassificationsAsInstance() {
    try {
      return (EList<Classification>) GET_CLASSIFICATIONS_AS_INSTANCE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getClassificationsAsType()
   * <em>Get Classifications As Type</em>}' operation. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getClassificationsAsType()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFICATIONS_AS_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_CLASSIFICATIONS_AS_TYPE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Classification> getClassificationsAsType() {
    try {
      return (EList<Classification>) GET_CLASSIFICATIONS_AS_TYPE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getInstances() <em>Get
   * Instances</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getInstances()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_INSTANCES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_INSTANCES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getInstances() {
    try {
      return (EList<Clabject>) GET_INSTANCES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getTypes() <em>Get
   * Types</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_TYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_TYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getTypes() {
    try {
      return (EList<Clabject>) GET_TYPES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDirectTypes() <em>Get
   * Direct Types</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDirectTypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DIRECT_TYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DIRECT_TYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDirectTypes() {
    try {
      return (EList<Clabject>) GET_DIRECT_TYPES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getLevelTypes() <em>Get Level
   * Types</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLevelTypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_LEVEL_TYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_LEVEL_TYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getLevelTypes() {
    try {
      return (EList<Clabject>) GET_LEVEL_TYPES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getDefinedClassificationTreeAsInstance() <em>Get Defined
   * Classification Tree As Instance</em>}' operation. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getDefinedClassificationTreeAsInstance()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDefinedClassificationTreeAsInstance() {
    try {
      return (EList<Clabject>) GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getClassificationTreeAsInstance() <em>Get Classification Tree As
   * Instance</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getClassificationTreeAsInstance()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFICATION_TREE_AS_INSTANCE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_CLASSIFICATION_TREE_AS_INSTANCE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getClassificationTreeAsInstance() {
    try {
      return (EList<Clabject>) GET_CLASSIFICATION_TREE_AS_INSTANCE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDefinedInstances() <em>Get
   * Defined Instances</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getDefinedInstances()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_INSTANCES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_INSTANCES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDefinedInstances() {
    try {
      return (EList<Clabject>) GET_DEFINED_INSTANCES__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getDefinedClassificationTreeAsType() <em>Get Defined Classification
   * Tree As Type</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDefinedClassificationTreeAsType()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDefinedClassificationTreeAsType() {
    try {
      return (EList<Clabject>) GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getClassificationTreeAsType()
   * <em>Get Classification Tree As Type</em>}' operation. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getClassificationTreeAsType()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFICATION_TREE_AS_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getClassificationTreeAsType() {
    try {
      return (EList<Clabject>) GET_CLASSIFICATION_TREE_AS_TYPE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getClassificationTreeAsType(int) <em>Get Classification Tree As
   * Type</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getClassificationTreeAsType(int)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFICATION_TREE_AS_TYPE_INT__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getClassificationTreeAsType(int distance) {
    try {
      return (EList<Clabject>) GET_CLASSIFICATION_TREE_AS_TYPE_INT__EINVOCATION_DELEGATE
          .dynamicInvoke(this,
              new BasicEList.UnmodifiableEList<Object>(1, new Object[] { distance }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getClassificationTreeAsType(int, int) <em>Get Classification Tree As
   * Type</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getClassificationTreeAsType(int, int)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFICATION_TREE_AS_TYPE_INT_INT__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getClassificationTreeAsType(int min, int max) {
    try {
      return (EList<Clabject>) GET_CLASSIFICATION_TREE_AS_TYPE_INT_INT__EINVOCATION_DELEGATE
          .dynamicInvoke(this,
              new BasicEList.UnmodifiableEList<Object>(2, new Object[] { min, max }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getAllFeatures() <em>Get All
   * Features</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getAllFeatures()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ALL_FEATURES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ALL_FEATURES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Feature> getAllFeatures() {
    try {
      return (EList<Feature>) GET_ALL_FEATURES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getAllAttributes() <em>Get
   * All Attributes</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getAllAttributes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ALL_ATTRIBUTES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ALL_ATTRIBUTES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Attribute> getAllAttributes() {
    try {
      return (EList<Attribute>) GET_ALL_ATTRIBUTES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDefinedAttributes()
   * <em>Get Defined Attributes</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getDefinedAttributes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_ATTRIBUTES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_ATTRIBUTES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Attribute> getDefinedAttributes() {
    try {
      return (EList<Attribute>) GET_DEFINED_ATTRIBUTES__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getDefinedAttributeByName(java.lang.String) <em>Get Defined
   * Attribute By Name</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getDefinedAttributeByName(java.lang.String)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_ATTRIBUTE_BY_NAME_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Attribute getDefinedAttributeByName(String name) {
    try {
      return (Attribute) GET_DEFINED_ATTRIBUTE_BY_NAME_STRING__EINVOCATION_DELEGATE
          .dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[] { name }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getAllMethods() <em>Get All
   * Methods</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getAllMethods()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ALL_METHODS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ALL_METHODS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Method> getAllMethods() {
    try {
      return (EList<Method>) GET_ALL_METHODS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDefinedMethods() <em>Get
   * Defined Methods</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getDefinedMethods()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_METHODS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_METHODS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Feature> getDefinedMethods() {
    try {
      return (EList<Feature>) GET_DEFINED_METHODS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #isInstanceOf(org.melanee.core.models.plm.PLM.Clabject) <em>Is
   * Instance Of</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isInstanceOf(org.melanee.core.models.plm.PLM.Clabject)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate IS_INSTANCE_OF_CLABJECT__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___IS_INSTANCE_OF__CLABJECT)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isInstanceOf(Clabject type) {
    try {
      return (Boolean) IS_INSTANCE_OF_CLABJECT__EINVOCATION_DELEGATE.dynamicInvoke(this,
          new BasicEList.UnmodifiableEList<Object>(1, new Object[] { type }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #isTypeOf(org.melanee.core.models.plm.PLM.Clabject) <em>Is Type
   * Of</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isTypeOf(org.melanee.core.models.plm.PLM.Clabject)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate IS_TYPE_OF_CLABJECT__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___IS_TYPE_OF__CLABJECT)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isTypeOf(Clabject type) {
    try {
      return (Boolean) IS_TYPE_OF_CLABJECT__EINVOCATION_DELEGATE.dynamicInvoke(this,
          new BasicEList.UnmodifiableEList<Object>(1, new Object[] { type }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #isContainerOf(org.melanee.core.models.plm.PLM.Clabject) <em>Is
   * Container Of</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isContainerOf(org.melanee.core.models.plm.PLM.Clabject)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate IS_CONTAINER_OF_CLABJECT__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___IS_CONTAINER_OF__CLABJECT)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isContainerOf(Clabject clabject) {
    try {
      return (Boolean) IS_CONTAINER_OF_CLABJECT__EINVOCATION_DELEGATE.dynamicInvoke(this,
          new BasicEList.UnmodifiableEList<Object>(1, new Object[] { clabject }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getComposite() <em>Get
   * Composite</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getComposite()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_COMPOSITE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_COMPOSITE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Clabject getComposite() {
    try {
      return (Clabject) GET_COMPOSITE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getAggregates() <em>Get
   * Aggregates</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getAggregates()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_AGGREGATES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_AGGREGATES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getAggregates() {
    try {
      return (EList<Clabject>) GET_AGGREGATES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getParts() <em>Get
   * Parts</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getParts()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_PARTS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_PARTS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getParts() {
    try {
      return (EList<Clabject>) GET_PARTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getPartsForMoniker(java.lang.String) <em>Get Parts For
   * Moniker</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getPartsForMoniker(java.lang.String)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_PARTS_FOR_MONIKER_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_PARTS_FOR_MONIKER__STRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getPartsForMoniker(String name) {
    try {
      return (EList<Clabject>) GET_PARTS_FOR_MONIKER_STRING__EINVOCATION_DELEGATE
          .dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[] { name }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDefinedConnections()
   * <em>Get Defined Connections</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getDefinedConnections()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_CONNECTIONS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_CONNECTIONS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Connection> getDefinedConnections() {
    try {
      return (EList<Connection>) GET_DEFINED_CONNECTIONS__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getConnections() <em>Get
   * Connections</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getConnections()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CONNECTIONS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_CONNECTIONS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Connection> getConnections() {
    try {
      return (EList<Connection>) GET_CONNECTIONS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getInheritedConnections()
   * <em>Get Inherited Connections</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getInheritedConnections()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_INHERITED_CONNECTIONS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_INHERITED_CONNECTIONS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Connection> getInheritedConnections() {
    try {
      return (EList<Connection>) GET_INHERITED_CONNECTIONS__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getLevelCompleteTypes()
   * <em>Get Level Complete Types</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getLevelCompleteTypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_LEVEL_COMPLETE_TYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_LEVEL_COMPLETE_TYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getLevelCompleteTypes() {
    try {
      return (EList<Clabject>) GET_LEVEL_COMPLETE_TYPES__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getLevelIncompleteTypes()
   * <em>Get Level Incomplete Types</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getLevelIncompleteTypes()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_LEVEL_INCOMPLETE_TYPES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_LEVEL_INCOMPLETE_TYPES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getLevelIncompleteTypes() {
    try {
      return (EList<Clabject>) GET_LEVEL_INCOMPLETE_TYPES__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getBlueprint() <em>Get
   * Blueprint</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getBlueprint()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_BLUEPRINT__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_BLUEPRINT)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Clabject getBlueprint() {
    try {
      return (Clabject) GET_BLUEPRINT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getOffspring() <em>Get
   * Offspring</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getOffspring()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_OFFSPRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_OFFSPRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getOffspring() {
    try {
      return (EList<Clabject>) GET_OFFSPRING__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getIsonyms() <em>Get
   * Isonyms</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getIsonyms()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ISONYMS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ISONYMS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getIsonyms() {
    try {
      return (EList<Clabject>) GET_ISONYMS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getHyponyms() <em>Get
   * Hyponyms</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getHyponyms()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_HYPONYMS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_HYPONYMS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getHyponyms() {
    try {
      return (EList<Clabject>) GET_HYPONYMS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getDomainForConnection(org.melanee.core.models.plm.PLM.Connection)
   * <em>Get Domain For Connection</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getDomainForConnection(org.melanee.core.models.plm.PLM.Connection)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DOMAIN_FOR_CONNECTION_CONNECTION__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DOMAIN_FOR_CONNECTION__CONNECTION)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDomainForConnection(Connection connection) {
    try {
      return (EList<Clabject>) GET_DOMAIN_FOR_CONNECTION_CONNECTION__EINVOCATION_DELEGATE
          .dynamicInvoke(this,
              new BasicEList.UnmodifiableEList<Object>(1, new Object[] { connection }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getPossibleDomainSpecificVisualizers() <em>Get Possible Domain
   * Specific Visualizers</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getPossibleDomainSpecificVisualizers()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<AbstractDSLVisualizer> getPossibleDomainSpecificVisualizers() {
    try {
      return (EList<AbstractDSLVisualizer>) GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getInheritancesAsSubtype()
   * <em>Get Inheritances As Subtype</em>}' operation. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getInheritancesAsSubtype()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_INHERITANCES_AS_SUBTYPE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_INHERITANCES_AS_SUBTYPE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Inheritance> getInheritancesAsSubtype() {
    try {
      return (EList<Inheritance>) GET_INHERITANCES_AS_SUBTYPE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getInheritancesAsSupertype()
   * <em>Get Inheritances As Supertype</em>}' operation. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getInheritancesAsSupertype()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_INHERITANCES_AS_SUPERTYPE__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_INHERITANCES_AS_SUPERTYPE)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Inheritance> getInheritancesAsSupertype() {
    try {
      return (EList<Inheritance>) GET_INHERITANCES_AS_SUPERTYPE__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDefinedNavigations()
   * <em>Get Defined Navigations</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getDefinedNavigations()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_NAVIGATIONS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_NAVIGATIONS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<ConnectionEnd> getDefinedNavigations() {
    try {
      return (EList<ConnectionEnd>) GET_DEFINED_NAVIGATIONS__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getInheritedNavigations()
   * <em>Get Inherited Navigations</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getInheritedNavigations()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_INHERITED_NAVIGATIONS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_INHERITED_NAVIGATIONS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<ConnectionEnd> getInheritedNavigations() {
    try {
      return (EList<ConnectionEnd>) GET_INHERITED_NAVIGATIONS__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getAllNavigations() <em>Get
   * All Navigations</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getAllNavigations()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ALL_NAVIGATIONS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ALL_NAVIGATIONS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<ConnectionEnd> getAllNavigations() {
    try {
      return (EList<ConnectionEnd>) GET_ALL_NAVIGATIONS__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDomainMonikers() <em>Get
   * Domain Monikers</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getDomainMonikers()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DOMAIN_MONIKERS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DOMAIN_MONIKERS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<String> getDomainMonikers() {
    try {
      return (EList<String>) GET_DOMAIN_MONIKERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getDomainForMoniker(java.lang.String) <em>Get Domain For
   * Moniker</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDomainForMoniker(java.lang.String)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DOMAIN_FOR_MONIKER_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DOMAIN_FOR_MONIKER__STRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDomainForMoniker(String moniker) {
    try {
      return (EList<Clabject>) GET_DOMAIN_FOR_MONIKER_STRING__EINVOCATION_DELEGATE.dynamicInvoke(
          this, new BasicEList.UnmodifiableEList<Object>(1, new Object[] { moniker }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getAllNavigationsForMoniker(java.lang.String) <em>Get All
   * Navigations For Moniker</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getAllNavigationsForMoniker(java.lang.String)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ALL_NAVIGATIONS_FOR_MONIKER_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<ConnectionEnd> getAllNavigationsForMoniker(String moniker) {
    try {
      return (EList<ConnectionEnd>) GET_ALL_NAVIGATIONS_FOR_MONIKER_STRING__EINVOCATION_DELEGATE
          .dynamicInvoke(this,
              new BasicEList.UnmodifiableEList<Object>(1, new Object[] { moniker }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getAllNavigationsAsDestination() <em>Get All Navigations As
   * Destination</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getAllNavigationsAsDestination()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ALL_NAVIGATIONS_AS_DESTINATION__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ALL_NAVIGATIONS_AS_DESTINATION)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<ConnectionEnd> getAllNavigationsAsDestination() {
    try {
      return (EList<ConnectionEnd>) GET_ALL_NAVIGATIONS_AS_DESTINATION__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getDefinedNavigationsAsDestination() <em>Get Defined Navigations As
   * Destination</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDefinedNavigationsAsDestination()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_NAVIGATIONS_AS_DESTINATION__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_NAVIGATIONS_AS_DESTINATION)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<ConnectionEnd> getDefinedNavigationsAsDestination() {
    try {
      return (EList<ConnectionEnd>) GET_DEFINED_NAVIGATIONS_AS_DESTINATION__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getInheritedNavigationsAsDestination() <em>Get Inherited Navigations
   * As Destination</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getInheritedNavigationsAsDestination()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_INHERITED_NAVIGATIONS_AS_DESTINATION__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_INHERITED_NAVIGATIONS_AS_DESTINATION)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<ConnectionEnd> getInheritedNavigationsAsDestination() {
    try {
      return (EList<ConnectionEnd>) GET_INHERITED_NAVIGATIONS_AS_DESTINATION__EINVOCATION_DELEGATE
          .dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #represent()
   * <em>Represent</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #represent()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate REPRESENT__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___REPRESENT)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String represent() {
    try {
      return (String) REPRESENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getFeatureForName(java.lang.String) <em>Get Feature For Name</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getFeatureForName(java.lang.String)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_FEATURE_FOR_NAME_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_FEATURE_FOR_NAME__STRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Feature getFeatureForName(String name) {
    try {
      return (Feature) GET_FEATURE_FOR_NAME_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this,
          new BasicEList.UnmodifiableEList<Object>(1, new Object[] { name }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getPotencyAsString() <em>Get
   * Potency As String</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getPotencyAsString()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_POTENCY_AS_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_POTENCY_AS_STRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getPotencyAsString() {
    try {
      return (String) GET_POTENCY_AS_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDisjointSiblings() <em>Get
   * Disjoint Siblings</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getDisjointSiblings()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DISJOINT_SIBLINGS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DISJOINT_SIBLINGS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getDisjointSiblings() {
    try {
      return (EList<Clabject>) GET_DISJOINT_SIBLINGS__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #getAttributeByName(java.lang.String) <em>Get Attribute By
   * Name</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getAttributeByName(java.lang.String)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_ATTRIBUTE_BY_NAME_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_ATTRIBUTE_BY_NAME__STRING)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Attribute getAttributeByName(String name) {
    try {
      return (Attribute) GET_ATTRIBUTE_BY_NAME_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this,
          new BasicEList.UnmodifiableEList<Object>(1, new Object[] { name }));
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the
   * '{@link #violatesMultiplicityConstraints() <em>Violates Multiplicity
   * Constraints</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #violatesMultiplicityConstraints()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate VIOLATES_MULTIPLICITY_CONSTRAINTS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___VIOLATES_MULTIPLICITY_CONSTRAINTS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean violatesMultiplicityConstraints() {
    try {
      return (Boolean) VIOLATES_MULTIPLICITY_CONSTRAINTS__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getDefinedInheritances()
   * <em>Get Defined Inheritances</em>}' operation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getDefinedInheritances()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_DEFINED_INHERITANCES__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_DEFINED_INHERITANCES)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Inheritance> getDefinedInheritances() {
    try {
      return (EList<Inheritance>) GET_DEFINED_INHERITANCES__EINVOCATION_DELEGATE.dynamicInvoke(this,
          null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getOwnedClabjects() <em>Get
   * Owned Clabjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getOwnedClabjects()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_OWNED_CLABJECTS__EINVOCATION_DELEGATE = ((EOperation.Internal) PLMPackage.Literals.CLABJECT___GET_OWNED_CLABJECTS)
      .getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<Clabject> getOwnedClabjects() {
    try {
      return (EList<Clabject>) GET_OWNED_CLABJECTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    } catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
    case PLMPackage.CLABJECT__CONTENT:
      return ((InternalEList<?>) getContent()).basicRemove(otherEnd, msgs);
    case PLMPackage.CLABJECT__FEATURE:
      return ((InternalEList<?>) getFeature()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case PLMPackage.CLABJECT__POTENCY:
      return getPotency();
    case PLMPackage.CLABJECT__LEVEL_INDEX:
      return getLevelIndex();
    case PLMPackage.CLABJECT__CONTENT:
      return getContent();
    case PLMPackage.CLABJECT__FEATURE:
      return getFeature();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case PLMPackage.CLABJECT__POTENCY:
      setPotency((Integer) newValue);
      return;
    case PLMPackage.CLABJECT__CONTENT:
      getContent().clear();
      getContent().addAll((Collection<? extends OwnedElement>) newValue);
      return;
    case PLMPackage.CLABJECT__FEATURE:
      getFeature().clear();
      getFeature().addAll((Collection<? extends Feature>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case PLMPackage.CLABJECT__POTENCY:
      setPotency(POTENCY_EDEFAULT);
      return;
    case PLMPackage.CLABJECT__CONTENT:
      getContent().clear();
      return;
    case PLMPackage.CLABJECT__FEATURE:
      getFeature().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case PLMPackage.CLABJECT__POTENCY:
      return potency != POTENCY_EDEFAULT;
    case PLMPackage.CLABJECT__LEVEL_INDEX:
      return isSetLevelIndex();
    case PLMPackage.CLABJECT__CONTENT:
      return content != null && !content.isEmpty();
    case PLMPackage.CLABJECT__FEATURE:
      return feature != null && !feature.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
    case PLMPackage.CLABJECT___GET_DEEP_MODEL:
      return getDeepModel();
    case PLMPackage.CLABJECT___GET_SUPERTYPES:
      return getSupertypes();
    case PLMPackage.CLABJECT___GET_SUPERTYPES__ELIST:
      return getSupertypes((EList<Clabject>) arguments.get(0));
    case PLMPackage.CLABJECT___GET_DIRECT_SUPERTYPES:
      return getDirectSupertypes();
    case PLMPackage.CLABJECT___GET_SUBTYPES:
      return getSubtypes();
    case PLMPackage.CLABJECT___GET_HOLLOW_SUBTYPES:
      return getHollowSubtypes();
    case PLMPackage.CLABJECT___GET_HOLLOW_SUPERTYPES:
      return getHollowSupertypes();
    case PLMPackage.CLABJECT___GET_CLASSIFICATIONS_AS_INSTANCE:
      return getClassificationsAsInstance();
    case PLMPackage.CLABJECT___GET_CLASSIFICATIONS_AS_TYPE:
      return getClassificationsAsType();
    case PLMPackage.CLABJECT___GET_INSTANCES:
      return getInstances();
    case PLMPackage.CLABJECT___GET_TYPES:
      return getTypes();
    case PLMPackage.CLABJECT___GET_DIRECT_TYPES:
      return getDirectTypes();
    case PLMPackage.CLABJECT___GET_LEVEL_TYPES:
      return getLevelTypes();
    case PLMPackage.CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE:
      return getDefinedClassificationTreeAsInstance();
    case PLMPackage.CLABJECT___GET_CLASSIFICATION_TREE_AS_INSTANCE:
      return getClassificationTreeAsInstance();
    case PLMPackage.CLABJECT___GET_DEFINED_INSTANCES:
      return getDefinedInstances();
    case PLMPackage.CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE:
      return getDefinedClassificationTreeAsType();
    case PLMPackage.CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE:
      return getClassificationTreeAsType();
    case PLMPackage.CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT:
      return getClassificationTreeAsType((Integer) arguments.get(0));
    case PLMPackage.CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT:
      return getClassificationTreeAsType((Integer) arguments.get(0), (Integer) arguments.get(1));
    case PLMPackage.CLABJECT___GET_ALL_FEATURES:
      return getAllFeatures();
    case PLMPackage.CLABJECT___GET_ALL_ATTRIBUTES:
      return getAllAttributes();
    case PLMPackage.CLABJECT___GET_DEFINED_ATTRIBUTES:
      return getDefinedAttributes();
    case PLMPackage.CLABJECT___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING:
      return getDefinedAttributeByName((String) arguments.get(0));
    case PLMPackage.CLABJECT___GET_ALL_METHODS:
      return getAllMethods();
    case PLMPackage.CLABJECT___GET_DEFINED_METHODS:
      return getDefinedMethods();
    case PLMPackage.CLABJECT___IS_INSTANCE_OF__CLABJECT:
      return isInstanceOf((Clabject) arguments.get(0));
    case PLMPackage.CLABJECT___IS_TYPE_OF__CLABJECT:
      return isTypeOf((Clabject) arguments.get(0));
    case PLMPackage.CLABJECT___IS_CONTAINER_OF__CLABJECT:
      return isContainerOf((Clabject) arguments.get(0));
    case PLMPackage.CLABJECT___GET_COMPOSITE:
      return getComposite();
    case PLMPackage.CLABJECT___GET_AGGREGATES:
      return getAggregates();
    case PLMPackage.CLABJECT___GET_PARTS:
      return getParts();
    case PLMPackage.CLABJECT___GET_PARTS_FOR_MONIKER__STRING:
      return getPartsForMoniker((String) arguments.get(0));
    case PLMPackage.CLABJECT___GET_DEFINED_CONNECTIONS:
      return getDefinedConnections();
    case PLMPackage.CLABJECT___GET_CONNECTIONS:
      return getConnections();
    case PLMPackage.CLABJECT___GET_INHERITED_CONNECTIONS:
      return getInheritedConnections();
    case PLMPackage.CLABJECT___GET_LEVEL_COMPLETE_TYPES:
      return getLevelCompleteTypes();
    case PLMPackage.CLABJECT___GET_LEVEL_INCOMPLETE_TYPES:
      return getLevelIncompleteTypes();
    case PLMPackage.CLABJECT___GET_BLUEPRINT:
      return getBlueprint();
    case PLMPackage.CLABJECT___GET_OFFSPRING:
      return getOffspring();
    case PLMPackage.CLABJECT___GET_ISONYMS:
      return getIsonyms();
    case PLMPackage.CLABJECT___GET_HYPONYMS:
      return getHyponyms();
    case PLMPackage.CLABJECT___GET_DOMAIN_FOR_CONNECTION__CONNECTION:
      return getDomainForConnection((Connection) arguments.get(0));
    case PLMPackage.CLABJECT___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS:
      return getPossibleDomainSpecificVisualizers();
    case PLMPackage.CLABJECT___GET_INHERITANCES_AS_SUBTYPE:
      return getInheritancesAsSubtype();
    case PLMPackage.CLABJECT___GET_INHERITANCES_AS_SUPERTYPE:
      return getInheritancesAsSupertype();
    case PLMPackage.CLABJECT___GET_DEFINED_NAVIGATIONS:
      return getDefinedNavigations();
    case PLMPackage.CLABJECT___GET_INHERITED_NAVIGATIONS:
      return getInheritedNavigations();
    case PLMPackage.CLABJECT___GET_ALL_NAVIGATIONS:
      return getAllNavigations();
    case PLMPackage.CLABJECT___GET_DOMAIN_MONIKERS:
      return getDomainMonikers();
    case PLMPackage.CLABJECT___GET_DOMAIN_FOR_MONIKER__STRING:
      return getDomainForMoniker((String) arguments.get(0));
    case PLMPackage.CLABJECT___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING:
      return getAllNavigationsForMoniker((String) arguments.get(0));
    case PLMPackage.CLABJECT___GET_ALL_NAVIGATIONS_AS_DESTINATION:
      return getAllNavigationsAsDestination();
    case PLMPackage.CLABJECT___GET_DEFINED_NAVIGATIONS_AS_DESTINATION:
      return getDefinedNavigationsAsDestination();
    case PLMPackage.CLABJECT___GET_INHERITED_NAVIGATIONS_AS_DESTINATION:
      return getInheritedNavigationsAsDestination();
    case PLMPackage.CLABJECT___REPRESENT:
      return represent();
    case PLMPackage.CLABJECT___GET_FEATURE_FOR_NAME__STRING:
      return getFeatureForName((String) arguments.get(0));
    case PLMPackage.CLABJECT___GET_POTENCY_AS_STRING:
      return getPotencyAsString();
    case PLMPackage.CLABJECT___GET_DISJOINT_SIBLINGS:
      return getDisjointSiblings();
    case PLMPackage.CLABJECT___GET_ATTRIBUTE_BY_NAME__STRING:
      return getAttributeByName((String) arguments.get(0));
    case PLMPackage.CLABJECT___VIOLATES_MULTIPLICITY_CONSTRAINTS:
      return violatesMultiplicityConstraints();
    case PLMPackage.CLABJECT___GET_DEFINED_INHERITANCES:
      return getDefinedInheritances();
    case PLMPackage.CLABJECT___GET_OWNED_CLABJECTS:
      return getOwnedClabjects();
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (potency: ");
    result.append(potency);
    result.append(')');
    return result.toString();
  }

} // ClabjectImpl
