package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private static final int DEFAULT_EMPTY_ARRAY_SIZE = 0;
    private Object[] elements;

    public ImmutableArrayList() {
        elements = new Object[DEFAULT_EMPTY_ARRAY_SIZE];
    }

    public ImmutableArrayList(Object[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    // додає елемент у кінець колекції
    public ImmutableArrayList add(Object e) {
        Object[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[elements.length] = e;

        return new ImmutableArrayList(newArray);
    }

    // додає елемент до колекції за індексом, та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції
    public ImmutableArrayList add(int index, Object e) {
        checkIndexError(index);

        Object[] newArray = Arrays.copyOf(elements, elements.length + 1);
        System.arraycopy(
                elements, index, newArray, index + 1, elements.length - index
        );
        newArray[index] = e;

        return new ImmutableArrayList(newArray);
    }

    // додає масив елементів у кінець колекції
    public ImmutableArrayList addAll(Object[] c) {
        Object[] newArray = Arrays.copyOf(elements, elements.length + c.length);
        System.arraycopy(c, 0, newArray, elements.length, c.length);

        return new ImmutableArrayList(newArray);
    }

    // додає масив елементів починаючи з зазначеного індекса,
    // та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndexError(index);

        Object[] newArray = Arrays.copyOf(elements, elements.length + c.length);
        System.arraycopy(
                elements, index, newArray, index + c.length,
                elements.length - index
        );
        System.arraycopy(c, 0, newArray, index, c.length);


        return new ImmutableArrayList(newArray);
    }

    // повертає елемент за індексом, та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції
    public Object get(int index) {
        checkIndexError(index);

        return elements[index];
    }

    // видаляє елемент за індексом, та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції
    public ImmutableArrayList remove(int index) {
        checkIndexError(index);

        Object[] newArray = new Object[elements.length - 1];
        System.arraycopy(elements, 0, newArray, 0, index);
        System.arraycopy(
                elements, index + 1, newArray, index,
                elements.length - index - 1
        );

        return new ImmutableArrayList(newArray);
    }

    // змінює значення елементу за індексом, та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції
    public ImmutableArrayList set(int index, Object e) {
        checkIndexError(index);

        Object[] newArray = Arrays.copyOf(elements, elements.length);
        newArray[index] = e;

        return new ImmutableArrayList(newArray);
    }

    // шукає індекс елемента (повертає індекс першого який знайшов,
    // або -1 у випадку відсутності)
    public int indexOf(Object e) {
        if (isEmpty()) {
            return -1;
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    // розмір колекції
    public int size() {
        return elements.length;
    }

    // очищує вміст колекції
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    // якщо у колеції нема елементів то повертає true
    public boolean isEmpty() {
        return size() == 0;
    }

    // перетворює колекцію до масиву обєктів
    public Object[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }

    // повертає рядок, де через кому відображаютсься елементи колекції
    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    private void checkIndexError(int index) {
        if (index < 0 || index >= elements.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
