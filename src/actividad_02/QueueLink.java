package actividad_02;

import actividad_01.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;
    public QueueLink() {
        first = null;
        last = null;
    }
    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);
        if (isEmpty()) {
            first = aux;
        } else {
            last.setNext(aux);
        }
        last = aux;
    }
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E aux = first.getData();
        first = first.getNext();
        if (first == null) last = null;
        return aux;
    }
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return first.getData();
    }
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return last.getData();
    }
    public boolean isEmpty() {
        return first == null;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> aux = first;
        while (aux != null) {
            sb.append(aux.getData()).append(" ");
            aux = aux.getNext();
        }
        return sb.toString();
    }
}