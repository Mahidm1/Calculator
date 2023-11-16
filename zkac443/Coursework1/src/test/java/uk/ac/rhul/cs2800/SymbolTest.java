package uk.ac.rhul.cs2800;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for the {@link Symbol} enum's {@link Symbol#toString()} method.
 */
public class SymbolTest {

  /**
   * Test that the {@link Symbol#toString()} method returns the expected string representation for
   * the left bracket symbol.
   */
  // test 1
  @Test
  public void testLeftBracketToString() {
    Symbol symbol = Symbol.LEFT_BRACKET;
    assertEquals("(", symbol.toString());
  }

  /**
   * Test that the {@link Symbol#toString()} method returns the expected string representation for
   * the right bracket symbol.
   */
  // test 2
  @Test
  public void testRightBracketToString() {
    Symbol symbol = Symbol.RIGHT_BRACKET;
    assertEquals(")", symbol.toString());
  }

  /**
   * Test that the {@link Symbol#toString()} method returns the expected string representation for
   * the multiplication symbol.
   */
  // test 3
  @Test
  public void testTimeToString() {
    Symbol symbol = Symbol.TIME;
    assertEquals("*", symbol.toString());
  }

  /**
   * Test that the {@link Symbol#toString()} method returns the expected string representation for
   * the division symbol.
   */
  // test 4
  @Test
  public void testDivideToString() {
    Symbol symbol = Symbol.DIVIDE;
    assertEquals("/", symbol.toString());
  }

  /**
   * Test that the {@link Symbol#toString()} method returns the expected string representation for
   * the addition symbol.
   */
  // test 5
  @Test
  public void testPlusToString() {
    Symbol symbol = Symbol.PLUS;
    assertEquals("+", symbol.toString());
  }

  /**
   * Test that the {@link Symbol#toString()} method returns the expected string representation for
   * the subtraction symbol.
   */
  // test 6
  @Test
  public void testMinusToString() {
    Symbol symbol = Symbol.MINUS;
    assertEquals("-", symbol.toString());
  }

  /**
   * Test that the {@link Symbol#toString()} method returns the expected string representation for
   * an invalid symbol.
   */
  // test 7
  @Test
  public void testInvalidToString() {
    Symbol symbol = Symbol.INVALID;
    assertEquals("Invalid", symbol.toString());
  }
}
