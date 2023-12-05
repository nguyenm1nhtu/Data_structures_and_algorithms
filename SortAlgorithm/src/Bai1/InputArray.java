package Bai1;

import java.util.Random;
import java.util.Scanner;

public class InputArray {

    public int[] inputArray() {
        int[] array = new int[size()];
        int bound = bound();
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(bound) + 1;
            array[i] = randomNumber;
        }
        return array;
    }

    public static int size() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        return sc.nextInt();
    }

    public static int bound() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the bound: ");
        return sc.nextInt();
    }
}
