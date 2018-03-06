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
 * '<em><b>Level</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.plm.PLM.Level#getContent
 * <em>Content</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLevel()
 * @model
 * @generated
 */
public interface Level extends Element {
  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference
   * list. The list contents are of type
   * {@link org.melanee.core.models.plm.PLM.OwnedElement}. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getLevel_Content()
   * @model containment="true"
   * @generated
   */
  EList<OwnedElement> getContent();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the generalizations present in the model <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.content->select(e|e.oclIsKindOf(Inheritance))->collect(g |
   *        g.oclAsType(Inheritance))->asSet()'"
   * @generated
   */
  EList<Inheritance> getAllInheritances();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the clabjects present in the model, without recursive inclusion
   * of clabjects contained in clabejcts <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.content->select(e|e.oclIsKindOf(Clabject))->collect(g |
   *        g.oclAsType(Clabject))->asSet()'"
   * @generated
   */
  EList<Clabject> getClabjects();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the entities present in the model, without recursive inclusion of
   * entities contained in entities <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.content->select(e|e.oclIsKindOf(Entity))->collect(g |
   *        g.oclAsType(Entity))->asOrderedSet()'"
   * @generated
   */
  EList<Entity> getEntities();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the connections present in the model, without recursive inclusion
   * of connections contained in clabjects <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.content->select(e|e.oclIsKindOf(Connection))->collect(g |
   *        g.oclAsType(Connection))->asOrderedSet()'"
   * @generated
   */
  EList<Connection> getConnections();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the classifications where the instance is in the model <!--
   * end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.content->select(e|e.oclIsKindOf(Classification))->collect(g
   *        | g.oclAsType(Classification))->asSet()'"
   * @generated
   */
  EList<Classification> getClassifications();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the containing ontology of the model <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='if(self.oclAsType(ecore::EObject).eContainer().oclIsUndefined())
   *        then\r\nnull\r\nelse
   *        \r\nself.oclAsType(ecore::EObject).eContainer().oclAsType(DeepModel)\r\nendif'"
   * @generated
   */
  DeepModel getDeepModel();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the model that is classified by the current model, i.e. one level
   * below <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        (self.getDeepModel().content->indexOf(self) =
   *        self.getDeepModel().content->size())
   *        then\n\tnull\nelse\n\tself.getDeepModel().content->at(self.getDeepModel().content->indexOf(self)
   *        + 1)\nendif'"
   * @generated
   */
  Level getClassifiedLevel();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the model that is classifying the current model, i.e. one level above
   * <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        (self.getDeepModel().content->indexOf(self) = 1)
   *        then\n\tnull\nelse\n\tself.getDeepModel().content->at(self.getDeepModel().content->indexOf(self)
   *        - 1)\nendif'"
   * @generated
   */
  Level getClassifyingLevel();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the level of the model <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getDeepModel().content->indexOf(self)-1'"
   * @generated
   */
  int getLevel();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the model is the topmost model <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getDeepModel().content->indexOf(self) = 1'"
   * @generated
   */
  boolean isRootLevel();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the model is the bottom model <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getDeepModel().content->indexOf(self) =
   *        self.getDeepModel().content->size()'"
   * @generated
   */
  boolean isLeafLevel();

} // Level
