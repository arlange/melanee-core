/**
 */
package PLM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Feature#getDurability <em>Durability</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends Element {
  /**
   * Returns the value of the '<em><b>Durability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Durability</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Durability</em>' attribute.
   * @see #setDurability(int)
   * @see PLM.PLMPackage#getFeature_Durability()
   * @model
   * @generated
   */
  int getDurability();

  /**
   * Sets the value of the '{@link PLM.Feature#getDurability <em>Durability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Durability</em>' attribute.
   * @see #getDurability()
   * @generated
   */
  void setDurability(int value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabject that owns the feature
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject)'"
   * @generated
   */
  Clabject getClabject();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation
   * <!-- end-model-doc -->
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if (self.durability &gt; 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}\r\n\t-&gt;iterate(denominator : Integer; s : String = \'\'|\r\n\t\tlet numberAsString : String = \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}-&gt;at(self.durability.div(denominator).mod(10) + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\' then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif (self.durability = 0) then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n'"
   * @generated
   */
  String getDurabilityAsString();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation
   * <!-- end-model-doc -->
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsTypeOf(Attribute) then \r\n\tself.oclAsType(Attribute).represent() \r\nelse \r\n\tself.oclAsType(Method).represent() \r\nendif'"
   * @generated
   */
  String represent();

} // Feature
