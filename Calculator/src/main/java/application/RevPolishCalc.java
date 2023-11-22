package application;

public class RevPolishCalc {
  private Stack stack;

  public RevPolishCalc(Stack stack) {
    this.stack = stack;
  }

  public float evaluate(String expression) {
    String[] tokens = expression.split("\\s+");
    for (String token : tokens) {
      if (token.matches("-?\\d+(\\.\\d+)?")) {
        stack.push(new Entry(Float.parseFloat(token)));
      } else {
        float secondOperand = stack.pop().getValue();
        float firstOperand = stack.pop().getValue();
        switch (token) {
          case "+":
            stack.push(new Entry(firstOperand + secondOperand));
            break;
        }
      }
    }
    return stack.pop().getValue();
  }
}
