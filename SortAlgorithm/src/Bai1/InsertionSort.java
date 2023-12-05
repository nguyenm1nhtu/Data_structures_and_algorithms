package Bai1;

import java.util.Arrays;

public class InsertionSort implements Sort{
    
    @Override
    public void sort(int[] array) {
        int[] copy = Arrays.copyOfRange(array, 0 , array.length);
        int index, value;
        System.out.println("Insertion Sort: ");
        for (int i = 1; i < copy.length; i++){
            index = i;
            value = copy[i];
            while (index > 0 && copy[index - 1] > value){
                copy[index] = copy[index - 1];
                index --;
            }
            copy[index] = value;
            System.out.println(Arrays.toString(copy));
        }
    }
}
