package ejercicio_03;

import java.util.Scanner;

public class ViajeMasBarato {
    public static int[][] calcularCostoMinimo(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                C[i][j] = T[i][j];
                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                    }
                }
            }
        }
        return C;
    }
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print((valor == Integer.MAX_VALUE ? "INF" : valor) + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = Integer.MAX_VALUE;
        System.out.print("Ingrese el número de embarcaderos: ");
        int n = sc.nextInt();
        int[][] T = new int[n][n];
        System.out.println("\nIngrese los valores de la matriz de tarifas:");
        System.out.println("(Use un número grande como 99999 para representar INF)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    T[i][j] = INF;
                } else {
                    System.out.print("T[" + i + "][" + j + "]: ");
                    int valor = sc.nextInt();
                    T[i][j] = (valor >= 99999) ? INF : valor;
                }
            }
        }
        int[][] C = calcularCostoMinimo(T);
        System.out.println("\nMatriz de Costos Mínimos:");
        imprimirMatriz(C);
        sc.close();
    }
}