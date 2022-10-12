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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.ClassificationKind;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Classification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ClassificationImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ClassificationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ClassificationImpl#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassificationImpl extends CorrelationImpl implements Classification {
  /**
   * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getInstance()
   * @generated
   * @ordered
   */
  protected Clabject instance;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Clabject type;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final ClassificationKind KIND_EDEFAULT = ClassificationKind.INSTANTIATION;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected ClassificationKind kind = KIND_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.CLASSIFICATION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject getInstance() {
    if (instance != null && instance.eIsProxy()) {
      InternalEObject oldInstance = (InternalEObject)instance;
      instance = (Clabject)eResolveProxy(oldInstance);
      if (instance != oldInstance) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLMPackage.CLASSIFICATION__INSTANCE, oldInstance, instance));
      }
    }
    return instance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject basicGetInstance() {
    return instance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setInstance(Clabject newInstance) {
    Clabject oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CLASSIFICATION__INSTANCE, oldInstance, instance));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject getType() {
    if (type != null && type.eIsProxy()) {
      InternalEObject oldType = (InternalEObject)type;
      type = (Clabject)eResolveProxy(oldType);
      if (type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLMPackage.CLASSIFICATION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject basicGetType() {
    return type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setType(Clabject newType) {
    Clabject oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CLASSIFICATION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ClassificationKind getKind() {
    return kind;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setKind(ClassificationKind newKind) {
    ClassificationKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CLASSIFICATION__KIND, oldKind, kind));
  }

  /**
   * The cached invocation delegate for the '{@link #represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #represent()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate REPRESENT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CLASSIFICATION___REPRESENT).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String represent() {
    try {
      return (String)REPRESENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case PLMPackage.CLASSIFICATION__INSTANCE:
        if (resolve) return getInstance();
        return basicGetInstance();
      case PLMPackage.CLASSIFICATION__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case PLMPackage.CLASSIFICATION__KIND:
        return getKind();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case PLMPackage.CLASSIFICATION__INSTANCE:
        setInstance((Clabject)newValue);
        return;
      case PLMPackage.CLASSIFICATION__TYPE:
        setType((Clabject)newValue);
        return;
      case PLMPackage.CLASSIFICATION__KIND:
        setKind((ClassificationKind)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case PLMPackage.CLASSIFICATION__INSTANCE:
        setInstance((Clabject)null);
        return;
      case PLMPackage.CLASSIFICATION__TYPE:
        setType((Clabject)null);
        return;
      case PLMPackage.CLASSIFICATION__KIND:
        setKind(KIND_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case PLMPackage.CLASSIFICATION__INSTANCE:
        return instance != null;
      case PLMPackage.CLASSIFICATION__TYPE:
        return type != null;
      case PLMPackage.CLASSIFICATION__KIND:
        return kind != KIND_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLMPackage.CLASSIFICATION___REPRESENT:
        return represent();
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} // ClassificationImpl
