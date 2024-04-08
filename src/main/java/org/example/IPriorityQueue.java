package org.example;

public interface IPriorityQueue <E extends Comparable<E>>{

    void add (E element);

    E remove();

    E peeck();

    boolean isEmpty();


}
