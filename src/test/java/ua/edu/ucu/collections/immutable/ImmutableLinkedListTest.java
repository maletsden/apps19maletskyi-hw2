package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest extends ImmutableArrayListTest {
    private static final Object[] basicArray = {1, 2.0, "abc", 'd'};
    private static final ImmutableLinkedList testArray = new ImmutableLinkedList(basicArray);

    public ImmutableLinkedListTest() {
        super.testArray = new ImmutableLinkedList(basicArray);
    }

    @Test
    public void testLinkedListFromEmptyArray() {
        Object[] expectedResult = new Object[0];

        ImmutableList emptyList = new ImmutableLinkedList(expectedResult);

        assertArrayEquals(expectedResult, emptyList.toArray());
    }

    @Test
    public void testAddFirst() {
        Object[] expectedResult = {0, 1, 2.0, "abc", 'd'};
        int value = 0;

        ImmutableLinkedList modifiedArray = testArray.addFirst(value);

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test
    public void testSet() {
        System.out.println("set");
        super.testSet();
    }


    @Test
    public void testAddLast() {
        Object[] expectedResult = {1, 2.0, "abc", 'd', 5};
        int value = 5;

        ImmutableLinkedList modifiedArray = testArray.addLast(value);

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test
    public void testGetFirst() {
        int expectedResult = 1;

        Object result = testArray.getFirst();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetLast() {
        char expectedResult = 'd';

        Object result = testArray.getLast();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testRemoveFirst() {
        Object[] expectedResult = {2.0, "abc", 'd'};

        ImmutableLinkedList modifiedArray = testArray.removeFirst();

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test
    public void testRemoveLast() {
        Object[] expectedResult = {1, 2.0, "abc"};

        ImmutableLinkedList modifiedArray = testArray.removeLast();

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }
}
