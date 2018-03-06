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
 * '<em><b>Connection</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.plm.PLM.Connection#getConnectionEnd
 * <em>Connection End</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnection()
 * @model annotation="Comment Unique\040Workaround='if (this.participant ==
 *        null) {\r\n\t\t this.participant = new
 *        EObjectResolvingEList<Clabject>(Clabject.class, this,\r\n\t\t
 *        \t\tPLMPackage.DOMAIN_CONNECTION__PARTICIPANT)
 *        {\r\n\t\t @Override\r\n\t\t protected boolean isUnique() {\r\n\t\t
 *        return false;\r\n\t\t }\r\n\t\t };\r\n\t\t }\r\n\t\t return
 *        this.participant;'"
 * @generated
 */
public interface Connection extends Clabject {
  /**
   * Returns the value of the '<em><b>Connection End</b></em>' containment
   * reference list. The list contents are of type
   * {@link org.melanee.core.models.plm.PLM.ConnectionEnd}. It is bidirectional
   * and its opposite is
   * '{@link org.melanee.core.models.plm.PLM.ConnectionEnd#getConnection
   * <em>Connection</em>}'. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection End</em>' containment reference list
   * isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Connection End</em>' containment reference
   *         list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getConnection_ConnectionEnd()
   * @see org.melanee.core.models.plm.PLM.ConnectionEnd#getConnection
   * @model opposite="connection" containment="true"
   * @generated
   */
  EList<ConnectionEnd> getConnectionEnd();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects that are reachable through this operation, i.e. the
   * destinations of the navigable connectionEnds of the connection <!--
   * end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->select(r |
   *        r.navigable).destination->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDomain();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects that are participate in this connection, but are not
   * navigable. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->reject(r |
   *        r.navigable).destination->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getNotDomain();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation constructed from the
   * connectionEnds <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--Works
   *        only on connections with two or more participants or has a name by
   *        itself\r\nif (not (self.connectionEnd->size() > 1)) then\r\n\tif (not
   *        self.name.oclIsUndefined() or self.name <> \'\')
   *        then\r\n\t\tself.name\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\tif
   *        (not self.name.oclIsUndefined() and self.name.size() <> 0)
   *        then\r\n\t\tself.name\r\n\telse\r\n\t\tlet
   *        navigableConnectionEnds:OrderedSet(ConnectionEnd)
   *        =\r\n\t\t\tself.connectionEnd->select(r |
   *        r.navigable)->asOrderedSet()\r\n\t\tin\r\n\t\tif
   *        (navigableConnectionEnds->size() = 1) then\r\n\t\t\tlet
   *        domainConnectionEndName:String =
   *        \r\n\t\t\t\tnavigableConnectionEnds->first().getHumanReadableConnectionEndName()\r\n\t\t\tin\r\n\t\t\tlet
   *        notNavigableConnectionEnds:OrderedSet(ConnectionEnd)=\t\r\n\t\t\t\tself.connectionEnd->reject(r
   *        | r.navigable)->asOrderedSet()\r\n\t\t\tin\r\n\t\t\tif
   *        (notNavigableConnectionEnds->size() = 0)
   *        then\r\n\t\t\t\tnavigableConnectionEnds.destination->first().name.concat(\'.\').concat(domainConnectionEndName)\r\n\t\t\telse\r\n\t\t\t\tnotNavigableConnectionEnds->first().destination.name.concat(\'.\').concat(domainConnectionEndName)\r\n\t\t\tendif\r\n\t\telse\r\n\t\t\tif
   *        (navigableConnectionEnds->size() > 0) then\r\n\t\t\t\tlet
   *        connectionName:String =
   *        \r\n\t\t\t\t\tnavigableConnectionEnds->iterate(r:ConnectionEnd;
   *        name:String = \'\' |\r\n\t\t\t\t\t\tlet monikerToUpper:String =
   *        \r\n\t\t\t\t\t\t\tif (r.destination.name.size() = 0 or
   *        r.destination.name.oclIsUndefined())
   *        then\r\n\t\t\t\t\t\t\t\t\'~\'\r\n\t\t\t\t\t\t\telse\r\n\t\t\t\t\t\t\t\tr.destination.name.substring(1,1).toUpper().concat(if
   *        (r.destination.name.size() > 1) then r.destination.name.substring(2,
   *        r.destination.name.size()) else \'\'
   *        endif)\r\n\t\t\t\t\t\t\tendif\r\n\t\t\t\t\t\tin\r\n\t\t\t\t\t\tif (r =
   *        navigableConnectionEnds->last())
   *        then\t\r\n\t\t\t\t\t\t\tname.concat(monikerToUpper)\r\n\t\t\t\t\t\telse\r\n\t\t\t\t\t\t\tname.concat(monikerToUpper).concat(\'And\')\r\n\t\t\t\t\t\tendif\r\n\t\t\t\t\t)\r\n\t\t\t\tin\r\n\t\t\t\t\t\'Between\'.concat(connectionName)\r\n\t\t\telse\r\n\t\t\t\t\'\'\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif'"
   * @generated
   */
  String getHumanReadableName();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the participants of the connection, i.e. the destinations of all the
   * connectionEnds <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getAllConnectionEnd().destination->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getParticipants();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the monikers of the connectionEnds of the connection <!--
   * end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->collect(r|r.getHumanReadableConnectionEndName())->asOrderedSet()'"
   * @generated
   */
  EList<String> getMoniker();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects that are in the domain of the connection and are not
   * the source <!-- end-model-doc -->
   * 
   * @model sourceRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->select(r | r.navigable and r.destination <>
   *        source).destination->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDomain(Clabject source);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the monikers the source is reachable with through this connection
   * <!-- end-model-doc -->
   * 
   * @model sourceRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->select(r | r.destination =
   *        source)->collect(r|r.moniker())->asOrderedSet()'"
   * @generated
   */
  EList<String> getMonikerForParticipant(Clabject source);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the lower multiplicity of the connectionEnd identified by rN <!--
   * end-model-doc -->
   * 
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->select(r | r.moniker() =
   *        rN).lower->first()'"
   * @generated
   */
  int getLowerForMoniker(String rN);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the upper multiplicity of the connectionEnd identified by rN <!--
   * end-model-doc -->
   * 
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->select(r | r.moniker() =
   *        rN).upper->first()'"
   * @generated
   */
  int getUpperForMoniker(String rN);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the navigability of the connectionEnd identified by rN <!--
   * end-model-doc -->
   * 
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->select(r | r.moniker() =
   *        rN).navigable->first()'"
   * @generated
   */
  boolean isNavigableForMoniker(String rN);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the number of connectionEnds in the connection <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->size()'"
   * @generated
   */
  int getOrder();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the connectionEnds that the connection inherits from its supertypes.
   * a connectionEnd is inherited if the moniker is not already present in a
   * connectionEnd defined with the connection itself <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getDirectSupertypes()->iterate(\r\n\tsuper;\r\n\tr :
   *        OrderedSet(ConnectionEnd)= OrderedSet{}
   *        |\r\n\tr->union(super.oclAsType(Connection).getAllConnectionEnd()->reject(rs|r->exists(rss|rss.moniker()=rs.moniker())))->asOrderedSet()\r\n)'"
   * @generated
   */
  EList<ConnectionEnd> getInheritedConnectionEnd();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all connectionEnds of the connection, including the inherited ones
   * <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->union(\r\n\tself.getInheritedConnectionEnd()->reject(r
   *        | self.connectionEnd->exists(rs | rs.moniker() = r.moniker() )
   *        )\r\n)->asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllConnectionEnd();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabject reachable through the connection via rN, i.e. the
   * destination of the connectionEnd of the connection where the moniker is rN
   * <!-- end-model-doc -->
   * 
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.connectionEnd->select(r | r.moniker() =
   *        rN).destination->first()'"
   * @generated
   */
  Clabject getParticipantForMoniker(String rN);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        self.name.oclIsUndefined() or self.name = \'\'
   *        then\n\tself.connectionEnd.represent()->iterate(\n\t\tr:String;
   *        res:String=\'|\'| res.concat(r).concat(\'|\')\n\t)\nelse
   *        \n\tself.name\nendif'"
   * @generated
   */
  String represent();

} // Connection
