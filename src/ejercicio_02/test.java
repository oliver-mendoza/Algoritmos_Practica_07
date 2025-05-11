package ejercicio_02;

import actividad_02.Queue;
import ejercicio_02.QueueArray;
import actividad_01.ExceptionIsEmpty;

public class test {
    public static void main(String[] args) {
        Queue<String> cola1 = new QueueArray<>(5);
        Queue<Integer> cola2 = new QueueArray<>(3);
        cola1.enqueue("Uno");
        cola1.enqueue("Dos");
        cola1.enqueue("Tres");
        cola2.enqueue(100);
        cola2.enqueue(200);
        cola2.enqueue(300);
        System.out.println("Cola de Strings: " + cola1);
        System.out.println("Cola de Integers: " + cola2);
        try {
            System.out.println("Front cola1: " + cola1.front());
            System.out.println("Back cola1: " + cola1.back());
            cola1.dequeue();
            System.out.println("Cola1 tras dequeue: " + cola1);
            System.out.println("Front cola2: " + cola2.front());
            System.out.println("Back cola2: " + cola2.back());
            cola2.dequeue();
            System.out.println("Cola2 tras dequeue: " + cola2);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}