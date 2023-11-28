package application;

public class StrStack {
  private Stack stack;

  public StrStack() {
    this.stack = new Stack();
  }

  public int size() {
    return this.stack.size();
  }
}
