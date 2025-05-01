package lab_05;

import java.util.ArrayList;
import java.util.List;
public class GestorDeTareas<T> {
    private Node<T> head;
    private List<T> tareasCompletadas;
    public GestorDeTareas() {
        this.head = null;
        this.tareasCompletadas = new ArrayList<>();
    }
    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevo;
        }
    }
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;
        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }
        Node<T> actual = head;
        while (actual.next != null && !actual.next.data.equals(tarea)) {
            actual = actual.next;
        }
        if (actual.next != null) {
            actual.next = actual.next.next;
            return true;
        }
        return false;
    }
    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.data.equals(tarea)) return true;
            actual = actual.next;
        }
        return false;
    }
    public void imprimirTareas() {
        Node<T> actual = head;
        System.out.println("Lista de tareas:");
        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.next;
        }
    }
    public int contarTareas() {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }
    @SuppressWarnings("unchecked")
    public T obtenerTareaMasPrioritaria() {
        if (head == null || !(head.data instanceof Tarea)) return null;
        Node<T> actual = head;
        Tarea mayor = (Tarea) actual.data;
        while (actual != null) {
            Tarea t = (Tarea) actual.data;
            if (t.getPrioridad() > mayor.getPrioridad()) {
                mayor = t;
            }
            actual = actual.next;
        }
        return (T) mayor;
    }
    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = head;
        Node<T> siguiente;
        while (actual != null) {
            siguiente = actual.next;
            actual.next = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }
    public boolean transferirATareasCompletadas(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
            return true;
        }
        return false;
    }
    public void imprimirTareasCompletadas() {
        System.out.println("Tareas completadas:");
        for (T tarea : tareasCompletadas) {
            System.out.println(tarea);
        }
    }
}