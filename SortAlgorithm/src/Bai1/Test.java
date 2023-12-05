package Bai1;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        InputArray input = new InputArray();
        int[] arr = input.inputArray();
        SetSort sort = new SetSort();


        System.out.println("Before Sorting: \n" + Arrays.toString(arr) + " \n");

        sort.setSort(new QuickSort(), arr);
        System.out.println("Run Time: " + sort.getTime() + "ns\n");

        sort.setSort(new BubbleSort(), arr);
        System.out.println("Run Time: " + sort.getTime() + "ns\n");

        sort.setSort(new InsertionSort(), arr);
        System.out.println("Run Time: " + sort.getTime() + "ns\n");

        sort.setSort(new SelectionSort(), arr);
        System.out.println("Run Time: " + sort.getTime() + "ns\n");

        sort.setSort(new MergeSort(), arr);
        System.out.println("Run Time: " + sort.getTime() + "ns\n");
    }
}
