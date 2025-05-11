package ejercicio_01;

import actividad_01.ExceptionIsEmpty;
import actividad_01.Stack;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;
    public StackLink() {
        top = null;
    }
    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.next = top;
        top = newNode;
    }
    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        E value = top.data;
        top = top.next;
        return value;
    }
    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return top.data;
    }
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = top;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}