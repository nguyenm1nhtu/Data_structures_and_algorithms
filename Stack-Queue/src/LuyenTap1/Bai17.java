package LuyenTap1;

import Bai4.*;
import java.util.Scanner;

public class Bai17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println(queue(arr, k));
    }

    public static String queue(int[] arr, int k) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int number : arr) {
            queue.enqueue(number);
        }
        for (int i = 0; i < k; i++) {
            queue.enqueue(queue.dequeue());
        }
        return queue.toString();
    }
}
