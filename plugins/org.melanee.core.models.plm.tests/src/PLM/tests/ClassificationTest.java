/**
 */
package PLM.tests;

import PLM.Classification;
import PLM.PLMFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Classification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link PLM.Classification#represent() <em>Represent</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ClassificationTest extends CorrelationTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ClassificationTest.class);
  }

  /**
   * Constructs a new Classification test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Classification test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Classification getFixture() {
    return (Classification)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(PLMFactory.eINSTANCE.createClassification());
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
   * Tests the '{@link PLM.Classification#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.Classification#represent()
   * @generated
   */
  public void testRepresent() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //ClassificationTest
