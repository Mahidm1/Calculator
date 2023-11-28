package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
