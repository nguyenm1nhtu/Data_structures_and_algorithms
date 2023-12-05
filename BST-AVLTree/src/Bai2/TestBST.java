package Bai2;

import java.util.Arrays;
import java.util.Random;

public class TestBST {

    public static void main(String[] args) {
        SearchBinaryTree<Integer> tree = new SearchBinaryTree<>();

        int[] input = new int[30];
        for (int i = 0; i < input.length; i++) {
            input[i] = inputNonDup(input, new Random(), i, 100);
        }
        System.out.println("Input: " + Arrays.toString(input) + "\n");

        //Test Binary Search Tree
        for (int i : input) {
            tree.insert(i);
        }
        System.out.println(tree);
        System.out.println("Smallest element is: " + tree.findMin());
        System.out.println("Search index 17 in tree: " + tree.search(input[17]).getElement());
        System.out.println("Delete index 10 in tree: " + input[10]);
        tree.delete(input[10]);
        System.out.println("Delete index 20 in tree: " + input[20]);
        tree.delete(input[20]);
        System.out.println("Delete smallest element: " + tree.findMin());
        tree.delete(input[findIndex(input, tree.findMin())]);
        System.out.println("Tree after delete some element: ");
        System.out.println(tree);
    }

    public static int inputNonDup(int[] array, Random random, int i, int bound) {
        if (array == null) {
            System.out.println("Empty array!");
            System.exit(0);
        }
        int num = random.nextInt(bound);
        while (isDuplicate(array, i, num)) {
            num = random.nextInt(bound);
        }
        return num;
    }

    public static boolean isDuplicate(int[] array, int i, int num) {
        if (array == null) {
            System.out.println("Empty array!");
            System.exit(0);
        }
        for (int j = 0; j < i; j++) {
            if (array[j] == num) {
                return true;
            }
        }
        return false;
    }

    public static int findIndex(int[] input, int data) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == data) return i;
        }
        return -1;
    }
}
