package trash;

class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node delete(Node node, int val) {
        if(node == null) {
            return node;
        }

        if(val < node.data) {
            node.left = delete(node.left, val);
        } else if(val > node.data) {
            node.right = delete(node.right, val);
        } else {
            if(node.left == null || node.right == null) {
                Node temp = node.left != null ? node.left : node.right;

                if(temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                Node successor = getSuccessor(node);
                node.data = successor.data;

                node.right = delete(node.right, successor.data);
                return node;
            }
        }

        return node;
    }

    public Node getSuccessor(Node node) {
        if(node == null) {
            return null;
        }

        Node temp = node.right;

        while(temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    public Node insert(Node node, int val) {
        if(node == null) {
            return createNewNode(val);
        }

        if(val < node.data) {
            node.left = insert(node.left, val);
        } else if((val > node.data)) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public Node createNewNode(int k) {
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }
    public void iterator(Node root) {
//        MyQueue<K> q = new MyQueue<>();
        inOrder(root);
//        return q;
    }

    private void inOrder(Node x) {
        if (x == null) return;
        inOrder(x.left);
        System.out.print(x.data + " ");
        inOrder(x.right);
    }
}

public class BSTApp {

    public static void main(String[] args) {
        BST a = new BST();
        Node root = null;

        root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 6);
        root = a.insert(root, 10);
        root = a.insert(root, 4);
        root = a.insert(root, 7);
        root = a.insert(root, 1);
        root = a.insert(root, 14);
        root = a.insert(root, 13);
        a.iterator(root);
        root = a.delete(root, 8);
        a.iterator(root);
    }

}