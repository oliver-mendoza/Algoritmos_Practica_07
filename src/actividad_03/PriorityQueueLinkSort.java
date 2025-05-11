package actividad_03;

import actividad_01.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
    class EntryNode {
        E data;
        N priority;
        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
        public String toString() {
            return "(" + data + "," + priority + ")";
        }
    }
    private Node<EntryNode> first;
    private Node<EntryNode> last;
    public PriorityQueueLinkSort() {
        first = null;
        last = null;
    }
    public void enqueue(E x, N pr) {
        EntryNode nuevo = new EntryNode(x, pr);
        Node<EntryNode> nuevoNodo = new Node<>(nuevo);

        if (isEmpty() || pr.compareTo(first.getData().priority) > 0) {
            nuevoNodo.setNext(first);
            first = nuevoNodo;
            if (last == null) last = first;
        } else {
            Node<EntryNode> aux = first;
            while (aux.getNext() != null && pr.compareTo(aux.getNext().getData().priority) <= 0) {
                aux = aux.getNext();
            }
            nuevoNodo.setNext(aux.getNext());
            aux.setNext(nuevoNodo);
            if (nuevoNodo.getNext() == null) last = nuevoNodo;
        }
    }
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E aux = first.getData().data;
        first = first.getNext();
        if (first == null) last = null;
        return aux;
    }
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return first.getData().data;
    }
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return last.getData().data;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> aux = first;
        while (aux != null) {
            sb.append(aux.getData()).append(" ");
            aux = aux.getNext();
        }
        return sb.toString();
    }
}