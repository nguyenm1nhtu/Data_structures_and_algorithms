package LuyenTap1;

import Bai2.*;
import java.util.Scanner;

public class Bai13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String word = sc.nextLine();
        System.out.println(reverseWord(word));
    }

    public static String reverseWord (String word) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        StringBuilder reverse = new StringBuilder();
        while (!stack.isEmpty()) {
            reverse.append(stack.pop());
        }
        return reverse.toString();
    }
}
