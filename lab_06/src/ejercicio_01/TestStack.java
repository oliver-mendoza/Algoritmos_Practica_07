package ejercicio_01;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackLink<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Esta vacio?: " + stack.isEmpty());
    }
}