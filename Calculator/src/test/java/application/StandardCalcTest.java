package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StandardCalcTest {

  private StandardCalc calc;

  // Set up a new StandardCalc object before each test.
  @BeforeEach
  public void setUp() {
    calc = new StandardCalc();
  }

  // Test 1: Check if the calculator correctly adds two numbers.
  @Test
  public void testSimpleAddition() throws InvalidExpression {
    assertEquals(3, calc.evaluate("1 + 2"), 0.001, "Addition is incorrect");
  }

  // Test 2: Check if the calculator correctly subtracts one number from another.
  @Test
  public void testSimpleSubtraction() throws InvalidExpression {
    assertEquals(3, calc.evaluate("5 - 2"), 0.001, "Subtraction is incorrect");
  }

  // Test 3: Check if the calculator correctly multiplies two numbers.
  @Test
  public void testSimpleMultiplication() throws InvalidExpression {
    assertEquals(10, calc.evaluate("5 * 2"), 0.001, "Multiplication is incorrect");
  }

  // Test 4: Check if the calculator correctly divides one number by another.
  @Test
  public void testSimpleDivision() throws InvalidExpression {
    assertEquals(2.5, calc.evaluate("5 / 2"), 0.001, "Division is incorrect");
  }

  // Test 5: Verify that the calculator correctly handles expressions with parentheses.
  @Test
  public void testExpressionWithParentheses() throws InvalidExpression {
    assertEquals(10, calc.evaluate("( 3 + 2 ) * 2"), 0.001, "Parentheses handling is incorrect");
  }

  // Test 6: Ensure that the calculator throws an exception for invalid expressions.
  @Test
  public void testInvalidExpression() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("5 + * 2"));
  }

  // Test 7: Check if the calculator handles expressions with whitespaces correctly.
  @Test
  public void testExpressionWithWhitespaces() throws InvalidExpression {
    assertEquals(7, calc.evaluate(" 5 + 2 "), 0.001, "Handling of whitespaces is incorrect");
  }

  // Test 8: Ensure that the calculator throws an exception for empty expressions.
  @Test
  public void testEmptyExpression() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate(""));
  }

  // Test 9: Test if the calculator can handle a single number as an expression.
  @Test
  public void testSingleNumber() throws InvalidExpression {
    assertEquals(5, calc.evaluate("5"), 0.001, "Single number handling is incorrect");
  }

  // Test 10: Ensure that the calculator throws an exception for division by zero.
  @Test
  public void testDivisionByZero() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("5 / 0"));
  }

  // Test 11: Check if the calculator correctly identifies and throws an exception for invalid
  // characters.
  @Test
  public void testInvalidCharacters() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("5 + a"));
  }

  // Test 12: Evaluate a more complex expression involving multiple operations.
  @Test
  public void testComplexExpression() throws InvalidExpression {
    assertEquals(1, calc.evaluate("( 2 + 3 - (2 + 2) )"), 0.001,
        "Complex expression handling is incorrect");
  }

  // Test 13: Verify the correctness of the addition operation in the calculator.
  @Test
  public void testAddition() throws InvalidExpression {
    assertEquals(9, calc.evaluate("4 + 5"), "Addition operation is incorrect");
  }

  // Test 14: Verify the correctness of the subtraction operation in the calculator.
  @Test
  public void testSubtraction() throws InvalidExpression {
    assertEquals(1, calc.evaluate("5 - 4"), "Subtraction operation is incorrect");
  }

  // Test 15: Test the multiplication operation to ensure it calculates correctly.
  @Test
  public void testMultiplication() throws InvalidExpression {
    assertEquals(20, calc.evaluate("5 * 4"), "Multiplication operation is incorrect");
  }

  // Test 16: Check the division operation to confirm it handles division correctly.
  @Test
  public void testDivision() throws InvalidExpression {
    assertEquals(2, calc.evaluate("8 / 4"), "Division operation is incorrect");
  }

  // Test 17: Evaluate an expression with parentheses to confirm the calculator respects operation
  // precedence.
  @Test
  public void testParentheses() throws InvalidExpression {
    assertEquals(6, calc.evaluate("(1 + 2) * 2"), "Parentheses handling is incorrect");
  }
}
