package org.example;

/**
 * La interfaz IPriorityQueue define los métodos esenciales para una cola de prioridad.
 * Permite la inserción de elementos y el acceso o eliminación del elemento de mayor prioridad.
 *
 * @param <E> El tipo de elementos almacenados en esta cola de prioridad. Debe ser Comparable.
 */

public interface IPriorityQueue <E extends Comparable<E>>{

    /**
     * Añade un elemento a la cola de prioridad.
     *
     * @param element El elemento a añadir.
     */
    void add (E element);

    /**
     * Elimina y retorna el elemento de mayor prioridad en la cola.
     *
     * @return El elemento de mayor prioridad.
     */

    E remove();

    /**
     * Retorna sin eliminar el elemento de mayor prioridad en la cola.
     *
     * @return El elemento de mayor prioridad.
     */

    E peeck();

    /**
     * Comprueba si la cola de prioridad está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */

    boolean isEmpty();


}
