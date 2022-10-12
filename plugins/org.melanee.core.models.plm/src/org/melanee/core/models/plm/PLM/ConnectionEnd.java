/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.plm.PLM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Connection End</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getLower <em>Lower</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getMoniker <em>Moniker</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getKind <em>Kind</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getType <em>Type</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd()
 * @model
 * @generated
 */
public interface ConnectionEnd extends Property {
  /**
   * Returns the value of the '<em><b>Lower</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' attribute.
   * @see #setLower(int)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Lower()
   * @model default="0"
   * @generated
   */
  int getLower();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getLower <em>Lower</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' attribute.
   * @see #getLower()
   * @generated
   */
  void setLower(int value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' attribute.
   * @see #setUpper(int)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Upper()
   * @model default="-1"
   * @generated
   */
  int getUpper();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getUpper <em>Upper</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' attribute.
   * @see #getUpper()
   * @generated
   */
  void setUpper(int value);

  /**
   * Returns the value of the '<em><b>Navigable</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Navigable</em>' attribute isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Navigable</em>' attribute.
   * @see #setNavigable(boolean)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Navigable()
   * @model default="true" required="true"
   * @generated
   */
  boolean isNavigable();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#isNavigable <em>Navigable</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Navigable</em>' attribute.
   * @see #isNavigable()
   * @generated
   */
  void setNavigable(boolean value);

  /**
   * Returns the value of the '<em><b>Destination</b></em>' reference. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Destination</em>' reference isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Destination</em>' reference.
   * @see #setDestination(Clabject)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Destination()
   * @model required="true"
   * @generated
   */
  Clabject getDestination();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getDestination
   * <em>Destination</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @param value
   *          the new value of the '<em>Destination</em>' reference.
   * @see #getDestination()
   * @generated
   */
  void setDestination(Clabject value);

  /**
   * Returns the value of the '<em><b>Connection</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.melanee.core.models.plm.PLM.Connection#getConnectionEnd <em>Connection End</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connection</em>' container reference.
   * @see #setConnection(Connection)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Connection()
   * @see org.melanee.core.models.plm.PLM.Connection#getConnectionEnd
   * @model opposite="connectionEnd" transient="false"
   * @generated
   */
  Connection getConnection();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getConnection <em>Connection</em>}' container reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Connection</em>' container reference.
   * @see #getConnection()
   * @generated
   */
  void setConnection(Connection value);

  /**
   * Returns the value of the '<em><b>Moniker</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Moniker</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Moniker</em>' attribute.
   * @see #setMoniker(String)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Moniker()
   * @model
   * @generated
   */
  String getMoniker();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getMoniker <em>Moniker</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Moniker</em>' attribute.
   * @see #getMoniker()
   * @generated
   */
  void setMoniker(String value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute. The default value
   * is <code>"Basic"</code>. The literals are from the enumeration
   * {@link org.melanee.core.models.plm.PLM.ConnectionEndKind}. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.melanee.core.models.plm.PLM.ConnectionEndKind
   * @see #setKind(ConnectionEndKind)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Kind()
   * @model default="Basic" required="true"
   * @generated
   */
  ConnectionEndKind getKind();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.melanee.core.models.plm.PLM.ConnectionEndKind
   * @see #getKind()
   * @generated
   */
  void setKind(ConnectionEndKind value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(ConnectionEnd)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Type()
   * @model
   * @generated
   */
  ConnectionEnd getType();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(ConnectionEnd value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference list.
   * The list contents are of type {@link org.melanee.core.models.plm.PLM.Multiplicity}.
   * It is bidirectional and its opposite is '{@link org.melanee.core.models.plm.PLM.Multiplicity#getConnectionend <em>Connectionend</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' containment reference list
   * isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnectionEnd_Multiplicity()
   * @see org.melanee.core.models.plm.PLM.Multiplicity#getConnectionend
   * @model opposite="connectionend" containment="true"
   * @generated
   */
  EList<Multiplicity> getMultiplicity();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * constructs a readable moniker from the traits of the connectionEnd <!--
   * end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        (self.hasDefaultMoniker()) then\r\n\tif (self.destination.name.size()
   *        > 0)
   *        then\r\n\t\tself.destination.name.substring(1,1).toLower().concat(if
   *        (self.destination.name.size() > 1) then
   *        self.destination.name.substring(2, self.destination.name.size()) else
   *        \'\'
   *        endif)\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\tself.moniker\r\nendif'"
   * @generated
   */
  String getHumanReadableConnectionEndName();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the moniker is not explicitly given but implicitly defined
   * through the destination name <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        (self.moniker.oclIsUndefined() or self.moniker = \'\')
   *        then\r\n\ttrue\r\nelse\r\n\tfalse\r\nendif'"
   * @generated
   */
  boolean hasDefaultMoniker();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        destinationName : String = \r\n\tif
   *        self.destination.name.oclIsUndefined() or self.destination.name.size()
   *        = 0 then\r\n\t\t\'_\' else self.destination.name endif
   *        \r\nin\r\nself.moniker().concat(\'[\').concat(\r\n\tself.representMultiplicity()\r\n).concat(\']\').concat(\r\n\tif
   *        self.navigable then \'->\' else \'-\'
   *        endif\r\n).concat(destinationName)'"
   * @generated
   */
  String represent();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the moniker identifying the connectionEnd with in the connection
   * !!!crashes in case the connectionEnds destination has no name set and the
   * expressed connectionEnd name is not set either!!! <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        (self.hasDefaultMoniker()) then\r\n\tif (self.destination.name.size()
   *        > 0)
   *        then\r\n\t\tself.destination.name.substring(1,1).toLower().concat(if
   *        (self.destination.name.size() > 1) then
   *        self.destination.name.substring(2, self.destination.name.size()) else
   *        \'\'
   *        endif)\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\tself.moniker\r\nendif'"
   * @generated
   */
  String moniker();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a string representation of the lower and upper multiplicity,
   * including special cases like '*' <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        lowerString:String = if (self.lower > 0) then OrderedSet{1000000,
   *        10000, 1000, 100, 10, 1}->iterate(\r\n denominator : Integer;\r\n s :
   *        String = \'\'|\r\n let numberAsString : String = OrderedSet{\r\n
   *        \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n
   *        }->at(self.lower.div(denominator).mod(10) + 1)\r\n in\r\n if s=\'\'
   *        and numberAsString = \'0\' then\r\n s\r\n else\r\n
   *        s.concat(numberAsString)\r\n endif\r\n )\r\n\telse \r\n\t\tif
   *        (self.lower = 0)
   *        then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nlet
   *        upperString:String = if (self.upper > 0) then OrderedSet{1000000,
   *        10000, 1000, 100, 10, 1}->iterate(\r\n denominator : Integer;\r\n s :
   *        String = \'\'|\r\n let numberAsString : String = OrderedSet{\r\n
   *        \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n
   *        }->at(self.upper.div(denominator).mod(10) + 1)\r\n in\r\n if s=\'\'
   *        and numberAsString = \'0\' then\r\n s\r\n else\r\n
   *        s.concat(numberAsString)\r\n endif\r\n )\r\n\telse \r\n\t\tif
   *        (self.upper = 0)
   *        then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nif
   *        (self.lower = 0 and self.upper = -1) then\r\n\t\'*\'\r\nelse\r\n\tif
   *        (self.lower = self.upper)
   *        then\r\n\t\tlowerString\r\n\telse\r\n\t\tlowerString.concat(\'..\').concat(upperString)\r\n\tendif\r\nendif'"
   * @generated
   */
  String representMultiplicity();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> helper
   * method to conform to the interface of elements <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.represent()'"
   * @generated
   */
  String getConnectionEndName();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the connectionEnd conforms to the other connectionEnd, i.e.
   * if the monikers and navigabilities match <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false" connectionEndRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        connectionEndNameConforms:Boolean = \r\n\t(self.moniker() =
   *        connectionEnd.moniker()) or (self.hasDefaultMoniker() and
   *        connectionEnd.hasDefaultMoniker())\r\nin\r\n\tconnectionEndNameConforms
   *        and ( self.navigable = connectionEnd.navigable)'"
   * @generated
   */
  boolean conforms(ConnectionEnd connectionEnd);

} // ConnectionEnd
