package Luyentap5;

public class UnrivaledBinaryTree {

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

    public UnrivaledBinaryTree() {
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

    public boolean check(Node root, int value){
        if(root == null) return true;
        if(root.data != value) return false;
        else return check(root.left, value) && check(root.right, value);
    }

    public boolean isUnitalTree(Node root) {
        if(root == null) return true;
        return check(root, root.data);
    }

    public static void main(String[] args) {
        UnrivaledBinaryTree unrivaledBinaryTree = new UnrivaledBinaryTree();
        unrivaledBinaryTree.insert(2);
        unrivaledBinaryTree.insert(2);
        unrivaledBinaryTree.insert(2);
        unrivaledBinaryTree.insert(2);
        unrivaledBinaryTree.insert(2);
        unrivaledBinaryTree.insert(2);
        unrivaledBinaryTree.insert(2);
        unrivaledBinaryTree.inorderPrint(unrivaledBinaryTree.root, 0);
        System.out.println("\nIs unival tree: " + unrivaledBinaryTree.isUnitalTree(unrivaledBinaryTree.root));
    }
}
