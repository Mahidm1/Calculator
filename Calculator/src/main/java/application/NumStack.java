package application;

import java.util.EmptyStackException;

/**
 * A facade class for handling a stack of numbers.
 */
public class NumStack {

  private Stack numStack;

  /**
   * Constructor for NumStack.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Pushes a float value onto the stack.
   *
   * @param value The float value to be pushed onto the stack.
   */
  public void push(float value) {
    numStack.push(new Entry(value));
  }

  /**
   * Pops the top float value from the stack.
   *
   * @return The float value at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public float pop() {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.pop().getValue();
  }

  /**
   * Retrieves the top float value from the stack without removing it.
   *
   * @return The float value at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public float top() {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.top().getValue();
  }

  /**
   * Returns the size of the stack.
   *
   * @return The number of elements in the stack.
   */
  public int size() {
    return numStack.size();
  }
}
