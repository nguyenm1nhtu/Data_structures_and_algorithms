package Bai1;

import java.util.Arrays;

public class SelectionSort implements Sort{

    @Override
    public void sort(int[] array) {
        int[] copy = Arrays.copyOfRange(array,0, array.length);
        System.out.println("Selection Sort: ");
        int indexMin;
        for (int i = 0; i < copy.length-1; i++){
            indexMin = i;
            for (int j = i+1; j < copy.length; j++){
                if (copy[indexMin] > copy[j]){
                    indexMin = j;
                }
            }
            if (i != indexMin){
                int temp = copy[i];
                copy[i] = copy[indexMin];
                copy[indexMin] = temp;
            }
            System.out.println(Arrays.toString(copy));
        }
    }
}
