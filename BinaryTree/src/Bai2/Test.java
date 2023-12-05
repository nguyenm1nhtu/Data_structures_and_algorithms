package Bai2;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter arithmetic expression: ");
//        prefix    postfix    infix
        String arithmeticExp = sc.nextLine();
        ExpressionTree<String> binaryTree = new ExpressionTree<>();
        binaryTree.addRoot("*");
        binaryTree.addLeft(binaryTree.root(), "+");
        binaryTree.addRight(binaryTree.root(), "-");
        binaryTree.addLeft(binaryTree.left(binaryTree.root()), "/");
        binaryTree.addRight(binaryTree.left(binaryTree.root()), "2");
        binaryTree.addLeft(binaryTree.right(binaryTree.root()), "7");
        binaryTree.addRight(binaryTree.right(binaryTree.root()), "4");
        binaryTree.addLeft(binaryTree.left(binaryTree.left(binaryTree.root())), "6");
        binaryTree.addRight(binaryTree.left(binaryTree.left(binaryTree.root())), "3");

        System.out.println(binaryTree.printExp(arithmeticExp));
        System.out.println("The result is: " + binaryTree.evaluate());
    }
}