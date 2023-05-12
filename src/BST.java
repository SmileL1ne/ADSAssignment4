public class BST <K extends Comparable<K>, V> {

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
        Node current = root;
        while (current.left != null && current.right != null) {
            if (current.key.compareTo(key) > 0) {
                current = current.right;
            } else if (current.key.compareTo(key) < 0) {
                current = current.left;
            } else {
                current.val = val;
            }
        }
        if (current.key.compareTo(key) > 0) {
            current.left = new Node(key, val);
        } else {
            current.right = new Node(key, val);
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
        Node current = root;
        while (!current.key.equals(key)) {
            if (current.key.compareTo(key) > 0) {
                current = current.left;
            } else if (current.key.compareTo(key) < 0) {
                current = current.right;
            }
        }

        if (current.)
    }
}