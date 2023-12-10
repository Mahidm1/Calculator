package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcControllerTest {

  private CalcModel calcModel;
  private MockView mockView;
  private CalcController controller;

  @BeforeEach
  public void setUp() {
    calcModel = new CalcModel();
    mockView = new MockView();
    controller = new CalcController(calcModel, mockView);
  }

  @Test
  public void testHandleCalculationInfix() {
    mockView.expression = "3 + 2";
    mockView.setType(OpType.STANDARD);
    controller.handleCalculation();
    assertEquals("5.00", mockView.answer, "Calculation for infix expression is incorrect");
  }

  @Test
  public void testHandleCalculationRPN() {
    mockView.expression = "3 2 +";
    mockView.setType(OpType.REV_POLISH);
    controller.handleCalculation();
    assertEquals("5.00", mockView.answer, "Calculation for RPN expression is incorrect");
  }
}
