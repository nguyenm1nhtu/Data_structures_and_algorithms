package Luyentap2;

public class HeightOfTree {

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

    public HeightOfTree() {
        root = null;
    }

    public void insert(int data) {
        root = insert(data, root);
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

    private boolean isLeaf(Node p) {
        return p.left == null && p.right == null;
    }

    public int depth(Node p) {
        if (p == null) return -1;
        if (isLeaf(p)) return 0;
        return 1 + Math.max(depth(p.left), depth((p.right)));
    }

    public static void main(String[] args) {
        HeightOfTree heightoftree = new HeightOfTree();
        heightoftree.insert(3);
        heightoftree.insert(2);
        heightoftree.insert(1);
        heightoftree.insert(5);
        heightoftree.insert(4);
        heightoftree.insert(6);
        heightoftree.insert(0);
        heightoftree.insert(10);
        heightoftree.inorderPrint(heightoftree.root, 0);
        System.out.println("\nHeight of binary tree is: " + heightoftree.depth(heightoftree.root));
    }
}
