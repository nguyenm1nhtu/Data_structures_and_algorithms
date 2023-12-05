package Luyentap6;

import Bai2.SearchBinaryTree;

public class K_thLargestElement<E extends Comparable<E>> extends SearchBinaryTree<E> {

    private E val;
    private static int i = 0;

    public E kthLargest(Node<E> root,int k)
    {
        if(root == null) return null;
        inOrder(root,k);
        i = 0;
        return val;
    }
    private void inOrder(Node<E> root,int k){
        if(root == null) return;
        inOrder(root.getRight(), k);
        i += 1;
        if(i == k) {val = root.getElement();}
        inOrder(root.getLeft(),k);
    }

    private E printKthLargest(int k) {
        return kthLargest(root, k);
    }

    public static void main(String[] args) {
        K_thLargestElement<Integer> tree = new K_thLargestElement<>();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(tree);
        System.out.println("1st largest element: " + tree.printKthLargest(1));
        System.out.println("3rd largest element: " + tree.printKthLargest(3));
    }
}
