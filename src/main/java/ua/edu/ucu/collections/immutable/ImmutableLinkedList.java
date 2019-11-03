package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList {
    private Node head = null;
    private int size = 0;
    private Node tail = null;

    private static class Node {
        Node next = null;
        Object value;

        Node(Object value) {
            this.value = value;
        }
    }

    public ImmutableLinkedList() {}

    public ImmutableLinkedList(Object[] elements) {
        size = elements.length;

        if (size == 0) {
            return;
        }

        Node currentNode = new Node(elements[0]);
        head = tail = currentNode;

        for (int i = 1; i < size; i++) {
            Node newNode = new Node(elements[i]);
            currentNode.next = newNode;

            currentNode = tail = newNode;
        }
    }

    // додає елемент у кінець колекції
    public ImmutableList add(Object e) {
        Object[] newArray = Arrays.copyOf(toArray(), size + 1);
        newArray[size] = e;

        return new ImmutableLinkedList(newArray);
    }

    // додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableList add(int index, Object e) {
        checkIndexError(index);

        Object[] newArray = Arrays.copyOf(toArray(), size + 1);
        System.arraycopy(newArray, index, newArray, index + 1, size - index);
        newArray[index] = e;

        return new ImmutableLinkedList(newArray);
    }

    //додає масив елементів у кінець колекції
    public ImmutableList addAll(Object[] c) {
        Object[] newArray = Arrays.copyOf(toArray(), size + c.length);
        System.arraycopy(c, 0, newArray, size, c.length);

        return new ImmutableLinkedList(newArray);
    }

    // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableList addAll(int index, Object[] c) {
        checkIndexError(index);

        Object[] newArray = Arrays.copyOf(toArray(), size + c.length);
        System.arraycopy(newArray, index, newArray, index + c.length, size - index);
        System.arraycopy(c, 0, newArray, index, c.length);

        return new ImmutableLinkedList(newArray);
    }

    // повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public Object get(int index) {
        checkIndexError(index);

        Node node = head;
        for (int i = 1; i <= index; i++) {
            node = node.next;
        }

        return node.value;
    }

    // видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableList remove(int index) {
        checkIndexError(index);

        Object[] elements = toArray();
        Object[] newArray = new Object[size - 1];
        System.arraycopy(elements, 0, newArray, 0, index);
        System.arraycopy(elements, index + 1, newArray, index, elements.length - index - 1);

        return new ImmutableLinkedList(newArray);
    }

    // змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableList set(int index, Object e) {
        checkIndexError(index);

        Object[] newArray = Arrays.copyOf(toArray(), size);
        newArray[index] = e;

        return new ImmutableLinkedList(newArray);
    }

    // шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)
    public int indexOf(Object e) {
        if (isEmpty()) {
            return -1;
        }

        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.value == e) {
                return i;
            }

            node = node.next;
        }

        return -1;
    }

    // розмір колекції
    public int size() {
        return size;
    }

    // очищує вміст колекції
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    // якщо у колеції нема елементів то повертає true
    public boolean isEmpty() {
        return size == 0;
    }

    // перетворює колекцію до масиву обєктів
    public Object[] toArray() {
        Object[] array = new Object[size];

        Node node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.value;

            node = node.next;
        }

        return array;
    }


    // додає елемент у початок зв'язаного списку
    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    // додає елемент у кінець зв'язаного списку
    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return tail != null ? tail.value : null;
    }

    // видаляє перший елемент
    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    // видаляє останній елемент
    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size - 1);
    }


    // повертає рядок, де через кому відображаютсься елементи колекції
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private void checkIndexError(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
