/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Element#getName <em>Name</em>}</li>
 *   <li>{@link PLM.Element#getVisualizer <em>Visualizer</em>}</li>
 *   <li>{@link PLM.Element#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link PLM.Element#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
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
   * @see PLM.PLMPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link PLM.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Visualizer</b></em>' containment reference list.
   * The list contents are of type {@link PLM.LMLVisualizer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visualizer</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visualizer</em>' containment reference list.
   * @see PLM.PLMPackage#getElement_Visualizer()
   * @model containment="true"
   * @generated
   */
  EList<LMLVisualizer> getVisualizer();

  /**
   * Returns the value of the '<em><b>Behavior</b></em>' containment reference list.
   * The list contents are of type {@link PLM.AbstractBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behavior</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior</em>' containment reference list.
   * @see PLM.PLMPackage#getElement_Behavior()
   * @model containment="true"
   * @generated
   */
  EList<AbstractBehavior> getBehavior();

  /**
   * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
   * The list contents are of type {@link PLM.AbstractConstraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint</em>' containment reference list.
   * @see PLM.PLMPackage#getElement_Constraint()
   * @model containment="true"
   * @generated
   */
  EList<AbstractConstraint> getConstraint();

} // Element
