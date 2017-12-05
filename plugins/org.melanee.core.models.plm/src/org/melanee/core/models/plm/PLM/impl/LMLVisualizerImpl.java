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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LML Visualizer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LMLVisualizerImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LMLVisualizerImpl#getDslVisualizer <em>Dsl Visualizer</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LMLVisualizerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LMLVisualizerImpl#getXLocation <em>XLocation</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LMLVisualizerImpl#getYLocation <em>YLocation</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LMLVisualizerImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.LMLVisualizerImpl#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LMLVisualizerImpl extends MinimalEObjectImpl.Container implements LMLVisualizer {
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> attributes;

	/**
	 * The cached value of the '{@link #getDslVisualizer() <em>Dsl Visualizer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDslVisualizer()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDSLVisualizer> dslVisualizer;

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
	 * The default value of the '{@link #getXLocation() <em>XLocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int XLOCATION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getXLocation() <em>XLocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXLocation()
	 * @generated
	 * @ordered
	 */
	protected int xLocation = XLOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getYLocation() <em>YLocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int YLOCATION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getYLocation() <em>YLocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYLocation()
	 * @generated
	 * @ordered
	 */
	protected int yLocation = YLOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LMLVisualizerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PLMPackage.Literals.LML_VISUALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAttributes() {
		if (attributes == null) {
			attributes = new EDataTypeUniqueEList<String>(String.class, this, PLMPackage.LML_VISUALIZER__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDSLVisualizer> getDslVisualizer() {
		if (dslVisualizer == null) {
			dslVisualizer = new EObjectContainmentEList<AbstractDSLVisualizer>(AbstractDSLVisualizer.class, this, PLMPackage.LML_VISUALIZER__DSL_VISUALIZER);
		}
		return dslVisualizer;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.LML_VISUALIZER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getXLocation() {
		return xLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLocation(int newXLocation) {
		int oldXLocation = xLocation;
		xLocation = newXLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.LML_VISUALIZER__XLOCATION, oldXLocation, xLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getYLocation() {
		return yLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLocation(int newYLocation) {
		int oldYLocation = yLocation;
		yLocation = newYLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.LML_VISUALIZER__YLOCATION, oldYLocation, yLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.LML_VISUALIZER__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.LML_VISUALIZER__HEIGHT, oldHeight, height));
	}

	/**
	 * The cached invocation delegate for the '{@link #getDefaultVisualizationValues() <em>Get Default Visualization Values</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultVisualizationValues()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_DEFAULT_VISUALIZATION_VALUES__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LML_VISUALIZER___GET_DEFAULT_VISUALIZATION_VALUES).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getDefaultVisualizationValues() {
		try {
			return (EList<String>)GET_DEFAULT_VISUALIZATION_VALUES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getValueForKey(java.lang.String) <em>Get Value For Key</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueForKey(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_VALUE_FOR_KEY_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LML_VISUALIZER___GET_VALUE_FOR_KEY__STRING).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueForKey(String key) {
		try {
			return (String)GET_VALUE_FOR_KEY_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{key}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #getContainingElement() <em>Get Containing Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainingElement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_CONTAINING_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.LML_VISUALIZER___GET_CONTAINING_ELEMENT).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getContainingElement() {
		try {
			return (Element)GET_CONTAINING_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public void EOperation0() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PLMPackage.LML_VISUALIZER__DSL_VISUALIZER:
				return ((InternalEList<?>)getDslVisualizer()).basicRemove(otherEnd, msgs);
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
			case PLMPackage.LML_VISUALIZER__ATTRIBUTES:
				return getAttributes();
			case PLMPackage.LML_VISUALIZER__DSL_VISUALIZER:
				return getDslVisualizer();
			case PLMPackage.LML_VISUALIZER__NAME:
				return getName();
			case PLMPackage.LML_VISUALIZER__XLOCATION:
				return getXLocation();
			case PLMPackage.LML_VISUALIZER__YLOCATION:
				return getYLocation();
			case PLMPackage.LML_VISUALIZER__WIDTH:
				return getWidth();
			case PLMPackage.LML_VISUALIZER__HEIGHT:
				return getHeight();
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
			case PLMPackage.LML_VISUALIZER__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends String>)newValue);
				return;
			case PLMPackage.LML_VISUALIZER__DSL_VISUALIZER:
				getDslVisualizer().clear();
				getDslVisualizer().addAll((Collection<? extends AbstractDSLVisualizer>)newValue);
				return;
			case PLMPackage.LML_VISUALIZER__NAME:
				setName((String)newValue);
				return;
			case PLMPackage.LML_VISUALIZER__XLOCATION:
				setXLocation((Integer)newValue);
				return;
			case PLMPackage.LML_VISUALIZER__YLOCATION:
				setYLocation((Integer)newValue);
				return;
			case PLMPackage.LML_VISUALIZER__WIDTH:
				setWidth((Integer)newValue);
				return;
			case PLMPackage.LML_VISUALIZER__HEIGHT:
				setHeight((Integer)newValue);
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
			case PLMPackage.LML_VISUALIZER__ATTRIBUTES:
				getAttributes().clear();
				return;
			case PLMPackage.LML_VISUALIZER__DSL_VISUALIZER:
				getDslVisualizer().clear();
				return;
			case PLMPackage.LML_VISUALIZER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PLMPackage.LML_VISUALIZER__XLOCATION:
				setXLocation(XLOCATION_EDEFAULT);
				return;
			case PLMPackage.LML_VISUALIZER__YLOCATION:
				setYLocation(YLOCATION_EDEFAULT);
				return;
			case PLMPackage.LML_VISUALIZER__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case PLMPackage.LML_VISUALIZER__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
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
			case PLMPackage.LML_VISUALIZER__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case PLMPackage.LML_VISUALIZER__DSL_VISUALIZER:
				return dslVisualizer != null && !dslVisualizer.isEmpty();
			case PLMPackage.LML_VISUALIZER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PLMPackage.LML_VISUALIZER__XLOCATION:
				return xLocation != XLOCATION_EDEFAULT;
			case PLMPackage.LML_VISUALIZER__YLOCATION:
				return yLocation != YLOCATION_EDEFAULT;
			case PLMPackage.LML_VISUALIZER__WIDTH:
				return width != WIDTH_EDEFAULT;
			case PLMPackage.LML_VISUALIZER__HEIGHT:
				return height != HEIGHT_EDEFAULT;
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
			case PLMPackage.LML_VISUALIZER___GET_DEFAULT_VISUALIZATION_VALUES:
				return getDefaultVisualizationValues();
			case PLMPackage.LML_VISUALIZER___GET_VALUE_FOR_KEY__STRING:
				return getValueForKey((String)arguments.get(0));
			case PLMPackage.LML_VISUALIZER___GET_CONTAINING_ELEMENT:
				return getContainingElement();
			case PLMPackage.LML_VISUALIZER___EOPERATION0:
				EOperation0();
				return null;
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
		result.append(" (attributes: ");
		result.append(attributes);
		result.append(", name: ");
		result.append(name);
		result.append(", xLocation: ");
		result.append(xLocation);
		result.append(", yLocation: ");
		result.append(yLocation);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //LMLVisualizerImpl
