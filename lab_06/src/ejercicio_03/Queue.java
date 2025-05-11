package ejercicio_03;

public interface Queue<T> {
    void enqueue(T data);
    T dequeue() throws ExceptionIsEmpty;
    T peek() throws ExceptionIsEmpty;
    boolean isEmpty();
    int size();
}