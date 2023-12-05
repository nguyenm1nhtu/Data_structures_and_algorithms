package Luyentap7;

public class CountNonLeaf {

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

    public CountNonLeaf() {
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

    public int countNonLeafNodes(Node root) {
        if(root == null) return 0;

        int left = countNonLeafNodes(root.left);
        int right = countNonLeafNodes(root.right);

        int count = left + right;
        if(root.left != null || root.right != null) count = count+1;

        return count;
    }

    public static void main(String[] args) {
        CountNonLeaf countNonLeaf = new CountNonLeaf();
        countNonLeaf.insert(3);
        countNonLeaf.insert(2);
        countNonLeaf.insert(1);
        countNonLeaf.insert(5);
        countNonLeaf.insert(4);
        countNonLeaf.insert(6);
        countNonLeaf.insert(0);
        countNonLeaf.inorderPrint(countNonLeaf.root, 0);
        System.out.println("\nNumber of non leaf in tree: " + countNonLeaf.countNonLeafNodes(countNonLeaf.root));
    }
}
