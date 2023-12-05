package Luyentap3;

import Bai1.LinkedBinaryTree;

public class CountLeaf {

    static LinkedBinaryTree<Integer> treeNode = new LinkedBinaryTree<>();

    public static int countLeaf(LinkedBinaryTree.Node p) {
        if (p == null) {return 0;}
        if (isLeaf(p)) {return 1;}
        return countLeaf(treeNode.left(p)) + countLeaf(treeNode.right(p));
    }

    public static boolean isLeaf(LinkedBinaryTree.Node p) {
        return treeNode.numChildren(p) == 0;
    }

    public static void main(String[] args) {
        treeNode.addRoot(4);

        treeNode.addLeft(treeNode.root(), 7);
        treeNode.addRight(treeNode.root(), 2);
        treeNode.addLeft(treeNode.left(treeNode.root()), 1);
        treeNode.addRight(treeNode.left(treeNode.root()), 3);
        treeNode.addLeft(treeNode.right(treeNode.root()), 2);
        treeNode.addRight(treeNode.right(treeNode.root()), 5);

        System.out.println(treeNode);
        System.out.println("Number of leaf: " + countLeaf(treeNode.root()));
    }
}
