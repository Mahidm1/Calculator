package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RevPolishCalcTest {

  // Test 1: Evaluating a single number.
  // The first implementation of evaluate() method simply parsed and returned the number.

  @Test
  public void evaluateSingleNumber() {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("8 + 5");
    }, "Single number without operators should throw InvalidExpression");
  }

  // Test 2: Simple addition.
  // The evaluate() method was extended to handle basic addition operations.

  @Test
  public void evaluateSimpleAddition() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertEquals(20.0f, calc.evaluate("10 10 +"), 0.001,
        "Should correctly evaluate addition");
  }

  // Test 3: Simple subtraction.
  // Subtraction operation was added to the evaluate() method.

  @Test
  public void evaluateSimpleSubtraction() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertEquals(3.0f, calc.evaluate("7 4 -"), 0.001,
        "Should correctly evaluate subtraction");
  }

  // Test 4: Simple multiplication.
  // Included multiplication operation in evaluate() method.

  @Test
  public void evaluateSimpleMultiplication() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertEquals(25.0f, calc.evaluate("5 5 *"), 0.001,
        "Should correctly evaluate multiplication");
  }

  // Test 5: Simple division.
  // Division operation was implemented in evaluate().

  @Test
  public void evaluateSimpleDivision() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertEquals(5.0f, calc.evaluate("20 4 /"), 0.001,
        "Should correctly evaluate division");
  }

  // Test 6: Handling unknown operators.
  // InvalidExpression exception was added for unknown operators.

  @Test
  public void evaluateWithUnknownOperatorThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("3 4 @");
    }, "Unknown operator should throw InvalidExpression");
  }

  // Test 7: Handling malformed expressions.
  // Added check in evaluate() for incorrect format or insufficient operands.

  @Test
  public void evaluateMalformedExpressionThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("4 +");
    }, "Malformed expression should throw InvalidExpression");
  }

  // Test 8: Division by zero.
  // Added check for division by zero in evaluate().

  @Test
  public void evaluateDivisionByZeroThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("4 0 /");
    }, "Division by zero should throw InvalidExpression");
  }

  // Test 9: Too many operands.
  // Added validation in evaluate() for expressions with excess operands.

  @Test
  public void evaluateTooManyOperandsThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc();
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("8 8 8 +");
    }, "An expression with too many operands should throw InvalidExpression");
  }
}
