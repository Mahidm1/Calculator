package application;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        stack.push(new Entry(Symbol.PLUS)); // Use the PLUS symbol as an example
        Assertions.assertEquals(1, stack.size(), "The stack should have size 1 after pushing one item");
    }

}

