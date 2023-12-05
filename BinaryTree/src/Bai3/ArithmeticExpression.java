package Bai3;

import Bai1.LinkedBinaryTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ArithmeticExpression extends LinkedBinaryTree {

    private final ArrayList<Character> OPERATORS_BRACKET = new ArrayList<>(
            Arrays.asList('+', '-', '*', '/', '^', '(', '[', '{', ')', ']', '}'));

    private boolean isValidExpression(String exp) {
        String function = exp.replaceAll("\\s", "");
        if (function.length() == 0) {
            System.out.print("Invalid input because the input is null");
            return false;
        }
        if (!checkBracket(function)) {
            System.out.println("Missing opening or closing parenthesis");
            return false;
        }
        for (int i = 0; i < function.length(); i++) {
            if (Character.isDigit(function.charAt(i))) {
                continue;
            }
            if (!OPERATORS_BRACKET.contains(function.charAt(i))) {
                System.out.println("Unknown character!");
                return false;
            }
        }
        if (function.charAt(0) == '.' || function.charAt(0) == '/' || function.charAt(0) == '*' || function.charAt(0) == '%') {
            return false;
        }
        for (int i = 1; i < function.length() - 1; i++) {
            if ((function.charAt(i) == '+' || function.charAt(i) == '-') && (function.charAt(i + 1) == '/' || function.charAt(i + 1) == '*')) {
                return false;
            }
            if ((function.charAt(i) == '/' || function.charAt(i) == '*') && (function.charAt(i + 1) == '/' || function.charAt(i + 1) == '*')) {
                return false;
            }
            if ((function.charAt(i) == '/' || function.charAt(i) == '*') && (function.charAt(i + 1) == '+')) {
                return false;
            }
        }
        return true;
    }

    private Character[] separate(String exp) {
        String expWithoutSpace = exp.replaceAll("\\s", "").trim();
        Character[] tokens = new Character[expWithoutSpace.length()];
        if (isValidExpression(expWithoutSpace)) {
            for (int i = 0; i < expWithoutSpace.length(); i++) {
                tokens[i] = expWithoutSpace.charAt(i);
            }
        }
        return tokens;
    }

    private String infixToPostfix(Character[] infix) {
        StringBuilder postFix = new StringBuilder();
        Stack<Character> stackOfChars = new Stack<>();
        for (char c : infix) {
            if (Character.isDigit(c)) {
                postFix.append(c).append(' ');
            } else if (c == '(' || c == '[' || c == '{') {
                stackOfChars.push(c);
            } else if (isOperators(c)) {
                if (isOperators(stackOfChars.peek())
                        && !stackOfChars.isEmpty()
                        && isHaveHigherOrder(stackOfChars.peek(), c)) {
                    postFix.append(stackOfChars.pop()).append(' ');
                }
                stackOfChars.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                while (stackOfChars.peek() == '('
                        || stackOfChars.peek() == '['
                        || stackOfChars.peek() == '{'
                        && !stackOfChars.isEmpty()) {
                    postFix.append(stackOfChars.pop()).append(' ');
                }
                if (stackOfChars.peek() == '('
                    || stackOfChars.peek() == '['
                    || stackOfChars.peek() == '{') {
                    stackOfChars.pop();
                }
            } else {
                System.out.println("Unknown Symbol");
            }
        }
        while (!stackOfChars.isEmpty()) {
            postFix.append(stackOfChars.pop()).append(' ');
        }

        return postFix.toString().trim();
    }

    public void convertedToTree(String input) {
        String exp = infixToPostfix(separate(input));
        Stack<Node> stackOfNode = new Stack<>();

        for (String token : exp.split("\\s")) {
            Node newNode = new Node<>(token);
            if (token.matches("-?\\d+")) {
                stackOfNode.push(newNode);
            } else if (isOperators(token.charAt(0))) {
                 newNode.setRight(stackOfNode.pop());
                 newNode.setLeft(stackOfNode.pop());
                 stackOfNode.push(newNode);
            }
        }
        printTree(stackOfNode.pop(), 0);
    }

    private void printTree(Node p, int height) {
        if (p == null) {return;}
        printTree(right(p), height + 1);
        for (int i = 0; i < height; i++) {
            System.out.print("\t");
        }
        System.out.println(p.getElement());
        printTree(left(p), height + 1);
    }

    private boolean isHaveHigherOrder(char operator1, char operator2) {
        return operatorPrecedence(operator1) >= operatorPrecedence(operator2);
    }

    private int operatorPrecedence(char operator) {
        if (operator == '^') {
            return 3;
        } else if (operator == '/' || operator == '*') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean checkBracket(String exp) {
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

    private boolean isOperators(char opChar) {
        return opChar == '+' || opChar == '-' || opChar == '*' || opChar == '/';
    }

    public static void main(String[] args) {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your expression: ");
        String exp = sc.nextLine();
        arithmeticExpression.convertedToTree(exp);
    }
}
