/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deep Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.DeepModel#getContent <em>Content</em>}</li>
 *   <li>{@link PLM.DeepModel#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getDeepModel()
 * @model
 * @generated
 */
public interface DeepModel extends Element {
  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link PLM.Level}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see PLM.PLMPackage#getDeepModel_Content()
   * @model containment="true"
   * @generated
   */
  EList<Level> getContent();

  /**
   * Returns the value of the '<em><b>Enumeration</b></em>' containment reference list.
   * The list contents are of type {@link PLM.Enumeration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration</em>' containment reference list.
   * @see PLM.PLMPackage#getDeepModel_Enumeration()
   * @model containment="true"
   * @generated
   */
  EList<Enumeration> getEnumeration();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the model identified by the level
   * <!-- end-model-doc -->
   * @model ordered="false" levelRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if level &gt; 0 and level &lt;= self.content-&gt;size() then\r\n\tself.content-&gt;at(level)\r\nelse\r\n\tnull\r\nendif'"
   * @generated
   */
  Level getLevelAtIndex(int level);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all primitive datatypes
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details.key-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getPrimitiveDatatypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all primitive datatypes
   * <!-- end-model-doc -->
   * @model required="true" typeRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if (self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details-&gt;select(e | e.key = type)-&gt;size() = 1) then\r\n\tself.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details-&gt;select(e | e.key = type).value-&gt;first()\r\nelse\r\n\tnull\r\nendif'"
   * @generated
   */
  String getRegexForPrimitiveDatatype(String type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all primitive datatypes and enumeration
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getPrimitiveDatatypes()-&gt;asSequence()-&gt;union(self.enumeration.name)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getAllDatatypes();

} // DeepModel
