import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BST <K extends Comparable<K>, V> implements Iterable<BST.KandV<K, V>>{

    private Node root;
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (current.key.compareTo(key) > 0) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else if (current.key.compareTo(key) < 0) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } else {
                current.val = val;
                return;
            }
        }
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) > 0) {
                current = current.left;
            } else if (current.key.compareTo(key) < 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }
        if (key.compareTo(current.key) > 0) {
            current.right = delete(current.right, key);
        } else if (key.compareTo(current.key) < 0) {
            current.left = delete(current.left, key);
        } else {
            if (current.left == null || current.right == null) {
                return current.left == null ? current.right : current.left;
            } else {
                Node child = current.right;
                while (child.left != null) {
                    child = child.left;
                }
                current.key = child.key;
                current.val = child.val;
                current.right = delete(current.right, child.key);
            }
        }
        return current;
    }

    public int size() {
        return size(root);
    }
    private int size(Node current) {
        if (current == null) {
            return 0;
        } else {
            return size(current.left) + 1 + size(current.right);
        }
    }

    public static class KandV<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public KandV(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Iterator<KandV<K, V>> iterator() {
        List<KandV<K, V>> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list.iterator();
    }

    private void inOrderTraversal(Node node, List<KandV<K, V>> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(new KandV<>(node.key, node.val));
        inOrderTraversal(node.right, list);
    }
}