package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    public Stack(Object[] elements) {
        stack = new ImmutableLinkedList(elements);
    }

    // Returns the object from the top of the Stack without removing it
    public Object peek() {
        return stack.getLast();
    }

    // Removes and returns the object from the top of the Stack
    public Object pop() {
        Object last = peek();
        stack = stack.removeLast();
        return last;
    }

    // Adds an object to the the top of the Stack
    public void push(Object e) {
       stack = stack.addLast(e);
    }

    public Object[] toArray() {
        return stack.toArray();
    }

}
