package Bai3;

public class Test {

    public static void main(String[] args) {
        SetSort sort = new SetSort();
        int[] arr = {1 ,5 ,10 , 2, 7, 4};
        sort.setSort(new SelectionSort(), arr);
        System.out.println(sort.getTime());
        sort.setSort(new MergeSort(), arr);
        System.out.println(sort.getTime());
    }
}
