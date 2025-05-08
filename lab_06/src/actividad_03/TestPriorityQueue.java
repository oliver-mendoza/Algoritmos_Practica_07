package actividad_03;

import actividad_03.*;
import actividad_01.ExceptionIsEmpty;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> colaPrioridad = new PriorityQueueLinkSort<>();
        colaPrioridad.enqueue("Tarea urgente", 5);
        colaPrioridad.enqueue("Tarea media", 3);
        colaPrioridad.enqueue("Tarea baja", 1);
        colaPrioridad.enqueue("Tarea muy urgente", 6);
        System.out.println("Contenido de la cola de prioridad: " + colaPrioridad);
        try {
            System.out.println("Frente: " + colaPrioridad.front());
            System.out.println("Final: " + colaPrioridad.back());
            colaPrioridad.dequeue();
            System.out.println("Después de quitar un elemento: " + colaPrioridad);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}