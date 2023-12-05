package Luyentap13;

public class Postorder {

    static class Node {

        int data;
        Node right;
        Node parent;
        Node left;

        public Node(int data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right= right;
        }
    }

    private Node root;

    public Postorder() {
        root = null;
    }

    public void addRoot(int data) {
        root = new Node(data, null, null, null);
    }

    public void addLeft(Node p, int data) {
        p.left = new Node(data, p, null, null);
    }

    public void addRight(Node p, int data) {
        p.right = new Node(data, p, null, null);
    }

    public Node getRoot() {
        return root;
    }

    public Node getLeft(Node p) {
        return p.left;
    }

    public Node getRight(Node p) {
        return p.right;
    }

    public void postorder(Node p, int depth) {
        if (p == null) return;
        postorder(p.left, depth + 1);
        postorder(p.right, depth + 1);
        System.out.print(p.data + " ");
    }

    @Override
    public String toString() {
        System.out.println("Here is your binary tree: ");
        postorder(root, 0);
        return " ";
    }
}

