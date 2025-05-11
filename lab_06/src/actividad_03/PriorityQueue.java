package actividad_03;

import actividad_01.ExceptionIsEmpty;

public interface PriorityQueue<E, N extends Comparable<N>> {
    void enqueue(E x, N pr);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    E back() throws ExceptionIsEmpty;
    boolean isEmpty();
}