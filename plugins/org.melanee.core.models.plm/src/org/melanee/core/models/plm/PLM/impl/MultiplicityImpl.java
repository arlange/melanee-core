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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.Multiplicity;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.MultiplicityImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.MultiplicityImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.MultiplicityImpl#getPotency <em>Potency</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.MultiplicityImpl#getConnectionend <em>Connectionend</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplicityImpl extends MinimalEObjectImpl.Container implements Multiplicity {
	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected int lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected int upper = UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPotency() <em>Potency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotency()
	 * @generated
	 * @ordered
	 */
	protected static final int POTENCY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getPotency() <em>Potency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotency()
	 * @generated
	 * @ordered
	 */
	protected int potency = POTENCY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.MULTIPLICITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(int newLower) {
		int oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.MULTIPLICITY__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(int newUpper) {
		int oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.MULTIPLICITY__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPotency() {
		return potency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPotency(int newPotency) {
		int oldPotency = potency;
		potency = newPotency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.MULTIPLICITY__POTENCY, oldPotency, potency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEnd getConnectionend() {
		if (eContainerFeatureID() != PLMPackage.MULTIPLICITY__CONNECTIONEND) return null;
		return (ConnectionEnd)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnectionend(ConnectionEnd newConnectionend, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConnectionend, PLMPackage.MULTIPLICITY__CONNECTIONEND, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionend(ConnectionEnd newConnectionend) {
		if (newConnectionend != eInternalContainer() || (eContainerFeatureID() != PLMPackage.MULTIPLICITY__CONNECTIONEND && newConnectionend != null)) {
			if (EcoreUtil.isAncestor(this, newConnectionend))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConnectionend != null)
				msgs = ((InternalEObject)newConnectionend).eInverseAdd(this, PLMPackage.CONNECTION_END__MULTIPLICITY, ConnectionEnd.class, msgs);
			msgs = basicSetConnectionend(newConnectionend, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.MULTIPLICITY__CONNECTIONEND, newConnectionend, newConnectionend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PLMPackage.MULTIPLICITY__CONNECTIONEND:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConnectionend((ConnectionEnd)otherEnd, msgs);
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
			case PLMPackage.MULTIPLICITY__CONNECTIONEND:
				return basicSetConnectionend(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PLMPackage.MULTIPLICITY__CONNECTIONEND:
				return eInternalContainer().eInverseRemove(this, PLMPackage.CONNECTION_END__MULTIPLICITY, ConnectionEnd.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PLMPackage.MULTIPLICITY__LOWER:
				return getLower();
			case PLMPackage.MULTIPLICITY__UPPER:
				return getUpper();
			case PLMPackage.MULTIPLICITY__POTENCY:
				return getPotency();
			case PLMPackage.MULTIPLICITY__CONNECTIONEND:
				return getConnectionend();
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
			case PLMPackage.MULTIPLICITY__LOWER:
				setLower((Integer)newValue);
				return;
			case PLMPackage.MULTIPLICITY__UPPER:
				setUpper((Integer)newValue);
				return;
			case PLMPackage.MULTIPLICITY__POTENCY:
				setPotency((Integer)newValue);
				return;
			case PLMPackage.MULTIPLICITY__CONNECTIONEND:
				setConnectionend((ConnectionEnd)newValue);
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
			case PLMPackage.MULTIPLICITY__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case PLMPackage.MULTIPLICITY__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case PLMPackage.MULTIPLICITY__POTENCY:
				setPotency(POTENCY_EDEFAULT);
				return;
			case PLMPackage.MULTIPLICITY__CONNECTIONEND:
				setConnectionend((ConnectionEnd)null);
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
			case PLMPackage.MULTIPLICITY__LOWER:
				return lower != LOWER_EDEFAULT;
			case PLMPackage.MULTIPLICITY__UPPER:
				return upper != UPPER_EDEFAULT;
			case PLMPackage.MULTIPLICITY__POTENCY:
				return potency != POTENCY_EDEFAULT;
			case PLMPackage.MULTIPLICITY__CONNECTIONEND:
				return getConnectionend() != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(", potency: ");
		result.append(potency);
		result.append(')');
		return result.toString();
	}

} //MultiplicityImpl
