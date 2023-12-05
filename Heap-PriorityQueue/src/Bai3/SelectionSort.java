package Bai3;


public class SelectionSort implements Sort{

    @Override
    public void sort(int[] array) {
        int indexMin;
        for (int i = 0; i < array.length-1; i++){
            indexMin = i;
            for (int j = i+1; j < array.length; j++){
                if (array[indexMin] > array[j]){
                    indexMin = j;
                }
            }
            if (i != indexMin){
                int temp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = temp;
            }
        }
    }
}
