package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;

public class OpStackTest {

  private OpStack stack;

  @BeforeEach
  public void setUp() {
    stack = new OpStack();
  }

  // Test 1: Verify that a new stack is empty
  // This was the first test written. To make it pass, the size() method was implemented in OpStack.
  @Test
  public void newStackShouldBeEmpty() {
    Assertions.assertEquals(0, stack.size(), "A new stack should have size 0");
  }

  // Test 2: Ensure that the size increases after pushing an entry
  // This test led to the implementation of the push() method in OpStack.
  @Test
  public void sizeShouldIncreaseAfterPush() {
    stack.push(new Entry(Symbol.PLUS));
    Assertions.assertEquals(1, stack.size(), "The stack should have size 1 after pushing one item");
  }

  // Test 3: Check if popping an entry decreases the size and returns the correct entry
  // To pass this test, the pop() method was implemented with logic to handle empty stacks and
  // return the correct entry.
  @Test
  public void shouldPopCorrectEntryAndDecreaseSize() {
    Entry entry = new Entry(Symbol.PLUS);
    stack.push(entry);
    Assertions.assertEquals(1, stack.size(), "The stack should have size 1 after pushing one item");

    Entry poppedEntry = stack.pop();
    Assertions.assertEquals(entry, poppedEntry,
        "The popped entry should be the same as the pushed one");
    Assertions.assertEquals(0, stack.size(), "The stack should be empty after popping");
  }

  // Test 4: Verify that popping from an empty stack throws an exception
  // This was added to test the exception handling of the pop() method.
  @Test
  public void popOnEmptyStackShouldThrowException() {
    Assertions.assertThrows(EmptyStackException.class, () -> {
      stack.pop();
    }, "Popping from an empty stack should throw EmptyStackException");
  }

  // Test 5: Ensure the top() method returns the correct entry without removing it
  // This led to the implementation of the top() method in OpStack.
  @Test
  public void topShouldReturnCorrectEntryWithoutRemoving() {
    Entry entry = new Entry(Symbol.PLUS);
    stack.push(entry);
    Assertions.assertEquals(1, stack.size(), "The stack should have size 1 after pushing one item");

    Entry topEntry = stack.top();
    Assertions.assertEquals(entry, topEntry, "The top entry should be the same as the pushed one");
    Assertions.assertEquals(1, stack.size(),
        "The stack size should remain the same after calling top()");
  }

  // Test 6: Check if calling top() on an empty stack throws an exception
  // This was added to ensure proper exception handling in the top() method.
  @Test
  public void topOnEmptyStackShouldThrowException() {
    Assertions.assertThrows(EmptyStackException.class, () -> {
      stack.top();
    }, "Calling top on an empty stack should throw EmptyStackException");
  }
}
