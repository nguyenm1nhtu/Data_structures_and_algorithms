package Luyentap5;

import Bai2.SearchBinaryTree;

public class K_thSmallestElement<E extends Comparable<E>> extends SearchBinaryTree<E> {

    int count = 0;
    private E KthSmallestElement(Node<E> root, int k) {
        if(root == null)
            return null;
        E node = KthSmallestElement(root.getLeft(),k);
        if(node != null)
            return node;
        count++;
        if(count == k) {
            return root.getElement();
        }
        return KthSmallestElement(root.getRight(),k);
    }

    public E printKthSmallest(int k) {
        return KthSmallestElement(root, k);
    }

    public static void main(String[] args) {
        K_thSmallestElement<Integer> tree = new K_thSmallestElement<>();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(tree);
        System.out.println("1st smallest element: " + tree.printKthSmallest(1));
        System.out.println("3rd smallest element: " + tree.printKthSmallest(3));
    }
}
