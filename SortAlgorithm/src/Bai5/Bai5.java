package Bai5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bai5 {

    public static int[] sort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
        return array;
    }

    public static void quickSort(int[] array, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(array, low, high);

            quickSort(array, low, pivotIdx - 1);
            quickSort(array, pivotIdx + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int index = low;

        for (int i = index + 1; i <= high; i++) {
            if (array[i] < pivot) {
                index++;
                swap(array, i, index);
            }
        }
        swap(array, low, index);
        return index;
    }

    private static void swap(int[] array, int i, int index) {
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNumber = random.nextInt(100) + 1;
            arr[i] = randomNumber;
        }

        System.out.println("Before Sorting: \n" + Arrays.toString(arr));
        System.out.println("After Sorting: \n" + Arrays.toString(sort(arr)));
    }
}
