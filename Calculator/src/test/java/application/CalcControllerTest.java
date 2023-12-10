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

  // Test 1: Test if CalcController correctly handles calculation for infix expressions.
  // This was the first test written in TDD. To make this test pass, handleCalculation method was implemented
  // in CalcController to use CalcModel's evaluate method for infix expressions.
  @Test
  public void testHandleCalculationInfix() {
    mockView.expression = "3 + 2"; 
    mockView.setType(OpType.STANDARD); 
    controller.handleCalculation(); 
    assertEquals("5.00", mockView.answer, "Calculation for infix expression is incorrect");
  }

  // Test 2: Test if CalcController correctly handles calculation for RPN expressions.
  // This was the second test written. To pass this test, modifications were made in handleCalculation
  // to support RPN evaluations, including setting the isUsingInfix flag based on the type.
  @Test
  public void testHandleCalculationRPN() {
    mockView.expression = "3 2 +"; 
    mockView.setType(OpType.REV_POLISH); 
    controller.handleCalculation(); 
    assertEquals("5.00", mockView.answer, "Calculation for RPN expression is incorrect");
  }
}
