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

import org.melanee.core.models.plm.PLM.ComplianceKind;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.DomainImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.DomainImpl#getDeepModel <em>Deep Model</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.DomainImpl#getPlmVersion <em>Plm Version</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.DomainImpl#getComplianceKind <em>Compliance Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainImpl extends MinimalEObjectImpl.Container implements Domain {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeepModel() <em>Deep Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeepModel()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> deepModel;

	/**
	 * The default value of the '{@link #getPlmVersion() <em>Plm Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlmVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String PLM_VERSION_EDEFAULT = "2.0b2";

	/**
	 * The cached value of the '{@link #getPlmVersion() <em>Plm Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlmVersion()
	 * @generated
	 * @ordered
	 */
	protected String plmVersion = PLM_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getComplianceKind() <em>Compliance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplianceKind()
	 * @generated
	 * @ordered
	 */
	protected static final ComplianceKind COMPLIANCE_KIND_EDEFAULT = ComplianceKind.MELANEE;

	/**
	 * The cached value of the '{@link #getComplianceKind() <em>Compliance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplianceKind()
	 * @generated
	 * @ordered
	 */
	protected ComplianceKind complianceKind = COMPLIANCE_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.DOMAIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getDeepModel() {
		if (deepModel == null) {
			deepModel = new EObjectContainmentEList<Element>(Element.class, this, PLMPackage.DOMAIN__DEEP_MODEL);
		}
		return deepModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlmVersion() {
		return plmVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlmVersion(String newPlmVersion) {
		String oldPlmVersion = plmVersion;
		plmVersion = newPlmVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.DOMAIN__PLM_VERSION, oldPlmVersion, plmVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplianceKind getComplianceKind() {
		return complianceKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplianceKind(ComplianceKind newComplianceKind) {
		ComplianceKind oldComplianceKind = complianceKind;
		complianceKind = newComplianceKind == null ? COMPLIANCE_KIND_EDEFAULT : newComplianceKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.DOMAIN__COMPLIANCE_KIND, oldComplianceKind, complianceKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PLMPackage.DOMAIN__DEEP_MODEL:
				return ((InternalEList<?>)getDeepModel()).basicRemove(otherEnd, msgs);
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
			case PLMPackage.DOMAIN__NAME:
				return getName();
			case PLMPackage.DOMAIN__DEEP_MODEL:
				return getDeepModel();
			case PLMPackage.DOMAIN__PLM_VERSION:
				return getPlmVersion();
			case PLMPackage.DOMAIN__COMPLIANCE_KIND:
				return getComplianceKind();
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
			case PLMPackage.DOMAIN__NAME:
				setName((String)newValue);
				return;
			case PLMPackage.DOMAIN__DEEP_MODEL:
				getDeepModel().clear();
				getDeepModel().addAll((Collection<? extends Element>)newValue);
				return;
			case PLMPackage.DOMAIN__PLM_VERSION:
				setPlmVersion((String)newValue);
				return;
			case PLMPackage.DOMAIN__COMPLIANCE_KIND:
				setComplianceKind((ComplianceKind)newValue);
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
			case PLMPackage.DOMAIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PLMPackage.DOMAIN__DEEP_MODEL:
				getDeepModel().clear();
				return;
			case PLMPackage.DOMAIN__PLM_VERSION:
				setPlmVersion(PLM_VERSION_EDEFAULT);
				return;
			case PLMPackage.DOMAIN__COMPLIANCE_KIND:
				setComplianceKind(COMPLIANCE_KIND_EDEFAULT);
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
			case PLMPackage.DOMAIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PLMPackage.DOMAIN__DEEP_MODEL:
				return deepModel != null && !deepModel.isEmpty();
			case PLMPackage.DOMAIN__PLM_VERSION:
				return PLM_VERSION_EDEFAULT == null ? plmVersion != null : !PLM_VERSION_EDEFAULT.equals(plmVersion);
			case PLMPackage.DOMAIN__COMPLIANCE_KIND:
				return complianceKind != COMPLIANCE_KIND_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", plmVersion: ");
		result.append(plmVersion);
		result.append(", complianceKind: ");
		result.append(complianceKind);
		result.append(')');
		return result.toString();
	}

} //DomainImpl
