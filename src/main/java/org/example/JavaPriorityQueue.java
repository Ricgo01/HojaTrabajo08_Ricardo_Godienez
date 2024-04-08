package org.example;
import java.util.PriorityQueue;

/**
 * La clase JavaPriorityQueue proporciona una implementación de la interfaz IPriorityQueue
 * utilizando la clase PriorityQueue del Java Collection Framework.
 *
 * @param <E> El tipo de elementos almacenados en esta cola de prioridad. Debe ser Comparable.
 */

public class JavaPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E>{

    private PriorityQueue <E> queue;

    public JavaPriorityQueue() {
        this.queue = new PriorityQueue<>();
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
    public String toString() {
        Object[] arr = queue.toArray();
        StringBuilder sb = new StringBuilder();
        sb.append("MyPriorityQueue{");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
