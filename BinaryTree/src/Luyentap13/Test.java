package Luyentap13;

public class Test {

    public static void main(String[] args) {
        Postorder binaryTree = new Postorder();
        binaryTree.addRoot(1);
        binaryTree.addLeft(binaryTree.getRoot(), 2);
        binaryTree.addRight(binaryTree.getRoot(), 3);
        Postorder.Node node2 = binaryTree.getLeft(binaryTree.getRoot());
        Postorder.Node node3 = binaryTree.getRight(binaryTree.getRoot());
        binaryTree.addLeft(node2, 4);
        binaryTree.addRight(node2, 5);
        binaryTree.addLeft(node3, 6);
        binaryTree.addRight(node3, 7);
        System.out.println(binaryTree);
    }
}
