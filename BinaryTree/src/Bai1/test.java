package Bai1;

public class test {

    public static void main(String[] args) {
//        ArrayBinaryTree<Integer> binaryTree = new ArrayBinaryTree<>();
//        binaryTree.setRoot(1);
//        binaryTree.setLeft(1,2);
//        binaryTree.setLeft(2, 4);
//        binaryTree.setRight(1, 3);
//        binaryTree.setLeft(3,6);
//        binaryTree.setRight(2, 5);
//        binaryTree.setRight(3,7);
//        binaryTree.setLeft(4,8);
//        binaryTree.setRight(4,9);
//        binaryTree.setLeft(5,10);
//        System.out.println(binaryTree);
//        System.out.println("The left of position 99 is: " + binaryTree.left(99));
//        System.out.println("The right of position 2 is: " + binaryTree.right(2));
//        System.out.println("The right of position 3 is: " + binaryTree.right(3));
//        System.out.println("The sibling of position 10 is: " + binaryTree.sibling(10));
//        System.out.println("The position of root is: " + binaryTree.root());
//        System.out.println("The number of children in position 5 is: " + binaryTree.numChildren(5));

        LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();
        binaryTree.addRoot(1);
        binaryTree.addLeft(binaryTree.root(), 20);
        binaryTree.addRight(binaryTree.root(), 3);
        binaryTree.addLeft(binaryTree.left(binaryTree.root()), 4);
        binaryTree.set(binaryTree.left(binaryTree.root()), 2);
        binaryTree.addRight(binaryTree.left(binaryTree.root()), 5);
        binaryTree.addLeft(binaryTree.right(binaryTree.root()), 6);
        binaryTree.addRight(binaryTree.right(binaryTree.root()), 7);
        binaryTree.addLeft(binaryTree.left(binaryTree.left(binaryTree.root())), 8);
        binaryTree.addRight(binaryTree.left(binaryTree.left(binaryTree.root())), 9);
        binaryTree.addLeft(binaryTree.right(binaryTree.left(binaryTree.root())), 10);
        binaryTree.addRight(binaryTree.right(binaryTree.left(binaryTree.root())), 11);
        binaryTree.addLeft(binaryTree.left(binaryTree.right(binaryTree.root())), 12);

        System.out.println(binaryTree);

        System.out.println("Number of child in position 6: " + binaryTree.numChildren(binaryTree.left(binaryTree.right(binaryTree.root()))));
        System.out.println("Parent in position 4: " + binaryTree.parent(binaryTree.left(binaryTree.left(binaryTree.root()))).getElement());
        System.out.println("Sibling in position 11: " + binaryTree.sibling(binaryTree.right(binaryTree.right(binaryTree.left(binaryTree.root())))).getElement());
        System.out.println("If binary tree is empty ? " + binaryTree.isEmpty());
        System.out.println("Depth of binary tree: " + binaryTree.depth(binaryTree.root()));
    }

}
