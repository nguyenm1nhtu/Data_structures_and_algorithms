package Bai3;

public class InsertionSort implements Sort {
    
    @Override
    public void sort(int[] array) {
        int index, value;
        for (int i = 1; i < array.length; i++){
            index = i;
            value = array[i];
            while (index > 0 && array[index - 1] > value){
                array[index] = array[index - 1];
                index --;
            }
            array[index] = value;
        }
    }
}
