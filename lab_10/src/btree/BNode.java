package btree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
    public int id;
    public boolean isLeaf = true;
    public List<E> keys = new ArrayList<>();
    public List<BNode<E>> children = new ArrayList<>();
    public BNode<E> parent;
    public BNode(int order, int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Nodo " + id + ": " + keys.toString();
    }
}