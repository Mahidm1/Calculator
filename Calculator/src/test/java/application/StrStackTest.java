package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

public class StrStackTest {

  // Test 1: Check if a new stack has size 0. This is the simplest test and likely the first one
  // written.
  // To make this test pass, the StrStack constructor must initialise the size to 0.
  @Test
  public void testStackSizeWhenEmpty() {
    StrStack stack = new StrStack();
    Assertions.assertEquals(0, stack.size(), "Stack size should be 0 when empty");
  }

  // Test 2: After adding one item to the stack, the size should be 1.
  // To pass this test, the push method must increment the stack's size.
  @Test
  public void testStackSizeAfterPush() {
    StrStack stack = new StrStack();
    stack.push("test");
    Assertions.assertEquals(1, stack.size(), "Stack size should be 1 after pushing one item");
  }

  // Test 3: When an item is popped, it should be returned and the stack size should decrease.
  // To pass this test, the pop method must both return the last item and decrement the size.
  @Test
  public void testPop() {
    StrStack stack = new StrStack();
    stack.push("test");
    Assertions.assertEquals(1, stack.size(), "Stack size should be 1 after one push");
    String item = stack.pop();
    Assertions.assertEquals("test", item, "Popped item should be 'test'");
    Assertions.assertEquals(0, stack.size(), "Stack size should be 0 after one pop");
  }

  // Test 4: Popping from an empty stack should throw an EmptyStackException.
  // This test ensures the stack correctly handles underflow errors.
  // To pass, the pop method must throw an exception when the stack is empty.
  @Test
  public void testPopEmptyStackThrowsException() {
    StrStack stack = new StrStack();
    Assertions.assertThrows(EmptyStackException.class, () -> {
      stack.pop();
    }, "Popping from an empty stack should throw EmptyStackException");
  }

  // Test 5: Checking the top item should return the last item pushed without removing it.
  // To pass this test, the top method must retrieve the last item without altering the size.
  @Test
  public void testTop() {
    StrStack stack = new StrStack();
    stack.push("Mount");
    stack.push("Everest");
    String topItem = stack.top();
    Assertions.assertEquals("Everest", topItem, "The top item should be 'Everest'");
    Assertions.assertEquals(2, stack.size(), "The stack size should remain 2 after calling top");
  }

  // Test 6: Similar to test 4 but for the top method. The top method should throw an exception if
  // the stack is empty.
  // This test is to ensure that the top method doesn't allow peeking at an empty stack.
  @Test
  public void testTopEmptyStackThrowsException() {
    StrStack stack = new StrStack();
    Assertions.assertThrows(EmptyStackException.class, stack::top,
        "Calling top on an empty stack should throw EmptyStackException");
  }

}
