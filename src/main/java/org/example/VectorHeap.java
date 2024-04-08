package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class VectorHeap <E extends Comparable<E>> implements IPriorityQueue <E>{


    private ArrayList<E> heap;

    public VectorHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void add(E item) {
        heap.add(item);
        int childIndex = heap.size() - 1;
        siftUp(childIndex);
    }

    private void siftUp(int childIndex) {
        E item = heap.get(childIndex);
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            E parent = heap.get(parentIndex);
            if (item.compareTo(parent) >= 0) {

                break;
            }

            heap.set(childIndex, parent);
            heap.set(parentIndex, item);
            childIndex = parentIndex;
        }
    }

    @Override
    public E remove() {
        if (heap.isEmpty()) {
            return null;
        }

        E removedItem = heap.get(0);

        E lastItem = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            siftDown(0);
        }

        return removedItem;
    }

    private void siftDown(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        while (leftChildIndex < heap.size()) {
            int rightChildIndex = leftChildIndex + 1;
            int minChildIndex = leftChildIndex;
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) < 0) {
                minChildIndex = rightChildIndex;
            }

            if (heap.get(parentIndex).compareTo(heap.get(minChildIndex)) <= 0) {
                break;
            }

            Collections.swap(heap, parentIndex, minChildIndex);
            parentIndex = minChildIndex;
            leftChildIndex = 2 * parentIndex + 1;
        }
    }

    @Override
    public E peeck() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VectorHeap{");
        for (int i = 0; i < heap.size(); i++) {
            sb.append(heap.get(i));
            if (i < heap.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
