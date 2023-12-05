package Luyentap11;

public class Test {

    public static void main(String[] args) {
        Inorder binaryTree = new Inorder();
        binaryTree.addRoot(1);
        binaryTree.addLeft(binaryTree.getRoot(), 2);
        binaryTree.addRight(binaryTree.getRoot(), 3);
        Inorder.Node node2 = binaryTree.getLeft(binaryTree.getRoot());
        Inorder.Node node3 = binaryTree.getRight(binaryTree.getRoot());
        binaryTree.addLeft(node2, 4);
        binaryTree.addRight(node2, 5);
        binaryTree.addLeft(node3, 6);
        binaryTree.addRight(node3, 7);
        System.out.println(binaryTree);
    }
}
