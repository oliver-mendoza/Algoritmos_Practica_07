package actividad_01;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de discos: ");
        int discos = scanner.nextInt();
        torresHanoi(discos, 1, 2, 3);
        scanner.close();
    }
    public static void torresHanoi(int discos, int origen, int auxiliar, int destino) {
        if (discos == 1) {
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
        } else {
            torresHanoi(discos - 1, origen, destino, auxiliar);
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }
}