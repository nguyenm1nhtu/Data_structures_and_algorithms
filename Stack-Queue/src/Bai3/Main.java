package Bai3;

import java.util.Stack;

public class Main {

    public static boolean check(String exp) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(' ||
                exp.charAt(i) == '[' ||
                exp.charAt(i) == '{') {
                stack.push(exp.charAt(i));
                continue;
            }

            switch (exp.charAt(i)) {
                case (')'):
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case (']'):
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case ('}'):
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static int calculate(String expR) {
        String exp = expR.replaceAll("\\s", "");
        Stack<Character> calculate = new Stack<>();
        StringBuilder sb = new StringBuilder();
        //(5-(8-4)*(2+3))+(8/4)
        if (check(exp)) {

            for (int i = 0; i < exp.length(); i++) {
                if(!Character.isDigit(exp.charAt(i))){

                    if (exp.charAt(i) == ')' ||
                            exp.charAt(i) == ']' ||
                            exp.charAt(i) == '}') {

                        sb.append(calculate.pop());
                        if (calculate.peek() == '(' ||
                            calculate.peek() == '[' ||
                            calculate.peek() == '{') {
                            calculate.pop();
                        } else {
                            sb.append(calculate.pop());
                            calculate.pop();
                        }
                        continue;
                    }
                    calculate.push(exp.charAt(i));
                    //calculate:(-(
                } else {
                    sb.append(exp.charAt(i));
                    //sb:584-23+*-
                }
            }
            while (!calculate.isEmpty()){
                sb.append(calculate.pop());
            }

        } else {
            System.out.println("Invalid");
            return -1;
        }
        return calculateNum(sb.toString());
    }

    public static int calculateNum(String exp) {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) {
                numbers.push(Character.getNumericValue(exp.charAt(i)));
                continue;
            }
            int number1 = numbers.pop();
            int number2 = numbers.pop();
            switch (exp.charAt(i)) {
                case '+' -> numbers.push(number1 + number2);
                case '-' -> numbers.push(number2 - number1);
                case '*' -> numbers.push(number1 * number2);
                case '/' -> numbers.push(number2 / number1);
            }
        }
        return numbers.pop();
    }

    public static void main(String[] args) {
        String bt0 = "{a * [b - (c + d) + e]";
        String bt1 = "(a − b) * (c + d)";
        String bt2 = "(10 + 8)/((5 − 2) ∗ 17)";
        String bt3 = "(a + b) * c − d)";
        String bt4 = "(10 − 8/((2 + 5) * 17)";
        String bt5 = ")u − v) * (m + n)";
        String bt6 = "(1 + ((2 + 3) * (8 * 5)))";
        String bt7 = "(5 - (8 - 4) * (2 + 3)) + (8 / 4)";

        System.out.println(check(bt0));
        System.out.println(check(bt1));
        System.out.println(check(bt2));
        System.out.println(check(bt3));
        System.out.println(check(bt4));
        System.out.println(check(bt5));
        System.out.println(bt6 + " = " + calculate(bt6));
        System.out.println(bt7 + " = " + calculate(bt7));
    }
}
