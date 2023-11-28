package application;

/**
 * This class provides functionality to evaluate expressions written in reverse Polish notation.
 */
public class RevPolishCalc {
  private Stack stack;

  /**
   * Constructs a RevPolishCalc with a given stack.
   * 
   * @param stack The stack used for evaluating expressions.
   */
  public RevPolishCalc(Stack stack) {
    this.stack = stack;
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
        stack.push(new Entry(Float.parseFloat(token)));
      } else {
        // Check if there are enough operands on the stack
        if (stack.size() < 2) {
          throw new InvalidExpression(
              "Malformed expression: insufficient operands for operator " + token);
        }

        // Pop operands and perform the operation
        float secondOperand = stack.pop().getValue();
        float firstOperand = stack.pop().getValue();
        switch (token) {
          case "+":
            stack.push(new Entry(firstOperand + secondOperand));
            break;
          case "-":
            stack.push(new Entry(firstOperand - secondOperand));
            break;
          case "*":
            stack.push(new Entry(firstOperand * secondOperand));
            break;
          case "/":
            if (secondOperand == 0) {
              throw new InvalidExpression("Division by zero");
            }
            stack.push(new Entry(firstOperand / secondOperand));
            break;
          default:
            throw new InvalidExpression("Unknown operator: " + token);
        }
      }
    }

    // Check for malformed expressions
    if (stack.size() != 1) {
      throw new InvalidExpression("Malformed expression: too many operands");
    }

    return stack.pop().getValue();
  }
}
