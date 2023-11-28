package application;

public class StrStack {
  private Stack stack;

  public StrStack() {
    this.stack = new Stack();
  }

  public int size() {
    return this.stack.size();
  }

  public void push(String item) {
    this.stack.push(new Entry(item));
  }

}
