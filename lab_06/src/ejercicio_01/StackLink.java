package ejercicio_01;

public class StackLink<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    public StackLink() {
        this.top = null;
        this.size = 0;
    }
    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Stack is empty");
        }
        T item = top.getData();
        top = top.getNext();
        size--;
        return item;
    }
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Stack is empty");
        }
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