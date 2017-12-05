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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract DSL Visualizer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.AbstractDSLVisualizerImpl#isInstanceLevel <em>Instance Level</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.AbstractDSLVisualizerImpl#getNotation <em>Notation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractDSLVisualizerImpl extends MinimalEObjectImpl.Container implements AbstractDSLVisualizer {
	/**
	 * The default value of the '{@link #isInstanceLevel() <em>Instance Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstanceLevel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANCE_LEVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstanceLevel() <em>Instance Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstanceLevel()
	 * @generated
	 * @ordered
	 */
	protected boolean instanceLevel = INSTANCE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotation() <em>Notation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotation()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotation() <em>Notation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotation()
	 * @generated
	 * @ordered
	 */
	protected String notation = NOTATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractDSLVisualizerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.ABSTRACT_DSL_VISUALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstanceLevel() {
		return instanceLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceLevel(boolean newInstanceLevel) {
		boolean oldInstanceLevel = instanceLevel;
		instanceLevel = newInstanceLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL, oldInstanceLevel, instanceLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotation() {
		return notation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotation(String newNotation) {
		String oldNotation = notation;
		notation = newNotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.ABSTRACT_DSL_VISUALIZER__NOTATION, oldNotation, notation));
	}

	/**
	 * The cached invocation delegate for the '{@link #format() <em>Format</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #format()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FORMAT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.ABSTRACT_DSL_VISUALIZER___FORMAT).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String format() {
		try {
			return (String)FORMAT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL:
				return isInstanceLevel();
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__NOTATION:
				return getNotation();
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
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL:
				setInstanceLevel((Boolean)newValue);
				return;
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__NOTATION:
				setNotation((String)newValue);
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
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL:
				setInstanceLevel(INSTANCE_LEVEL_EDEFAULT);
				return;
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__NOTATION:
				setNotation(NOTATION_EDEFAULT);
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
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL:
				return instanceLevel != INSTANCE_LEVEL_EDEFAULT;
			case PLMPackage.ABSTRACT_DSL_VISUALIZER__NOTATION:
				return NOTATION_EDEFAULT == null ? notation != null : !NOTATION_EDEFAULT.equals(notation);
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
			case PLMPackage.ABSTRACT_DSL_VISUALIZER___FORMAT:
				return format();
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
		result.append(" (instanceLevel: ");
		result.append(instanceLevel);
		result.append(", notation: ");
		result.append(notation);
		result.append(')');
		return result.toString();
	}

} //AbstractDSLVisualizerImpl
