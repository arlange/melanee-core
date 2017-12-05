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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionImpl#getConnectionEnd <em>Connection End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends ClabjectImpl implements Connection {
	/**
	 * The cached value of the '{@link #getConnectionEnd() <em>Connection End</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionEnd()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionEnd> connectionEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionEnd> getConnectionEnd() {
		if (connectionEnd == null) {
			connectionEnd = new EObjectContainmentWithInverseEList<ConnectionEnd>(ConnectionEnd.class, this, PLMPackage.CONNECTION__CONNECTION_END, PLMPackage.CONNECTION_END__CONNECTION);
		}
		return connectionEnd;
	}

	/**
	 * The cached invocation delegate for the '{@link #getDomain() <em>Get Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_DOMAIN__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_DOMAIN).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Clabject> getDomain() {
		try {
			return (EList<Clabject>)GET_DOMAIN__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getNotDomain() <em>Get Not Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotDomain()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_NOT_DOMAIN__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_NOT_DOMAIN).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Clabject> getNotDomain() {
		try {
			return (EList<Clabject>)GET_NOT_DOMAIN__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getHumanReadableName() <em>Get Human Readable Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHumanReadableName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_HUMAN_READABLE_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_HUMAN_READABLE_NAME).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHumanReadableName() {
		try {
			return (String)GET_HUMAN_READABLE_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getParticipants() <em>Get Participants</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_PARTICIPANTS__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_PARTICIPANTS).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Clabject> getParticipants() {
		try {
			return (EList<Clabject>)GET_PARTICIPANTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getMoniker() <em>Get Moniker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoniker()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_MONIKER__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_MONIKER).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getMoniker() {
		try {
			return (EList<String>)GET_MONIKER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getDomain(org.melanee.core.models.plm.PLM.Clabject) <em>Get Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain(org.melanee.core.models.plm.PLM.Clabject)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_DOMAIN_CLABJECT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_DOMAIN__CLABJECT).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Clabject> getDomain(Clabject source) {
		try {
			return (EList<Clabject>)GET_DOMAIN_CLABJECT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{source}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getMonikerForParticipant(org.melanee.core.models.plm.PLM.Clabject) <em>Get Moniker For Participant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonikerForParticipant(org.melanee.core.models.plm.PLM.Clabject)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_MONIKER_FOR_PARTICIPANT_CLABJECT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_MONIKER_FOR_PARTICIPANT__CLABJECT).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getMonikerForParticipant(Clabject source) {
		try {
			return (EList<String>)GET_MONIKER_FOR_PARTICIPANT_CLABJECT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{source}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getLowerForMoniker(java.lang.String) <em>Get Lower For Moniker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerForMoniker(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_LOWER_FOR_MONIKER_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_LOWER_FOR_MONIKER__STRING).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerForMoniker(String rN) {
		try {
			return (Integer)GET_LOWER_FOR_MONIKER_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{rN}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getUpperForMoniker(java.lang.String) <em>Get Upper For Moniker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperForMoniker(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_UPPER_FOR_MONIKER_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_UPPER_FOR_MONIKER__STRING).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperForMoniker(String rN) {
		try {
			return (Integer)GET_UPPER_FOR_MONIKER_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{rN}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNavigableForMoniker(java.lang.String) <em>Is Navigable For Moniker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNavigableForMoniker(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NAVIGABLE_FOR_MONIKER_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___IS_NAVIGABLE_FOR_MONIKER__STRING).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNavigableForMoniker(String rN) {
		try {
			return (Boolean)IS_NAVIGABLE_FOR_MONIKER_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{rN}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getOrder() <em>Get Order</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_ORDER__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_ORDER).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		try {
			return (Integer)GET_ORDER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getInheritedConnectionEnd() <em>Get Inherited Connection End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedConnectionEnd()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_INHERITED_CONNECTION_END__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_INHERITED_CONNECTION_END).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConnectionEnd> getInheritedConnectionEnd() {
		try {
			return (EList<ConnectionEnd>)GET_INHERITED_CONNECTION_END__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getAllConnectionEnd() <em>Get All Connection End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllConnectionEnd()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_ALL_CONNECTION_END__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_ALL_CONNECTION_END).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConnectionEnd> getAllConnectionEnd() {
		try {
			return (EList<ConnectionEnd>)GET_ALL_CONNECTION_END__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getParticipantForMoniker(java.lang.String) <em>Get Participant For Moniker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantForMoniker(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_PARTICIPANT_FOR_MONIKER_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___GET_PARTICIPANT_FOR_MONIKER__STRING).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clabject getParticipantForMoniker(String rN) {
		try {
			return (Clabject)GET_PARTICIPANT_FOR_MONIKER_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{rN}));
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
	protected static final EOperation.Internal.InvocationDelegate REPRESENT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION___REPRESENT).getInvocationDelegate();

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
			case PLMPackage.CONNECTION__CONNECTION_END:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionEnd()).basicAdd(otherEnd, msgs);
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
			case PLMPackage.CONNECTION__CONNECTION_END:
				return ((InternalEList<?>)getConnectionEnd()).basicRemove(otherEnd, msgs);
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
			case PLMPackage.CONNECTION__CONNECTION_END:
				return getConnectionEnd();
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
			case PLMPackage.CONNECTION__CONNECTION_END:
				getConnectionEnd().clear();
				getConnectionEnd().addAll((Collection<? extends ConnectionEnd>)newValue);
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
			case PLMPackage.CONNECTION__CONNECTION_END:
				getConnectionEnd().clear();
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
			case PLMPackage.CONNECTION__CONNECTION_END:
				return connectionEnd != null && !connectionEnd.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Clabject.class) {
			switch (baseOperationID) {
				case PLMPackage.CLABJECT___REPRESENT: return PLMPackage.CONNECTION___REPRESENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PLMPackage.CONNECTION___GET_DOMAIN:
				return getDomain();
			case PLMPackage.CONNECTION___GET_NOT_DOMAIN:
				return getNotDomain();
			case PLMPackage.CONNECTION___GET_HUMAN_READABLE_NAME:
				return getHumanReadableName();
			case PLMPackage.CONNECTION___GET_PARTICIPANTS:
				return getParticipants();
			case PLMPackage.CONNECTION___GET_MONIKER:
				return getMoniker();
			case PLMPackage.CONNECTION___GET_DOMAIN__CLABJECT:
				return getDomain((Clabject)arguments.get(0));
			case PLMPackage.CONNECTION___GET_MONIKER_FOR_PARTICIPANT__CLABJECT:
				return getMonikerForParticipant((Clabject)arguments.get(0));
			case PLMPackage.CONNECTION___GET_LOWER_FOR_MONIKER__STRING:
				return getLowerForMoniker((String)arguments.get(0));
			case PLMPackage.CONNECTION___GET_UPPER_FOR_MONIKER__STRING:
				return getUpperForMoniker((String)arguments.get(0));
			case PLMPackage.CONNECTION___IS_NAVIGABLE_FOR_MONIKER__STRING:
				return isNavigableForMoniker((String)arguments.get(0));
			case PLMPackage.CONNECTION___GET_ORDER:
				return getOrder();
			case PLMPackage.CONNECTION___GET_INHERITED_CONNECTION_END:
				return getInheritedConnectionEnd();
			case PLMPackage.CONNECTION___GET_ALL_CONNECTION_END:
				return getAllConnectionEnd();
			case PLMPackage.CONNECTION___GET_PARTICIPANT_FOR_MONIKER__STRING:
				return getParticipantForMoniker((String)arguments.get(0));
			case PLMPackage.CONNECTION___REPRESENT:
				return represent();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConnectionImpl
