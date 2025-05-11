package ejercicio_01;
import actividad_01.Stack;
import ejercicio_01.StackLink;
import actividad_01.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        Stack<String> pila1 = new StackLink<>();
        Stack<Integer> pila2 = new StackLink<>();
        pila1.push("Hola");
        pila1.push("Mundo");
        pila2.push(1);
        pila2.push(2);
        pila2.push(3);
        try {
            System.out.println("Pila de String: " + pila1);
            System.out.println("Tope de pila1: " + pila1.top());
            System.out.println("Pop de pila1: " + pila1.pop());
            System.out.println("Pila1 luego del pop: " + pila1);

            System.out.println("\nPila de Integer: " + pila2);
            System.out.println("Tope de pila2: " + pila2.top());
            System.out.println("Pop de pila2: " + pila2.pop());
            System.out.println("Pila2 luego del pop: " + pila2);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}