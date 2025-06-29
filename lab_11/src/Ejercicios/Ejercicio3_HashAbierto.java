package Ejercicios;

import java.util.LinkedList;

public class Ejercicio3_HashAbierto {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        LinkedList<Register>[] tabla = new LinkedList[5];
        for (int i = 0; i < 5; i++) {
            tabla[i] = new LinkedList<>();
        }
        tabla[10 % 5].add(new Register(10, "Juan"));
        tabla[15 % 5].add(new Register(15, "Ana"));
        tabla[20 % 5].add(new Register(20, "Luis"));
        tabla[25 % 5].add(new Register(25, "Rosa"));
        System.out.println("=== Ejercicio 3: Búsqueda en hash abierto ===");

        // Buscar 20
        boolean encontrado = false;
        int index = 20 % 5;
        for (Register r : tabla[index]) {
            if (r.getKey() == 20) {
                System.out.println("Resultado búsqueda 20: " + r.getName());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Resultado búsqueda 20: No encontrado");
        }

        // Buscar 30
        encontrado = false;
        index = 30 % 5;
        for (Register r : tabla[index]) {
            if (r.getKey() == 30) {
                System.out.println("Resultado búsqueda 30: " + r.getName());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Resultado búsqueda 30: No encontrado");
        }
    }
}