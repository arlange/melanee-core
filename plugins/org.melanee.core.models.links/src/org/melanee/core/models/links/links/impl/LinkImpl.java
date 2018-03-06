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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.links.links.LinksPackage;

import org.melanee.core.models.plm.PLM.Element;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Link</b></em>'. <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.links.links.impl.LinkImpl#getRevision
 * <em>Revision</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.impl.LinkImpl#getTarget
 * <em>Target</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.impl.LinkImpl#getSource
 * <em>Source</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.impl.LinkImpl#getSourceLocation
 * <em>Source Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkImpl extends MinimalEObjectImpl.Container implements Link {
  /**
   * The default value of the '{@link #getRevision() <em>Revision</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getRevision()
   * @generated
   * @ordered
   */
  protected static final String REVISION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRevision() <em>Revision</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getRevision()
   * @generated
   * @ordered
   */
  protected String revision = REVISION_EDEFAULT;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Element target;

  /**
   * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected String source = SOURCE_EDEFAULT;

  /**
   * The default value of the '{@link #getSourceLocation() <em>Source
   * Location</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSourceLocation()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSourceLocation() <em>Source
   * Location</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSourceLocation()
   * @generated
   * @ordered
   */
  protected String sourceLocation = SOURCE_LOCATION_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected LinkImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LinksPackage.Literals.LINK;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getRevision() {
    return revision;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setRevision(String newRevision) {
    String oldRevision = revision;
    revision = newRevision;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.LINK__REVISION,
          oldRevision, revision));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Element getTarget() {
    if (target != null && target.eIsProxy()) {
      InternalEObject oldTarget = (InternalEObject) target;
      target = (Element) eResolveProxy(oldTarget);
      if (target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinksPackage.LINK__TARGET,
              oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Element basicGetTarget() {
    return target;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setTarget(Element newTarget) {
    Element oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.LINK__TARGET, oldTarget,
          target));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getSource() {
    return source;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setSource(String newSource) {
    String oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.LINK__SOURCE, oldSource,
          source));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getSourceLocation() {
    return sourceLocation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setSourceLocation(String newSourceLocation) {
    String oldSourceLocation = sourceLocation;
    sourceLocation = newSourceLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.LINK__SOURCE_LOCATION,
          oldSourceLocation, sourceLocation));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case LinksPackage.LINK__REVISION:
      return getRevision();
    case LinksPackage.LINK__TARGET:
      if (resolve)
        return getTarget();
      return basicGetTarget();
    case LinksPackage.LINK__SOURCE:
      return getSource();
    case LinksPackage.LINK__SOURCE_LOCATION:
      return getSourceLocation();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case LinksPackage.LINK__REVISION:
      setRevision((String) newValue);
      return;
    case LinksPackage.LINK__TARGET:
      setTarget((Element) newValue);
      return;
    case LinksPackage.LINK__SOURCE:
      setSource((String) newValue);
      return;
    case LinksPackage.LINK__SOURCE_LOCATION:
      setSourceLocation((String) newValue);
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
    case LinksPackage.LINK__REVISION:
      setRevision(REVISION_EDEFAULT);
      return;
    case LinksPackage.LINK__TARGET:
      setTarget((Element) null);
      return;
    case LinksPackage.LINK__SOURCE:
      setSource(SOURCE_EDEFAULT);
      return;
    case LinksPackage.LINK__SOURCE_LOCATION:
      setSourceLocation(SOURCE_LOCATION_EDEFAULT);
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
    case LinksPackage.LINK__REVISION:
      return REVISION_EDEFAULT == null ? revision != null : !REVISION_EDEFAULT.equals(revision);
    case LinksPackage.LINK__TARGET:
      return target != null;
    case LinksPackage.LINK__SOURCE:
      return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
    case LinksPackage.LINK__SOURCE_LOCATION:
      return SOURCE_LOCATION_EDEFAULT == null ? sourceLocation != null
          : !SOURCE_LOCATION_EDEFAULT.equals(sourceLocation);
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
    result.append(" (revision: ");
    result.append(revision);
    result.append(", source: ");
    result.append(source);
    result.append(", sourceLocation: ");
    result.append(sourceLocation);
    result.append(')');
    return result.toString();
  }

} // LinkImpl
