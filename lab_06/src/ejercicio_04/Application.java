package ejercicio_04;

public class Application {
    public static boolean symbolBalancing(String str) {
        StackLink<Character> stack = new StackLink<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char top;
                try {
                    top = stack.pop();
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}