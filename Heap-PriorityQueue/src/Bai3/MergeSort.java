package Bai3;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        mergeSort(array, low, high);
    }

    void merge(int[] array, int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = array[mid + 1 + j];
        }


        int i = 0, j = 0;

        int key = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                array[key] = leftArr[i];
                i++;
            }
            else {
                array[key] = rightArr[j];
                j++;
            }
            key++;
        }

        while (i < n1) {
            array[key] = leftArr[i];
            i++;
            key++;
        }

        while (j < n2) {
            array[key] = rightArr[j];
            j++;
            key++;
        }
    }

    void mergeSort(int[] array, int left, int right)
    {
        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }
}
