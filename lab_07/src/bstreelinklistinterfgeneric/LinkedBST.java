package bstreelinklistinterfgeneric; 

import bstreeInterface.BinarySearchTree; 
import exceptions.*; 
import java.util.Queue; 
import java.util.LinkedList; 

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> { 
    private class Node { 
        E data; 
        Node left, right; 
        Node(E data) { 
            this(data, null, null); 
        } 
        Node(E data, Node left, Node right) { 
            this.data = data; 
            this.left = left; 
            this.right = right; 
        } 
    } 
    private Node root; 
    public LinkedBST() { 
        root = null; 
    } 
     
    // Desde aca ejercicios 

    public void destroyNodes() { 
        root = null; 
    } 
    public int countAllNodes() { 
        return countAllNodes(root); 
    } 
    private int countAllNodes(Node node) { 
        if (node == null) return 0; 
        return 1 + countAllNodes(node.left) + countAllNodes(node.right); 
    } 
    public int countNonLeafNodes() { 
        return countNonLeafNodes(root); 
    } 
    private int countNonLeafNodes(Node node) { 
        if (node == null || (node.left == null && node.right == null)) return 0; 
        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right); 
    } 
    public int height(E x) { 
        Node node = searchNode(root, x); 
        if (node == null) return -1; 
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(node); 
        int height = -1; 
        while (!queue.isEmpty()) { 
            int size = queue.size();
            height++; 
            for (int i = 0; i < size; i++) { 
                Node current = queue.poll(); 
                if (current.left != null) queue.add(current.left); 
                if (current.right != null) queue.add(current.right); 
            } 
        } 
        return height; 
    } 
    private Node searchNode(Node node, E data) { 
        if (node == null) return null; 
        int cmp = data.compareTo(node.data); 
        if (cmp == 0) return node; 
        else if (cmp < 0) return searchNode(node.left, data); 
        else return searchNode(node.right, data); 
    } 
    public int amplitude(int nivel) { 
        if (root == null || nivel < 0) return 0; 
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root); 
        int currentLevel = 0; 
        while (!queue.isEmpty()) { 
            int size = queue.size(); 
            if (currentLevel == nivel) return size; 
            for (int i = 0; i < size; i++) { 
                Node current = queue.poll(); 
                if (current.left != null) queue.add(current.left); 
                if (current.right != null) queue.add(current.right); 
            } 
            currentLevel++; 
        } 
        return 0; 
    } 
    public int areaBST() { 
        int height = heightOfTree(root); 
        int leafCount = countLeaves(root);// El numero de hojas x la altura total del arbol 
        return leafCount * height; 
    } 
    private int heightOfTree(Node node) { 
        if (node == null) return -1; 
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right)); 
    } 
    private int countLeaves(Node node) { 
        if (node == null) return 0; 
        if (node.left == null && node.right == null) return 1; 
        return countLeaves(node.left) + countLeaves(node.right); 
    } 
    public void drawBST() { 
        System.out.println(toStringTree(root, "", true)); 
    } 
    private String toStringTree(Node node, String prefix, boolean isTail) { 
        if (node == null) return ""; 
        StringBuilder sb = new StringBuilder(); 
        sb.append(prefix).append(isTail ? "└── " : "├── ").append(node.data).append("\n"); 
        if (node.left != null || node.right != null) { 
            sb.append(toStringTree(node.left, prefix + (isTail ? "    " : "│   "), node.right == null)); 
            sb.append(toStringTree(node.right, prefix + (isTail ? "    " : "│   "), true)); 
        } 
        return sb.toString(); 
    } 
    public void parenthesize() { 
        parenthesize(root, 0); 
    } 
    private void parenthesize(Node node, int level) { 
        if (node == null) return; 
        String indent = "  ".repeat(level); 
        System.out.println(indent + "(" + node.data);
        if (node.left != null) parenthesize(node.left, level + 1); 
        if (node.right != null) parenthesize(node.right, level + 1); 
        System.out.println(indent + ")"); 
    } 
    
// hasta aca ejercicios. 

    @Override 
    public void insert(E data) throws ItemDuplicated { 
        root = insert(root, data); 
    } 
    private Node insert(Node node, E data) throws ItemDuplicated { 
        if (node == null) return new Node(data); 
        int cmp = data.compareTo(node.data); 
        if (cmp < 0) node.left = insert(node.left, data); 
        else if (cmp > 0) node.right = insert(node.right, data); 
        else throw new ItemDuplicated("Elemento duplicado: " + data); 
        return node; 
    } 
    @Override 
    public E search(E data) throws ItemNotFound { 
        Node found = search(root, data); 
        if (found == null) throw new ItemNotFound("No encontrado: " + data); 
        return found.data; 
    } 
    private Node search(Node node, E data) { 
        if (node == null) return null; 
        int cmp = data.compareTo(node.data); 
        if (cmp == 0) return node; 
        if (cmp < 0) return search(node.left, data); 
        return search(node.right, data); 
    } 
    @Override 
    public void delete(E data) throws ExceptionIsEmpty { 
        if (root == null) throw new ExceptionIsEmpty(); 
        root = delete(root, data); 
    } 
    private Node delete(Node node, E data) { 
        if (node == null) return null; 
        int cmp = data.compareTo(node.data); 
        if (cmp < 0) node.left = delete(node.left, data); 
        else if (cmp > 0) node.right = delete(node.right, data); 
        else { 
            if (node.left == null) return node.right; 
            if (node.right == null) return node.left; 
            Node temp = findMin(node.right); 
            node.data = temp.data; 
            node.right = delete(node.right, temp.data); 
        } 
        return node; 
    } 
    private Node findMin(Node node) { 
        while (node.left != null) node = node.left; 
        return node; 
    } 
    @Override 
    public boolean isEmpty() { 
        return root == null; 
    } 
    @Override 
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        inOrder(root, sb); 
        return sb.toString().trim(); 
    } 
    private void inOrder(Node node, StringBuilder sb) { 
        if (node != null) { 
            inOrder(node.left, sb); 
            sb.append(node.data).append(" "); 
            inOrder(node.right, sb); 
        } 
    } 
    public void inOrderTraversal() { 
        System.out.print("InOrder: "); 
        inOrder(root); 
        System.out.println(); 
    }
    private void inOrder(Node node) { 
        if (node != null) { 
            inOrder(node.left); 
            System.out.print(node.data + " "); 
            inOrder(node.right); 
        } 
    } 
    public void preOrderTraversal() { 
        System.out.print("PreOrder: "); 
        preOrder(root); 
        System.out.println(); 
    } 
    private void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.data + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 
    public void postOrderTraversal() { 
        System.out.print("PostOrder: "); 
        postOrder(root); 
        System.out.println(); 
    } 
    private void postOrder(Node node) { 
        if (node != null) { 
            postOrder(node.left); 
            postOrder(node.right); 
            System.out.print(node.data + " "); 
        } 
    } 
    public E findMinNode() throws ItemNotFound { 
        if (root == null) throw new ItemNotFound(); 
        return findMin(root).data; 
    } 
    public E findMaxNode() throws ItemNotFound { 
        if (root == null) throw new ItemNotFound(); 
        Node current = root; 
        while (current.right != null) current = current.right; 
        return current.data; 
    } 
} 