package ejercicio_02;

public class QueueArray<T> implements Queue<T> {
    private T[] queue;
    private int first;
    private int last;
    private int size;
    private int capacity;
    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }
    @Override
    public void enqueue(T item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        queue[last] = item;
        last = (last + 1) % capacity;
        size++;
    }
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }
        T item = queue[first];
        first = (first + 1) % capacity;
        size--;
        return item;
    }
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }
        return queue[first];
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