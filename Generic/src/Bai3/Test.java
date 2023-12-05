package Bai3;

public class Test {

    public static void main(String[] args) {
        MyComplex myComplex1 = new MyComplex(3,4);
        System.out.println(myComplex1);
        MyComplex myComplex2 = new MyComplex(6, -7);
        System.out.println(myComplex2);

        System.out.println("Addition: " + myComplex1.addition(myComplex2));
        System.out.println("Subtraction: " + myComplex1.subtraction(myComplex2));
        System.out.println("Multiplication: " + myComplex1.multiplication(myComplex2));
    }
}
