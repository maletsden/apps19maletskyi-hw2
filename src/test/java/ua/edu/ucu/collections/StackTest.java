package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private static final Object[] basicArray = {1, 2.0, "abc", 'd'};
    private static Stack testStack;

    @Before
    public void testBefore() {
        testStack = new Stack(basicArray);
        assertArrayEquals(basicArray, testStack.toArray());
    }

    @Test
    public void testEmptyStack() {
        Object[] expectedResult = new Object[0];
        Stack emptyStack = new Stack();
        assertArrayEquals(expectedResult, emptyStack.toArray());
    }

    @Test
    public void testPeek() {
        char expectedResult = 'd';

        Object result = testStack.peek();

        assertEquals(expectedResult, result);
        assertArrayEquals(basicArray, testStack.toArray());
    }

    @Test
    public void testPop() {
        Object[] expectedStack = {1, 2.0, "abc"};
        char expectedResult = 'd';

        Object result = testStack.pop();

        assertEquals(expectedResult, result);
        assertArrayEquals(expectedStack, testStack.toArray());
    }

    @Test
    public void testPush() {
        Object[] expectedResult = {1, 2.0, "abc", 'd', 5};
        int value = 5;

        testStack.push(value);

        assertArrayEquals(expectedResult, testStack.toArray());
    }
}
