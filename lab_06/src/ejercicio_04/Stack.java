package ejercicio_04;

public interface Stack<T> {
    void push(T item);
    T pop() throws ExceptionIsEmpty;
    T top() throws ExceptionIsEmpty;
    boolean isEmpty();
    int size();
}