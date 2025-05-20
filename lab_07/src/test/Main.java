package test; 

import bstreelinklistinterfgeneric.LinkedBST; 
import exceptions.*; 

public class Main { 
    public static <E extends Comparable<E>> boolean sameArea(LinkedBST<E> tree1, LinkedBST<E> tree2) { 
        return tree1.areaBST() == tree2.areaBST(); 
    } 
    public static void main(String[] args) { 
        LinkedBST<Integer> bst = new LinkedBST<>(); 
        try { 
            bst.insert(400); 
            bst.insert(100); 
            bst.insert(700); 
            bst.insert(50); 
            bst.insert(75); 
            bst.insert(200); 
            bst.inOrderTraversal(); 
            bst.preOrderTraversal(); 
            bst.postOrderTraversal(); 
            System.out.println("Mínimo: " + bst.findMinNode()); 
            System.out.println("Máximo: " + bst.findMaxNode());
            System.out.println("Total de nodos: " + bst.countAllNodes()); 
            System.out.println("Nodos no hoja: " + bst.countNonLeafNodes()); 
            System.out.println("Altura subárbol con raíz 100: " + bst.height(100)); 
            System.out.println("Amplitud nivel 2: " + bst.amplitude(2)); 
            System.out.println("Área del árbol: " + bst.areaBST()); 
            System.out.println("\nDibujo del árbol:"); 
            bst.drawBST(); 
            System.out.println("\nRepresentación entre paréntesis:"); 
            bst.parenthesize(); 
            LinkedBST<Integer> bst2 = new LinkedBST<>(); 
            bst2.insert(500); 
            bst2.insert(150); 
            bst2.insert(800); 
            bst2.insert(60); 
            bst2.insert(90); 
            bst2.insert(250); 
            boolean iguales = sameArea(bst, bst2); 
            System.out.println("\n¿Los árboles tienen la misma área? " + iguales); 
        } catch (Exception e) { 
            System.out.println("Excepción: " + e.getMessage()); 
        } 
    } 
}