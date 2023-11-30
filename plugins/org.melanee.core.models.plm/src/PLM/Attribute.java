/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Attribute#getValue <em>Value</em>}</li>
 *   <li>{@link PLM.Attribute#getMutability <em>Mutability</em>}</li>
 *   <li>{@link PLM.Attribute#getDatatype <em>Datatype</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Feature, Property {
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see PLM.PLMPackage#getAttribute_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link PLM.Attribute#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Mutability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mutability</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mutability</em>' attribute.
   * @see #setMutability(int)
   * @see PLM.PLMPackage#getAttribute_Mutability()
   * @model
   * @generated
   */
  int getMutability();

  /**
   * Sets the value of the '{@link PLM.Attribute#getMutability <em>Mutability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mutability</em>' attribute.
   * @see #getMutability()
   * @generated
   */
  void setMutability(int value);

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
   * @see PLM.PLMPackage#getAttribute_Datatype()
   * @model
   * @generated
   */
  String getDatatype();

  /**
   * Sets the value of the '{@link PLM.Attribute#getDatatype <em>Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Datatype</em>' attribute.
   * @see #getDatatype()
   * @generated
   */
  void setDatatype(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation
   * <!-- end-model-doc -->
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if (self.mutability &gt; 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}-&gt;iterate(\r\n\tdenominator : Integer;\ts : String = \'\'|\r\n\t\tlet numberAsString : String = \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}-&gt;at(self.mutability.div(denominator).mod(10) + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\' then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif (self.mutability = 0) then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n'"
   * @generated
   */
  String getMutabilityAsString();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation
   * <!-- end-model-doc -->
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.datatype.oclIsUndefined() or self.datatype = \'\' then\r\n\tself.name\r\nelse\r\n\tself.name.concat(\'[\').concat(self.datatype).concat(\']\')\r\nendif'"
   * @generated
   */
  String represent();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all possible datatypes
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getPrimitiveDataTypes()-&gt;union(self.getEnumerationDataTypes())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getPossibleDataTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all possible datatypes
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details.key-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getPrimitiveDataTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all possible datatypes
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClabject().getDeepModel().enumeration.name-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getEnumerationDataTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all possible datatypes
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='getEnumerationDataTypes()-&gt;includes(datatype)'"
   * @generated
   */
  boolean isEnumeration();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all possible datatypes
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--Check if the attribute is an enumeration\r\nif (isEnumeration()) then\r\n\tself.getClabject().getDeepModel().enumeration-&gt;select(name = datatype)-&gt;any(true)\r\nelse\r\n\tnull\r\nendif'"
   * @generated
   */
  Enumeration getEnumeration();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all possible datatypes
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='getEnumeration().literal-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getLiterals();

} // Attribute
