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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.ConnectionEndKind;
import org.melanee.core.models.plm.PLM.Multiplicity;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Connection End</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getMoniker <em>Moniker</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.impl.ConnectionEndImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionEndImpl extends PropertyImpl implements ConnectionEnd {
  /**
   * The default value of the '{@link #getLower() <em>Lower</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected static final int LOWER_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected int lower = LOWER_EDEFAULT;

  /**
   * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected static final int UPPER_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected int upper = UPPER_EDEFAULT;

  /**
   * The default value of the '{@link #isNavigable() <em>Navigable</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #isNavigable()
   * @generated
   * @ordered
   */
  protected static final boolean NAVIGABLE_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isNavigable() <em>Navigable</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #isNavigable()
   * @generated
   * @ordered
   */
  protected boolean navigable = NAVIGABLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getDestination()
   * @generated
   * @ordered
   */
  protected Clabject destination;

  /**
   * The default value of the '{@link #getMoniker() <em>Moniker</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getMoniker()
   * @generated
   * @ordered
   */
  protected static final String MONIKER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMoniker() <em>Moniker</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getMoniker()
   * @generated
   * @ordered
   */
  protected String moniker = MONIKER_EDEFAULT;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final ConnectionEndKind KIND_EDEFAULT = ConnectionEndKind.BASIC;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected ConnectionEndKind kind = KIND_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ConnectionEnd type;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected EList<Multiplicity> multiplicity;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ConnectionEndImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.CONNECTION_END;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public int getLower() {
    return lower;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setLower(int newLower) {
    int oldLower = lower;
    lower = newLower;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__LOWER, oldLower, lower));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public int getUpper() {
    return upper;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setUpper(int newUpper) {
    int oldUpper = upper;
    upper = newUpper;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__UPPER, oldUpper, upper));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean isNavigable() {
    return navigable;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setNavigable(boolean newNavigable) {
    boolean oldNavigable = navigable;
    navigable = newNavigable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__NAVIGABLE, oldNavigable, navigable));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject getDestination() {
    if (destination != null && destination.eIsProxy()) {
      InternalEObject oldDestination = (InternalEObject)destination;
      destination = (Clabject)eResolveProxy(oldDestination);
      if (destination != oldDestination) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLMPackage.CONNECTION_END__DESTINATION, oldDestination, destination));
      }
    }
    return destination;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Clabject basicGetDestination() {
    return destination;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setDestination(Clabject newDestination) {
    Clabject oldDestination = destination;
    destination = newDestination;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__DESTINATION, oldDestination, destination));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Connection getConnection() {
    if (eContainerFeatureID() != PLMPackage.CONNECTION_END__CONNECTION) return null;
    return (Connection)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConnection(Connection newConnection, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newConnection, PLMPackage.CONNECTION_END__CONNECTION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setConnection(Connection newConnection) {
    if (newConnection != eInternalContainer() || (eContainerFeatureID() != PLMPackage.CONNECTION_END__CONNECTION && newConnection != null)) {
      if (EcoreUtil.isAncestor(this, newConnection))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newConnection != null)
        msgs = ((InternalEObject)newConnection).eInverseAdd(this, PLMPackage.CONNECTION__CONNECTION_END, Connection.class, msgs);
      msgs = basicSetConnection(newConnection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__CONNECTION, newConnection, newConnection));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getMoniker() {
    return moniker;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setMoniker(String newMoniker) {
    String oldMoniker = moniker;
    moniker = newMoniker;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__MONIKER, oldMoniker, moniker));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ConnectionEndKind getKind() {
    return kind;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setKind(ConnectionEndKind newKind) {
    ConnectionEndKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ConnectionEnd getType() {
    if (type != null && type.eIsProxy()) {
      InternalEObject oldType = (InternalEObject)type;
      type = (ConnectionEnd)eResolveProxy(oldType);
      if (type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLMPackage.CONNECTION_END__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ConnectionEnd basicGetType() {
    return type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setType(ConnectionEnd newType) {
    ConnectionEnd oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.CONNECTION_END__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<Multiplicity> getMultiplicity() {
    if (multiplicity == null) {
      multiplicity = new EObjectContainmentWithInverseEList<Multiplicity>(Multiplicity.class, this, PLMPackage.CONNECTION_END__MULTIPLICITY, PLMPackage.MULTIPLICITY__CONNECTIONEND);
    }
    return multiplicity;
  }

  /**
   * The cached invocation delegate for the '{@link #getHumanReadableConnectionEndName() <em>Get Human Readable Connection End Name</em>}' operation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getHumanReadableConnectionEndName()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_HUMAN_READABLE_CONNECTION_END_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION_END___GET_HUMAN_READABLE_CONNECTION_END_NAME).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getHumanReadableConnectionEndName() {
    try {
      return (String)GET_HUMAN_READABLE_CONNECTION_END_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #hasDefaultMoniker() <em>Has
   * Default Moniker</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #hasDefaultMoniker()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate HAS_DEFAULT_MONIKER__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION_END___HAS_DEFAULT_MONIKER).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean hasDefaultMoniker() {
    try {
      return (Boolean)HAS_DEFAULT_MONIKER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #represent()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate REPRESENT__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION_END___REPRESENT).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
   * The cached invocation delegate for the '{@link #moniker() <em>Moniker</em>}' operation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #moniker()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate MONIKER__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION_END___MONIKER).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String moniker() {
    try {
      return (String)MONIKER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #representMultiplicity() <em>Represent Multiplicity</em>}' operation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #representMultiplicity()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate REPRESENT_MULTIPLICITY__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION_END___REPRESENT_MULTIPLICITY).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String representMultiplicity() {
    try {
      return (String)REPRESENT_MULTIPLICITY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getConnectionEndName() <em>Get Connection End Name</em>}' operation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getConnectionEndName()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_CONNECTION_END_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION_END___GET_CONNECTION_END_NAME).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getConnectionEndName() {
    try {
      return (String)GET_CONNECTION_END_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #conforms(org.melanee.core.models.plm.PLM.ConnectionEnd) <em>Conforms</em>}' operation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #conforms(org.melanee.core.models.plm.PLM.ConnectionEnd)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate CONFORMS_CONNECTION_END__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.CONNECTION_END___CONFORMS__CONNECTIONEND).getInvocationDelegate();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean conforms(ConnectionEnd connectionEnd) {
    try {
      return (Boolean)CONFORMS_CONNECTION_END__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{connectionEnd}));
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case PLMPackage.CONNECTION_END__CONNECTION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetConnection((Connection)otherEnd, msgs);
      case PLMPackage.CONNECTION_END__MULTIPLICITY:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMultiplicity()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case PLMPackage.CONNECTION_END__CONNECTION:
        return basicSetConnection(null, msgs);
      case PLMPackage.CONNECTION_END__MULTIPLICITY:
        return ((InternalEList<?>)getMultiplicity()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case PLMPackage.CONNECTION_END__CONNECTION:
        return eInternalContainer().eInverseRemove(this, PLMPackage.CONNECTION__CONNECTION_END, Connection.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case PLMPackage.CONNECTION_END__LOWER:
        return getLower();
      case PLMPackage.CONNECTION_END__UPPER:
        return getUpper();
      case PLMPackage.CONNECTION_END__NAVIGABLE:
        return isNavigable();
      case PLMPackage.CONNECTION_END__DESTINATION:
        if (resolve) return getDestination();
        return basicGetDestination();
      case PLMPackage.CONNECTION_END__CONNECTION:
        return getConnection();
      case PLMPackage.CONNECTION_END__MONIKER:
        return getMoniker();
      case PLMPackage.CONNECTION_END__KIND:
        return getKind();
      case PLMPackage.CONNECTION_END__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case PLMPackage.CONNECTION_END__MULTIPLICITY:
        return getMultiplicity();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case PLMPackage.CONNECTION_END__LOWER:
        setLower((Integer)newValue);
        return;
      case PLMPackage.CONNECTION_END__UPPER:
        setUpper((Integer)newValue);
        return;
      case PLMPackage.CONNECTION_END__NAVIGABLE:
        setNavigable((Boolean)newValue);
        return;
      case PLMPackage.CONNECTION_END__DESTINATION:
        setDestination((Clabject)newValue);
        return;
      case PLMPackage.CONNECTION_END__CONNECTION:
        setConnection((Connection)newValue);
        return;
      case PLMPackage.CONNECTION_END__MONIKER:
        setMoniker((String)newValue);
        return;
      case PLMPackage.CONNECTION_END__KIND:
        setKind((ConnectionEndKind)newValue);
        return;
      case PLMPackage.CONNECTION_END__TYPE:
        setType((ConnectionEnd)newValue);
        return;
      case PLMPackage.CONNECTION_END__MULTIPLICITY:
        getMultiplicity().clear();
        getMultiplicity().addAll((Collection<? extends Multiplicity>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case PLMPackage.CONNECTION_END__LOWER:
        setLower(LOWER_EDEFAULT);
        return;
      case PLMPackage.CONNECTION_END__UPPER:
        setUpper(UPPER_EDEFAULT);
        return;
      case PLMPackage.CONNECTION_END__NAVIGABLE:
        setNavigable(NAVIGABLE_EDEFAULT);
        return;
      case PLMPackage.CONNECTION_END__DESTINATION:
        setDestination((Clabject)null);
        return;
      case PLMPackage.CONNECTION_END__CONNECTION:
        setConnection((Connection)null);
        return;
      case PLMPackage.CONNECTION_END__MONIKER:
        setMoniker(MONIKER_EDEFAULT);
        return;
      case PLMPackage.CONNECTION_END__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case PLMPackage.CONNECTION_END__TYPE:
        setType((ConnectionEnd)null);
        return;
      case PLMPackage.CONNECTION_END__MULTIPLICITY:
        getMultiplicity().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case PLMPackage.CONNECTION_END__LOWER:
        return lower != LOWER_EDEFAULT;
      case PLMPackage.CONNECTION_END__UPPER:
        return upper != UPPER_EDEFAULT;
      case PLMPackage.CONNECTION_END__NAVIGABLE:
        return navigable != NAVIGABLE_EDEFAULT;
      case PLMPackage.CONNECTION_END__DESTINATION:
        return destination != null;
      case PLMPackage.CONNECTION_END__CONNECTION:
        return getConnection() != null;
      case PLMPackage.CONNECTION_END__MONIKER:
        return MONIKER_EDEFAULT == null ? moniker != null : !MONIKER_EDEFAULT.equals(moniker);
      case PLMPackage.CONNECTION_END__KIND:
        return kind != KIND_EDEFAULT;
      case PLMPackage.CONNECTION_END__TYPE:
        return type != null;
      case PLMPackage.CONNECTION_END__MULTIPLICITY:
        return multiplicity != null && !multiplicity.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLMPackage.CONNECTION_END___GET_HUMAN_READABLE_CONNECTION_END_NAME:
        return getHumanReadableConnectionEndName();
      case PLMPackage.CONNECTION_END___HAS_DEFAULT_MONIKER:
        return hasDefaultMoniker();
      case PLMPackage.CONNECTION_END___REPRESENT:
        return represent();
      case PLMPackage.CONNECTION_END___MONIKER:
        return moniker();
      case PLMPackage.CONNECTION_END___REPRESENT_MULTIPLICITY:
        return representMultiplicity();
      case PLMPackage.CONNECTION_END___GET_CONNECTION_END_NAME:
        return getConnectionEndName();
      case PLMPackage.CONNECTION_END___CONFORMS__CONNECTIONEND:
        return conforms((ConnectionEnd)arguments.get(0));
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (lower: ");
    result.append(lower);
    result.append(", upper: ");
    result.append(upper);
    result.append(", navigable: ");
    result.append(navigable);
    result.append(", moniker: ");
    result.append(moniker);
    result.append(", kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} // ConnectionEndImpl
