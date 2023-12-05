package Luyentap8;

public class MinimumDepth {

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

    public MinimumDepth() {
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

    public static int minDepth(Node root) {
        int[] ans =new int[1];
        MinHeight(root,1,ans);
        return ans[0];
    }
    public static void MinHeight(Node root, int level, int[] ans){
        if(root==null)return;
        if(root.left==null && root.right==null){
            ans[0] = (ans[0] == 0) ? level : Math.min(ans[0], level);
            return;
        }
        MinHeight(root.left,level+1,ans);
        MinHeight(root.right,level+1,ans);
    }

    public void inorderPrint(Node p, int height) {
        if (p == null) {return;}
        inorderPrint(p.left, height + 1);
        System.out.print(p.data + " ");
        inorderPrint(p.right, height + 1);
    }

    public static void main(String[] args) {
        MinimumDepth minimumDepth = new MinimumDepth();
        minimumDepth.insert(3);
        minimumDepth.insert(2);
        minimumDepth.insert(1);
        minimumDepth.insert(5);
        minimumDepth.insert(4);
        minimumDepth.insert(6);
        minimumDepth.insert(0);
        minimumDepth.inorderPrint(minimumDepth.root, 0);
        System.out.println("\nMinimum Depth is: " + minDepth(minimumDepth.root));
    }
}
