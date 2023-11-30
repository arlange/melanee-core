/**
 */
package PLM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Connection End Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see PLM.PLMPackage#getConnectionEndKind()
 * @model
 * @generated
 */
public enum ConnectionEndKind implements Enumerator {
  /**
   * The '<em><b>Basic</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BASIC_VALUE
   * @generated
   * @ordered
   */
  BASIC(0, "Basic", "Basic"),

  /**
   * The '<em><b>Aggregation</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AGGREGATION_VALUE
   * @generated
   * @ordered
   */
  AGGREGATION(1, "Aggregation", "Aggregation"),

  /**
   * The '<em><b>Composition</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPOSITION_VALUE
   * @generated
   * @ordered
   */
  COMPOSITION(2, "Composition", "Composition");

  /**
   * The '<em><b>Basic</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Basic</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BASIC
   * @model name="Basic"
   * @generated
   * @ordered
   */
  public static final int BASIC_VALUE = 0;

  /**
   * The '<em><b>Aggregation</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Aggregation</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AGGREGATION
   * @model name="Aggregation"
   * @generated
   * @ordered
   */
  public static final int AGGREGATION_VALUE = 1;

  /**
   * The '<em><b>Composition</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Composition</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPOSITION
   * @model name="Composition"
   * @generated
   * @ordered
   */
  public static final int COMPOSITION_VALUE = 2;

  /**
   * An array of all the '<em><b>Connection End Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ConnectionEndKind[] VALUES_ARRAY =
    new ConnectionEndKind[] {
      BASIC,
      AGGREGATION,
      COMPOSITION,
    };

  /**
   * A public read-only list of all the '<em><b>Connection End Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ConnectionEndKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Connection End Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ConnectionEndKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ConnectionEndKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Connection End Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ConnectionEndKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ConnectionEndKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Connection End Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ConnectionEndKind get(int value) {
    switch (value) {
      case BASIC_VALUE: return BASIC;
      case AGGREGATION_VALUE: return AGGREGATION;
      case COMPOSITION_VALUE: return COMPOSITION;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ConnectionEndKind(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }
  
} //ConnectionEndKind
