package Bai4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bai41 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNumber = random.nextInt(100) + 1;
            arr[i] = randomNumber;
        }

        System.out.println("Before Sorting: \n" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Bubble Sort: \n" + Arrays.toString(arr));
    }
}
