package ejercicio_04;

public class TestApplication {
    public static void main(String[] args) {
        String[] pruebas = {
            "()()()[()]()",      // true
            "((()))[]",          // true
            "([])[](",           // false
            "([{)]}",            // false
            "[",                 // false
            "[][][]{{{}}}"       // true
        };

        for (String prueba : pruebas) {
            System.out.println("Entrada: " + prueba + " -> " + Application.symbolBalancing(prueba));
        }
    }
}
