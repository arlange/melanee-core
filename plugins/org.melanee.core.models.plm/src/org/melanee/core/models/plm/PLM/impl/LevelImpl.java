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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.OwnedElement;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LevelImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LevelImpl extends ElementImpl implements Level {
	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected EList<OwnedElement> content;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OwnedElement> getContent() {
		if (content == null) {
			content = new EObjectContainmentEList<OwnedElement>(OwnedElement.class, this, PLMPackage.LEVEL__CONTENT);
		}
		return content;
	}

	/**
	 * The cached invocation delegate for the '{@link #getAllInheritances() <em>Get All Inheritances</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllInheritances()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_ALL_INHERITANCES__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_ALL_INHERITANCES).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Inheritance> getAllInheritances() {
		try {
			return (EList<Inheritance>)GET_ALL_INHERITANCES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getClabjects() <em>Get Clabjects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClabjects()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_CLABJECTS__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_CLABJECTS).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Clabject> getClabjects() {
		try {
			return (EList<Clabject>)GET_CLABJECTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getEntities() <em>Get Entities</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_ENTITIES__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_ENTITIES).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Entity> getEntities() {
		try {
			return (EList<Entity>)GET_ENTITIES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getConnections() <em>Get Connections</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_CONNECTIONS__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_CONNECTIONS).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Connection> getConnections() {
		try {
			return (EList<Connection>)GET_CONNECTIONS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getClassifications() <em>Get Classifications</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifications()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFICATIONS__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_CLASSIFICATIONS).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Classification> getClassifications() {
		try {
			return (EList<Classification>)GET_CLASSIFICATIONS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getDeepModel() <em>Get Deep Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeepModel()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_DEEP_MODEL__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_DEEP_MODEL).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeepModel getDeepModel() {
		try {
			return (DeepModel)GET_DEEP_MODEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getClassifiedLevel() <em>Get Classified Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifiedLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFIED_LEVEL__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_CLASSIFIED_LEVEL).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getClassifiedLevel() {
		try {
			return (Level)GET_CLASSIFIED_LEVEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getClassifyingLevel() <em>Get Classifying Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifyingLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_CLASSIFYING_LEVEL__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_CLASSIFYING_LEVEL).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getClassifyingLevel() {
		try {
			return (Level)GET_CLASSIFYING_LEVEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getLevel() <em>Get Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_LEVEL__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___GET_LEVEL).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevel() {
		try {
			return (Integer)GET_LEVEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isRootLevel() <em>Is Root Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRootLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ROOT_LEVEL__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___IS_ROOT_LEVEL).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRootLevel() {
		try {
			return (Boolean)IS_ROOT_LEVEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isLeafLevel() <em>Is Leaf Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLeafLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_LEAF_LEVEL__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LEVEL___IS_LEAF_LEVEL).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLeafLevel() {
		try {
			return (Boolean)IS_LEAF_LEVEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PLMPackage.LEVEL__CONTENT:
				return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
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
			case PLMPackage.LEVEL__CONTENT:
				return getContent();
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
			case PLMPackage.LEVEL__CONTENT:
				getContent().clear();
				getContent().addAll((Collection<? extends OwnedElement>)newValue);
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
			case PLMPackage.LEVEL__CONTENT:
				getContent().clear();
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
			case PLMPackage.LEVEL__CONTENT:
				return content != null && !content.isEmpty();
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
			case PLMPackage.LEVEL___GET_ALL_INHERITANCES:
				return getAllInheritances();
			case PLMPackage.LEVEL___GET_CLABJECTS:
				return getClabjects();
			case PLMPackage.LEVEL___GET_ENTITIES:
				return getEntities();
			case PLMPackage.LEVEL___GET_CONNECTIONS:
				return getConnections();
			case PLMPackage.LEVEL___GET_CLASSIFICATIONS:
				return getClassifications();
			case PLMPackage.LEVEL___GET_DEEP_MODEL:
				return getDeepModel();
			case PLMPackage.LEVEL___GET_CLASSIFIED_LEVEL:
				return getClassifiedLevel();
			case PLMPackage.LEVEL___GET_CLASSIFYING_LEVEL:
				return getClassifyingLevel();
			case PLMPackage.LEVEL___GET_LEVEL:
				return getLevel();
			case PLMPackage.LEVEL___IS_ROOT_LEVEL:
				return isRootLevel();
			case PLMPackage.LEVEL___IS_LEAF_LEVEL:
				return isLeafLevel();
		}
		return super.eInvoke(operationID, arguments);
	}

} //LevelImpl
