/**
 */
package PLM.impl;

import PLM.Clabject;
import PLM.Inheritance;
import PLM.PLMPackage;
import PLM.Supertype;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supertype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link PLM.impl.SupertypeImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link PLM.impl.SupertypeImpl#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupertypeImpl extends MinimalEObjectImpl.Container implements Supertype {
  /**
   * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupertype()
   * @generated
   * @ordered
   */
  protected Clabject supertype;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SupertypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.SUPERTYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clabject getSupertype() {
    if (supertype != null && supertype.eIsProxy()) {
      InternalEObject oldSupertype = (InternalEObject)supertype;
      supertype = (Clabject)eResolveProxy(oldSupertype);
      if (supertype != oldSupertype) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLMPackage.SUPERTYPE__SUPERTYPE, oldSupertype, supertype));
      }
    }
    return supertype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clabject basicGetSupertype() {
    return supertype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSupertype(Clabject newSupertype) {
    Clabject oldSupertype = supertype;
    supertype = newSupertype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.SUPERTYPE__SUPERTYPE, oldSupertype, supertype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Inheritance getInheritance() {
    if (eContainerFeatureID() != PLMPackage.SUPERTYPE__INHERITANCE) return null;
    return (Inheritance)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInheritance(Inheritance newInheritance, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newInheritance, PLMPackage.SUPERTYPE__INHERITANCE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInheritance(Inheritance newInheritance) {
    if (newInheritance != eInternalContainer() || (eContainerFeatureID() != PLMPackage.SUPERTYPE__INHERITANCE && newInheritance != null)) {
      if (EcoreUtil.isAncestor(this, newInheritance))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInheritance != null)
        msgs = ((InternalEObject)newInheritance).eInverseAdd(this, PLMPackage.INHERITANCE__SUPERTYPE, Inheritance.class, msgs);
      msgs = basicSetInheritance(newInheritance, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PLMPackage.SUPERTYPE__INHERITANCE, newInheritance, newInheritance));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case PLMPackage.SUPERTYPE__INHERITANCE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetInheritance((Inheritance)otherEnd, msgs);
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
      case PLMPackage.SUPERTYPE__INHERITANCE:
        return basicSetInheritance(null, msgs);
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
      case PLMPackage.SUPERTYPE__INHERITANCE:
        return eInternalContainer().eInverseRemove(this, PLMPackage.INHERITANCE__SUPERTYPE, Inheritance.class, msgs);
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
      case PLMPackage.SUPERTYPE__SUPERTYPE:
        if (resolve) return getSupertype();
        return basicGetSupertype();
      case PLMPackage.SUPERTYPE__INHERITANCE:
        return getInheritance();
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
      case PLMPackage.SUPERTYPE__SUPERTYPE:
        setSupertype((Clabject)newValue);
        return;
      case PLMPackage.SUPERTYPE__INHERITANCE:
        setInheritance((Inheritance)newValue);
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
      case PLMPackage.SUPERTYPE__SUPERTYPE:
        setSupertype((Clabject)null);
        return;
      case PLMPackage.SUPERTYPE__INHERITANCE:
        setInheritance((Inheritance)null);
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
      case PLMPackage.SUPERTYPE__SUPERTYPE:
        return supertype != null;
      case PLMPackage.SUPERTYPE__INHERITANCE:
        return getInheritance() != null;
    }
    return super.eIsSet(featureID);
  }

} //SupertypeImpl
