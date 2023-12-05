package Bai2;

import java.util.Random;

public class CompareRunningTime {

    public static void main(String[] args) {
        int[] inputSizes = {1000, 10000, 100000}; //Thời gian chạy lâu lắm
        try {
            for (int size : inputSizes) {
                int[] arr = getArray(size);
                int randomIdxToSearch = (int) (Math.random() * size);
                int randomNumToSearch = arr[randomIdxToSearch];

                System.out.println("Number to find: " + randomNumToSearch);
                System.out.println("====================================");
                System.out.println("Linear Search: ");
                linear(arr, randomNumToSearch);
                System.out.println("====================================");
                System.out.println("Binary Search: ");
                binarySearch(arr, randomNumToSearch);
                System.out.println("====================================");
                System.out.println("Binary Search Tree: ");
                binarySearchTree(arr, randomNumToSearch);

                System.out.println("\n************************************************************************\n");
            }
        } catch (OutOfMemoryError error) {
            System.out.println("Out of memories!");
        }
    }

    private static void linear(int[] array, int num) {
        LinearSearch<Integer> linear = new LinearSearch<>();
        for (int element : array) {
            linear.add(element);
        }
        linear.getTime(num);
    }

    private static void binarySearch(int[] array, int num) {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        for (int element : array) {
            binarySearch.add(element);
        }
        binarySearch.getTime(num);
    }

    private static void binarySearchTree(int[] array, int num) {
        SearchBinaryTree<Integer> bst = new SearchBinaryTree<>();
        for (int element : array) {
            bst.insert(element);
        }
        bst.getTime(num);
    }


    public static int[] getArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = inputNonDup(array, new Random(), i , 100000);
        }
        return array;
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
}
