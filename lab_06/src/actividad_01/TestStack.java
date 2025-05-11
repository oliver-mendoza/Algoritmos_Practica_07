package actividad_01;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> pila = new StackArray<>(5);
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Contenido de la pila: " + pila);
        try {
            System.out.println("Elemento en tope: " + pila.top());
            System.out.println("Elemento eliminado: " + pila.pop());
            System.out.println("Contenido de la pila: " + pila);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}