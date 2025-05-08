package ejercicio_02;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new QueueArray<>(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Size: " + queue.size());
        System.out.println("Esta vacio?: " + queue.isEmpty());
    }
}