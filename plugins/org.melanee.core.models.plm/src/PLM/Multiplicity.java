/**
 */
package PLM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Multiplicity#getLower <em>Lower</em>}</li>
 *   <li>{@link PLM.Multiplicity#getUpper <em>Upper</em>}</li>
 *   <li>{@link PLM.Multiplicity#getPotency <em>Potency</em>}</li>
 *   <li>{@link PLM.Multiplicity#getConnectionend <em>Connectionend</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getMultiplicity()
 * @model
 * @generated
 */
public interface Multiplicity extends EObject {
  /**
   * Returns the value of the '<em><b>Lower</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' attribute.
   * @see #setLower(int)
   * @see PLM.PLMPackage#getMultiplicity_Lower()
   * @model default="0"
   * @generated
   */
  int getLower();

  /**
   * Sets the value of the '{@link PLM.Multiplicity#getLower <em>Lower</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' attribute.
   * @see #getLower()
   * @generated
   */
  void setLower(int value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' attribute.
   * @see #setUpper(int)
   * @see PLM.PLMPackage#getMultiplicity_Upper()
   * @model default="-1"
   * @generated
   */
  int getUpper();

  /**
   * Sets the value of the '{@link PLM.Multiplicity#getUpper <em>Upper</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' attribute.
   * @see #getUpper()
   * @generated
   */
  void setUpper(int value);

  /**
   * Returns the value of the '<em><b>Potency</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Potency</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Potency</em>' attribute.
   * @see #setPotency(int)
   * @see PLM.PLMPackage#getMultiplicity_Potency()
   * @model default="1" required="true"
   * @generated
   */
  int getPotency();

  /**
   * Sets the value of the '{@link PLM.Multiplicity#getPotency <em>Potency</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Potency</em>' attribute.
   * @see #getPotency()
   * @generated
   */
  void setPotency(int value);

  /**
   * Returns the value of the '<em><b>Connectionend</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link PLM.ConnectionEnd#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connectionend</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connectionend</em>' container reference.
   * @see #setConnectionend(ConnectionEnd)
   * @see PLM.PLMPackage#getMultiplicity_Connectionend()
   * @see PLM.ConnectionEnd#getMultiplicity
   * @model opposite="multiplicity" transient="false"
   * @generated
   */
  ConnectionEnd getConnectionend();

  /**
   * Sets the value of the '{@link PLM.Multiplicity#getConnectionend <em>Connectionend</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connectionend</em>' container reference.
   * @see #getConnectionend()
   * @generated
   */
  void setConnectionend(ConnectionEnd value);

} // Multiplicity
