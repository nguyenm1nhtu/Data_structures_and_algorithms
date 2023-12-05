package Bai2;

import Bai1.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree {

    private final StringBuilder sb;
    private final List<Character> OPERATORS = new ArrayList<>
            (Arrays.asList('+', '-', '*', '%', '/'));
    public ExpressionTree() {
        sb = new StringBuilder();
    }
    private void preorderPrint(Node<E> p) {
        if (p == null) {return;}
        sb.append(p.getElement()).append(" ");
        preorderPrint(left(p));
        preorderPrint(right(p));
    }

    private void postorderPrint(Node<E> p) {
        if (p == null) {return;}
        postorderPrint(left(p));
        postorderPrint(right(p));
        sb.append(p.getElement()).append(" ");
    }

    private void inorderPrint(Node<E> p) {
        if (p == null) {return;}
        inorderPrint(left(p));
        sb.append(p.getElement()).append(" ");
        inorderPrint(right(p));
    }

    public String printExp(String input) {
        String inputAE = input.toLowerCase().replaceAll("\\s","");
        switch (inputAE) {
            case "infix":
                inorderPrint(root());
                break;
            case "postfix":
                postorderPrint(root());
                break;
            case "prefix":
                preorderPrint(root());
                break;
            default:
                return "Wrong input!";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            result.append(sb.charAt(i));
        }
        sb.delete(0, sb.length() - 1);
        return result.toString();
    }

//    (6 / 3 + 2) * (7 - 4)
    private boolean check() {
        String exp = printExp("infix").replaceAll("\\s", "");


        if (exp.charAt(0) == '.' || exp.charAt(0) == '/' || exp.charAt(0) == '*' || exp.charAt(0) == '%') {
            return false;
        }
        for (int i = 1; i < exp.length() - 1; i++) {
            if ((exp.charAt(i) == '+' || exp.charAt(i) == '-') && (exp.charAt(i + 1) == '/' || exp.charAt(i + 1) == '*')) {
                return false;
            }
            if ((exp.charAt(i) == '/' || exp.charAt(i) == '*') && (exp.charAt(i + 1) == '/' || exp.charAt(i + 1) == '*')) {
                return false;
            }
            if ((exp.charAt(i) == '/' || exp.charAt(i) == '*') && (exp.charAt(i + 1) == '+')) {
                return false;
            }
        }
        if (exp.charAt(exp.length() - 1) > '9' || exp.charAt(exp.length() - 1) < '0') {
            return false;
        }
        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) {
                continue;
            }
            if (!OPERATORS.contains(exp.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private int calculate(int number1, int number2, char operator) {
        return switch (operator) {
            case '-' -> number2 - number1;
            case '+' -> number1 + number2;
            case '*' -> number1 * number2;
            case '/' -> {
                if (number1 == 0) {
                    System.out.println("Can't divided to 0");
                    yield  Integer.MIN_VALUE;
                }
                yield number2 / number1;
            }
            default -> {
                System.out.println("Operator went wrong!");
                yield Integer.MIN_VALUE;
            }
        };
    }

    public double evaluate() {
        if (!check()) {
            System.out.println("Wrong input");
            return Integer.MIN_VALUE;
        }
        String exp = printExp("postfix").trim();
        Stack<Integer> stackDigit = new Stack<>();
        for (String element : exp.split("\\s")) {
            if (element.matches("-?\\d+")) {
                stackDigit.push(Integer.parseInt(element));
            }
            if (OPERATORS.contains(element.charAt(0))) {
                int number1 = stackDigit.pop();
                int number2 = stackDigit.pop();
                int total = calculate(number1, number2, element.charAt(0));
                stackDigit.push(total);
            }
        }
        return stackDigit.pop();
    }

}