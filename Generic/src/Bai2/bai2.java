package Bai2;

import java.util.Scanner;

public class bai2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap so phan tu: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        printPerfect(arr);
        System.out.println();
        printPrime(arr);
    }

    public static boolean prime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrime(int[] arr) {
        System.out.print("So nguyen to trong mang: ");
        for (int i = 0; i < arr.length; i++) {
            if (prime(arr[i])) {
                System.out.printf("%s ", arr[i]);
            }
        }
    }

    public static boolean perfect(int number) {
        if (number < 6) {
            return false;
        }
        int total = 0;
        for (int i = 1; i <= number/2; i++) {
            if (number % i == 0) {
                total += i;
            }
        }
        if (total != number) {
            return false;
        }
        return true;
    }

    public static void printPerfect(int[] arr) {
        System.out.print("So hoan hao trong mang: ");
        for (int i = 0; i < arr.length; i++) {
            if (perfect(arr[i])) {
                System.out.printf("%s ", arr[i]);
            }
        }
    }
}
