package Ejercicios;

public class Ejercicio1_SinColisiones {
    public static void main(String[] args) {
        Integer[] tabla = new Integer[7];
        int[] valores = {3, 10, 17, 24};
        for (int valor : valores) {
            int indice = valor % 7;
            tabla[indice] = valor;
        }
        System.out.println("=== Ejercicio 1: Insertar sin colisiones ===");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(i + ": " + (tabla[i] != null ? tabla[i] : "vacío"));
        }
    }
}