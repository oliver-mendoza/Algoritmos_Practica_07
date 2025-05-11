package ejercicio_03;

public interface PriorityQueue<T> {
    void enqueue(T data, int priority);
    T dequeue() throws ExceptionIsEmpty;
    T peek() throws ExceptionIsEmpty;
    boolean isEmpty();
}