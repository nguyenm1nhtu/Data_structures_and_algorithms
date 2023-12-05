package Bai2;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        GenericSort genericSort = new GenericSort();

        String[] animals = {"Dog", "Cat", "Monkey", "Tiger", "Wolf"};
        System.out.println("String Array: \n" + Arrays.toString(animals));
        genericSort.selectionSort(animals);
        System.out.println("After Sorting: \n" + Arrays.toString(animals) + "\n");

        Integer[] primeNumbers = {11, 3, 13, 7, 2, 5, 17};
        System.out.println("Prime Number Array: \n" + Arrays.toString(primeNumbers));
        genericSort.selectionSort(primeNumbers);
        System.out.println("After Sorting: \n" + Arrays.toString(primeNumbers) + "\n");

        Character[] characters = {'p', 'o', 'r', 'n', 'h', 'u', 'b'};
        System.out.println("Characters Array: \n" + Arrays.toString(characters));
        genericSort.selectionSort(characters);
        System.out.println("After Sorting: \n" + Arrays.toString(characters) + "\n");
    }
}
