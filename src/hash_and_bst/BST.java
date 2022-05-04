package hash_and_bst;

public class BST<K extends Comparable<K>, V> {
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
        newNode.left = null;
        newNode.right = null;
        insertNode(newNode);
    }

    // from book and I kinda understood the logic
    private void insertNode(Node newNode) {
        Node prev = null;
        Node parent = root;
        while (parent != null) {
            prev = parent;
            if (newNode.key.compareTo(parent.key) <= 0) parent = parent.left;
            else parent = parent.right;
        }
        //void
        if (prev == null) {
            root = newNode;
        } else if (newNode.key.compareTo(prev.key) <= 0) prev.left = newNode;
        else prev.right = newNode;
    }

    public V getNode(K key) {
        return getNode(key, root).val;
    }

    private Node getNode(K key, Node curr) {
        if (curr == null || curr.key.equals(key)) return curr;
        return curr.key.compareTo(key) >= 0 ? getNode(key, curr.left) : getNode(key, curr.right);
    }

    private Node getNodeParent(Node curr, K key, Node parent) {
        if (curr == null) return null;
        if (curr.key.equals(key)) return parent;
        return curr.key.compareTo(key) >= 0 ? getNodeParent(curr.left, key, curr) : getNodeParent(curr.right, key, curr);
    }

    public void delete(K key) {
        Node z = getNode(key, root);
        Node p = getNodeParent(root, key, root);
        if (z.left == null) Transplant(z, z.right, p);
        else if (z.right == null) Transplant(z, z.left, p);
        else {
            Node y = findMin(z.right);
            Node yParent = findMinParent(y, z.right);
            if (yParent != z) {
                Transplant(y, y.right, yParent);
                y.right = z.right;
            }
            Transplant(z, y, p);
            y.left = z.left;
        }
//        System.out.println(deleteYT(root, key).key+" - deleted");
    }

    private void Transplant(Node u, Node v, Node uParent) {
        if (uParent == null) root = v;
        else if (u == uParent.left) uParent.left = v;
        else uParent.right = v;
    }

    // this stuff doesn't work
    private Node deleteYT(Node node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) <= 0) node.left = deleteYT(node.left, key);
        else if (key.compareTo(node.key) > 0) node.right = deleteYT(node.right, key);
        else {
            if (node.left == null && node.right == null) node = null;

            else if (node.left == null || node.right == null) {
                Node temp = node.left == null ? node.right : node.left;
                return temp;
            } else {
                Node temp = findMin(node.right);
                node.key = temp.key;
                node.val = temp.val;

                node.right = deleteYT(node.right, temp.key);
                return node;
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node findMinParent(Node node, Node parent) {
        while (parent.left != null) {
            if (parent.left == node) break;
            parent = parent.left;
        }
        return parent;
    }

    public void iterator() {
//        MyQueue<K> q = new MyQueue<>();
        inOrder(root);
//        return q;
    }

    private void inOrder(Node x) {
        if (x == null) return;
        inOrder(x.left);
        System.out.print(x.key + " ");
        inOrder(x.right);
    }
}
