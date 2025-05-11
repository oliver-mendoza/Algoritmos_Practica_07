package actividad_02;

import actividad_02.*;
import actividad_01.ExceptionIsEmpty;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> cola = new QueueLink<>();
        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");
        System.out.println("Contenido de la cola: " + cola);
        try {
            System.out.println("Frente: " + cola.front());
            System.out.println("Final: " + cola.back());
            cola.dequeue();
            System.out.println("Después de quitar un elemento: " + cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}