package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import application.StrStack;
import java.util.EmptyStackException;

public class StrStackTest {

  @Test
  public void testStackSizeWhenEmpty() {
    StrStack stack = new StrStack();
    Assertions.assertEquals(0, stack.size(), "Stack size should be 0 when empty");
  }

  @Test
  public void testStackSizeAfterPush() {
    StrStack stack = new StrStack();
    stack.push("test");
    Assertions.assertEquals(1, stack.size(), "Stack size should be 1 after pushing one item");
  }

  @Test
  public void testPop() {
    StrStack stack = new StrStack();
    stack.push("test");
    Assertions.assertEquals(1, stack.size(), "Stack size should be 1 after one push");
    String item = stack.pop();
    Assertions.assertEquals("test", item, "Popped item should be 'test'");
    Assertions.assertEquals(0, stack.size(), "Stack size should be 0 after one pop");
  }

  @Test
  public void testPopEmptyStackThrowsException() {
    StrStack stack = new StrStack();
    Assertions.assertThrows(EmptyStackException.class, () -> {
      stack.pop();
    }, "Popping from an empty stack should throw EmptyStackException");
  }
}
