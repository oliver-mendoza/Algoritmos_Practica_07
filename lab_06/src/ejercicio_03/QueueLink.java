package ejercicio_03;

public class QueueLink<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    public QueueLink() {
        front = rear = null;
        size = 0;
    }
    @Override
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }
    @Override
    public T dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        T data = front.getData();
        front = front.getNext();
        if (front == null) rear = null;
        size--;
        return data;
    }
    @Override
    public T peek() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return front.getData();
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