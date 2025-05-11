package ejercicio_02;

import actividad_02.Queue;
import actividad_01.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int first;
    private int last;
    private int size;
    private int capacity;
    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
        first = 0;
        last = -1;
        size = 0;
    }
    @Override
    public void enqueue(E x) {
        if (size == capacity) {
            System.out.println("Cola llena");
            return;
        }
        last = (last + 1) % capacity;
        array[last] = x;
        size++;
    }
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E x = array[first];
        first = (first + 1) % capacity;
        size--;
        return x;
    }
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return array[first];
    }
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return array[last];
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[(first + i) % capacity]).append(" ");
        }
        return sb.toString();
    }
}