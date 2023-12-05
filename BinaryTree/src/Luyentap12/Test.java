package Luyentap12;

public class Test {

    public static void main(String[] args) {
        Preorder binaryTree = new Preorder();
        binaryTree.addRoot(1);
        binaryTree.addLeft(binaryTree.getRoot(), 2);
        binaryTree.addRight(binaryTree.getRoot(), 3);
        Preorder.Node node2 = binaryTree.getLeft(binaryTree.getRoot());
        Preorder.Node node3 = binaryTree.getRight(binaryTree.getRoot());
        binaryTree.addLeft(node2, 4);
        binaryTree.addRight(node2, 5);
        binaryTree.addLeft(node3, 6);
        binaryTree.addRight(node3, 7);
        System.out.println(binaryTree);
    }
}
