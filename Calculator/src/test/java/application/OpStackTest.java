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
    
}

