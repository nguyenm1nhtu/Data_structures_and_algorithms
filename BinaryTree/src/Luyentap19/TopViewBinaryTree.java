package Luyentap19;

import Bai1.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopViewBinaryTree {

    static StringBuilder sb = new StringBuilder();
    static LinkedBinaryTree<Integer> treeNode = new LinkedBinaryTree<>();

    public static void preorderPrintP1(LinkedBinaryTree.Node p) {
        if (p == null) {return;}
        sb.append(p.getElement()).append(" ");
        preorderPrintP1(treeNode.left(p));
        preorderPrintP1(treeNode.right(p));
    }

    public static void preorderPrintP2(LinkedBinaryTree.Node p) {
        if (p == null) {return;}
        sb.append(p.getElement()).append(" ");
        preorderPrintP2(treeNode.right(p));
        preorderPrintP2(treeNode.left(p));
    }

    private static String[] printNode(String name) {
        if (name.equals("p1")) {
            preorderPrintP1(treeNode.root());
        } else {
            preorderPrintP2(treeNode.root());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            result.append(sb.charAt(i));
        }
        sb.delete(0, sb.length() - 1);

        String exp = result.toString();
        String[] leftNodes = exp.split("\\s");

        return Arrays.copyOfRange(leftNodes, 0, treeNode.depth(treeNode.root()) + 1);
    }

    private static String[] reverse(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return Arrays.copyOfRange(array, 0, array.length - 1);
    }

    public static void printTopView() {
        String[] leftSide = reverse(printNode("p1"));
        String[] rightSide = printNode("p2");
        List<String> list = new ArrayList<>();
        list.addAll(List.of(leftSide));
        list.addAll(List.of(rightSide));
        for (String s : list) {
            System.out.print(s + " ");
        }
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
        printTopView();
    }
}
