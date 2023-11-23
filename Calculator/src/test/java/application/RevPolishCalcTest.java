package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RevPolishCalcTest {

  @Test
  public void evaluateSingleNumber() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(8.0f, calc.evaluate("8"), 0.001,
        "A single number should return itself");
  }

  @Test
  public void evaluateSimpleAddition() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(20.0f, calc.evaluate("10 10 +"), 0.001,
        "Should correctly evaluate addition");
  }

  @Test
  public void evaluateSimpleSubtraction() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(3.0f, calc.evaluate("7 4 -"), 0.001,
        "Should correctly evaluate subtraction");
  }

  @Test
  public void evaluateSimpleMultiplication() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(25.0f, calc.evaluate("5 5 *"), 0.001,
        "Should correctly evaluate multiplication");
  }

  @Test
  public void evaluateSimpleDivision() throws InvalidExpression {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(5.0f, calc.evaluate("20 4 /"), 0.001,
        "Should correctly evaluate division");
  }

  @Test
  public void evaluateWithUnknownOperatorThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("3 4 @");
    }, "Unknown operator should throw InvalidExpression");
  }

  @Test
  public void evaluateMalformedExpressionThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("4 +");
    }, "Malformed expression should throw InvalidExpression");
  }

  @Test
  public void evaluateDivisionByZeroThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("4 0 /");
    }, "Division by zero should throw InvalidExpression");
  }

  @Test
  public void evaluateTooManyOperandsThrowsInvalidExpression() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertThrows(InvalidExpression.class, () -> {
      calc.evaluate("8 8 8 +");
    }, "An expression with too many operands should throw InvalidExpression");
  }
}
