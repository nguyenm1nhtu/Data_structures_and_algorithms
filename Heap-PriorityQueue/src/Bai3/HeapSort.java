package Bai3;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] array) {
        int parent = array.length / 2 - 1;

        for (int i = parent; i >= 0; i--)
            toHeap(array, array.length, i);

        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            toHeap(array, i, 0);
        }
    }

    private void toHeap(int[] array, int size, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && array[left] > array[root])
            root = left;

        if (right < size && array[right] > array[root])
            root = right;

        if (root != i) {
            int temp = array[i];
            array[i] = array[root];
            array[root] = temp;

            toHeap(array, size, root);
        }
    }
}
