package application;

import java.util.EmptyStackException;
import java.util.Stack;

public class OpStack {
  private Stack<Entry> opStack;

  public OpStack() {
    opStack = new Stack<>();
  }

  public int size() {
    return opStack.size();
  }

  public void push(Entry entry) {
    opStack.push(entry);
  }

  public Entry pop() {
    if (opStack.isEmpty()) {
      throw new EmptyStackException();
    }
    return opStack.pop();
  }

  public Entry top() {
    if (opStack.isEmpty()) {
      throw new EmptyStackException();
    }
    return opStack.peek();
  }
}
