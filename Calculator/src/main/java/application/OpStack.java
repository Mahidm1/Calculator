package application;

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

}
