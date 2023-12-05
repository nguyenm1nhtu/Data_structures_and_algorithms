package LuyenTap21;

public class LevelOrderFashion {

    Node root;
    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void inorderPrint(Node root)
    {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }
    public Node levelOrder(int[] input, int i)
    {
        Node root = null;
        if (i < input.length) {
            root = new Node(input[i]);
            root.left = levelOrder(input, 2 * i + 1);
            root.right = levelOrder(input, 2 * i + 2);
        }
        return root;
    }

    public static void main(String[] args)
    {
        LevelOrderFashion tree = new LevelOrderFashion();
        int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Output: ");
        tree.root = tree.levelOrder(input, 0);
        tree.inorderPrint(tree.root);
    }
}
