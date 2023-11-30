/**
 */
package PLM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Classification#getInstance <em>Instance</em>}</li>
 *   <li>{@link PLM.Classification#getType <em>Type</em>}</li>
 *   <li>{@link PLM.Classification#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getClassification()
 * @model
 * @generated
 */
public interface Classification extends Correlation {
  /**
   * Returns the value of the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance</em>' reference.
   * @see #setInstance(Clabject)
   * @see PLM.PLMPackage#getClassification_Instance()
   * @model required="true"
   * @generated
   */
  Clabject getInstance();

  /**
   * Sets the value of the '{@link PLM.Classification#getInstance <em>Instance</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance</em>' reference.
   * @see #getInstance()
   * @generated
   */
  void setInstance(Clabject value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Clabject)
   * @see PLM.PLMPackage#getClassification_Type()
   * @model required="true"
   * @generated
   */
  Clabject getType();

  /**
   * Sets the value of the '{@link PLM.Classification#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Clabject value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The default value is <code>"instantiation"</code>.
   * The literals are from the enumeration {@link PLM.ClassificationKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see PLM.ClassificationKind
   * @see #setKind(ClassificationKind)
   * @see PLM.PLMPackage#getClassification_Kind()
   * @model default="instantiation" required="true"
   * @generated
   */
  ClassificationKind getKind();

  /**
   * Sets the value of the '{@link PLM.Classification#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see PLM.ClassificationKind
   * @see #getKind()
   * @generated
   */
  void setKind(ClassificationKind value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable representation of the classification constructed from the names of the instance and the type as well as the kind of the classification.
   * <!-- end-model-doc -->
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.instance.represent().concat(\'-&gt;\').concat(self.type.represent())'"
   * @generated
   */
  String represent();

} // Classification
