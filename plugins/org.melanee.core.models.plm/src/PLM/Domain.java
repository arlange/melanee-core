/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is the root model element usually containing an DeepModel.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Domain#getName <em>Name</em>}</li>
 *   <li>{@link PLM.Domain#getDeepModel <em>Deep Model</em>}</li>
 *   <li>{@link PLM.Domain#getPlmVersion <em>Plm Version</em>}</li>
 *   <li>{@link PLM.Domain#getComplianceKind <em>Compliance Kind</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see PLM.PLMPackage#getDomain_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link PLM.Domain#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Deep Model</b></em>' containment reference list.
   * The list contents are of type {@link PLM.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deep Model</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deep Model</em>' containment reference list.
   * @see PLM.PLMPackage#getDomain_DeepModel()
   * @model containment="true"
   * @generated
   */
  EList<Element> getDeepModel();

  /**
   * Returns the value of the '<em><b>Plm Version</b></em>' attribute.
   * The default value is <code>"2.0b2"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plm Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plm Version</em>' attribute.
   * @see #setPlmVersion(String)
   * @see PLM.PLMPackage#getDomain_PlmVersion()
   * @model default="2.0b2"
   * @generated
   */
  String getPlmVersion();

  /**
   * Sets the value of the '{@link PLM.Domain#getPlmVersion <em>Plm Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plm Version</em>' attribute.
   * @see #getPlmVersion()
   * @generated
   */
  void setPlmVersion(String value);

  /**
   * Returns the value of the '<em><b>Compliance Kind</b></em>' attribute.
   * The literals are from the enumeration {@link PLM.ComplianceKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compliance Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compliance Kind</em>' attribute.
   * @see PLM.ComplianceKind
   * @see #setComplianceKind(ComplianceKind)
   * @see PLM.PLMPackage#getDomain_ComplianceKind()
   * @model required="true"
   * @generated
   */
  ComplianceKind getComplianceKind();

  /**
   * Sets the value of the '{@link PLM.Domain#getComplianceKind <em>Compliance Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compliance Kind</em>' attribute.
   * @see PLM.ComplianceKind
   * @see #getComplianceKind()
   * @generated
   */
  void setComplianceKind(ComplianceKind value);

} // Domain
