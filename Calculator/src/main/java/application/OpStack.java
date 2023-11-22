package application;

import java.util.EmptyStackException;

/**
 * The OpStack class represents a stack data structure specifically for handling Entry objects. It
 * offers basic stack operations such as push, pop, and peek (top).
 */
public class OpStack {
  private Stack opStack;

  /**
   * Constructor for OpStack. Initialises a new Stack.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Returns the number of entries in the stack.
   * 
   * @return The size of the stack.
   */
  public int size() {
    return opStack.size();
  }

  /**
   * Pushes an entry onto the top of the stack.
   * 
   * @param entry The Entry object to be pushed onto the stack.
   */
  public void push(Entry entry) {
    opStack.push(entry);
  }

  /**
   * Removes and returns the top entry from the stack.
   * 
   * @return The Entry object at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry pop() {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.pop();
  }

  /**
   * Retrieves, but does not remove, the top entry of the stack.
   * 
   * @return The Entry object at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry top() {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.top();
  }
}
