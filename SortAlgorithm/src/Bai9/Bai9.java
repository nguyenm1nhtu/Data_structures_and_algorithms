package Bai9;

import java.util.Scanner;

public class Bai9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int size = sc.nextInt();
        System.out.print("Enter the student's position in line: ");
        int position = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the height of each student: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The new position is: " + findStudent(arr,position - 1));
    }

    public static int findStudent(int[] arr, int position) {
        int ti_height = arr[position];
        sort(arr);
        return binarySearch(arr, 0, arr.length - 1, ti_height) + 1;
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int height) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == height)
                return mid;

            if (arr[mid] > height)
                return binarySearch(arr, left, mid - 1, height);

            return binarySearch(arr, mid + 1, right, height);
        }
        return -1;
    }
}
