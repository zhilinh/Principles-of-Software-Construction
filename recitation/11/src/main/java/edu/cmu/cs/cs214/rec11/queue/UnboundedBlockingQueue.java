package edu.cmu.cs.cs214.rec11.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Modify this class to be thread-safe and be an UnboundedBlockingQueue.
 */
public class UnboundedBlockingQueue<E> implements SimpleQueue<E> {
    private Deque<E> queue = new ArrayDeque<>();

    public UnboundedBlockingQueue() { }

    public boolean isEmpty() { return queue.isEmpty(); }

    public int size() { return queue.size(); }

    public E peek() { return queue.peek(); }

    public void enqueue(E element) { queue.add(element); }

    /**
     * TODO:  Change this method to block (waiting for an enqueue) rather
     * than throw an exception.  Completing this task may require
     * modifying other methods.
     */
    public E dequeue() { return queue.remove(); }

    public String toString() { return queue.toString(); }
}
