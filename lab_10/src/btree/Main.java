package btree;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Parte 1: Inserciones iniciales ===");
        BTree<Integer> arbol1 = new BTree<>(5);
        int[] claves1 = {100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93, 94};
        for (int clave : claves1) {
            arbol1.insert(clave);
        }
        System.out.println("\nÁrbol 1:");
        System.out.println(arbol1.toStructuredString());
        System.out.println("\n=== Parte 2: Árbol de la figura 10.13 ===");
        BTree<Integer> arbol2 = new BTree<>(4);
        int[] claves2 = {
            12, 25, 20, 80, 142, 150, 176, 206, 297, 380, 395, 412, 430, 451, 300, 480, 493, 506, 520, 521, 600};
        for (int clave : claves2) {
            arbol2.insert(clave);
        }
        System.out.println("\nÁrbol figura 10.13 (antes de eliminar):");
        System.out.println(arbol2.toStructuredString());
        int[] eliminar = {451, 20, 12, 150, 142, 506, 300, 297, 521, 176};
        System.out.println("\nEliminando claves: " + Arrays.toString(eliminar));
        for (int clave : eliminar) {
            arbol2.remove(clave);
        }
        System.out.println("\nÁrbol figura 10.13 (después de eliminar):");
        System.out.println(arbol2.toStructuredString());
        // ================= Ejercicio 01: search =================
        System.out.println("\n=== Ejercicio 01: Búsqueda de claves ===");
        int[] buscarClaves = {451, 395, 520};
        for (int clave : buscarClaves) {
            boolean encontrado = arbol2.search(clave);
            System.out.println(clave + " está en el árbol: " + encontrado);
        }
        // ================= Ejercicio 03: Construcción desde archivo =================
        System.out.println("\n=== Ejercicio 03: Construcción desde archivo ===");
        try {
            BTree<Integer> arbolDesdeArchivo = BTree.building_Btree("src/arbolB.txt");
            System.out.println("Árbol construido desde archivo:");
            System.out.println(arbolDesdeArchivo.toStructuredString());
        } catch (ItemNoFound e) {
            System.out.println("Error al construir el árbol: " + e.getMessage());
        }
        // ================= Ejercicio 04: RegistroEstudiante =================
        System.out.println("\n=== Ejercicio 04: RegistroEstudiante ===");
        BTree<RegistroEstudiante> arbolEstudiantes = new BTree<>(4);
        RegistroEstudiante[] estudiantes = {
            new RegistroEstudiante(103, "Ana"), new RegistroEstudiante(110, "Luis"),
            new RegistroEstudiante(101, "Carlos"), new RegistroEstudiante(120, "Lucía"),
            new RegistroEstudiante(115, "David"), new RegistroEstudiante(125, "Jorge"),
            new RegistroEstudiante(140, "Camila"), new RegistroEstudiante(108, "Rosa"),
            new RegistroEstudiante(132, "Ernesto"), new RegistroEstudiante(128, "Denis"),
            new RegistroEstudiante(145, "Enrique"), new RegistroEstudiante(122, "Karina"),
            new RegistroEstudiante(108, "Juan")
        };
        for (RegistroEstudiante est : estudiantes) {
            arbolEstudiantes.insert(est);
        }
        System.out.println("\nBuscar estudiante con código 115: " + arbolEstudiantes.buscarNombre(115));
        System.out.println("Buscar estudiante con código 132: " + arbolEstudiantes.buscarNombre(132));
        System.out.println("Buscar estudiante con código 999: " + arbolEstudiantes.buscarNombre(999));
        System.out.println("\nEliminando estudiante con código 101");
        arbolEstudiantes.remove(new RegistroEstudiante(101, ""));
        System.out.println("Insertando nuevo estudiante: 106 - Sara");
        arbolEstudiantes.insert(new RegistroEstudiante(106, "Sara"));
        System.out.println("Buscar estudiante con código 106: " + arbolEstudiantes.buscarNombre(106));
    }
}