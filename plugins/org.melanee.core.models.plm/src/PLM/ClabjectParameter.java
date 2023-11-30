/**
 */
package PLM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clabject Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.ClabjectParameter#getDatatype <em>Datatype</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getClabjectParameter()
 * @model
 * @generated
 */
public interface ClabjectParameter extends Parameter {
  /**
   * Returns the value of the '<em><b>Datatype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Datatype</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Datatype</em>' reference.
   * @see #setDatatype(Clabject)
   * @see PLM.PLMPackage#getClabjectParameter_Datatype()
   * @model required="true"
   * @generated
   */
  Clabject getDatatype();

  /**
   * Sets the value of the '{@link PLM.ClabjectParameter#getDatatype <em>Datatype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Datatype</em>' reference.
   * @see #getDatatype()
   * @generated
   */
  void setDatatype(Clabject value);

} // ClabjectParameter
