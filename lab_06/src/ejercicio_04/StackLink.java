package ejercicio_04;

public class StackLink<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    public StackLink() {
        top = null;
        size = 0;
    }
    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    @Override
    public T pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }
    @Override
    public T top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return top.getData();
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
}