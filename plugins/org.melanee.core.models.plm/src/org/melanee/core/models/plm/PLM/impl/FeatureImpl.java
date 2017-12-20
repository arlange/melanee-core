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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.FeatureImpl#getDurability <em>Durability</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FeatureImpl extends ElementImpl implements Feature {
	/**
	 * The default value of the '{@link #getDurability() <em>Durability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDurability()
	 * @generated
	 * @ordered
	 */
	protected static final int DURABILITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDurability() <em>Durability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDurability()
	 * @generated
	 * @ordered
	 */
	protected int durability = DURABILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDurability() {
		return durability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDurability(int newDurability) {
		int oldDurability = durability;
		durability = newDurability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.FEATURE__DURABILITY, oldDurability, durability));
	}

	/**
	 * The cached invocation delegate for the '{@link #getClabject() <em>Get Clabject</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClabject()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_CLABJECT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.FEATURE___GET_CLABJECT).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clabject getClabject() {
		try {
			return (Clabject)GET_CLABJECT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getDurabilityAsString() <em>Get Durability As String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDurabilityAsString()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_DURABILITY_AS_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.FEATURE___GET_DURABILITY_AS_STRING).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDurabilityAsString() {
		try {
			return (String)GET_DURABILITY_AS_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #represent() <em>Represent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #represent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REPRESENT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.FEATURE___REPRESENT).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PLMPackage.FEATURE__DURABILITY:
				return getDurability();
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
			case PLMPackage.FEATURE__DURABILITY:
				setDurability((Integer)newValue);
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
			case PLMPackage.FEATURE__DURABILITY:
				setDurability(DURABILITY_EDEFAULT);
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
			case PLMPackage.FEATURE__DURABILITY:
				return durability != DURABILITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PLMPackage.FEATURE___GET_CLABJECT:
				return getClabject();
			case PLMPackage.FEATURE___GET_DURABILITY_AS_STRING:
				return getDurabilityAsString();
			case PLMPackage.FEATURE___REPRESENT:
				return represent();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (durability: ");
		result.append(durability);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
