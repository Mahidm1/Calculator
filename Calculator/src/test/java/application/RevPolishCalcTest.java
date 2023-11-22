package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RevPolishCalcTest {

  @Test
  public void evaluateSingleNumber() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(5.0f, calc.evaluate("5"), 0.001,
        "A single number should return itself");
  }

  @Test
  public void evaluateSimpleAddition() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(7.0f, calc.evaluate("3 4 +"), 0.001,
        "Should correctly evaluate addition");
  }

  @Test
  public void evaluateSimpleSubtraction() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(1.0f, calc.evaluate("5 4 -"), 0.001,
        "Should correctly evaluate subtraction");
  }

  @Test
  public void evaluateSimpleMultiplication() {
    RevPolishCalc calc = new RevPolishCalc(new Stack());
    Assertions.assertEquals(20.0f, calc.evaluate("5 4 *"), 0.001,
        "Should correctly evaluate multiplication");
  }
}
