/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Package#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends OwnedElement {
  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link PLM.OwnedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see PLM.PLMPackage#getPackage_Content()
   * @model containment="true"
   * @generated
   */
  EList<OwnedElement> getContent();

} // Package
