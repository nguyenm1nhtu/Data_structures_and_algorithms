package LuyenTap3;

import Bai2.*;

public class DeleteMiddle {

    public static void main(String[] args) {
        ArrayStack<Integer> numbers = new ArrayStack<>();
        numbers.push(10);
        numbers.push(11);
        numbers.push(12);
        numbers.push(20);
        numbers.push(30);
        numbers.push(33);

        System.out.println(deleteMid(numbers));
    }

    public static String deleteMid(ArrayStack numbers) {
        if (numbers.size() == 1) {
            numbers.pop();
            return "Stack is empty";
        }
        ArrayStack<Object> stack = new ArrayStack<>();
        int midIndex = (int) Math.floor(numbers.size() / 2);
        int count = 0;
        while (!numbers.isEmpty()) {
            if (count == midIndex) {
                numbers.pop();
            } else {
                stack.push(numbers.pop());
            }
            count++;
        }

        while (!stack.isEmpty()) {
            numbers.push(stack.pop());
        }

        return numbers.toString();
    }

}
