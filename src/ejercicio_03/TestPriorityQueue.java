package ejercicio_03;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueueLinked<>(3);
        pq.enqueue("Alta prioridad", 0);
        pq.enqueue("Media prioridad", 1);
        pq.enqueue("Baja prioridad", 2);
        pq.enqueue("Otra alta", 0);
        try {
            while (!pq.isEmpty()) {
                System.out.println("Atendiendo: " + pq.dequeue());
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}