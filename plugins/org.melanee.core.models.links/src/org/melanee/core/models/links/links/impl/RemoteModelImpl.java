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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.links.links.LinksPackage;
import org.melanee.core.models.links.links.RemoteModel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Remote
 * Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.links.links.impl.RemoteModelImpl#getLinks
 * <em>Links</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.impl.RemoteModelImpl#getURL
 * <em>URL</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.impl.RemoteModelImpl#getPath
 * <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoteModelImpl extends MinimalEObjectImpl.Container implements RemoteModel {
  /**
   * The cached value of the '{@link #getLinks() <em>Links</em>}' containment
   * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLinks()
   * @generated
   * @ordered
   */
  protected EList<Link> links;

  /**
   * The default value of the '{@link #getURL() <em>URL</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getURL()
   * @generated
   * @ordered
   */
  protected static final String URL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getURL() <em>URL</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getURL()
   * @generated
   * @ordered
   */
  protected String url = URL_EDEFAULT;

  /**
   * The default value of the '{@link #getPath() <em>Path</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected static final String PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected String path = PATH_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected RemoteModelImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LinksPackage.Literals.REMOTE_MODEL;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<Link> getLinks() {
    if (links == null) {
      links = new EObjectContainmentEList<Link>(Link.class, this, LinksPackage.REMOTE_MODEL__LINKS);
    }
    return links;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getURL() {
    return url;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setURL(String newURL) {
    String oldURL = url;
    url = newURL;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.REMOTE_MODEL__URL, oldURL,
          url));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getPath() {
    return path;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setPath(String newPath) {
    String oldPath = path;
    path = newPath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.REMOTE_MODEL__PATH,
          oldPath, path));
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
    case LinksPackage.REMOTE_MODEL__LINKS:
      return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
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
    case LinksPackage.REMOTE_MODEL__LINKS:
      return getLinks();
    case LinksPackage.REMOTE_MODEL__URL:
      return getURL();
    case LinksPackage.REMOTE_MODEL__PATH:
      return getPath();
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
    case LinksPackage.REMOTE_MODEL__LINKS:
      getLinks().clear();
      getLinks().addAll((Collection<? extends Link>) newValue);
      return;
    case LinksPackage.REMOTE_MODEL__URL:
      setURL((String) newValue);
      return;
    case LinksPackage.REMOTE_MODEL__PATH:
      setPath((String) newValue);
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
    case LinksPackage.REMOTE_MODEL__LINKS:
      getLinks().clear();
      return;
    case LinksPackage.REMOTE_MODEL__URL:
      setURL(URL_EDEFAULT);
      return;
    case LinksPackage.REMOTE_MODEL__PATH:
      setPath(PATH_EDEFAULT);
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
    case LinksPackage.REMOTE_MODEL__LINKS:
      return links != null && !links.isEmpty();
    case LinksPackage.REMOTE_MODEL__URL:
      return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
    case LinksPackage.REMOTE_MODEL__PATH:
      return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (URL: ");
    result.append(url);
    result.append(", path: ");
    result.append(path);
    result.append(')');
    return result.toString();
  }

} // RemoteModelImpl
