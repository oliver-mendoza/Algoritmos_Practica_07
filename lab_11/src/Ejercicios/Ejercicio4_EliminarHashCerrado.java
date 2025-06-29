package Ejercicios;

public class Ejercicio4_EliminarHashCerrado {
    static class Celda {
        Integer valor;
        boolean disponible;
        Celda() {
            valor = null;
            disponible = true;
        }
    }
    public static void main(String[] args) {
        Celda[] tabla = new Celda[7];
        for (int i = 0; i < 7; i++) tabla[i] = new Celda();
        int[] insertar = {5, 12, 19};

        // Insertar
        for (int val : insertar) {
            int index = val % 7;
            while (!tabla[index].disponible) {
                index = (index + 1) % 7;
            }
            tabla[index].valor = val;
            tabla[index].disponible = false;
        }

        // Eliminar 12
        int eliminar = 12;
        int index = eliminar % 7;
        while (!tabla[index].disponible || tabla[index].valor != null) {
            if (tabla[index].valor != null && tabla[index].valor == eliminar) {
                tabla[index].disponible = true; // Eliminación lógica
                break;
            }
            index = (index + 1) % 7;
        }

        // Buscar 19
        int buscar = 19;
        index = buscar % 7;
        while (!tabla[index].disponible || tabla[index].valor != null) {
            if (tabla[index].valor != null && tabla[index].valor == buscar) {
                System.out.println("19 encontrado en índice " + index);
                break;
            }
            index = (index + 1) % 7;
        }
        System.out.println("\n=== Tabla después de eliminar 12 ===");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(i + ": " + (tabla[i].disponible ? "vacío" : tabla[i].valor));
        }
    }
}