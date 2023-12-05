package LuyenTap18;

import Bai1.LinkedBinaryTree;
import java.util.Arrays;

public class LeftViewBinaryTree {

    static StringBuilder sb = new StringBuilder();
    static LinkedBinaryTree<Integer> treeNode = new LinkedBinaryTree<>();

    public static void preorderPrint(LinkedBinaryTree.Node p) {
        if (p == null) {return;}
        sb.append(p.getElement()).append(" ");
        preorderPrint(treeNode.left(p));
        preorderPrint(treeNode.right(p));
    }

    public static String[] printLeftNode() {
        preorderPrint(treeNode.root());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            result.append(sb.charAt(i));
        }
        sb.delete(0, sb.length() - 1);

        String exp = result.toString();
        String[] leftNodes = exp.split("\\s");
        return Arrays.copyOfRange(leftNodes, 0, treeNode.depth(treeNode.root()) + 1);
    }

    public static void main(String[] args) {
        treeNode.addRoot(1);
        treeNode.addLeft(treeNode.root(), 20);
        treeNode.addRight(treeNode.root(), 3);
        treeNode.addLeft(treeNode.left(treeNode.root()), 4);
        treeNode.set(treeNode.left(treeNode.root()), 2);
        treeNode.addRight(treeNode.left(treeNode.root()), 5);
        treeNode.addLeft(treeNode.right(treeNode.root()), 6);
        treeNode.addRight(treeNode.right(treeNode.root()), 7);
        treeNode.addLeft(treeNode.left(treeNode.left(treeNode.root())), 8);
        treeNode.addRight(treeNode.left(treeNode.left(treeNode.root())), 9);
        treeNode.addLeft(treeNode.right(treeNode.left(treeNode.root())), 10);
        treeNode.addRight(treeNode.right(treeNode.left(treeNode.root())), 11);
        treeNode.addLeft(treeNode.left(treeNode.right(treeNode.root())), 12);

        System.out.println(treeNode);
        System.out.println("Output: " + Arrays.toString(printLeftNode()));
    }
}
