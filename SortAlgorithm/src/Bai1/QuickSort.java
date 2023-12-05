package Bai1;

import java.util.Arrays;

public class QuickSort implements Sort{

    @Override
    public void sort(int[] array) {
        int[] copy = Arrays.copyOfRange(array,0, array.length);
        int low = 0;
        int high = array.length - 1;
        System.out.println("Quick Sort: ");
        quickSort(copy, low, high);
    }

    public void quickSort(int[] array, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(array, low, high);

            quickSort(array, low, pivotIdx - 1);
            quickSort(array, pivotIdx + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int index = low;

        for (int i = index + 1; i <= high; i++) {
            if (array[i] < pivot) {
                index++;
                swap(array, i, index);
            }
        }
        swap(array, low, index);
        System.out.println(Arrays.toString(array));
        return index;
    }

    private void swap(int[] array, int i, int index) {
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }
}
