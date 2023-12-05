package Luyentap1;

import java.util.Scanner;

public class Bai55 {

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter position of fibonacci: ");
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
}
