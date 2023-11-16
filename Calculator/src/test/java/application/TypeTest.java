package application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link Type} enum to ensure its functionality.
 */
public class TypeTest {

  /**
   * Tests the {@link Type#toString()} method for the STRING type.
   */
  // test 1
  @Test
  public void testStringTypeToString() {
    Type type = Type.STRING;
    assertEquals("String", type.toString());
  }

  /**
   * Tests the {@link Type#toString()} method for the NUMBER type.
   */
  // test 2
  @Test
  public void testNumberTypeToString() {
    Type type = Type.NUMBER;
    assertEquals("Number", type.toString());
  }

  /**
   * Tests the {@link Type#toString()} method for the SYMBOL type.
   */
  // test 3
  @Test
  public void testSymbolTypeToString() {
    Type type = Type.SYMBOL;
    assertEquals("Symbol", type.toString());
  }

  /**
   * Tests the {@link Type#toString()} method for the INVALID type.
   */
  // test 4
  @Test
  public void testInvalidTypeToString() {
    Type type = Type.INVALID;
    assertEquals("Invalid", type.toString());
  }
}
