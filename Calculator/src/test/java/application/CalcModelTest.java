package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcModelTest {

  private CalcModel calcModel;

  @BeforeEach
  public void setUp() {
    calcModel = new CalcModel();
  }

  // Test 1: Check if the CalcModel correctly evaluates a simple infix expression.
  @Test
  public void testEvaluateWithInfixExpression() throws InvalidExpression {
    assertEquals(5.0, calcModel.evaluate("3 + 2", true), "Infix evaluation is incorrect");
  }

  // Test 2: Check if the CalcModel correctly evaluates a simple RPN expression.
  @Test
  public void testEvaluateWithRPNExpression() throws InvalidExpression {
    assertEquals(5.0, calcModel.evaluate("3 2 +", false), "RPN evaluation is incorrect");
  }

  // Test 3: Verify that an InvalidExpression exception is thrown for incomplete expressions.
  @Test
  public void testEvaluateInvalidExpression() {
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("3 +", true),
        "Evaluation should throw InvalidExpression for incomplete expressions");
  }

  // Test 4: Ensure division by zero in infix expressions is handled as an InvalidExpression.
  @Test
  public void testEvaluateDivisionByZeroInInfix() {
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("10 / 0", true),
        "Evaluation should throw InvalidExpression for division by zero");
  }

  // Test 5: Ensure division by zero in RPN expressions is handled as an InvalidExpression.
  @Test
  public void testEvaluateDivisionByZeroInRPN() {
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("10 0 /", false),
        "Evaluation should throw InvalidExpression for division by zero");
  }

  // Test 6: Test the evaluation of a more complex infix expression.
  @Test
  public void testComplexInfixEvaluation() throws InvalidExpression {
    assertEquals(15, calcModel.evaluate("(3 + 6) * (10 / 5) - 3", true), 0.001,
        "Complex infix evaluation is incorrect");
  }

  // Test 7: Test the evaluation of a more complex RPN expression.
  @Test
  public void testComplexRPNEvaluation() throws InvalidExpression {
    assertEquals(15, calcModel.evaluate("3 6 + 10 5 / * 3 -", false), 0.001,
        "Complex RPN evaluation is incorrect");
  }
}
