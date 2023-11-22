package application;

public class RevPolishCalc {
  private Stack stack;

  public RevPolishCalc(Stack stack) {
    this.stack = stack;
  }

  public float evaluate(String expression) {
    stack.push(new Entry(Float.parseFloat(expression)));
    return stack.pop().getValue();
  }
}
