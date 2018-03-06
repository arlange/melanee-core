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
 * '<em><b>Clabject</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.plm.PLM.Clabject#getPotency
 * <em>Potency</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.Clabject#getLevelIndex <em>Level
 * Index</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.Clabject#getContent
 * <em>Content</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.Clabject#getFeature
 * <em>Feature</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getClabject()
 * @model abstract="true" annotation="Comment level\040derrived='Element
 *        container = (this.eContainer() instanceof Element) ?
 *        (Element)this.eContainer() : null;\r\n\t\t\r\n\t\twhile ( (container
 *        != null) && !(container instanceof Level) )\r\n\t\t\tcontainer =
 *        (container.eContainer() instanceof Element) ?
 *        (Element)container.eContainer() : null;\r\n\t\tif (container ==
 *        null)\r\n\t\t\treturn -1;\r\n\t\treturn (container.eContainer()
 *        instanceof DeepModel) ?
 *        ((DeepModel)container.eContainer()).getLevels().indexOf(container) :
 *        -1;'"
 * @generated
 */
public interface Clabject extends OwnedElement {
  /**
   * Returns the value of the '<em><b>Potency</b></em>' attribute. The default
   * value is <code>"1"</code>. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Potency</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Potency</em>' attribute.
   * @see #setPotency(int)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getClabject_Potency()
   * @model default="1" required="true"
   * @generated
   */
  int getPotency();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.plm.PLM.Clabject#getPotency
   * <em>Potency</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Potency</em>' attribute.
   * @see #getPotency()
   * @generated
   */
  void setPotency(int value);

  /**
   * Returns the value of the '<em><b>Level Index</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Level Index</em>' attribute isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Level Index</em>' attribute.
   * @see #isSetLevelIndex()
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getClabject_LevelIndex()
   * @model unsettable="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='let
   *        containingLevel : Level = \r\n\tself.getLevel()\r\nin\r\nlet
   *        containingDeepModel : DeepModel = \r\n\tself.getDeepModel()
   *        \r\nin\r\nif (containingLevel.oclIsUndefined() or
   *        containingDeepModel.oclIsUndefined())
   *        then\r\n\t-1\r\nelse\r\n\tcontainingDeepModel.content->indexOf(containingLevel)
   *        - 1\r\nendif'"
   * @generated
   */
  int getLevelIndex();

  /**
   * Returns whether the value of the
   * '{@link org.melanee.core.models.plm.PLM.Clabject#getLevelIndex <em>Level
   * Index</em>}' attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return whether the value of the '<em>Level Index</em>' attribute is set.
   * @see #getLevelIndex()
   * @generated
   */
  boolean isSetLevelIndex();

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
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getClabject_Content()
   * @model containment="true"
   * @generated
   */
  EList<OwnedElement> getContent();

  /**
   * Returns the value of the '<em><b>Feature</b></em>' containment reference
   * list. The list contents are of type
   * {@link org.melanee.core.models.plm.PLM.Feature}. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Feature</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getClabject_Feature()
   * @model containment="true"
   * @generated
   */
  EList<Feature> getFeature();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the ontology the clabject's model is contained in, recursing up the
   * containment path if necessary. <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='if(self.getLevel().oclIsUndefined())\r\nthen null\r\nelse
   *        \r\nself.getLevel().getDeepModel()\r\nendif'"
   * @generated
   */
  DeepModel getDeepModel();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects the clabject inherits properties from. A model
   * supertype is a clabject reachable through generalization supertypes. <!--
   * end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let directResult:OrderedSet(Clabject)
   *        =\r\n\tself.getDirectSupertypes()->asOrderedSet()\r\nin\r\n--Start
   *        recursion\r\ndirectResult->iterate(c:Clabject;
   *        type:OrderedSet(Clabject) =
   *        directResult|\r\n\ttype->union(c.getSupertypes(directResult))->asOrderedSet()\r\n)'"
   * @generated
   */
  EList<Clabject> getSupertypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects the clabject inherits properties from. A model
   * supertype is a clabject reachable through generalization supertypes. <!--
   * end-model-doc -->
   * 
   * @model immediateResultMany="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        directResult:OrderedSet(Clabject)
   *        =\r\n\tself.getDirectSupertypes()->asOrderedSet()\r\nin\r\n--Start
   *        recursion\r\ndirectResult->iterate(c:Clabject;
   *        type:OrderedSet(Clabject) = directResult|\r\n\tif
   *        (immediateResult->includes(c))
   *        then\r\n\t\ttype\r\n\telse\r\n\t\ttype->union(c.getSupertypes(immediateResult->union(directResult)->asOrderedSet()))->asOrderedSet()\r\n\tendif\r\n)'"
   * @generated
   */
  EList<Clabject> getSupertypes(EList<Clabject> immediateResult);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects that are supertypes in a generalization the current
   * clabejct is a subtype in. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='Inheritance.allInstances()->select(i |
   *        i.subtype.subtype->includes(self)).supertype.supertype->flatten()->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDirectSupertypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects the clabject passes properties to. A model subtype is a
   * clabject reachable through generalization subtypes. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let directResult:OrderedSet(Clabject)
   *        =\r\n\tInheritance.allInstances()->select(g |
   *        g.supertype.supertype->includes(self)).subtype.subtype->flatten()->asOrderedSet()\r\nin\r\n--Start
   *        recursion\r\ndirectResult->iterate(c:Clabject;
   *        type:OrderedSet(Clabject) =
   *        directResult|\r\n\ttype->union(c.getSubtypes())->asOrderedSet()\r\n)'"
   * @generated
   */
  EList<Clabject> getSubtypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects the clabject passes properties to. A model subtype is a
   * clabject reachable through generalization subtypes. Shallow subtypes to not
   * add additional features to a supertype. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='getSubtypes()->select(st | st.feature->forAll(f |
   *        self.feature->one(selfF | selfF.name = f.name)))'"
   * @generated
   */
  EList<Clabject> getHollowSubtypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects the clabject passes properties to. A model subtype is a
   * clabject reachable through generalization subtypes. Shallow subtypes to not
   * add additional features to a supertype. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='getSupertypes()->select(st | self.feature->forAll(f |
   *        st.feature->one(selfF | selfF.name = f.name)))'"
   * @generated
   */
  EList<Clabject> getHollowSupertypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the classifications the clabject is the instance of. <!--
   * end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='Classification.allInstances()->select(i|i.instance = self)'"
   * @generated
   */
  EList<Classification> getClassificationsAsInstance();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the classifications the clabject is the type of. <!-- end-model-doc
   * -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='Classification.allInstances()->select(i|i.type = self)'"
   * @generated
   */
  EList<Classification> getClassificationsAsType();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the clabjects that are an instance of the clabject based on
   * classification elements. A clabject i is a model instance of t if there
   * exists a classification c with c.type = t or a subtype of t and c.instance =
   * i or a supertype of i <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsType().instance->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getInstances();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the clabjects that are atype of the clabject based on
   * classification elements. A clabject t is a model type of i if there exists a
   * classification c with c.type = t or a subtype of t and c.instance = i or a
   * supertype of i <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let directTypes:OrderedSet(Clabject) =
   *        self.getClassificationsAsInstance().type->asOrderedSet()\r\nin\r\n\tdirectTypes->union(directTypes.getSupertypes()->asOrderedSet())->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the clabjects that are atype of the clabject based on
   * classification elements. Does not take inheritance into account. <!--
   * end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsInstance().type->asOrderedSet()\r\n'"
   * @generated
   */
  EList<Clabject> getDirectTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * Returns the types and their supertypes of the clabject only. The clabject's
   * inheritance hierarchy are not taken into account. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsInstance().type->union(self.getClassificationsAsInstance().type.getSupertypes())->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getLevelTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in
   * the type direction. In other words, all the model instances recursively
   * including their model instances. This does not take the clabject's own
   * classification hierarchy into account. The clabject is root instance in this
   * tree. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let directResult:OrderedSet(Clabject) =
   *        \r\n\tself.getLevelTypes()->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getTypes()->asOrderedSet())->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDefinedClassificationTreeAsInstance();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in
   * the type direction. In other words, all the model instances recursively
   * including their model instances. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let directResult:OrderedSet(Clabject) =
   *        \r\n\tself.getSupertypes()->append(self).getTypes()->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getTypes()->asOrderedSet())->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsInstance();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * Returns the instances and their subtypes of the clabject only. The clabject's
   * inheritance hierarchy are not taken into account. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsType().instance->union(self.getClassificationsAsType().instance.getSubtypes())->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDefinedInstances();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in
   * the instance direction. In other words, all the model instances recursively
   * including their model instances. This does not take the clabject's own
   * inheritance hierarchy into account. The clabject is root type in this tree.
   * <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let directResult:OrderedSet(Clabject) =
   *        \r\n\tself.getDefinedInstances()->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getInstances()->asOrderedSet())->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDefinedClassificationTreeAsType();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in
   * the instance direction. In other words, all the model instances recursively
   * including their model instances. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let directResult:OrderedSet(Clabject) =
   *        \r\n\tself.getSubtypes().getInstances()->asOrderedSet()->union(self.getInstances())->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getInstances()->asOrderedSet())->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsType();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in
   * the instance direction with the specified relative distance. In other words,
   * all the model instances recursively including their model instances. <!--
   * end-model-doc -->
   * 
   * @model distanceRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        classificationTree:OrderedSet(Clabject)
   *        =\r\n\tself.getClassificationTreeAsType()\r\nin\r\n-- first find
   *        instances at level with relative distance\r\nlet
   *        instances:OrderedSet(Clabject) =\r\n\tclassificationTree->select(i :
   *        Clabject | i.level - self.level = distance)\r\nin\r\n-- if relative
   *        distance did not have a result take the most concrete instances\r\nif
   *        (distance = -1 or instances->size() = 0) then\r\n\tlet
   *        maxLevel:Integer
   *        =\r\n\t\tclassificationTree.level->max()\r\n\tin\r\n\tclassificationTree->select(c
   *        | c.level = maxLevel)\r\nelse\r\n\t\tinstances\r\nendif'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsType(int distance);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in
   * the instance direction with the specified relative range between including
   * min and max. In other words, all the model instances recursively including
   * their model instances. <!-- end-model-doc -->
   * 
   * @model minRequired="true" maxRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        classificationTree:OrderedSet(Clabject)
   *        =\r\n\tself.getClassificationTreeAsType()\r\nin\r\n-- first find
   *        instances at level with relative distance\r\nlet
   *        instances:OrderedSet(Clabject) =\r\n\tclassificationTree->select(i :
   *        Clabject | i.level - self.level >= min and (i.level - self.level <=
   *        max or max = -1))\r\nin\r\n-- if relative distance did not have a
   *        result take the most concrete instances\r\nif (instances->size() = 0)
   *        then\r\n\tlet maxLevel:Integer
   *        =\r\n\t\tclassificationTree.level->max()\r\n\tin\r\n\tclassificationTree->select(c
   *        | c.level = maxLevel)\r\nelse\r\n\t\tinstances\r\nendif'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsType(int min, int max);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the features the clabject defines. That includes features
   * inherited from supertypes. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let features:OrderedSet(Feature) =
   *        \r\n\tself.getSupertypes()->including(self).feature->asOrderedSet()\r\nin\r\n\tfeatures\r\n\t\t\t->select(f
   *        | features\r\n\t\t\t\t->excluding(f)\r\n\t\t\t\t\t->forAll(f2 | f.name
   *        = f2.name implies not
   *        f.getClabject().getSubtypes()->includes(f2.getClabject())))->asOrderedSet()'"
   * @generated
   */
  EList<Feature> getAllFeatures();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the attributes the clabject defines. That includes the attributes
   * inherited from supertypes. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getAllFeatures()->select(f |
   *        f.oclIsTypeOf(Attribute)).oclAsType(Attribute)->asOrderedSet()'"
   * @generated
   */
  EList<Attribute> getAllAttributes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the features the clabject defines. That includes features
   * inherited from supertypes. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.feature->select(f |
   *        f.oclIsKindOf(Attribute)).oclAsType(Attribute)->asOrderedSet()'"
   * @generated
   */
  EList<Attribute> getDefinedAttributes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the feature with given name that is defined by the clabject <!--
   * end-model-doc -->
   * 
   * @model required="true" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.feature->select(f |
   *        f.oclIsKindOf(Attribute)).oclAsType(Attribute)->select(f | f.name =
   *        name)->first()'"
   * @generated
   */
  Attribute getDefinedAttributeByName(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the methods the clabject defines. That includes the methods
   * inherited from supertypes. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getAllFeatures()->select(f |
   *        f.oclIsTypeOf(Method)).oclAsType(Method)->asOrderedSet()'"
   * @generated
   */
  EList<Method> getAllMethods();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the features the clabject defines. That includes features
   * inherited from supertypes. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.feature->select(f |
   *        f.oclIsKindOf(Method))->asOrderedSet()'"
   * @generated
   */
  EList<Feature> getDefinedMethods();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if there is a classification connecting the clabject or a
   * supertype to the type or a subtype. In other words, if the clabject is in the
   * model instances of the type. <!-- end-model-doc -->
   * 
   * @model ordered="false" typeRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='type.getInstances()->includes(self)'"
   * @generated
   */
  boolean isInstanceOf(Clabject type);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if there is a classification connecting the instance or a
   * supertype to the clabject or a subtype. In other words, if the clabject is in
   * the model types of the instance. <!-- end-model-doc -->
   * 
   * @model ordered="false" typeRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getTypes() -> includes(type)'"
   * @generated
   */
  boolean isTypeOf(Clabject type);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the clabject is connected via a containment connectionEnd
   * with the clabject that is passed as parameter. <!-- end-model-doc -->
   * 
   * @model ordered="false" clabjectRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='clabject.getComposite()->includes(self)'"
   * @generated
   */
  boolean isContainerOf(Clabject clabject);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects by which a clabject is contained. <!-- end-model-doc
   * -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        containers:OrderedSet(Clabject)
   *        =\r\n\tself.getConnections().connectionEnd->select(p | p.destination
   *        <> self and p.kind =
   *        ConnectionEndKind::Composition).destination->asOrderedSet()\r\nin\r\n\t--no
   *        container found return null\r\n\tif (containers->size() = 0)
   *        then\r\n\t\tnull\r\n\t--return the container\r\n
   *        \telse\r\n\t\tcontainers->any(true)\r\n\tendif'"
   * @generated
   */
  Clabject getComposite();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the model the clabject is contained or owned in, recursing up the
   * containment path if necessary. <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        containers:OrderedSet(Clabject)
   *        =\r\n\tself.getConnections().connectionEnd->select(p | p.destination
   *        <> self and p.kind =
   *        ConnectionEndKind::Aggregation).destination->asOrderedSet()\r\nin\r\n\t--no
   *        container found return null\r\n\tif (containers->size() = 0)
   *        then\r\n\t\tOrderedSet(Element){}\r\n\t--return the container\r\n
   *        \telse\r\n\t\tcontainers->asOrderedSet()\r\n\tendif'"
   * @generated
   */
  EList<Clabject> getAggregates();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the model the clabject is contained or owned in, recursing up the
   * containment path if necessary. <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='--ConnectionEnds taking part in\r\nlet connectionEnds :
   *        Set(ConnectionEnd) =
   *        \r\n\tself.getConnections().connectionEnd->select(p | p.destination =
   *        self and (p.kind = ConnectionEndKind::Composition or p.kind =
   *        ConnectionEndKind::Aggregation)
   *        )->asOrderedSet()\r\nin\r\n\tconnectionEnds.connection.connectionEnd->select(p
   *        | p.destination <> self).destination->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getParts();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the model the clabject is contained or owned in, recursing up the
   * containment path if necessary. <!-- end-model-doc -->
   * 
   * @model ordered="false" nameRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='--ConnectionEnds taking part in\r\nlet connectionEnds :
   *        Set(ConnectionEnd) =
   *        \r\n\tself.getConnections().connectionEnd->select(p | p.destination =
   *        self and (p.kind = ConnectionEndKind::Composition or p.kind =
   *        ConnectionEndKind::Aggregation)
   *        )->asOrderedSet()\r\nin\r\n\tconnectionEnds.connection.connectionEnd->select(p
   *        | p.destination <> self and p.moniker =
   *        name).destination->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getPartsForMoniker(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the connections that have a connectionEnd where the clabject is the
   * destination. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='ConnectionEnd.allInstances()->select(r | r.destination =
   *        self).connection->asOrderedSet()'"
   * @generated
   */
  EList<Connection> getDefinedConnections();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the connections which have a connectionEnd where either the clabject
   * or a supertype is the destination of. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getInheritedConnections()->union(self.getDefinedConnections())->asOrderedSet()'"
   * @generated
   */
  EList<Connection> getConnections();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the connections that have a connectionEnd where a supertype of the
   * clabject is the destination of <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getSupertypes().getDefinedConnections()->asOrderedSet()'"
   * @generated
   */
  EList<Connection> getInheritedConnections();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the types of classifications where the clabject is an instance of and
   * the kind is isonym or instantiation <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsInstance()->select((kind=
   *        ClassificationKind::isonym) or (kind=
   *        ClassificationKind::instantiation)).type->asSet()'"
   * @generated
   */
  EList<Clabject> getLevelCompleteTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the types of classifications where the clabject is an instance of and
   * the kind is hyponym <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsInstance()->select(kind=
   *        ClassificationKind::hyponym).type->asSet()'"
   * @generated
   */
  EList<Clabject> getLevelIncompleteTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the type of a classification the clabject is the instance of and the
   * kind is instantiation <!-- end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        blueprints:OrderedSet(Clabject) =
   *        \r\n\tself.getClassificationsAsInstance()->select(c | c.kind=
   *        ClassificationKind::instantiation).type->asOrderedSet()\r\nin\r\n\tif
   *        blueprints->size() > 0 then \r\n\t\tblueprints->first() \r\n\telse
   *        \r\n\t\tnull \r\n\tendif'"
   * @generated
   */
  Clabject getBlueprint();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects that are the instance of classifications with kind
   * instantiation and the clabject is the type of <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsType()->select(c | c.kind =
   *        ClassificationKind::instantiation).instance->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getOffspring();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects that are the instance of classifications with kind
   * instantiation or isonym and the clabject is the type of <!-- end-model-doc
   * -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsType()->select(c | c.kind =
   *        ClassificationKind::isonym).instance->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getIsonyms();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects that are the instance of classifications with kind
   * hyponym and the clabject is the type of <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClassificationsAsType()->select(c | c.kind =
   *        ClassificationKind::hyponym).instance->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getHyponyms();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the destinations of the connectionEnds of the connection that are not
   * the clabject itself (i.e. the other participants of the connection) <!--
   * end-model-doc -->
   * 
   * @model connectionRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='connection.getDomain(self)'"
   * @generated
   */
  EList<Clabject> getDomainForConnection(Connection connection);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * 
   * @deprecated searches for domain specific visualizers that can be used for
   *             visualization <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--At first
   *        we look if a visualization descriptor is directly attached\r\nlet
   *        possibleVisualization:Set(AbstractDSLVisualizer) =
   *        \r\n\tself.visualizer.dslVisualizer->asSet()\r\nin\r\n--Now look at
   *        the superTypes if nothing is directly found\r\nlet
   *        possibleVisualizationOfLevelSupertypes:Set(AbstractDSLVisualizer)
   *        =\r\n\tif (possibleVisualization->size() = 0)
   *        then\r\n\t\tself.getSupertypes().visualizer.dslVisualizer->asSet()\r\n\telse\r\n\t\tpossibleVisualization\r\n\tendif\r\nin\r\n--Look
   *        at the level types if nothing is found\r\nif
   *        (possibleVisualizationOfLevelSupertypes->size() = 0)
   *        then\r\n\tself.getTypes().getPossibleDomainSpecificVisualizers()->asSet()\r\nelse\r\n\tpossibleVisualizationOfLevelSupertypes\r\nendif'"
   * @generated
   */
  EList<AbstractDSLVisualizer> getPossibleDomainSpecificVisualizers();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the generalizations where the clabject is (one of) the subtype <!--
   * end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='Inheritance.allInstances()->select(g|g.subtype.subtype->includes(self))'"
   * @generated
   */
  EList<Inheritance> getInheritancesAsSubtype();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the generalizations where the clabject is (one of) the supertype <!--
   * end-model-doc -->
   * 
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='Inheritance.allInstances()->select(g|g.supertype.supertype->includes(self))'"
   * @generated
   */
  EList<Inheritance> getInheritancesAsSupertype();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the connectionEnds that define a navigation for the clabject. the
   * result is ordered by the return value of getHumanReadableName invoked on the
   * returned connectionEnds. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let
   *        allConnections:OrderedSet(Connection)=\r\nConnection.allInstances()->select(c
   *        |
   *        c.getParticipants()->includes(self))->asOrderedSet()\r\nin\r\nallConnections->collect(c|
   *        if c.connectionEnd->select(r|r.destination=self)->size() = 1 then
   *        \r\n\tc.connectionEnd->reject(r|r.destination=self) else
   *        c.connectionEnd endif\r\n)->reject(p | not
   *        p.navigable)->asOrderedSet()->sortedBy(r | r.moniker())'"
   * @generated
   */
  EList<ConnectionEnd> getDefinedNavigations();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the connectionEnds that define a navigation for a supertype of the
   * clabject <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getSupertypes()->iterate(\nsuper;\nres :
   *        OrderedSet(ConnectionEnd)= OrderedSet{}
   *        |\nres->union(super.getDefinedNavigations())->asOrderedSet()\n)'"
   * @generated
   */
  EList<ConnectionEnd> getInheritedNavigations();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the connectionEnds that define a navigation either for the
   * clabject or one of its supertypes <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getDefinedNavigations()->union(self.getInheritedNavigations())->asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllNavigations();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the monikers the clabject can navigate by, i.e. the monikers of the
   * connectionEnds from allNavigations <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getAllNavigations().moniker()->asOrderedSet()'"
   * @generated
   */
  EList<String> getDomainMonikers();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * 
   * @deprecated <!-- end-model-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getDirectSupertypes()->collect(getDomainForMoniker(moniker))->asOrderedSet()->union(\r\n\tself.getDefinedNavigations()->select(r|r.moniker()
   *        = moniker).destination->asOrderedSet()\r\n)->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDomainForMoniker(String moniker);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the connectionEnds the clabject can navigate by filtered for the
   * moniker <!-- end-model-doc -->
   * 
   * @model monikerRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getAllNavigations()->select(r | r.moniker() =
   *        moniker)->asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllNavigationsForMoniker(String moniker);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all the connectionEnds either the clabject or one of its supertypes
   * is reachable by <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getDefinedNavigationsAsDestination()->union(self.getInheritedNavigationsAsDestination())->asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllNavigationsAsDestination();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all connectionEnds that the clabject is the destination of <!--
   * end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='ConnectionEnd.allInstances()->select(destination =
   *        self)->asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getDefinedNavigationsAsDestination();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all connectionEnds that the one of the clabjects supertype is the
   * destination of <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='ConnectionEnd.allInstances()->select(r|
   *        self.getSupertypes()->includes(r.destination))->asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getInheritedNavigationsAsDestination();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        self.oclIsTypeOf(Connection) then
   *        \r\n\tself.oclAsType(Connection).represent() \r\nelse
   *        \r\n\tself.oclAsType(Entity).represent() \r\nendif'"
   * @generated
   */
  String represent();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the feature with the matching name <!-- end-model-doc -->
   * 
   * @model ordered="false" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='if self.getAllFeatures()->select(f|f.name = name)->size() = 0
   *        then \r\n\tnull\r\nelse\r\n\tself.getAllFeatures()->select(f|f.name =
   *        name)->asOrderedSet()->first()\r\nendif'"
   * @generated
   */
  Feature getFeatureForName(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        (self.potency > 0) then OrderedSet{1000000, 100000, 10000, 1000, 100,
   *        10, 1}->iterate(\r\n\tdenominator : Integer; s : String =
   *        \'\'|\r\n\t\tlet numberAsString : String =
   *        \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}->at(self.potency.div(denominator).mod(10)
   *        + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\'
   *        then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif
   *        (self.potency = 0)
   *        then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n'"
   * @generated
   */
  String getPotencyAsString();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in
   * the type direction. In other words, all the model instances recursively
   * including their model instances. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='let siblings:OrderedSet(Clabject) = \r\n\t--get all disjoint
   *        generalizations in which self
   *        participates\r\n\tself.getInheritancesAsSubtype()->reject(i |
   *        i.disjoint = null or not i.disjoint)\r\n\t--from these disjoint
   *        generalization get all subtypes except
   *        self\r\n\t.subtype.subtype->reject(s |
   *        s=self)->asOrderedSet()\r\n\r\nin
   *        \r\nsiblings->union(\r\n\tsiblings->collect(s |
   *        s.getSubtypes())->asOrderedSet()\r\n)->union(\r\n\tself.getSupertypes()->reject(super
   *        | super = self)->collect(super |
   *        super.getDisjointSiblings())->asOrderedSet()\r\n)->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDisjointSiblings();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * Searches for an Attribute with given name. Inherited attributes are
   * considered if not overriden. <!-- end-model-doc -->
   * 
   * @model nameRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let
   *        foundAttributes:OrderedSet(Attribute)
   *        =\t\r\n\tself.getAllAttributes()->select(a | a.name = name)\r\nin
   *        \r\n\tif (foundAttributes->size() > 0) then
   *        \r\n\t\tfoundAttributes->first()\r\n\telse\r\n\t\tnull\r\n\tendif'"
   * @generated
   */
  Attribute getAttributeByName(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Checks
   * wether the clabjects violates multiplicity constraints defined on type level
   * with its connections <!-- end-model-doc -->
   * 
   * @model ordered="false" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='--Type-level connections are needed to check constrainsts
   *        againt\r\nlet typeLevelConnections:OrderedSet(Connection)
   *        =\r\n\tself.getTypes().getConnections()->asOrderedSet()\r\nin\r\n--Connections
   *        at instance levels are validated\r\nlet
   *        instanceLevelConnections:OrderedSet(Connection)
   *        =\r\n\tself.getConnections()\r\nin\r\n\t--Special case is if a
   *        clabject does not have any connections\r\n\tif
   *        instanceLevelConnections->size() = 0 then\r\n\t\t\t--The
   *        connectionEnds which are pointing to the wrong end are not
   *        interesting\r\n\t\t\tlet relevantTypeConnectionEnds :
   *        OrderedSet(ConnectionEnd) =\r\n\t\t\t\tif (typeLevelConnections->one(c
   *        : Connection | c.connectionEnd->select(p : ConnectionEnd |
   *        p.destination = c)->size() > 1)) then\r\n\t\t\t\t\t--Has anyone ever
   *        seen a self connection with lower = 0 on both
   *        sides?\r\n\t\t\t\t\ttypeLevelConnections.connectionEnd->asOrderedSet()\r\n\t\t\t\telse\r\n\t\t\t\t\t--Reject
   *        the connectionEnds which show to an type of this
   *        clabject\r\n\t\t\t\t\ttypeLevelConnections.connectionEnd->select(p :
   *        ConnectionEnd |
   *        p.destination.getInstances()->excludes(self))->asOrderedSet()\r\n\t\t\t\tendif\r\n\t\t\tin\r\n\t\t\t\trelevantTypeConnectionEnds->size()
   *        > 0 and relevantTypeConnectionEnds.lower->sum() >
   *        0\r\n\telse\r\n\t\tnot(\r\n\t\t\t--For all connections at the type
   *        level constraints must be valid at instance
   *        level\r\n\t\t\ttypeLevelConnections->forAll(typeConnection :
   *        Connection | \r\n\t\t\t\t--All Connections that belong to checked type
   *        Connection\r\n\t\t\t\tlet
   *        relevantInstanceLevelConnections:OrderedSet(Connection)=\r\n\t\t\t\t\tinstanceLevelConnections->select(c
   *        : Connection |
   *        c.getTypes()->includes(typeConnection))\r\n\t\t\t\tin\r\n\t\t\t\t--Get
   *        the connectionEnds connected to the instance
   *        connections\r\n\t\t\t\tlet
   *        relevantInstanceConnectionEnds:OrderedSet(ConnectionEnd) =
   *        \r\n\t\t\t\t\trelevantInstanceLevelConnections.connectionEnd->select(p
   *        : ConnectionEnd | p.destination <>
   *        self)->asOrderedSet()\r\n\t\t\t\tin\r\n\t\t\t\t--For self connections
   *        it is filtered by navigability\r\n\t\t\t\tlet
   *        relevantTypeConnectionEnd:ConnectionEnd =\r\n\t\t\t\t\t--Is the code
   *        executed on a self connection at the type level?\r\n\t\t\t\t\tif
   *        typeConnection.connectionEnd->forAll(p : ConnectionEnd | p.destination
   *        = typeConnection) then\r\n\t\t\t\t\t\t--When looking at a self
   *        connection we need to compare navigabilities to get an idicator for
   *        the right
   *        connectionEnd\r\n\t\t\t\t\t\ttypeConnection.connectionEnd->select(p :
   *        ConnectionEnd | p.navigable =
   *        relevantInstanceConnectionEnds->first().navigable)->first()\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\t--Take
   *        the opposite connectionEnd
   *        end\r\n\t\t\t\t\t\ttypeConnection.connectionEnd->reject(p :
   *        ConnectionEnd | p.destination =
   *        typeConnection)->first()\r\n\t\t\t\t\tendif\r\n\t\t\t\tin\r\n\t\t\t\tif(relevantInstanceConnectionEnds->size()
   *        = 0) then\r\n\t\t\t\t\trelevantTypeConnectionEnd.lower =
   *        0\r\n\t\t\t\telse\r\n\t\t\t\t\t--Get the sum of multiplicities from
   *        the the to the instance connections connected
   *        connectionEnds\r\n\t\t\t\t\trelevantTypeConnectionEnd.upper <> -1
   *        implies relevantInstanceConnectionEnds.upper->sum() <=
   *        relevantTypeConnectionEnd.upper\r\n\t\t\t\tendif\r\n\t\t\t)\r\n\t\t)\r\n\tendif'"
   * @generated
   */
  boolean violatesMultiplicityConstraints();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns the generalizations in which the clabject takes part either as super
   * or subtype. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='Inheritance.allInstances()->select(i |
   *        i.subtype.subtype->includes(self) or
   *        i.supertype.supertype->includes(self))->asOrderedSet()'"
   * @generated
   */
  EList<Inheritance> getDefinedInheritances();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * Returns all clabjects stored in the content trait. Does not return clabjectes
   * of owned clabjects. <!-- end-model-doc -->
   * 
   * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.content->select(oclIsKindOf(Clabject)).oclAsType(Clabject)->asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getOwnedClabjects();

} // Clabject
