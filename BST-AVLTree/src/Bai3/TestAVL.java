package Bai3;

import java.util.Arrays;
import java.util.Random;

public class TestAVL {

    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] input = new int[40];
        for (int i = 0; i < input.length; i++) {
            input[i] = inputNonDup(input, new Random(), i, 100);
        }
        System.out.println("Input: " + Arrays.toString(input));

        for (int i : input) {
            avl.insert(i);
        }
        System.out.println(avl);
        System.out.println("Smallest number in tree: " + avl.findMin());
        System.out.println("Search index 7 in tree: " + avl.search(input[7]).getElement());
        System.out.println("Delete index 19 in tree: " + input[19]);
        avl.delete(input[19]);
        System.out.println("Delete index 3 in tree: " + input[3]);
        avl.delete(input[3]);
        System.out.println("Delete smallest element: " + avl.findMin());
        avl.delete(input[findIndex(input, avl.findMin())]);
        System.out.println("Tree after delete some element: ");
        System.out.println(avl);
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
