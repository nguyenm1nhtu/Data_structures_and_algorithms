package Bai5;

import Bai2.*;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String string = sc.nextLine();
        //Mr. Owl, ate my metal worm?
        System.out.println(isWord(string));
    }

    public static boolean isWord(String words) {
        String word = words.replaceAll("\\s", "")
                .replaceAll(",", "")
                .replaceAll("\\.", "")
                .replaceAll("\\?", "")
                .toLowerCase();

        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder reverseWord = new StringBuilder();
        while (!stack.isEmpty()) {
            reverseWord.append(stack.pop());
        }

        return reverseWord.toString().equals(word);
    }
}
