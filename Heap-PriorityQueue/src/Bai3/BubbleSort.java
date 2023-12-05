package Bai3;

import java.util.Arrays;

public class BubbleSort implements Sort{

    @Override
    public void sort(int[] array) {
        int[] copy = Arrays.copyOfRange(array,0, array.length);
        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[i] > copy[j]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }
    }
}
