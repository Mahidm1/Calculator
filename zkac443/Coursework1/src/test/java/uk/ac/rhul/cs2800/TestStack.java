package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the {@link Stack} class to ensure its functionality.
 */
public class TestStack {

  private Stack stack;

  /**
   * Sets up a new {@link Stack} instance before each test method is executed.
   */
  @BeforeEach
  public void setUp() {
    stack = new Stack();
  }

  /**
   * Tests that an empty stack is initialised correctly.
   */
  // test 1
  @Test
  public void testEmptyStack() {
    assertTrue(stack.size() == 0, "Expected an empty stack after initialization");
  }

  /**
   * Tests the push and pop operations on the stack.
   */
  // test 2
  @Test
  public void testPushAndPop() {
    Entry entry1 = new Entry(1);
    Entry entry2 = new Entry(2);

    stack.push(entry1);
    stack.push(entry2);

    assertEquals(2, stack.size(), "Stack size should be 2 after pushing two elements");
    assertEquals(entry2, stack.pop(),
        "Popped element should be equal to the second pushed element");
    assertEquals(1, stack.size(), "Stack size should be 1 after popping one element");
    assertEquals(entry1, stack.pop(), "Popped element should be equal to the first pushed element");
    assertEquals(0, stack.size(), "Stack size should be 0 after popping all elements");
  }

  /**
   * Tests the top operation on the stack.
   */
  // test 3
  @Test
  public void testTop() {
    Entry entry1 = new Entry(1);
    Entry entry2 = new Entry(2);

    stack.push(entry1);
    stack.push(entry2);

    assertEquals(2, stack.size(), "Stack size should be 2 after pushing two elements");
    assertEquals(entry2, stack.top(), "Top element should be equal to the last pushed element");
    assertEquals(2, stack.size(), "Stack size should remain 2 after calling top");
  }

  /**
   * Tests the pop operation on an empty stack, expecting an {@link EmptyStackException}.
   */
  // test 4
  @Test
  public void testPopOnEmptyStack() {
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

  /**
   * Tests the top operation on an empty stack, expecting an {@link EmptyStackException}.
   */
  // test 5
  @Test
  public void testTopOnEmptyStack() {
    assertThrows(EmptyStackException.class, () -> stack.top());
  }
}
