package Luyentap6;

public class SizeOfBinaryTree {

    static class Node {

        int data;
        Node right;
        Node left;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right= right;
        }
    }

    private Node root;
    private int size;

    public SizeOfBinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insert(data, root);
        size++;
    }

    public Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data, null, null);
        } else if (data > node.data) {
            node.right = insert(data, node.right);

        } else {
            node.left = insert(data, node.left);
        }
        return node;
    }

    public void inorderPrint(Node p, int height) {
        if (p == null) {return;}
        inorderPrint(p.left, height + 1);
        System.out.print(p.data + " ");
        inorderPrint(p.right, height + 1);
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SizeOfBinaryTree size = new SizeOfBinaryTree();
        size.insert(3);
        size.insert(2);
        size.insert(1);
        size.insert(5);
        size.insert(4);
        size.insert(9);
        size.inorderPrint(size.root, 0);
        System.out.println("Size of binary tree is: " + size.getSize());
    }
}
