package application;

/**
 * This class provides functionality to evaluate expressions written in reverse Polish notation.
 */
public class RevPolishCalc {
  private NumStack numStack;

  /**
   * Constructs a RevPolishCalc with a given NumStack.
   */
  public RevPolishCalc() {
    this.numStack = new NumStack();
  }

  /**
   * Evaluates a reverse Polish notation expression.
   * 
   * @param expression The expression to evaluate.
   * @return The result of the evaluated expression.
   * @throws InvalidExpression If the expression is invalid or malformed.
   */
  public float evaluate(String expression) throws InvalidExpression {
    String[] tokens = expression.split("\\s+");
    for (String token : tokens) {
      // Handle numbers
      if (token.matches("-?\\d+(\\.\\d+)?")) {
        numStack.push(Float.parseFloat(token));
      } else {
        // Check if there are enough operands on the stack
        if (numStack.size() < 2) {
          throw new InvalidExpression(
              "Malformed expression: insufficient operands for operator " + token);
        }

        // Pop operands and perform the operation
        float secondOperand = numStack.pop();
        float firstOperand = numStack.pop();
        switch (token) {
          case "+":
            numStack.push(firstOperand + secondOperand);
            break;
          case "-":
            numStack.push(firstOperand - secondOperand);
            break;
          case "*":
            numStack.push(firstOperand * secondOperand);
            break;
          case "/":
            if (secondOperand == 0) {
              throw new InvalidExpression("Division by zero");
            }
            numStack.push(firstOperand / secondOperand);
            break;
          default:
            throw new InvalidExpression("Unknown operator: " + token);
        }
      }
    }

    // Check for malformed expressions
    if (numStack.size() != 1) {
      throw new InvalidExpression("Malformed expression: too many operands");
    }

    return numStack.pop();
  }
}
