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

  @Test
  public void newStackShouldBeEmpty() {
    Assertions.assertEquals(0, stack.size(), "A new stack should have size 0");
  }

  @Test
  public void sizeShouldIncreaseAfterPush() {
    stack.push(new Entry(Symbol.PLUS));
    Assertions.assertEquals(1, stack.size(), "The stack should have size 1 after pushing one item");
  }

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

  @Test
  public void popOnEmptyStackShouldThrowException() {
    Assertions.assertThrows(EmptyStackException.class, () -> {
      stack.pop();
    }, "Popping from an empty stack should throw EmptyStackException");
  }

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

  @Test
  public void topOnEmptyStackShouldThrowException() {
    Assertions.assertThrows(EmptyStackException.class, () -> {
      stack.top();
    }, "Calling top on an empty stack should throw EmptyStackException");
  }
}


