package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * A stack data structure that stores {@link Entry} objects.
 */
public class Stack {

  private List<Entry> entries;
  private int size;

  /**
   * Initialises an empty stack.
   */
  public Stack() {
    this.entries = new ArrayList<>();
    this.size = 0;
  }

  /**
   * Pushes an {@link Entry} onto the top of the stack.
   *
   * @param entry The entry to push onto the stack.
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++;
  }

  /**
   * Pops the top {@link Entry} from the stack and removes it from the stack.
   *
   * @return The top entry that has been removed from the stack.
   * @throws EmptyStackException If the stack is empty and there is nothing to pop.
   */
  public Entry pop() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry topEntry = entries.get(size - 1);
    entries.remove(size - 1);
    size--;
    return topEntry;
  }

  /**
   * Retrieves the top {@link Entry} from the stack without removing it.
   *
   * @return The top entry in the stack.
   * @throws EmptyStackException If the stack is empty and there is no top entry to retrieve.
   */
  public Entry top() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.get(size - 1);
  }

  /**
   * Returns the current size of the stack.
   *
   * @return The number of entries currently in the stack.
   */
  public int size() {
    return size;
  }
}
