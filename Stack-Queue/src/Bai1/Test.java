package Bai1;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        String hoten = "NguyenMinhTu";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                s.pop();
            }
            System.out.println(s);
        }
        System.out.println(s);
    }
}
