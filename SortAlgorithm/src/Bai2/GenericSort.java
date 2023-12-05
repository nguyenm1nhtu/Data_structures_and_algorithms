package Bai2;

public class GenericSort <T extends Comparable<T>> {

    public void selectionSort(T[] array) {
        int minIdx;
        for (int i = 0; i < array.length; i++) {
            minIdx = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIdx].compareTo(array[j]) > 0) {
                    minIdx = j;
                }
            }

            if (i != minIdx) {
                swap(array,i , minIdx);
            }
        }
    }
    public void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
