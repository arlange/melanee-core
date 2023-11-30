/**
 */
package PLM.impl;

import PLM.Level;
import PLM.OwnedElement;
import PLM.PLMPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Owned Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class OwnedElementImpl extends ElementImpl implements OwnedElement {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OwnedElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMPackage.Literals.OWNED_ELEMENT;
  }

  /**
   * The cached invocation delegate for the '{@link #getLevel() <em>Get Level</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_LEVEL__EINVOCATION_DELEGATE = ((EOperation.Internal)PLMPackage.Literals.OWNED_ELEMENT___GET_LEVEL).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Level getLevel() {
    try {
      return (Level)GET_LEVEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLMPackage.OWNED_ELEMENT___GET_LEVEL:
        return getLevel();
    }
    return super.eInvoke(operationID, arguments);
  }

} //OwnedElementImpl
