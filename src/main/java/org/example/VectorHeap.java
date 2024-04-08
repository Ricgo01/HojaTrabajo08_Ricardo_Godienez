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
        heap.add(item); // Agregamos el elemento al final del ArrayList
        int childIndex = heap.size() - 1; // La posición del nuevo elemento
        siftUp(childIndex);
    }

    // Método para "sift up" (subir el elemento en el heap)
    private void siftUp(int childIndex) {
        E item = heap.get(childIndex);
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2; // Encuentra el índice del padre
            E parent = heap.get(parentIndex);
            if (item.compareTo(parent) >= 0) {
                // Si el elemento es mayor o igual al padre, entonces el heap está en orden
                break;
            }
            // Si el elemento es menor que el padre, intercambiamos
            heap.set(childIndex, parent);
            heap.set(parentIndex, item);
            // Actualizamos el índice para continuar el proceso con el nuevo padre
            childIndex = parentIndex;
        }
    }

    @Override
    public E remove() {
        if (heap.isEmpty()) {
            return null; // O lanzar una excepción, dependiendo de tu preferencia.
        }
        // Guarda el elemento a remover, que es el primer elemento (la raíz del heap).
        E removedItem = heap.get(0);

        // Toma el último elemento y lo coloca en la raíz.
        E lastItem = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            siftDown(0); // Restaura la propiedad de heap comenzando desde la raíz.
        }

        return removedItem;
    }

    // Método para "sift down" (bajar el elemento en el heap)
    private void siftDown(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        while (leftChildIndex < heap.size()) {
            // Encuentra el índice del hijo más pequeño.
            int rightChildIndex = leftChildIndex + 1;
            int minChildIndex = leftChildIndex;
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) < 0) {
                minChildIndex = rightChildIndex;
            }

            // Si el padre es menor o igual al hijo más pequeño, el heap está en orden.
            if (heap.get(parentIndex).compareTo(heap.get(minChildIndex)) <= 0) {
                break;
            }

            // Intercambia el padre con el hijo más pequeño y continúa el proceso.
            Collections.swap(heap, parentIndex, minChildIndex);
            parentIndex = minChildIndex;
            leftChildIndex = 2 * parentIndex + 1;
        }
    }

    @Override
    public E peeck() {
        if (heap.isEmpty()) {
            return null; // O lanzar una excepción, dependiendo de tu preferencia.
        }
        return heap.get(0); // Retorna el primer elemento del ArrayList sin eliminarlo.
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
