/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.plm.PLM.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.Subtype;
import org.melanee.core.models.plm.PLM.Supertype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inheritance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.InheritanceImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.InheritanceImpl#getSubtype <em>Subtype</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.InheritanceImpl#getDisjoint <em>Disjoint</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.InheritanceImpl#getComplete <em>Complete</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InheritanceImpl extends CorrelationImpl implements Inheritance {
	/**
	 * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupertype()
	 * @generated
	 * @ordered
	 */
	protected EList<Supertype> supertype;

	/**
	 * The cached value of the '{@link #getSubtype() <em>Subtype</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtype()
	 * @generated
	 * @ordered
	 */
	protected EList<Subtype> subtype;

	/**
	 * The default value of the '{@link #getDisjoint() <em>Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean DISJOINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisjoint() <em>Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisjoint()
	 * @generated
	 * @ordered
	 */
	protected Boolean disjoint = DISJOINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplete()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean COMPLETE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplete()
	 * @generated
	 * @ordered
	 */
	protected Boolean complete = COMPLETE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InheritanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.INHERITANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Supertype> getSupertype() {
		if (supertype == null) {
			supertype = new EObjectContainmentWithInverseEList<Supertype>(Supertype.class, this, PLMPackage.INHERITANCE__SUPERTYPE, PLMPackage.SUPERTYPE__INHERITANCE);
		}
		return supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subtype> getSubtype() {
		if (subtype == null) {
			subtype = new EObjectContainmentWithInverseEList<Subtype>(Subtype.class, this, PLMPackage.INHERITANCE__SUBTYPE, PLMPackage.SUBTYPE__INHERITANCE);
		}
		return subtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getDisjoint() {
		return disjoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisjoint(Boolean newDisjoint) {
		Boolean oldDisjoint = disjoint;
		disjoint = newDisjoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.INHERITANCE__DISJOINT, oldDisjoint, disjoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getComplete() {
		return complete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplete(Boolean newComplete) {
		Boolean oldComplete = complete;
		complete = newComplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.INHERITANCE__COMPLETE, oldComplete, complete));
	}

	/**
	 * The cached invocation delegate for the '{@link #isDisjoint() <em>Is Disjoint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_DISJOINT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.INHERITANCE___IS_DISJOINT).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisjoint() {
		try {
			return (Boolean)IS_DISJOINT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isComplete() <em>Is Complete</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_COMPLETE__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.INHERITANCE___IS_COMPLETE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComplete() {
		try {
			return (Boolean)IS_COMPLETE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isIntersection() <em>Is Intersection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIntersection()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_INTERSECTION__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.INHERITANCE___IS_INTERSECTION).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntersection() {
		try {
			return (Boolean)IS_INTERSECTION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate REPRESENT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.INHERITANCE___REPRESENT).getInvocationDelegate();

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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PLMPackage.INHERITANCE__SUPERTYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupertype()).basicAdd(otherEnd, msgs);
			case PLMPackage.INHERITANCE__SUBTYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubtype()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PLMPackage.INHERITANCE__SUPERTYPE:
				return ((InternalEList<?>)getSupertype()).basicRemove(otherEnd, msgs);
			case PLMPackage.INHERITANCE__SUBTYPE:
				return ((InternalEList<?>)getSubtype()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PLMPackage.INHERITANCE__SUPERTYPE:
				return getSupertype();
			case PLMPackage.INHERITANCE__SUBTYPE:
				return getSubtype();
			case PLMPackage.INHERITANCE__DISJOINT:
				return getDisjoint();
			case PLMPackage.INHERITANCE__COMPLETE:
				return getComplete();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PLMPackage.INHERITANCE__SUPERTYPE:
				getSupertype().clear();
				getSupertype().addAll((Collection<? extends Supertype>)newValue);
				return;
			case PLMPackage.INHERITANCE__SUBTYPE:
				getSubtype().clear();
				getSubtype().addAll((Collection<? extends Subtype>)newValue);
				return;
			case PLMPackage.INHERITANCE__DISJOINT:
				setDisjoint((Boolean)newValue);
				return;
			case PLMPackage.INHERITANCE__COMPLETE:
				setComplete((Boolean)newValue);
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
			case PLMPackage.INHERITANCE__SUPERTYPE:
				getSupertype().clear();
				return;
			case PLMPackage.INHERITANCE__SUBTYPE:
				getSubtype().clear();
				return;
			case PLMPackage.INHERITANCE__DISJOINT:
				setDisjoint(DISJOINT_EDEFAULT);
				return;
			case PLMPackage.INHERITANCE__COMPLETE:
				setComplete(COMPLETE_EDEFAULT);
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
			case PLMPackage.INHERITANCE__SUPERTYPE:
				return supertype != null && !supertype.isEmpty();
			case PLMPackage.INHERITANCE__SUBTYPE:
				return subtype != null && !subtype.isEmpty();
			case PLMPackage.INHERITANCE__DISJOINT:
				return DISJOINT_EDEFAULT == null ? disjoint != null : !DISJOINT_EDEFAULT.equals(disjoint);
			case PLMPackage.INHERITANCE__COMPLETE:
				return COMPLETE_EDEFAULT == null ? complete != null : !COMPLETE_EDEFAULT.equals(complete);
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
			case PLMPackage.INHERITANCE___IS_DISJOINT:
				return isDisjoint();
			case PLMPackage.INHERITANCE___IS_COMPLETE:
				return isComplete();
			case PLMPackage.INHERITANCE___IS_INTERSECTION:
				return isIntersection();
			case PLMPackage.INHERITANCE___REPRESENT:
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
		result.append(" (disjoint: ");
		result.append(disjoint);
		result.append(", complete: ");
		result.append(complete);
		result.append(')');
		return result.toString();
	}

} //InheritanceImpl
