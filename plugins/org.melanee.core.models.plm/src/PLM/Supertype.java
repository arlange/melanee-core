/**
 */
package PLM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supertype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Supertype#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link PLM.Supertype#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getSupertype()
 * @model
 * @generated
 */
public interface Supertype extends EObject {
  /**
   * Returns the value of the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supertype</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supertype</em>' reference.
   * @see #setSupertype(Clabject)
   * @see PLM.PLMPackage#getSupertype_Supertype()
   * @model required="true"
   * @generated
   */
  Clabject getSupertype();

  /**
   * Sets the value of the '{@link PLM.Supertype#getSupertype <em>Supertype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supertype</em>' reference.
   * @see #getSupertype()
   * @generated
   */
  void setSupertype(Clabject value);

  /**
   * Returns the value of the '<em><b>Inheritance</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link PLM.Inheritance#getSupertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inheritance</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inheritance</em>' container reference.
   * @see #setInheritance(Inheritance)
   * @see PLM.PLMPackage#getSupertype_Inheritance()
   * @see PLM.Inheritance#getSupertype
   * @model opposite="supertype" transient="false"
   * @generated
   */
  Inheritance getInheritance();

  /**
   * Sets the value of the '{@link PLM.Supertype#getInheritance <em>Inheritance</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inheritance</em>' container reference.
   * @see #getInheritance()
   * @generated
   */
  void setInheritance(Inheritance value);

} // Supertype
