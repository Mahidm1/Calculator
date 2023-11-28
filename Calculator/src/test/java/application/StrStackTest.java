package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrStackTest {

    @Test
    public void testStackSizeWhenEmpty() {
        StrStack stack = new StrStack();
        Assertions.assertEquals(0, stack.size(), "Stack size should be 0 when empty");
    }
}