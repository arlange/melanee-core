/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Connection#getConnectionEnd <em>Connection End</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getConnection()
 * @model annotation="Comment Unique\040Workaround='if (this.participant == null) {\r\n\t\t    this.participant = new EObjectResolvingEList&lt;Clabject&gt;(Clabject.class, this,\r\n\t\t    \t\tPLMPackage.DOMAIN_CONNECTION__PARTICIPANT) {\r\n\t\t      @Override\r\n\t\t      protected boolean isUnique() {\r\n\t\t        return false;\r\n\t\t      }\r\n\t\t    };\r\n\t\t  }\r\n\t\t  return this.participant;'"
 * @generated
 */
public interface Connection extends Clabject {
  /**
   * Returns the value of the '<em><b>Connection End</b></em>' containment reference list.
   * The list contents are of type {@link PLM.ConnectionEnd}.
   * It is bidirectional and its opposite is '{@link PLM.ConnectionEnd#getConnection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection End</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connection End</em>' containment reference list.
   * @see PLM.PLMPackage#getConnection_ConnectionEnd()
   * @see PLM.ConnectionEnd#getConnection
   * @model opposite="connection" containment="true"
   * @generated
   */
  EList<ConnectionEnd> getConnectionEnd();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects that are reachable through this operation, i.e. the destinations of the navigable connectionEnds of the connection
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;select(r | r.navigable).destination-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDomain();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects that are participate in this connection, but are not navigable.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;reject(r | r.navigable).destination-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getNotDomain();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation constructed from the connectionEnds
   * <!-- end-model-doc -->
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--Works only on connections with two or more participants or has a name by itself\r\nif (not (self.connectionEnd-&gt;size() &gt; 1)) then\r\n\tif (not self.name.oclIsUndefined() or self.name &lt;&gt; \'\') then\r\n\t\tself.name\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\tif (not self.name.oclIsUndefined() and self.name.size() &lt;&gt; 0) then\r\n\t\tself.name\r\n\telse\r\n\t\tlet navigableConnectionEnds:OrderedSet(ConnectionEnd) =\r\n\t\t\tself.connectionEnd-&gt;select(r | r.navigable)-&gt;asOrderedSet()\r\n\t\tin\r\n\t\tif (navigableConnectionEnds-&gt;size() = 1) then\r\n\t\t\tlet domainConnectionEndName:String = \r\n\t\t\t\tnavigableConnectionEnds-&gt;first().getHumanReadableConnectionEndName()\r\n\t\t\tin\r\n\t\t\tlet notNavigableConnectionEnds:OrderedSet(ConnectionEnd)=\t\r\n\t\t\t\tself.connectionEnd-&gt;reject(r | r.navigable)-&gt;asOrderedSet()\r\n\t\t\tin\r\n\t\t\tif (notNavigableConnectionEnds-&gt;size() = 0) then\r\n\t\t\t\tnavigableConnectionEnds.destination-&gt;first().name.concat(\'.\').concat(domainConnectionEndName)\r\n\t\t\telse\r\n\t\t\t\tnotNavigableConnectionEnds-&gt;first().destination.name.concat(\'.\').concat(domainConnectionEndName)\r\n\t\t\tendif\r\n\t\telse\r\n\t\t\tif (navigableConnectionEnds-&gt;size() &gt; 0) then\r\n\t\t\t\tlet connectionName:String = \r\n\t\t\t\t\tnavigableConnectionEnds-&gt;iterate(r:ConnectionEnd; name:String = \'\' |\r\n\t\t\t\t\t\tlet monikerToUpper:String = \r\n\t\t\t\t\t\t\tif (r.destination.name.size() = 0 or r.destination.name.oclIsUndefined()) then\r\n\t\t\t\t\t\t\t\t\'~\'\r\n\t\t\t\t\t\t\telse\r\n\t\t\t\t\t\t\t\tr.destination.name.substring(1,1).toUpper().concat(if (r.destination.name.size() &gt; 1) then r.destination.name.substring(2, r.destination.name.size()) else \'\' endif)\r\n\t\t\t\t\t\t\tendif\r\n\t\t\t\t\t\tin\r\n\t\t\t\t\t\tif (r = navigableConnectionEnds-&gt;last()) then\t\r\n\t\t\t\t\t\t\tname.concat(monikerToUpper)\r\n\t\t\t\t\t\telse\r\n\t\t\t\t\t\t\tname.concat(monikerToUpper).concat(\'And\')\r\n\t\t\t\t\t\tendif\r\n\t\t\t\t\t)\r\n\t\t\t\tin\r\n\t\t\t\t\t\'Between\'.concat(connectionName)\r\n\t\t\telse\r\n\t\t\t\t\'\'\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif'"
   * @generated
   */
  String getHumanReadableName();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the participants of the connection, i.e. the destinations of all the connectionEnds
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getAllConnectionEnd().destination-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getParticipants();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the monikers of the connectionEnds of the connection
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;collect(r|r.getHumanReadableConnectionEndName())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getMoniker();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects that are in the domain of the connection and are not the source
   * <!-- end-model-doc -->
   * @model sourceRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;select(r | r.navigable and  r.destination &lt;&gt; source).destination-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDomain(Clabject source);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the monikers the source is reachable with through this connection
   * <!-- end-model-doc -->
   * @model sourceRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;select(r | r.destination = source)-&gt;collect(r|r.moniker())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getMonikerForParticipant(Clabject source);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the lower multiplicity of the connectionEnd identified by rN
   * <!-- end-model-doc -->
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;select(r | r.moniker() = rN).lower-&gt;first()'"
   * @generated
   */
  int getLowerForMoniker(String rN);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the upper multiplicity of the connectionEnd identified by rN
   * <!-- end-model-doc -->
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;select(r | r.moniker() = rN).upper-&gt;first()'"
   * @generated
   */
  int getUpperForMoniker(String rN);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the navigability of the connectionEnd identified by rN
   * <!-- end-model-doc -->
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;select(r | r.moniker() = rN).navigable-&gt;first()'"
   * @generated
   */
  boolean isNavigableForMoniker(String rN);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the number of connectionEnds in the connection
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;size()'"
   * @generated
   */
  int getOrder();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the connectionEnds that the connection inherits from its supertypes. a connectionEnd is inherited if the moniker is not already present in a connectionEnd defined with the connection itself
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getDirectSupertypes()-&gt;iterate(\r\n\tsuper;\r\n\tr : OrderedSet(ConnectionEnd)= OrderedSet{} |\r\n\tr-&gt;union(super.oclAsType(Connection).getAllConnectionEnd()-&gt;reject(rs|r-&gt;exists(rss|rss.moniker()=rs.moniker())))-&gt;asOrderedSet()\r\n)'"
   * @generated
   */
  EList<ConnectionEnd> getInheritedConnectionEnd();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all connectionEnds of the connection, including the inherited ones
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;union(\r\n\tself.getInheritedConnectionEnd()-&gt;reject(r | self.connectionEnd-&gt;exists(rs | rs.moniker() = r.moniker() ) )\r\n)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllConnectionEnd();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabject reachable through the connection via rN, i.e. the destination of the connectionEnd of the connection where the moniker is rN
   * <!-- end-model-doc -->
   * @model rNRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.connectionEnd-&gt;select(r | r.moniker() = rN).destination-&gt;first()'"
   * @generated
   */
  Clabject getParticipantForMoniker(String rN);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation
   * <!-- end-model-doc -->
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.name.oclIsUndefined() or self.name = \'\' then\n\tself.connectionEnd.represent()-&gt;iterate(\n\t\tr:String; res:String=\'|\'| res.concat(r).concat(\'|\')\n\t)\nelse \n\tself.name\nendif'"
   * @generated
   */
  String represent();

} // Connection
