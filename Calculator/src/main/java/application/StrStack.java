package application;

import java.util.EmptyStackException;

/**
 * StrStack is a stack data structure specifically for storing strings. It provides basic stack
 * operations like push, pop, and top, along with a method to check the current size of the stack.
 */
public class StrStack {
  private Stack stack;

  /**
   * Constructs a new StrStack instance. Initialises an empty stack to hold string entries.
   */
  public StrStack() {
    this.stack = new Stack();
  }

  /**
   * Returns the current size of the stack.
   *
   * @return the number of items currently in the stack.
   */
  public int size() {
    return this.stack.size();
  }

  /**
   * Pushes a new string item onto the top of the stack.
   *
   * @param item the string item to be pushed onto the stack.
   */
  public void push(String item) {
    this.stack.push(new Entry(item));
  }

  /**
   * Removes and returns the top item from the stack. If the stack is empty, it throws an
   * EmptyStackException.
   *
   * @return the string item that was at the top of the stack.
   * @throws EmptyStackException if the stack is empty when the method is called.
   */
  public String pop() {
    if (this.stack.size() == 0) {
      throw new EmptyStackException();
    }
    return this.stack.pop().getString();
  }

  /**
   * Returns the item at the top of the stack without removing it. If the stack is empty, it throws
   * an EmptyStackException.
   *
   * @return the string item currently at the top of the stack.
   * @throws EmptyStackException if the stack is empty when the method is called.
   */
  public String top() {
    if (this.stack.size() == 0) {
      throw new EmptyStackException();
    }
    return this.stack.top().getString();
  }
}
