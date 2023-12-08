package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

/**
 * Test class for NumStack using TDD approach.
 */
public class TestNumStack {

  private NumStack numStack;

  /**
   * Set up the test environment for each test, which involves creating a new NumStack.
   */
  @BeforeEach
  public void setUp() {
    numStack = new NumStack();
  }

  /**
   * Test 1: Instantiate NumStack. The first test ensures that a NumStack object can be created. To
   * pass this test, the NumStack class must exist.
   */
  @Test
  public void testCreateNumStack() {
    assertNotNull(numStack);
  }

  /**
   * Test 2: Pushing a value onto the stack. This test checks if a value can be pushed onto the
   * stack. To pass this test, implement the push(float value) method in NumStack.
   */
  @Test
  public void testPushOntoStack() {
    numStack.push(1.0f);
    assertEquals(1, numStack.size(), "Stack should have one entry after push.");
  }

  /**
   * Test 3: Popping a value from the stack. This test ensures that the correct value is popped from
   * the stack. To pass this test, implement the pop() method to return the last pushed value.
   */
  @Test
  public void testPopFromStack() {
    numStack.push(2.0f);
    assertEquals(2.0f, numStack.pop(), "Popped value should be equal to last pushed value.");
  }

  /**
   * Test 4: Popping from an empty stack throws an exception. This test ensures that popping from an
   * empty stack throws an EmptyStackException. To pass this test, the pop() method should throw
   * EmptyStackException if the stack is empty.
   */
  @Test
  public void testPopEmptyStackThrowsException() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "Popping from an empty stack should throw EmptyStackException.");
  }

  /**
   * Test 5: Peeking the top value of the stack. This test ensures that we can peek at the top value
   * of the stack without removing it. To pass this test, implement the top() method to return the
   * last pushed value without removing it.
   */
  @Test
  public void testPeekTopValue() {
    numStack.push(3.0f);
    numStack.push(4.0f);
    assertEquals(4.0f, numStack.top(), "Peeked value should be equal to last pushed value.");
    assertEquals(2, numStack.size(), "Stack size should remain unchanged after peeking.");
  }

  /**
   * Test 6: Peeking an empty stack throws an exception. This test checks that calling top() on an
   * empty stack throws an EmptyStackException. To pass this test, the top() method should throw
   * EmptyStackException if the stack is empty.
   */
  @Test
  public void testPeekEmptyStackThrowsException() {
    assertThrows(EmptyStackException.class, () -> numStack.top(),
        "Peeking an empty stack should throw EmptyStackException.");
  }

  /**
   * Test 7: Stack size after multiple operations. This test verifies the size of the stack after a
   * series of push and pop operations. To pass this test, ensure that push() and pop() correctly
   * modify the stack's size.
   */
  @Test
  public void testStackSizeAfterOperations() {
    numStack.push(5.0f);
    numStack.push(6.0f);
    numStack.pop();
    numStack.push(7.0f);
    assertEquals(2, numStack.size(),
        "Stack size should be correct after a series of pushes and pops.");
  }
}
