package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PriorityQueue <E extends Comparable<E>> implements IPriorityQueue<E>{

    private Queue <E> queue;

    public PriorityQueue() {
        queue = new ArrayDeque<>();
    }

    @Override
    public void add(E element) {
        queue.offer(element);
    }

    @Override
    public E remove() {
        return queue.poll();
    }

    @Override
    public E peeck() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
