/**
 */
package PLM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clabject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PLM.Clabject#getPotency <em>Potency</em>}</li>
 *   <li>{@link PLM.Clabject#getLevelIndex <em>Level Index</em>}</li>
 *   <li>{@link PLM.Clabject#getContent <em>Content</em>}</li>
 *   <li>{@link PLM.Clabject#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see PLM.PLMPackage#getClabject()
 * @model abstract="true"
 *        annotation="Comment level\040derrived='Element container = (this.eContainer() instanceof Element) ? (Element)this.eContainer() : null;\r\n\t\t\r\n\t\twhile ( (container != null) &amp;&amp; !(container instanceof Level) )\r\n\t\t\tcontainer = (container.eContainer() instanceof Element) ? (Element)container.eContainer() : null;\r\n\t\tif (container == null)\r\n\t\t\treturn -1;\r\n\t\treturn (container.eContainer() instanceof DeepModel) ? ((DeepModel)container.eContainer()).getLevels().indexOf(container) : -1;'"
 * @generated
 */
public interface Clabject extends OwnedElement {
  /**
   * Returns the value of the '<em><b>Potency</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Potency</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Potency</em>' attribute.
   * @see #setPotency(int)
   * @see PLM.PLMPackage#getClabject_Potency()
   * @model default="1" required="true"
   * @generated
   */
  int getPotency();

  /**
   * Sets the value of the '{@link PLM.Clabject#getPotency <em>Potency</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Potency</em>' attribute.
   * @see #getPotency()
   * @generated
   */
  void setPotency(int value);

  /**
   * Returns the value of the '<em><b>Level Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Level Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level Index</em>' attribute.
   * @see #isSetLevelIndex()
   * @see PLM.PLMPackage#getClabject_LevelIndex()
   * @model unsettable="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='let containingLevel : Level = \r\n\tself.getLevel()\r\nin\r\nlet containingDeepModel : DeepModel = \r\n\tself.getDeepModel() \r\nin\r\nif (containingLevel.oclIsUndefined() or containingDeepModel.oclIsUndefined()) then\r\n\t-1\r\nelse\r\n\tcontainingDeepModel.content-&gt;indexOf(containingLevel) - 1\r\nendif'"
   * @generated
   */
  int getLevelIndex();

  /**
   * Returns whether the value of the '{@link PLM.Clabject#getLevelIndex <em>Level Index</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Level Index</em>' attribute is set.
   * @see #getLevelIndex()
   * @generated
   */
  boolean isSetLevelIndex();

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link PLM.OwnedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see PLM.PLMPackage#getClabject_Content()
   * @model containment="true"
   * @generated
   */
  EList<OwnedElement> getContent();

  /**
   * Returns the value of the '<em><b>Feature</b></em>' containment reference list.
   * The list contents are of type {@link PLM.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' containment reference list.
   * @see PLM.PLMPackage#getClabject_Feature()
   * @model containment="true"
   * @generated
   */
  EList<Feature> getFeature();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the ontology the clabject's model is contained in, recursing up the containment path if necessary.
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if(self.getLevel().oclIsUndefined())\r\nthen null\r\nelse \r\nself.getLevel().getDeepModel()\r\nendif'"
   * @generated
   */
  DeepModel getDeepModel();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects the clabject inherits properties from. A model supertype is a clabject reachable through generalization supertypes.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directResult:OrderedSet(Clabject) =\r\n\tself.getDirectSupertypes()-&gt;asOrderedSet()\r\nin\r\n--Start recursion\r\ndirectResult-&gt;iterate(c:Clabject; type:OrderedSet(Clabject) = directResult|\r\n\ttype-&gt;union(c.getSupertypes(directResult))-&gt;asOrderedSet()\r\n)'"
   * @generated
   */
  EList<Clabject> getSupertypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects the clabject inherits properties from. A model supertype is a clabject reachable through generalization supertypes.
   * <!-- end-model-doc -->
   * @model immediateResultMany="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directResult:OrderedSet(Clabject) =\r\n\tself.getDirectSupertypes()-&gt;asOrderedSet()\r\nin\r\n--Start recursion\r\ndirectResult-&gt;iterate(c:Clabject; type:OrderedSet(Clabject) = directResult|\r\n\tif (immediateResult-&gt;includes(c)) then\r\n\t\ttype\r\n\telse\r\n\t\ttype-&gt;union(c.getSupertypes(immediateResult-&gt;union(directResult)-&gt;asOrderedSet()))-&gt;asOrderedSet()\r\n\tendif\r\n)'"
   * @generated
   */
  EList<Clabject> getSupertypes(EList<Clabject> immediateResult);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects that are supertypes in a generalization the current clabejct is a subtype in.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='Inheritance.allInstances()-&gt;select(i | i.subtype.subtype-&gt;includes(self)).supertype.supertype-&gt;flatten()-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDirectSupertypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects the clabject passes properties to. A model subtype is a clabject reachable through generalization subtypes.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directResult:OrderedSet(Clabject) =\r\n\tInheritance.allInstances()-&gt;select(g | g.supertype.supertype-&gt;includes(self)).subtype.subtype-&gt;flatten()-&gt;asOrderedSet()\r\nin\r\n--Start recursion\r\ndirectResult-&gt;iterate(c:Clabject; type:OrderedSet(Clabject) = directResult|\r\n\ttype-&gt;union(c.getSubtypes())-&gt;asOrderedSet()\r\n)'"
   * @generated
   */
  EList<Clabject> getSubtypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects the clabject passes properties to. A model subtype is a clabject reachable through generalization subtypes. Shallow subtypes to not add additional features to a supertype.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='getSubtypes()-&gt;select(st | st.feature-&gt;forAll(f | self.feature-&gt;one(selfF | selfF.name = f.name)))'"
   * @generated
   */
  EList<Clabject> getHollowSubtypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects the clabject passes properties to. A model subtype is a clabject reachable through generalization subtypes. Shallow subtypes to not add additional features to a supertype.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='getSupertypes()-&gt;select(st | self.feature-&gt;forAll(f | st.feature-&gt;one(selfF | selfF.name = f.name)))'"
   * @generated
   */
  EList<Clabject> getHollowSupertypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the classifications the clabject is the instance of.
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='Classification.allInstances()-&gt;select(i|i.instance = self)'"
   * @generated
   */
  EList<Classification> getClassificationsAsInstance();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the classifications the clabject is the type of.
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='Classification.allInstances()-&gt;select(i|i.type = self)'"
   * @generated
   */
  EList<Classification> getClassificationsAsType();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the clabjects that are an instance of the clabject based on classification elements.
   * A clabject i is a model instance of t if there exists a classification c with c.type = t or a subtype of t and c.instance = i or a supertype of i
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsType().instance-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getInstances();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the clabjects that are atype of the clabject based on classification elements.
   * A clabject t is a model type of i if there exists a classification c with c.type = t or a subtype of t and c.instance = i or a supertype of i
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directTypes:OrderedSet(Clabject) = self.getClassificationsAsInstance().type-&gt;asOrderedSet()\r\nin\r\n\tdirectTypes-&gt;union(directTypes.getSupertypes()-&gt;asOrderedSet())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the clabjects that are atype of the clabject based on classification elements.
   * Does not take inheritance into account.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsInstance().type-&gt;asOrderedSet()\r\n'"
   * @generated
   */
  EList<Clabject> getDirectTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Returns the types and their supertypes of the clabject only. The clabject's inheritance hierarchy are not taken into account.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsInstance().type-&gt;union(self.getClassificationsAsInstance().type.getSupertypes())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getLevelTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in the type direction. 
   * In other words, all the model instances recursively including their model instances.
   * This does not take the clabject's own classification hierarchy into account.
   * The clabject is root instance in this tree.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directResult:OrderedSet(Clabject) = \r\n\tself.getLevelTypes()-&gt;asOrderedSet()\r\nin\r\n\tdirectResult-&gt;union(directResult.getTypes()-&gt;asOrderedSet())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDefinedClassificationTreeAsInstance();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in the type direction.
   * In other words, all the model instances recursively including their model instances.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directResult:OrderedSet(Clabject) = \r\n\tself.getSupertypes()-&gt;append(self).getTypes()-&gt;asOrderedSet()\r\nin\r\n\tdirectResult-&gt;union(directResult.getTypes()-&gt;asOrderedSet())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsInstance();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Returns the instances and their subtypes of the clabject only. The clabject's inheritance hierarchy are not taken into account.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsType().instance-&gt;union(self.getClassificationsAsType().instance.getSubtypes())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDefinedInstances();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in the instance direction. 
   * In other words, all the model instances recursively including their model instances.
   * This does not take the clabject's own inheritance hierarchy into account.
   * The clabject is root type in this tree.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directResult:OrderedSet(Clabject) = \r\n\tself.getDefinedInstances()-&gt;asOrderedSet()\r\nin\r\n\tdirectResult-&gt;union(directResult.getInstances()-&gt;asOrderedSet())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDefinedClassificationTreeAsType();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in the instance direction. In other words, all the model instances recursively including their model instances.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let directResult:OrderedSet(Clabject) = \r\n\tself.getSubtypes().getInstances()-&gt;asOrderedSet()-&gt;union(self.getInstances())-&gt;asOrderedSet()\r\nin\r\n\tdirectResult-&gt;union(directResult.getInstances()-&gt;asOrderedSet())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsType();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in the instance direction with the specified relative distance. In other words, all the model instances recursively including their model instances.
   * <!-- end-model-doc -->
   * @model distanceRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let classificationTree:OrderedSet(Clabject) =\r\n\tself.getClassificationTreeAsType()\r\nin\r\n-- first find instances at level with relative distance\r\nlet instances:OrderedSet(Clabject)  =\r\n\tclassificationTree-&gt;select(i : Clabject | i.level - self.level = distance)\r\nin\r\n-- if relative distance did not have a result take the most concrete instances\r\nif (distance = -1 or instances-&gt;size() = 0) then\r\n\tlet maxLevel:Integer =\r\n\t\tclassificationTree.level-&gt;max()\r\n\tin\r\n\tclassificationTree-&gt;select(c | c.level = maxLevel)\r\nelse\r\n\t\tinstances\r\nendif'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsType(int distance);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in the instance direction with the specified relative range between including min and max. In other words, all the model instances recursively including their model instances.
   * <!-- end-model-doc -->
   * @model minRequired="true" maxRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let classificationTree:OrderedSet(Clabject) =\r\n\tself.getClassificationTreeAsType()\r\nin\r\n-- first find instances at level with relative distance\r\nlet instances:OrderedSet(Clabject)  =\r\n\tclassificationTree-&gt;select(i : Clabject |  i.level - self.level &gt;= min and  (i.level - self.level &lt;= max or max = -1))\r\nin\r\n-- if relative distance did not have a result take the most concrete instances\r\nif (instances-&gt;size() = 0) then\r\n\tlet maxLevel:Integer =\r\n\t\tclassificationTree.level-&gt;max()\r\n\tin\r\n\tclassificationTree-&gt;select(c | c.level = maxLevel)\r\nelse\r\n\t\tinstances\r\nendif'"
   * @generated
   */
  EList<Clabject> getClassificationTreeAsType(int min, int max);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the features the clabject defines. That includes features inherited from supertypes.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let features:OrderedSet(Feature) =  \r\n\tself.getSupertypes()-&gt;including(self).feature-&gt;asOrderedSet()\r\nin\r\n\tfeatures\r\n\t\t\t-&gt;select(f | features\r\n\t\t\t\t-&gt;excluding(f)\r\n\t\t\t\t\t-&gt;forAll(f2 | f.name = f2.name implies not f.getClabject().getSubtypes()-&gt;includes(f2.getClabject())))-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Feature> getAllFeatures();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the attributes the clabject defines. That includes the attributes inherited from supertypes.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getAllFeatures()-&gt;select(f | f.oclIsTypeOf(Attribute)).oclAsType(Attribute)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Attribute> getAllAttributes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the features the clabject defines. That includes features inherited from supertypes.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.feature-&gt;select(f | f.oclIsKindOf(Attribute)).oclAsType(Attribute)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Attribute> getDefinedAttributes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the feature with given name that is defined by the clabject
   * <!-- end-model-doc -->
   * @model required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.feature-&gt;select(f | f.oclIsKindOf(Attribute)).oclAsType(Attribute)-&gt;select(f | f.name = name)-&gt;first()'"
   * @generated
   */
  Attribute getDefinedAttributeByName(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the methods the clabject defines. That includes the methods inherited from supertypes.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getAllFeatures()-&gt;select(f | f.oclIsTypeOf(Method)).oclAsType(Method)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Method> getAllMethods();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the features the clabject defines. That includes features inherited from supertypes.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.feature-&gt;select(f | f.oclIsKindOf(Method))-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Feature> getDefinedMethods();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns true if there is a classification connecting the clabject or a supertype to the type or a subtype.
   * In other words, if the clabject is in the model instances of the type.
   * <!-- end-model-doc -->
   * @model ordered="false" typeRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='type.getInstances()-&gt;includes(self)'"
   * @generated
   */
  boolean isInstanceOf(Clabject type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns true if there is a classification connecting the instance or a supertype to the clabject or a subtype.
   * In other words, if the clabject is in the model types of the instance.
   * <!-- end-model-doc -->
   * @model ordered="false" typeRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getTypes() -&gt; includes(type)'"
   * @generated
   */
  boolean isTypeOf(Clabject type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns true if the clabject is connected via a containment connectionEnd with the clabject that is passed as parameter.
   * <!-- end-model-doc -->
   * @model ordered="false" clabjectRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='clabject.getComposite()-&gt;includes(self)'"
   * @generated
   */
  boolean isContainerOf(Clabject clabject);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects by which a clabject is contained.
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let containers:OrderedSet(Clabject) =\r\n\tself.getConnections().connectionEnd-&gt;select(p | p.destination &lt;&gt; self and  p.kind = ConnectionEndKind::Composition).destination-&gt;asOrderedSet()\r\nin\r\n\t--no container found return null\r\n\tif (containers-&gt;size() = 0) then\r\n\t\tnull\r\n\t--return the container\r\n \telse\r\n\t\tcontainers-&gt;any(true)\r\n\tendif'"
   * @generated
   */
  Clabject getComposite();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the model the clabject is contained or owned in, recursing up the containment path if necessary.
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let containers:OrderedSet(Clabject) =\r\n\tself.getConnections().connectionEnd-&gt;select(p | p.destination &lt;&gt; self and  p.kind = ConnectionEndKind::Aggregation).destination-&gt;asOrderedSet()\r\nin\r\n\t--no container found return null\r\n\tif (containers-&gt;size() = 0) then\r\n\t\tOrderedSet(Element){}\r\n\t--return the container\r\n \telse\r\n\t\tcontainers-&gt;asOrderedSet()\r\n\tendif'"
   * @generated
   */
  EList<Clabject> getAggregates();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the model the clabject is contained or owned in, recursing up the containment path if necessary.
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--ConnectionEnds taking part in\r\nlet connectionEnds : Set(ConnectionEnd) = \r\n\tself.getConnections().connectionEnd-&gt;select(p | p.destination = self and (p.kind = ConnectionEndKind::Composition or p.kind = ConnectionEndKind::Aggregation) )-&gt;asOrderedSet()\r\nin\r\n\tconnectionEnds.connection.connectionEnd-&gt;select(p | p.destination &lt;&gt; self).destination-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getParts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the model the clabject is contained or owned in, recursing up the containment path if necessary.
   * <!-- end-model-doc -->
   * @model ordered="false" nameRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--ConnectionEnds taking part in\r\nlet connectionEnds : Set(ConnectionEnd) = \r\n\tself.getConnections().connectionEnd-&gt;select(p | p.destination = self and (p.kind = ConnectionEndKind::Composition or p.kind = ConnectionEndKind::Aggregation) )-&gt;asOrderedSet()\r\nin\r\n\tconnectionEnds.connection.connectionEnd-&gt;select(p | p.destination &lt;&gt; self and p.moniker = name).destination-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getPartsForMoniker(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the connections that have a connectionEnd where the clabject is the destination.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='ConnectionEnd.allInstances()-&gt;select(r | r.destination = self).connection-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Connection> getDefinedConnections();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the connections which have a connectionEnd where either the clabject or a supertype is the destination of.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getInheritedConnections()-&gt;union(self.getDefinedConnections())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Connection> getConnections();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the connections that have a connectionEnd where a supertype of the clabject is the destination of
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getSupertypes().getDefinedConnections()-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Connection> getInheritedConnections();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the types of classifications where the clabject is an instance of and the kind is isonym or instantiation
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsInstance()-&gt;select((kind= ClassificationKind::isonym) or (kind= ClassificationKind::instantiation)).type-&gt;asSet()'"
   * @generated
   */
  EList<Clabject> getLevelCompleteTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the types of classifications where the clabject is an instance of and the kind is hyponym
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsInstance()-&gt;select(kind= ClassificationKind::hyponym).type-&gt;asSet()'"
   * @generated
   */
  EList<Clabject> getLevelIncompleteTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the type of a classification the clabject is the instance of and the kind is instantiation
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let blueprints:OrderedSet(Clabject) = \r\n\tself.getClassificationsAsInstance()-&gt;select(c | c.kind= ClassificationKind::instantiation).type-&gt;asOrderedSet()\r\nin\r\n\tif blueprints-&gt;size() &gt; 0 then \r\n\t\tblueprints-&gt;first() \r\n\telse \r\n\t\tnull \r\n\tendif'"
   * @generated
   */
  Clabject getBlueprint();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects that are the instance of classifications with kind instantiation and the clabject is the type of
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsType()-&gt;select(c | c.kind = ClassificationKind::instantiation).instance-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getOffspring();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects that are the instance of classifications with kind instantiation or isonym and the clabject is the type of
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsType()-&gt;select(c | c.kind = ClassificationKind::isonym).instance-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getIsonyms();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects that are the instance of classifications with kind hyponym and the clabject is the type of
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsType()-&gt;select(c | c.kind = ClassificationKind::hyponym).instance-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getHyponyms();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the destinations of the connectionEnds of the connection that are not the clabject itself (i.e. the other participants of the connection)
   * <!-- end-model-doc -->
   * @model connectionRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='connection.getDomain(self)'"
   * @generated
   */
  EList<Clabject> getDomainForConnection(Connection connection);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * @deprecated
   * searches for domain specific visualizers that can be used for visualization
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--At first we look if a visualization descriptor is directly attached\r\nlet possibleVisualization:Set(AbstractDSLVisualizer) = \r\n\tself.visualizer.dslVisualizer-&gt;asSet()\r\nin\r\n--Now look at the superTypes if nothing is directly found\r\nlet possibleVisualizationOfLevelSupertypes:Set(AbstractDSLVisualizer) =\r\n\tif (possibleVisualization-&gt;size() = 0) then\r\n\t\tself.getSupertypes().visualizer.dslVisualizer-&gt;asSet()\r\n\telse\r\n\t\tpossibleVisualization\r\n\tendif\r\nin\r\n--Look at the level types if nothing is found\r\nif (possibleVisualizationOfLevelSupertypes-&gt;size() = 0) then\r\n\tself.getTypes().getPossibleDomainSpecificVisualizers()-&gt;asSet()\r\nelse\r\n\tpossibleVisualizationOfLevelSupertypes\r\nendif'"
   * @generated
   */
  @Deprecated
  EList<AbstractDSLVisualizer> getPossibleDomainSpecificVisualizers();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the generalizations where the clabject is (one of) the subtype
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='Inheritance.allInstances()-&gt;select(g|g.subtype.subtype-&gt;includes(self))'"
   * @generated
   */
  EList<Inheritance> getInheritancesAsSubtype();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the generalizations where the clabject is (one of) the supertype
   * <!-- end-model-doc -->
   * @model kind="operation" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='Inheritance.allInstances()-&gt;select(g|g.supertype.supertype-&gt;includes(self))'"
   * @generated
   */
  EList<Inheritance> getInheritancesAsSupertype();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the connectionEnds that define a navigation for the clabject. the result is ordered by the return value of getHumanReadableName invoked on the returned connectionEnds.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let allConnections:OrderedSet(Connection)=\r\nConnection.allInstances()-&gt;select(c | c.getParticipants()-&gt;includes(self))-&gt;asOrderedSet()\r\nin\r\nallConnections-&gt;collect(c| if c.connectionEnd-&gt;select(r|r.destination=self)-&gt;size() = 1 then \r\n\tc.connectionEnd-&gt;reject(r|r.destination=self) else c.connectionEnd endif\r\n)-&gt;reject(p | not p.navigable)-&gt;asOrderedSet()-&gt;sortedBy(r | r.moniker())'"
   * @generated
   */
  EList<ConnectionEnd> getDefinedNavigations();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the connectionEnds that define a navigation for a supertype of the clabject
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getSupertypes()-&gt;iterate(\nsuper;\nres : OrderedSet(ConnectionEnd)= OrderedSet{} |\nres-&gt;union(super.getDefinedNavigations())-&gt;asOrderedSet()\n)'"
   * @generated
   */
  EList<ConnectionEnd> getInheritedNavigations();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the connectionEnds that define a navigation either for the clabject or one of its supertypes
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getDefinedNavigations()-&gt;union(self.getInheritedNavigations())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllNavigations();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the monikers the clabject can navigate by, i.e. the monikers of the connectionEnds from allNavigations
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getAllNavigations().moniker()-&gt;asOrderedSet()'"
   * @generated
   */
  EList<String> getDomainMonikers();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * @deprecated
   * <!-- end-model-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getDirectSupertypes()-&gt;collect(getDomainForMoniker(moniker))-&gt;asOrderedSet()-&gt;union(\r\n\tself.getDefinedNavigations()-&gt;select(r|r.moniker() = moniker).destination-&gt;asOrderedSet()\r\n)-&gt;asOrderedSet()'"
   * @generated
   */
  @Deprecated
  EList<Clabject> getDomainForMoniker(String moniker);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the connectionEnds the clabject can navigate by filtered for the moniker
   * <!-- end-model-doc -->
   * @model monikerRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getAllNavigations()-&gt;select(r | r.moniker() = moniker)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllNavigationsForMoniker(String moniker);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all the connectionEnds either the clabject or one of its supertypes is reachable by
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getDefinedNavigationsAsDestination()-&gt;union(self.getInheritedNavigationsAsDestination())-&gt;asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getAllNavigationsAsDestination();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all connectionEnds that the clabject is the destination of
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='ConnectionEnd.allInstances()-&gt;select(destination = self)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getDefinedNavigationsAsDestination();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns all connectionEnds that the one of the clabjects supertype is the destination of
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='ConnectionEnd.allInstances()-&gt;select(r| self.getSupertypes()-&gt;includes(r.destination))-&gt;asOrderedSet()'"
   * @generated
   */
  EList<ConnectionEnd> getInheritedNavigationsAsDestination();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation
   * <!-- end-model-doc -->
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsTypeOf(Connection) then \r\n\tself.oclAsType(Connection).represent() \r\nelse \r\n\tself.oclAsType(Entity).represent() \r\nendif'"
   * @generated
   */
  String represent();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the feature with the matching name
   * <!-- end-model-doc -->
   * @model ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.getAllFeatures()-&gt;select(f|f.name = name)-&gt;size() = 0 then \r\n\tnull\r\nelse\r\n\tself.getAllFeatures()-&gt;select(f|f.name = name)-&gt;asOrderedSet()-&gt;first()\r\nendif'"
   * @generated
   */
  Feature getFeatureForName(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns a human readable string representation
   * <!-- end-model-doc -->
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if (self.potency &gt; 0) then OrderedSet{1000000, 100000, 10000, 1000, 100, 10, 1}-&gt;iterate(\r\n\tdenominator : Integer; s : String = \'\'|\r\n\t\tlet numberAsString : String = \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}-&gt;at(self.potency.div(denominator).mod(10) + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\' then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif (self.potency = 0) then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n'"
   * @generated
   */
  String getPotencyAsString();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the clabjects reachable from the clabject through classifications in the type direction.
   * In other words, all the model instances recursively including their model instances.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let siblings:OrderedSet(Clabject) = \r\n\t--get all disjoint generalizations in which self participates\r\n\tself.getInheritancesAsSubtype()-&gt;reject(i | i.disjoint = null or not i.disjoint)\r\n\t--from these disjoint generalization get all subtypes except self\r\n\t.subtype.subtype-&gt;reject(s | s=self)-&gt;asOrderedSet()\r\n\r\nin \r\nsiblings-&gt;union(\r\n\tsiblings-&gt;collect(s | s.getSubtypes())-&gt;asOrderedSet()\r\n)-&gt;union(\r\n\tself.getSupertypes()-&gt;reject(super | super = self)-&gt;collect(super | super.getDisjointSiblings())-&gt;asOrderedSet()\r\n)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getDisjointSiblings();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Searches for an Attribute with given name. Inherited attributes are considered if not overriden.
   * <!-- end-model-doc -->
   * @model nameRequired="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let foundAttributes:OrderedSet(Attribute) =\t\r\n\tself.getAllAttributes()-&gt;select(a | a.name = name)\r\nin \r\n\tif (foundAttributes-&gt;size() &gt; 0) then \r\n\t\tfoundAttributes-&gt;first()\r\n\telse\r\n\t\tnull\r\n\tendif'"
   * @generated
   */
  Attribute getAttributeByName(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Checks wether the clabjects violates multiplicity constraints defined on type level with its connections
   * <!-- end-model-doc -->
   * @model ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--Type-level connections are needed to check constrainsts againt\r\nlet typeLevelConnections:OrderedSet(Connection) =\r\n\tself.getTypes().getConnections()-&gt;asOrderedSet()\r\nin\r\n--Connections at instance levels are validated\r\nlet instanceLevelConnections:OrderedSet(Connection) =\r\n\tself.getConnections()\r\nin\r\n\t--Special case is if a clabject does not have any connections\r\n\tif instanceLevelConnections-&gt;size() = 0 then\r\n\t\t\t--The connectionEnds which are pointing to the wrong end are not interesting\r\n\t\t\tlet relevantTypeConnectionEnds : OrderedSet(ConnectionEnd) =\r\n\t\t\t\tif (typeLevelConnections-&gt;one(c : Connection  |  c.connectionEnd-&gt;select(p : ConnectionEnd | p.destination = c)-&gt;size() &gt; 1)) then\r\n\t\t\t\t\t--Has anyone ever seen a self connection with lower = 0 on both sides?\r\n\t\t\t\t\ttypeLevelConnections.connectionEnd-&gt;asOrderedSet()\r\n\t\t\t\telse\r\n\t\t\t\t\t--Reject the connectionEnds which show to an type of this clabject\r\n\t\t\t\t\ttypeLevelConnections.connectionEnd-&gt;select(p : ConnectionEnd | p.destination.getInstances()-&gt;excludes(self))-&gt;asOrderedSet()\r\n\t\t\t\tendif\r\n\t\t\tin\r\n\t\t\t\trelevantTypeConnectionEnds-&gt;size() &gt; 0 and relevantTypeConnectionEnds.lower-&gt;sum() &gt; 0\r\n\telse\r\n\t\tnot(\r\n\t\t\t--For all connections at the type level constraints must be valid at instance level\r\n\t\t\ttypeLevelConnections-&gt;forAll(typeConnection : Connection | \r\n\t\t\t\t--All Connections that belong to checked type Connection\r\n\t\t\t\tlet relevantInstanceLevelConnections:OrderedSet(Connection)=\r\n\t\t\t\t\tinstanceLevelConnections-&gt;select(c : Connection | c.getTypes()-&gt;includes(typeConnection))\r\n\t\t\t\tin\r\n\t\t\t\t--Get the connectionEnds connected to the instance connections\r\n\t\t\t\tlet relevantInstanceConnectionEnds:OrderedSet(ConnectionEnd) = \r\n\t\t\t\t\trelevantInstanceLevelConnections.connectionEnd-&gt;select(p : ConnectionEnd | p.destination &lt;&gt; self)-&gt;asOrderedSet()\r\n\t\t\t\tin\r\n\t\t\t\t--For self connections it is filtered by navigability\r\n\t\t\t\tlet relevantTypeConnectionEnd:ConnectionEnd =\r\n\t\t\t\t\t--Is the code executed on a self connection at the type level?\r\n\t\t\t\t\tif typeConnection.connectionEnd-&gt;forAll(p : ConnectionEnd | p.destination = typeConnection) then\r\n\t\t\t\t\t\t--When looking at a self connection we need to compare navigabilities to get an idicator for the right connectionEnd\r\n\t\t\t\t\t\ttypeConnection.connectionEnd-&gt;select(p : ConnectionEnd | p.navigable = relevantInstanceConnectionEnds-&gt;first().navigable)-&gt;first()\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\t--Take the opposite connectionEnd end\r\n\t\t\t\t\t\ttypeConnection.connectionEnd-&gt;reject(p : ConnectionEnd | p.destination = typeConnection)-&gt;first()\r\n\t\t\t\t\tendif\r\n\t\t\t\tin\r\n\t\t\t\tif(relevantInstanceConnectionEnds-&gt;size() = 0) then\r\n\t\t\t\t\trelevantTypeConnectionEnd.lower = 0\r\n\t\t\t\telse\r\n\t\t\t\t\t--Get the sum of multiplicities from the the to the instance connections connected connectionEnds\r\n\t\t\t\t\trelevantTypeConnectionEnd.upper &lt;&gt; -1 implies relevantInstanceConnectionEnds.upper-&gt;sum() &lt;= relevantTypeConnectionEnd.upper\r\n\t\t\t\tendif\r\n\t\t\t)\r\n\t\t)\r\n\tendif'"
   * @generated
   */
  boolean violatesMultiplicityConstraints();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the generalizations in which the clabject takes part either as super or subtype.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='Inheritance.allInstances()-&gt;select(i | i.subtype.subtype-&gt;includes(self) or i.supertype.supertype-&gt;includes(self))-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Inheritance> getDefinedInheritances();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Returns all clabjects stored in the content trait. Does not return clabjectes of owned clabjects.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.content-&gt;select(oclIsKindOf(Clabject)).oclAsType(Clabject)-&gt;asOrderedSet()'"
   * @generated
   */
  EList<Clabject> getOwnedClabjects();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the direct type of a clabject based on the classification relationship
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getClassificationsAsInstance().type-&gt;asOrderedSet()-&gt;first()'"
   * @generated
   */
  Clabject getDirectType();

} // Clabject
