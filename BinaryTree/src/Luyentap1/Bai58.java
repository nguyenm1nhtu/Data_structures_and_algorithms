package Luyentap1;

import java.util.Scanner;

public class Bai58 {

    public static void binary(int size, String s) {
        if (size == 0) {
            System.out.print(s + " ");
            return;
        }
        for (String element : new String[]{"0", "1"}) {
            binary(size - 1, s + element);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        binary(size, "");
    }
}
