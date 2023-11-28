package application;

import java.util.EmptyStackException;

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

  public String pop() {
    if (this.stack.size() == 0) {
      throw new EmptyStackException();
    }
    return this.stack.pop().getString();
  }

}
