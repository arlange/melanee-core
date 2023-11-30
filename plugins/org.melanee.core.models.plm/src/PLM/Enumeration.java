/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Enumeration#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends Element {
  /**
   * Returns the value of the '<em><b>Literal</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' attribute list.
   * @see PLM.PLMPackage#getEnumeration_Literal()
   * @model
   * @generated
   */
  EList<String> getLiteral();

} // Enumeration
