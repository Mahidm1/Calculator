package application;

public class RevPolishCalc {
  private Stack stack;

  public RevPolishCalc(Stack stack) {
    this.stack = stack;
  }

  public float evaluate(String expression) throws InvalidExpression {
    String[] tokens = expression.split("\\s+");
    for (String token : tokens) {
      if (token.matches("-?\\d+(\\.\\d+)?")) {
        stack.push(new Entry(Float.parseFloat(token)));
      } else {
        if (stack.size() < 2) {
          throw new InvalidExpression(
              "Malformed expression: insufficient operands for operator " + token);
        }

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

    if (stack.size() != 1) {
      throw new InvalidExpression("Malformed expression: too many operands");
    }

    return stack.pop().getValue();
  }
}
