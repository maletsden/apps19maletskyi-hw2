package ua.edu.ucu.collections.immutable;

import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private static final Object[] basicArray = {1, 2.0, "abc", 'd'};;
    public ImmutableList testArray = new ImmutableArrayList(basicArray);

    @Before
    public void testBeforeTestedArray() {
        assertArrayEquals(basicArray, testArray.toArray());
    }

    @Test
    public void testAdd() {
        Object[] expectedResult = {1, 2.0, "abc", 'd', 5};
        int value = 5;

        ImmutableList modifiedArray = testArray.add(value);

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test
    public void testInsert() {
        Object[] expectedResult = {1, 2.0, 3, "abc", 'd'};
        int index = 2, value = 3;

        ImmutableList modifiedArray = testArray.add(index, value);

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testInsertIndexError() {
        int index = 10, value = 3;
        testArray.add(index, value);
    }

    @Test
    public void testAddAll() {
        Object[] expectedResult = {1, 2.0, "abc", 'd', 4, 5, 6};
        Object[] arrayToAdd = {4, 5, 6};

        ImmutableList modifiedArray = testArray.addAll(arrayToAdd);

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test
    public void testInsertAll() {
        Object[] expectedResult = {1, 2.0, 3, 4.0, 5.0, "abc", 'd'};
        Object[] arrayToAdd = {3, 4.0, 5.0};
        int index = 2;

        ImmutableList modifiedArray = testArray.addAll(index, arrayToAdd);

        System.out.println(modifiedArray.toString());
        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testInsertAllIndexError() {
        Object[] arrayToAdd = {3, 4.0, 5.0};
        int index = 10;
        testArray.addAll(index, arrayToAdd);
    }

    @Test
    public void testGet() {
        Object expectedResult = "abc";
        int index = 2;

        Object result = testArray.get(index);

        assertEquals(expectedResult, result);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetIndexError() {
        int index = 10;
        testArray.get(index);
    }

    @Test
    public void testRemove() {
        Object[] expectedResult = {1, 2.0, 'd'};
        int index = 2;

        ImmutableList modifiedArray = testArray.remove(index);

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveIndexError() {
        int index = 10;
        testArray.remove(index);
    }


    @Test
    public void testSet() {
        System.out.println("set");


        Object[] expectedResult = {1, 2.0, 3, 'd'};
        int value = 3, index = 2;

        ImmutableList modifiedArray = testArray.set(index, value);

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetIndexError() {
        int value = 3, index = 10;
        testArray.set(index, value);
    }

    @Test
    public void testIndexOf() {
        int expectedResult = 2;
        String value = "abc";

        int result = testArray.indexOf(value);

        assertEquals(expectedResult, result);

        expectedResult = -1;
        value = "3";

        result = testArray.indexOf(value);

        assertEquals(expectedResult, result);

        // test empty array
        ImmutableList emptyArrayList = testArray.clear();

        result = emptyArrayList.indexOf(value);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testSize() {
        int expectedResult = 4;

        int result = testArray.size();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testClear() {
        Object[] expectedResult = new Object[0];

        ImmutableList modifiedArray = testArray.clear();

        assertArrayEquals(expectedResult, modifiedArray.toArray());
    }

    @Test
    public void testIsEmpty() {
        boolean result = testArray.isEmpty();

        assertFalse(result);

        ImmutableList emptyArray = new ImmutableArrayList();
        result = emptyArray.isEmpty();

        assertTrue(result);
    }

    @Test
    public void testToArray() {
        Object[] expectedResult = Arrays.copyOf(basicArray, basicArray.length);
        Object[] result = testArray.toArray();

        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testToString() {
        String expectedResult = "[1, 2.0, abc, d]";
        String result = testArray.toString();

        assertEquals(expectedResult, result);
    }


    @After
    public void testAfterTestedArray() {
        assertArrayEquals(basicArray, testArray.toArray());
    }
}
