/**
 */
package PLM.tests;

import PLM.Entity;
import PLM.PLMFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link PLM.Entity#represent() <em>Represent</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EntityTest extends ClabjectTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(EntityTest.class);
  }

  /**
   * Constructs a new Entity test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Entity test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Entity getFixture() {
    return (Entity)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(PLMFactory.eINSTANCE.createEntity());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception {
    setFixture(null);
  }

  /**
   * Tests the '{@link PLM.Entity#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Entity#represent()
   * @generated
   */
  public void testRepresent() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //EntityTest
