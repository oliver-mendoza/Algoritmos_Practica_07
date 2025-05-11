package ejercicio_03;

public class PriorityQueueLinked<T> implements PriorityQueue<T> {
    private QueueLink<T>[] priorityQueues;
    private int priorities;
    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int priorities) {
        this.priorities = priorities;
        priorityQueues = new QueueLink[priorities];
        for (int i = 0; i < priorities; i++) {
            priorityQueues[i] = new QueueLink<>();
        }
    }
    @Override
    public void enqueue(T data, int priority) {
        if (priority < 0 || priority >= priorities) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }
        priorityQueues[priority].enqueue(data);
    }
    @Override
    public T dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < priorities; i++) {
            if (!priorityQueues[i].isEmpty()) {
                return priorityQueues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }
    @Override
    public T peek() throws ExceptionIsEmpty {
        for (int i = 0; i < priorities; i++) {
            if (!priorityQueues[i].isEmpty()) {
                return priorityQueues[i].peek();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }
    @Override
    public boolean isEmpty() {
        for (QueueLink<T> q : priorityQueues) {
            if (!q.isEmpty()) return false;
        }
        return true;
    }
}