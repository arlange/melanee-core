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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.Subtype;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Subtype</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.SubtypeImpl#getSubtype <em>Subtype</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.SubtypeImpl#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubtypeImpl extends MinimalEObjectImpl.Container implements Subtype {
  /**
   * The cached value of the '{@link #getSubtype() <em>Subtype</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getSubtype()
   * @generated
   * @ordered
   */
  protected Clabject subtype;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SubtypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.SUBTYPE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject getSubtype() {
    if (subtype != null && subtype.eIsProxy()) {
      InternalEObject oldSubtype = (InternalEObject)subtype;
      subtype = (Clabject)eResolveProxy(oldSubtype);
      if (subtype != oldSubtype) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLMPackage.SUBTYPE__SUBTYPE, oldSubtype, subtype));
      }
    }
    return subtype;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject basicGetSubtype() {
    return subtype;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setSubtype(Clabject newSubtype) {
    Clabject oldSubtype = subtype;
    subtype = newSubtype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.SUBTYPE__SUBTYPE, oldSubtype, subtype));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Inheritance getInheritance() {
    if (eContainerFeatureID() != PLMPackage.SUBTYPE__INHERITANCE) return null;
    return (Inheritance)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInheritance(Inheritance newInheritance, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newInheritance, PLMPackage.SUBTYPE__INHERITANCE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setInheritance(Inheritance newInheritance) {
    if (newInheritance != eInternalContainer() || (eContainerFeatureID() != PLMPackage.SUBTYPE__INHERITANCE && newInheritance != null)) {
      if (EcoreUtil.isAncestor(this, newInheritance))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInheritance != null)
        msgs = ((InternalEObject)newInheritance).eInverseAdd(this, PLMPackage.INHERITANCE__SUBTYPE, Inheritance.class, msgs);
      msgs = basicSetInheritance(newInheritance, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.SUBTYPE__INHERITANCE, newInheritance, newInheritance));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case PLMPackage.SUBTYPE__INHERITANCE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetInheritance((Inheritance)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case PLMPackage.SUBTYPE__INHERITANCE:
        return basicSetInheritance(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case PLMPackage.SUBTYPE__INHERITANCE:
        return eInternalContainer().eInverseRemove(this, PLMPackage.INHERITANCE__SUBTYPE, Inheritance.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case PLMPackage.SUBTYPE__SUBTYPE:
        if (resolve) return getSubtype();
        return basicGetSubtype();
      case PLMPackage.SUBTYPE__INHERITANCE:
        return getInheritance();
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
      case PLMPackage.SUBTYPE__SUBTYPE:
        setSubtype((Clabject)newValue);
        return;
      case PLMPackage.SUBTYPE__INHERITANCE:
        setInheritance((Inheritance)newValue);
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
      case PLMPackage.SUBTYPE__SUBTYPE:
        setSubtype((Clabject)null);
        return;
      case PLMPackage.SUBTYPE__INHERITANCE:
        setInheritance((Inheritance)null);
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
      case PLMPackage.SUBTYPE__SUBTYPE:
        return subtype != null;
      case PLMPackage.SUBTYPE__INHERITANCE:
        return getInheritance() != null;
    }
    return super.eIsSet(featureID);
  }

} // SubtypeImpl
