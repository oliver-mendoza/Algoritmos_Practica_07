package Ejercicios;

public class Ejercicio2_SondeoLineal {
    public static void main(String[] args) {
        Integer[] tabla = new Integer[6];
        int[] valores = {12, 18, 24, 30};
        System.out.println("=== Ejercicio 2: Sondeo lineal ===");
        for (int valor : valores) {
            int indice = valor % 6;
            int original = indice;
            while (tabla[indice] != null) {
                System.out.println("Colisión en índice " + indice + " para valor " + valor + ", probando siguiente...");
                indice = (indice + 1) % 6;
                if (indice == original) {
                    System.out.println("Tabla llena. No se pudo insertar " + valor);
                    break;
                }
            }
            if (tabla[indice] == null) {
                tabla[indice] = valor;
                System.out.println("Insertado " + valor + " en posición " + indice);
            }
        }
        System.out.println("\nTabla final:");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(i + ": " + (tabla[i] != null ? tabla[i] : "vacío"));
        }
    }
}