package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private static final Object[] basicArray = {1, 2.0, "abc", 'd'};
    private static Queue testQueue;

    @Before
    public void testBefore() {
        testQueue = new Queue(basicArray);
        assertArrayEquals(basicArray, testQueue.toArray());
    }

    @Test
    public void testEmptyQueue() {
        Object[] expectedResult = new Object[0];
        Queue emptyQueue = new Queue();
        assertArrayEquals(expectedResult, emptyQueue.toArray());
    }

    @Test
    public void testPeek() {
        int expectedResult = 1;

        Object result = testQueue.peek();

        assertEquals(expectedResult, result);
        assertArrayEquals(basicArray, testQueue.toArray());
    }

    @Test
    public void testDequeue() {
        Object[] expectedQueue = {2.0, "abc", 'd'};
        int expectedResult = 1;

        Object result = testQueue.dequeue();

        assertEquals(expectedResult, result);
        assertArrayEquals(expectedQueue, testQueue.toArray());
    }

    @Test
    public void testEnqueue() {
        Object[] expectedResult = {1, 2.0, "abc", 'd', 5};
        int value = 5;

        testQueue.enqueue(value);

        assertArrayEquals(expectedResult, testQueue.toArray());
    }
}
