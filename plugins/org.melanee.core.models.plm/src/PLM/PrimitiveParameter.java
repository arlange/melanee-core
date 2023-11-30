/**
 */
package PLM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.PrimitiveParameter#getDatatype <em>Datatype</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getPrimitiveParameter()
 * @model
 * @generated
 */
public interface PrimitiveParameter extends Parameter {
  /**
   * Returns the value of the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Datatype</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Datatype</em>' attribute.
   * @see #setDatatype(String)
   * @see PLM.PLMPackage#getPrimitiveParameter_Datatype()
   * @model required="true"
   * @generated
   */
  String getDatatype();

  /**
   * Sets the value of the '{@link PLM.PrimitiveParameter#getDatatype <em>Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Datatype</em>' attribute.
   * @see #getDatatype()
   * @generated
   */
  void setDatatype(String value);

} // PrimitiveParameter
