package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StandardCalcTest {

  private StandardCalc calc;

  @BeforeEach
  public void setUp() {
    calc = new StandardCalc();
  }

  @Test
  public void testSimpleAddition() throws InvalidExpression {
    assertEquals(3, calc.convertToReversePolish("( 5 + 2 - 4 )"), "Addition is incorrect");
  }

  @Test
  public void testSimpleSubtraction() throws InvalidExpression {
    assertEquals(3, calc.convertToReversePolish("5 - 2"), "Subtraction is incorrect");
  }

  @Test
  public void testSimpleMultiplication() throws InvalidExpression {
    assertEquals(10, calc.convertToReversePolish("5 * 2"), "Multiplication is incorrect");
  }

  @Test
  public void testSimpleDivision() throws InvalidExpression {
    assertEquals(2.5, calc.convertToReversePolish("( 5 / 2 )"), "Division is incorrect");
  }

  @Test
  public void testExpressionWithParentheses() throws InvalidExpression {
    assertEquals(10, calc.convertToReversePolish("( 3 + 2 ) * 2"),
        "Parentheses handling is incorrect");
  }

  @Test
  public void testInvalidExpression() {
    assertThrows(InvalidExpression.class, () -> calc.convertToReversePolish("5 + * 2"));
  }

  @Test
  public void testExpressionWithWhitespaces() throws InvalidExpression {
    assertEquals(7, calc.convertToReversePolish(" 5 + 2 "), "Handling of whitespaces is incorrect");
  }

  @Test
  public void testEmptyExpression() {
    assertThrows(InvalidExpression.class, () -> calc.convertToReversePolish(""));
  }

  @Test
  public void testSingleNumber() throws InvalidExpression {
    assertEquals(5, calc.convertToReversePolish("5"), 0.001, "Single number handling is incorrect");
  }

  @Test
  public void testDivisionByZero() {
    assertThrows(InvalidExpression.class, () -> calc.convertToReversePolish("5 / 0"));
  }

  @Test
  public void testInvalidCharacters() {
    assertThrows(InvalidExpression.class, () -> calc.convertToReversePolish("5 + a"));
  }

  @Test
  public void testComplexExpression() throws InvalidExpression {
    assertEquals(1, calc.convertToReversePolish("( 2 + 3 - (2 + 2) )"), 0.001,
        "Complex expression handling is incorrect");
  }

  @Test
  public void testAddition() throws InvalidExpression {
    assertEquals(9, calc.convertToReversePolish("4 + 5"), "Addition operation is incorrect");
  }


  @Test
  public void testSubtraction() throws InvalidExpression {
    assertEquals(1, calc.convertToReversePolish("5 - 4"), "Subtraction operation is incorrect");
  }

  @Test
  public void testMultiplication() throws InvalidExpression {
    assertEquals(20, calc.convertToReversePolish("5 * 4"), "Multiplication operation is incorrect");
  }

  @Test
  public void testDivision() throws InvalidExpression {
    assertEquals(2, calc.convertToReversePolish("8 / 4"), "Division operation is incorrect");
  }

  @Test
  public void testParentheses() throws InvalidExpression {
    assertEquals(6, calc.convertToReversePolish("(1 + 2) * 2"),
        "Parentheses handling is incorrect");
  }

  @Test
  public void testInvalidCharacter() {
    assertThrows(InvalidExpression.class, () -> calc.convertToReversePolish("5 & 4"),
        "Invalid character handling is incorrect");
  }

  @Test
  public void testInvalidOperator() {
    assertThrows(InvalidExpression.class, () -> calc.convertToReversePolish("5 $ 2"),
        "Invalid operator should trigger an InvalidExpression");
  }

  @Test
  public void testIsOperator() {
    assertTrue(calc.isOperator('+'), "Plus should be recognized as an operator");
    assertTrue(calc.isOperator('-'), "Minus should be recognized as an operator");
    assertTrue(calc.isOperator('*'), "Multiplication should be recognized as an operator");
    assertTrue(calc.isOperator('/'), "Division should be recognized as an operator");
    assertTrue(calc.isOperator('('), "Opening parenthesis should be recognized as an operator");
    assertTrue(calc.isOperator(')'), "Closing parenthesis should be recognized as an operator");
    assertFalse(calc.isOperator('&'), "Ampersand should not be recognized as an operator");
  }


}
