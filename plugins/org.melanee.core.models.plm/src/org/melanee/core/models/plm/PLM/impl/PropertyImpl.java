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
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.Property;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Property</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.PropertyImpl#getParsingOrder <em>Parsing Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyImpl extends MinimalEObjectImpl.Container implements Property {
  /**
   * The default value of the '{@link #getParsingOrder() <em>Parsing Order</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getParsingOrder()
   * @generated
   * @ordered
   */
	protected static final String PARSING_ORDER_EDEFAULT = "0";
	/**
   * The cached value of the '{@link #getParsingOrder() <em>Parsing Order</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getParsingOrder()
   * @generated
   * @ordered
   */
	protected String parsingOrder = PARSING_ORDER_EDEFAULT;

		/**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PropertyImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.PROPERTY;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getParsingOrder() {
    return parsingOrder;
  }

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParsingOrder(String newParsingOrder) {
    String oldParsingOrder = parsingOrder;
    parsingOrder = newParsingOrder;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.PROPERTY__PARSING_ORDER, oldParsingOrder, parsingOrder));
  }

    /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case PLMPackage.PROPERTY__PARSING_ORDER:
        return getParsingOrder();
    }
    return super.eGet(featureID, resolve, coreType);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case PLMPackage.PROPERTY__PARSING_ORDER:
        setParsingOrder((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID) {
      case PLMPackage.PROPERTY__PARSING_ORDER:
        setParsingOrder(PARSING_ORDER_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID) {
      case PLMPackage.PROPERTY__PARSING_ORDER:
        return PARSING_ORDER_EDEFAULT == null ? parsingOrder != null : !PARSING_ORDER_EDEFAULT.equals(parsingOrder);
    }
    return super.eIsSet(featureID);
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (parsingOrder: ");
    result.append(parsingOrder);
    result.append(')');
    return result.toString();
  }

} // PropertyImpl
