package Luyentap4;

public class SumOfLeftLeaf {

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

    public SumOfLeftLeaf() {
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

    public int sumOfLeftLeaves(Node root) {
        int sum = 0;
        if(root==null) return 0;
        if(root.left!=null && root.left.right==null && root.left.left==null)
            sum += root.left.data;
        sum+= sumOfLeftLeaves(root.left);
        sum+= sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        SumOfLeftLeaf sumOfLeftLeaf = new SumOfLeftLeaf();
        sumOfLeftLeaf.insert(3);
        sumOfLeftLeaf.insert(2);
        sumOfLeftLeaf.insert(1);
        sumOfLeftLeaf.insert(5);
        sumOfLeftLeaf.insert(4);
        sumOfLeftLeaf.inorderPrint(sumOfLeftLeaf.root, 0);
        System.out.println("\nSum of left leaf is: " + sumOfLeftLeaf.sumOfLeftLeaves(sumOfLeftLeaf.root));
    }
}
