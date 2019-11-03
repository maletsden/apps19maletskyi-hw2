package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }

    public Queue(Object[] elements) {
        queue = new ImmutableLinkedList(elements);
    }

    // Returns the object at the beginning of the Queue without removing it
    public Object peek() {
        return queue.getFirst();
    }

    // Removes and returns the object at the beginning of the Queue
    Object dequeue() {
        Object first = peek();
        queue = queue.removeFirst();
        return first;
    }

    // Adds an object to the end of the Queue
    void enqueue(Object e) {
        queue = queue.addLast(e);
    }

    public Object[] toArray() {
        return queue.toArray();
    }

}
