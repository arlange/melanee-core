/**
 */
package PLM.tests;

import PLM.Clabject;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Clabject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link PLM.Clabject#getLevelIndex() <em>Level Index</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link PLM.Clabject#getDeepModel() <em>Get Deep Model</em>}</li>
 *   <li>{@link PLM.Clabject#getSupertypes() <em>Get Supertypes</em>}</li>
 *   <li>{@link PLM.Clabject#getSupertypes(org.eclipse.emf.common.util.EList) <em>Get Supertypes</em>}</li>
 *   <li>{@link PLM.Clabject#getDirectSupertypes() <em>Get Direct Supertypes</em>}</li>
 *   <li>{@link PLM.Clabject#getSubtypes() <em>Get Subtypes</em>}</li>
 *   <li>{@link PLM.Clabject#getHollowSubtypes() <em>Get Hollow Subtypes</em>}</li>
 *   <li>{@link PLM.Clabject#getHollowSupertypes() <em>Get Hollow Supertypes</em>}</li>
 *   <li>{@link PLM.Clabject#getClassificationsAsInstance() <em>Get Classifications As Instance</em>}</li>
 *   <li>{@link PLM.Clabject#getClassificationsAsType() <em>Get Classifications As Type</em>}</li>
 *   <li>{@link PLM.Clabject#getInstances() <em>Get Instances</em>}</li>
 *   <li>{@link PLM.Clabject#getTypes() <em>Get Types</em>}</li>
 *   <li>{@link PLM.Clabject#getDirectTypes() <em>Get Direct Types</em>}</li>
 *   <li>{@link PLM.Clabject#getLevelTypes() <em>Get Level Types</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedClassificationTreeAsInstance() <em>Get Defined Classification Tree As Instance</em>}</li>
 *   <li>{@link PLM.Clabject#getClassificationTreeAsInstance() <em>Get Classification Tree As Instance</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedInstances() <em>Get Defined Instances</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedClassificationTreeAsType() <em>Get Defined Classification Tree As Type</em>}</li>
 *   <li>{@link PLM.Clabject#getClassificationTreeAsType() <em>Get Classification Tree As Type</em>}</li>
 *   <li>{@link PLM.Clabject#getClassificationTreeAsType(int) <em>Get Classification Tree As Type</em>}</li>
 *   <li>{@link PLM.Clabject#getClassificationTreeAsType(int, int) <em>Get Classification Tree As Type</em>}</li>
 *   <li>{@link PLM.Clabject#getAllFeatures() <em>Get All Features</em>}</li>
 *   <li>{@link PLM.Clabject#getAllAttributes() <em>Get All Attributes</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedAttributes() <em>Get Defined Attributes</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedAttributeByName(java.lang.String) <em>Get Defined Attribute By Name</em>}</li>
 *   <li>{@link PLM.Clabject#getAllMethods() <em>Get All Methods</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedMethods() <em>Get Defined Methods</em>}</li>
 *   <li>{@link PLM.Clabject#isInstanceOf(PLM.Clabject) <em>Is Instance Of</em>}</li>
 *   <li>{@link PLM.Clabject#isTypeOf(PLM.Clabject) <em>Is Type Of</em>}</li>
 *   <li>{@link PLM.Clabject#isContainerOf(PLM.Clabject) <em>Is Container Of</em>}</li>
 *   <li>{@link PLM.Clabject#getComposite() <em>Get Composite</em>}</li>
 *   <li>{@link PLM.Clabject#getAggregates() <em>Get Aggregates</em>}</li>
 *   <li>{@link PLM.Clabject#getParts() <em>Get Parts</em>}</li>
 *   <li>{@link PLM.Clabject#getPartsForMoniker(java.lang.String) <em>Get Parts For Moniker</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedConnections() <em>Get Defined Connections</em>}</li>
 *   <li>{@link PLM.Clabject#getConnections() <em>Get Connections</em>}</li>
 *   <li>{@link PLM.Clabject#getInheritedConnections() <em>Get Inherited Connections</em>}</li>
 *   <li>{@link PLM.Clabject#getLevelCompleteTypes() <em>Get Level Complete Types</em>}</li>
 *   <li>{@link PLM.Clabject#getLevelIncompleteTypes() <em>Get Level Incomplete Types</em>}</li>
 *   <li>{@link PLM.Clabject#getBlueprint() <em>Get Blueprint</em>}</li>
 *   <li>{@link PLM.Clabject#getOffspring() <em>Get Offspring</em>}</li>
 *   <li>{@link PLM.Clabject#getIsonyms() <em>Get Isonyms</em>}</li>
 *   <li>{@link PLM.Clabject#getHyponyms() <em>Get Hyponyms</em>}</li>
 *   <li>{@link PLM.Clabject#getDomainForConnection(PLM.Connection) <em>Get Domain For Connection</em>}</li>
 *   <li>{@link PLM.Clabject#getPossibleDomainSpecificVisualizers() <em>Get Possible Domain Specific Visualizers</em>}</li>
 *   <li>{@link PLM.Clabject#getInheritancesAsSubtype() <em>Get Inheritances As Subtype</em>}</li>
 *   <li>{@link PLM.Clabject#getInheritancesAsSupertype() <em>Get Inheritances As Supertype</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedNavigations() <em>Get Defined Navigations</em>}</li>
 *   <li>{@link PLM.Clabject#getInheritedNavigations() <em>Get Inherited Navigations</em>}</li>
 *   <li>{@link PLM.Clabject#getAllNavigations() <em>Get All Navigations</em>}</li>
 *   <li>{@link PLM.Clabject#getDomainMonikers() <em>Get Domain Monikers</em>}</li>
 *   <li>{@link PLM.Clabject#getDomainForMoniker(java.lang.String) <em>Get Domain For Moniker</em>}</li>
 *   <li>{@link PLM.Clabject#getAllNavigationsForMoniker(java.lang.String) <em>Get All Navigations For Moniker</em>}</li>
 *   <li>{@link PLM.Clabject#getAllNavigationsAsDestination() <em>Get All Navigations As Destination</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedNavigationsAsDestination() <em>Get Defined Navigations As Destination</em>}</li>
 *   <li>{@link PLM.Clabject#getInheritedNavigationsAsDestination() <em>Get Inherited Navigations As Destination</em>}</li>
 *   <li>{@link PLM.Clabject#represent() <em>Represent</em>}</li>
 *   <li>{@link PLM.Clabject#getFeatureForName(java.lang.String) <em>Get Feature For Name</em>}</li>
 *   <li>{@link PLM.Clabject#getPotencyAsString() <em>Get Potency As String</em>}</li>
 *   <li>{@link PLM.Clabject#getDisjointSiblings() <em>Get Disjoint Siblings</em>}</li>
 *   <li>{@link PLM.Clabject#getAttributeByName(java.lang.String) <em>Get Attribute By Name</em>}</li>
 *   <li>{@link PLM.Clabject#violatesMultiplicityConstraints() <em>Violates Multiplicity Constraints</em>}</li>
 *   <li>{@link PLM.Clabject#getDefinedInheritances() <em>Get Defined Inheritances</em>}</li>
 *   <li>{@link PLM.Clabject#getOwnedClabjects() <em>Get Owned Clabjects</em>}</li>
 *   <li>{@link PLM.Clabject#getDirectType() <em>Get Direct Type</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class ClabjectTest extends OwnedElementTest {

  /**
   * Constructs a new Clabject test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClabjectTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Clabject test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Clabject getFixture() {
    return (Clabject)fixture;
  }

  /**
   * Tests the '{@link PLM.Clabject#getLevelIndex() <em>Level Index</em>}' feature getter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getLevelIndex()
   * @generated
   */
  public void testGetLevelIndex() {
    // TODO: implement this feature getter test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#isSetLevelIndex() <em>isSetLevelIndex()</em>}' method.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#isSetLevelIndex()
   * @generated
   */
  public void testIsSetLevelIndex() {
    // TODO: implement this test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDeepModel() <em>Get Deep Model</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDeepModel()
   * @generated
   */
  public void testGetDeepModel() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getSupertypes() <em>Get Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getSupertypes()
   * @generated
   */
  public void testGetSupertypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getSupertypes(org.eclipse.emf.common.util.EList) <em>Get Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getSupertypes(org.eclipse.emf.common.util.EList)
   * @generated
   */
  public void testGetSupertypes__EList() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDirectSupertypes() <em>Get Direct Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDirectSupertypes()
   * @generated
   */
  public void testGetDirectSupertypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getSubtypes() <em>Get Subtypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getSubtypes()
   * @generated
   */
  public void testGetSubtypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getHollowSubtypes() <em>Get Hollow Subtypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getHollowSubtypes()
   * @generated
   */
  public void testGetHollowSubtypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getHollowSupertypes() <em>Get Hollow Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getHollowSupertypes()
   * @generated
   */
  public void testGetHollowSupertypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getClassificationsAsInstance() <em>Get Classifications As Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getClassificationsAsInstance()
   * @generated
   */
  public void testGetClassificationsAsInstance() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getClassificationsAsType() <em>Get Classifications As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getClassificationsAsType()
   * @generated
   */
  public void testGetClassificationsAsType() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getInstances() <em>Get Instances</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getInstances()
   * @generated
   */
  public void testGetInstances() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getTypes() <em>Get Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getTypes()
   * @generated
   */
  public void testGetTypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDirectTypes() <em>Get Direct Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDirectTypes()
   * @generated
   */
  public void testGetDirectTypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getLevelTypes() <em>Get Level Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getLevelTypes()
   * @generated
   */
  public void testGetLevelTypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedClassificationTreeAsInstance() <em>Get Defined Classification Tree As Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedClassificationTreeAsInstance()
   * @generated
   */
  public void testGetDefinedClassificationTreeAsInstance() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getClassificationTreeAsInstance() <em>Get Classification Tree As Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getClassificationTreeAsInstance()
   * @generated
   */
  public void testGetClassificationTreeAsInstance() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedInstances() <em>Get Defined Instances</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedInstances()
   * @generated
   */
  public void testGetDefinedInstances() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedClassificationTreeAsType() <em>Get Defined Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedClassificationTreeAsType()
   * @generated
   */
  public void testGetDefinedClassificationTreeAsType() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getClassificationTreeAsType() <em>Get Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getClassificationTreeAsType()
   * @generated
   */
  public void testGetClassificationTreeAsType() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getClassificationTreeAsType(int) <em>Get Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getClassificationTreeAsType(int)
   * @generated
   */
  public void testGetClassificationTreeAsType__int() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getClassificationTreeAsType(int, int) <em>Get Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getClassificationTreeAsType(int, int)
   * @generated
   */
  public void testGetClassificationTreeAsType__int_int() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAllFeatures() <em>Get All Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAllFeatures()
   * @generated
   */
  public void testGetAllFeatures() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAllAttributes() <em>Get All Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAllAttributes()
   * @generated
   */
  public void testGetAllAttributes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedAttributes() <em>Get Defined Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedAttributes()
   * @generated
   */
  public void testGetDefinedAttributes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedAttributeByName(java.lang.String) <em>Get Defined Attribute By Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedAttributeByName(java.lang.String)
   * @generated
   */
  public void testGetDefinedAttributeByName__String() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAllMethods() <em>Get All Methods</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAllMethods()
   * @generated
   */
  public void testGetAllMethods() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedMethods() <em>Get Defined Methods</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedMethods()
   * @generated
   */
  public void testGetDefinedMethods() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#isInstanceOf(PLM.Clabject) <em>Is Instance Of</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#isInstanceOf(PLM.Clabject)
   * @generated
   */
  public void testIsInstanceOf__Clabject() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#isTypeOf(PLM.Clabject) <em>Is Type Of</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#isTypeOf(PLM.Clabject)
   * @generated
   */
  public void testIsTypeOf__Clabject() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#isContainerOf(PLM.Clabject) <em>Is Container Of</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#isContainerOf(PLM.Clabject)
   * @generated
   */
  public void testIsContainerOf__Clabject() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getComposite() <em>Get Composite</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getComposite()
   * @generated
   */
  public void testGetComposite() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAggregates() <em>Get Aggregates</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAggregates()
   * @generated
   */
  public void testGetAggregates() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getParts() <em>Get Parts</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getParts()
   * @generated
   */
  public void testGetParts() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getPartsForMoniker(java.lang.String) <em>Get Parts For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getPartsForMoniker(java.lang.String)
   * @generated
   */
  public void testGetPartsForMoniker__String() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedConnections() <em>Get Defined Connections</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedConnections()
   * @generated
   */
  public void testGetDefinedConnections() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getConnections() <em>Get Connections</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getConnections()
   * @generated
   */
  public void testGetConnections() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getInheritedConnections() <em>Get Inherited Connections</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getInheritedConnections()
   * @generated
   */
  public void testGetInheritedConnections() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getLevelCompleteTypes() <em>Get Level Complete Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getLevelCompleteTypes()
   * @generated
   */
  public void testGetLevelCompleteTypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getLevelIncompleteTypes() <em>Get Level Incomplete Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getLevelIncompleteTypes()
   * @generated
   */
  public void testGetLevelIncompleteTypes() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getBlueprint() <em>Get Blueprint</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getBlueprint()
   * @generated
   */
  public void testGetBlueprint() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getOffspring() <em>Get Offspring</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getOffspring()
   * @generated
   */
  public void testGetOffspring() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getIsonyms() <em>Get Isonyms</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getIsonyms()
   * @generated
   */
  public void testGetIsonyms() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getHyponyms() <em>Get Hyponyms</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getHyponyms()
   * @generated
   */
  public void testGetHyponyms() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDomainForConnection(PLM.Connection) <em>Get Domain For Connection</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDomainForConnection(PLM.Connection)
   * @generated
   */
  public void testGetDomainForConnection__Connection() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getPossibleDomainSpecificVisualizers() <em>Get Possible Domain Specific Visualizers</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getPossibleDomainSpecificVisualizers()
   * @deprecated See {@link PLM.Clabject#getPossibleDomainSpecificVisualizers() model documentation} for details.
   * @generated
   */
  @Deprecated
  public void testGetPossibleDomainSpecificVisualizers() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getInheritancesAsSubtype() <em>Get Inheritances As Subtype</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getInheritancesAsSubtype()
   * @generated
   */
  public void testGetInheritancesAsSubtype() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getInheritancesAsSupertype() <em>Get Inheritances As Supertype</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getInheritancesAsSupertype()
   * @generated
   */
  public void testGetInheritancesAsSupertype() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedNavigations() <em>Get Defined Navigations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedNavigations()
   * @generated
   */
  public void testGetDefinedNavigations() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getInheritedNavigations() <em>Get Inherited Navigations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getInheritedNavigations()
   * @generated
   */
  public void testGetInheritedNavigations() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAllNavigations() <em>Get All Navigations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAllNavigations()
   * @generated
   */
  public void testGetAllNavigations() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDomainMonikers() <em>Get Domain Monikers</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDomainMonikers()
   * @generated
   */
  public void testGetDomainMonikers() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDomainForMoniker(java.lang.String) <em>Get Domain For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDomainForMoniker(java.lang.String)
   * @deprecated
   * @generated
   */
  @Deprecated
  public void testGetDomainForMoniker__String() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAllNavigationsForMoniker(java.lang.String) <em>Get All Navigations For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAllNavigationsForMoniker(java.lang.String)
   * @generated
   */
  public void testGetAllNavigationsForMoniker__String() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAllNavigationsAsDestination() <em>Get All Navigations As Destination</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAllNavigationsAsDestination()
   * @generated
   */
  public void testGetAllNavigationsAsDestination() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedNavigationsAsDestination() <em>Get Defined Navigations As Destination</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedNavigationsAsDestination()
   * @generated
   */
  public void testGetDefinedNavigationsAsDestination() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getInheritedNavigationsAsDestination() <em>Get Inherited Navigations As Destination</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getInheritedNavigationsAsDestination()
   * @generated
   */
  public void testGetInheritedNavigationsAsDestination() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#represent()
   * @generated
   */
  public void testRepresent() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getFeatureForName(java.lang.String) <em>Get Feature For Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getFeatureForName(java.lang.String)
   * @generated
   */
  public void testGetFeatureForName__String() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getPotencyAsString() <em>Get Potency As String</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getPotencyAsString()
   * @generated
   */
  public void testGetPotencyAsString() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDisjointSiblings() <em>Get Disjoint Siblings</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDisjointSiblings()
   * @generated
   */
  public void testGetDisjointSiblings() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getAttributeByName(java.lang.String) <em>Get Attribute By Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getAttributeByName(java.lang.String)
   * @generated
   */
  public void testGetAttributeByName__String() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#violatesMultiplicityConstraints() <em>Violates Multiplicity Constraints</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#violatesMultiplicityConstraints()
   * @generated
   */
  public void testViolatesMultiplicityConstraints() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDefinedInheritances() <em>Get Defined Inheritances</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDefinedInheritances()
   * @generated
   */
  public void testGetDefinedInheritances() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getOwnedClabjects() <em>Get Owned Clabjects</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getOwnedClabjects()
   * @generated
   */
  public void testGetOwnedClabjects() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

  /**
   * Tests the '{@link PLM.Clabject#getDirectType() <em>Get Direct Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Clabject#getDirectType()
   * @generated
   */
  public void testGetDirectType() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //ClabjectTest
