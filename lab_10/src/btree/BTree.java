package btree;

import java.io.*;
import java.util.*;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int order;
    private int nextId;
    public BTree(int order) {
        this.order = order;
        this.root = new BNode<>(order, nextId++);
    }
    public boolean search(E key) {
        return search(root, key);
    }
    private boolean search(BNode<E> node, E key) {
        int i = 0;
        while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
            i++;
        }
        if (i < node.keys.size() && key.compareTo(node.keys.get(i)) == 0) {
            System.out.println(key + " se encuentra en el nodo " + node.id + " en la posición " + i);
            return true;
        } else if (node.isLeaf) {
            return false;
        } else {
            return search(node.children.get(i), key);
        }
    }
    public void remove(E key) {
        remove(root, key);
        if (!root.isLeaf && root.keys.isEmpty()) {
            root = root.children.get(0);
        }
    }
    private void remove(BNode<E> node, E key) {
        int idx = Collections.binarySearch(node.keys, key);
        if (idx >= 0) {
            if (node.isLeaf) {
                node.keys.remove(idx);
            } else {
                BNode<E> predChild = node.children.get(idx);
                if (predChild.keys.size() >= order / 2) {
                    E pred = getPredecessor(predChild);
                    node.keys.set(idx, pred);
                    remove(predChild, pred);
                } else {
                    BNode<E> succChild = node.children.get(idx + 1);
                    if (succChild.keys.size() >= order / 2) {
                        E succ = getSuccessor(succChild);
                        node.keys.set(idx, succ);
                        remove(succChild, succ);
                    } else {
                        merge(node, idx);
                        remove(predChild, key);
                    }
                }
            }
        } else {
            idx = -idx - 1;
            if (node.isLeaf) return;
            BNode<E> child = node.children.get(idx);
            if (child.keys.size() < order / 2) {
                if (idx > 0 && node.children.get(idx - 1).keys.size() >= order / 2) {
                    borrowFromLeft(node, idx);
                } else if (idx < node.children.size() - 1 && node.children.get(idx + 1).keys.size() >= order / 2) {
                    borrowFromRight(node, idx);
                } else {
                    if (idx < node.children.size() - 1) {
                        merge(node, idx);
                    } else {
                        merge(node, idx - 1);
                        child = node.children.get(idx - 1);
                    }
                }
            }
            remove(child, key);
        }
    }
    private void merge(BNode<E> parent, int idx) {
        BNode<E> left = parent.children.get(idx);
        BNode<E> right = parent.children.get(idx + 1);
        left.keys.add(parent.keys.remove(idx));
        left.keys.addAll(right.keys);
        if (!left.isLeaf) {
            left.children.addAll(right.children);
        }
        parent.children.remove(idx + 1);
    }
    private void borrowFromLeft(BNode<E> parent, int idx) {
        BNode<E> child = parent.children.get(idx);
        BNode<E> left = parent.children.get(idx - 1);
        child.keys.add(0, parent.keys.get(idx - 1));
        parent.keys.set(idx - 1, left.keys.remove(left.keys.size() - 1));
        if (!child.isLeaf) {
            child.children.add(0, left.children.remove(left.children.size() - 1));
        }
    }
    private void borrowFromRight(BNode<E> parent, int idx) {
        BNode<E> child = parent.children.get(idx);
        BNode<E> right = parent.children.get(idx + 1);
        child.keys.add(parent.keys.get(idx));
        parent.keys.set(idx, right.keys.remove(0));
        if (!child.isLeaf) {
            child.children.add(right.children.remove(0));
        }
    }
    private E getPredecessor(BNode<E> node) {
        while (!node.isLeaf) {
            node = node.children.get(node.children.size() - 1);
        }
        return node.keys.get(node.keys.size() - 1);
    }
    private E getSuccessor(BNode<E> node) {
        while (!node.isLeaf) {
            node = node.children.get(0);
        }
        return node.keys.get(0);
    }
    public static BTree<Integer> building_Btree(String filename) throws ItemNoFound {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int order = Integer.parseInt(reader.readLine().trim());
            Map<Integer, BNode<Integer>> nodeMap = new HashMap<>();
            BTree<Integer> tree = new BTree<>(order);
            tree.root = null;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int level = Integer.parseInt(parts[0].trim());
                int id = Integer.parseInt(parts[1].trim());
                List<Integer> keys = new ArrayList<>();
                for (int i = 2; i < parts.length; i++) {
                    keys.add(Integer.parseInt(parts[i].trim()));
                }
                BNode<Integer> node = new BNode<>(order, id);
                node.keys.addAll(keys);
                nodeMap.put(id, node);
                if (tree.root == null || level == 0) tree.root = node;
            }
            for (Map.Entry<Integer, BNode<Integer>> entry : nodeMap.entrySet()) {
                BNode<Integer> node = entry.getValue();
                for (int childId : nodeMap.keySet()) {
                    if (childId != entry.getKey()) {
                        BNode<Integer> child = nodeMap.get(childId);
                        if (child.id != node.id && child.id > node.id) {
                            node.children.add(child);
                        }
                    }
                }
                node.isLeaf = node.children.isEmpty();
            }

            return tree;
        } catch (Exception e) {
            throw new ItemNoFound("No se pudo construir el BTree desde el archivo");
        }
    }
    public String buscarNombre(int codigo) {
        return buscarNombreRecursivo(root, codigo);
    }
    private String buscarNombreRecursivo(BNode<E> node, int codigo) {
        for (E key : node.keys) {
            if (key instanceof RegistroEstudiante) {
                RegistroEstudiante r = (RegistroEstudiante) key;
                if (r.getCodigo() == codigo) {
                    return r.getNombre();
                }
            }
        }
        if (node.isLeaf) return "No encontrado";
        for (BNode<E> child : node.children) {
            String result = buscarNombreRecursivo(child, codigo);
            if (!result.equals("No encontrado")) return result;
        }
        return "No encontrado";
    }
    public void insert(E key) {
        if (root == null) {
            root = new BNode<>(order, nextId++);
        }
        if (root.keys.size() == order - 1) {
            BNode<E> s = new BNode<>(order, nextId++);
            s.isLeaf = false;
            s.children.add(root);
            splitChild(s, 0);
            root = s;
        }
        insertNonFull(root, key);
    }
    private void insertNonFull(BNode<E> node, E key) {
        int i = node.keys.size() - 1;
        if (node.isLeaf) {
            node.keys.add(null);
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                node.keys.set(i + 1, node.keys.get(i));
                i--;
            }
            node.keys.set(i + 1, key);
        } else {
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                i--;
            }
            i++;
            if (node.children.get(i).keys.size() == order - 1) {
                splitChild(node, i);
                if (key.compareTo(node.keys.get(i)) > 0) i++;
            }
            insertNonFull(node.children.get(i), key);
        }
    }
    private void splitChild(BNode<E> parent, int index) {
        BNode<E> y = parent.children.get(index);
        BNode<E> z = new BNode<>(order, nextId++);
        z.isLeaf = y.isLeaf;
        for (int j = 0; j < order / 2 - 1; j++) z.keys.add(y.keys.remove(order / 2));
        if (!y.isLeaf) {
            for (int j = 0; j < order / 2; j++) z.children.add(y.children.remove(order / 2));
        }
        parent.children.add(index + 1, z);
        parent.keys.add(index, y.keys.remove(order / 2 - 1));
    }
    public String toStructuredString() {
        StringBuilder sb = new StringBuilder();
        Queue<BNode<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BNode<E> node = queue.poll();
            sb.append("Nodo ID ").append(node.id).append(" | Claves: ").append(node.keys).append(" | Padre: ")
                    .append((node.parent != null) ? node.parent.id : "--").append(" | Hijos: [");
            for (BNode<E> child : node.children) {
                sb.append(child.id).append(", ");
                queue.add(child);
            }
            if (!node.children.isEmpty()) sb.setLength(sb.length() - 2);
            sb.append("]\n");
        }
        return sb.toString();
    }
}