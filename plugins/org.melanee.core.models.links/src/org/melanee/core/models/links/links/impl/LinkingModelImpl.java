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
package org.melanee.core.models.links.links.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.links.links.LinkingModel;
import org.melanee.core.models.links.links.LinksPackage;
import org.melanee.core.models.links.links.RemoteModel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Linking
 * Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.links.links.impl.LinkingModelImpl#getRemoteModels
 * <em>Remote Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkingModelImpl extends MinimalEObjectImpl.Container implements LinkingModel {
  /**
   * The cached value of the '{@link #getRemoteModels() <em>Remote Models</em>}'
   * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getRemoteModels()
   * @generated
   * @ordered
   */
  protected EList<RemoteModel> remoteModels;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected LinkingModelImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LinksPackage.Literals.LINKING_MODEL;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<RemoteModel> getRemoteModels() {
    if (remoteModels == null) {
      remoteModels = new EObjectContainmentEList<RemoteModel>(RemoteModel.class, this,
          LinksPackage.LINKING_MODEL__REMOTE_MODELS);
    }
    return remoteModels;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
    case LinksPackage.LINKING_MODEL__REMOTE_MODELS:
      return ((InternalEList<?>) getRemoteModels()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case LinksPackage.LINKING_MODEL__REMOTE_MODELS:
      return getRemoteModels();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case LinksPackage.LINKING_MODEL__REMOTE_MODELS:
      getRemoteModels().clear();
      getRemoteModels().addAll((Collection<? extends RemoteModel>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case LinksPackage.LINKING_MODEL__REMOTE_MODELS:
      getRemoteModels().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case LinksPackage.LINKING_MODEL__REMOTE_MODELS:
      return remoteModels != null && !remoteModels.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // LinkingModelImpl
