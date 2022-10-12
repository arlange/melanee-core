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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.plm.PLM.AbstractBehavior;
import org.melanee.core.models.plm.PLM.AbstractConstraint;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ElementImpl#getVisualizer <em>Visualizer</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ElementImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ElementImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementImpl extends MinimalEObjectImpl.Container implements Element {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getVisualizer() <em>Visualizer</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getVisualizer()
   * @generated
   * @ordered
   */
  protected EList<LMLVisualizer> visualizer;

  /**
   * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getBehavior()
   * @generated
   * @ordered
   */
  protected EList<AbstractBehavior> behavior;

  /**
   * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getConstraint()
   * @generated
   * @ordered
   */
  protected EList<AbstractConstraint> constraint;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.ELEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<LMLVisualizer> getVisualizer() {
    if (visualizer == null) {
      visualizer = new EObjectContainmentEList<LMLVisualizer>(LMLVisualizer.class, this, PLMPackage.ELEMENT__VISUALIZER);
    }
    return visualizer;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractBehavior> getBehavior() {
    if (behavior == null) {
      behavior = new EObjectContainmentEList<AbstractBehavior>(AbstractBehavior.class, this, PLMPackage.ELEMENT__BEHAVIOR);
    }
    return behavior;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractConstraint> getConstraint() {
    if (constraint == null) {
      constraint = new EObjectContainmentEList<AbstractConstraint>(AbstractConstraint.class, this, PLMPackage.ELEMENT__CONSTRAINT);
    }
    return constraint;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case PLMPackage.ELEMENT__VISUALIZER:
        return ((InternalEList<?>)getVisualizer()).basicRemove(otherEnd, msgs);
      case PLMPackage.ELEMENT__BEHAVIOR:
        return ((InternalEList<?>)getBehavior()).basicRemove(otherEnd, msgs);
      case PLMPackage.ELEMENT__CONSTRAINT:
        return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case PLMPackage.ELEMENT__NAME:
        return getName();
      case PLMPackage.ELEMENT__VISUALIZER:
        return getVisualizer();
      case PLMPackage.ELEMENT__BEHAVIOR:
        return getBehavior();
      case PLMPackage.ELEMENT__CONSTRAINT:
        return getConstraint();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case PLMPackage.ELEMENT__NAME:
        setName((String)newValue);
        return;
      case PLMPackage.ELEMENT__VISUALIZER:
        getVisualizer().clear();
        getVisualizer().addAll((Collection<? extends LMLVisualizer>)newValue);
        return;
      case PLMPackage.ELEMENT__BEHAVIOR:
        getBehavior().clear();
        getBehavior().addAll((Collection<? extends AbstractBehavior>)newValue);
        return;
      case PLMPackage.ELEMENT__CONSTRAINT:
        getConstraint().clear();
        getConstraint().addAll((Collection<? extends AbstractConstraint>)newValue);
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
      case PLMPackage.ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PLMPackage.ELEMENT__VISUALIZER:
        getVisualizer().clear();
        return;
      case PLMPackage.ELEMENT__BEHAVIOR:
        getBehavior().clear();
        return;
      case PLMPackage.ELEMENT__CONSTRAINT:
        getConstraint().clear();
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
      case PLMPackage.ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PLMPackage.ELEMENT__VISUALIZER:
        return visualizer != null && !visualizer.isEmpty();
      case PLMPackage.ELEMENT__BEHAVIOR:
        return behavior != null && !behavior.isEmpty();
      case PLMPackage.ELEMENT__CONSTRAINT:
        return constraint != null && !constraint.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} // ElementImpl
