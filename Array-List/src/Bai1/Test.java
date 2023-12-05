package Bai1;

public class Test {

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(1f, 300f);
        Fraction fraction2 = new Fraction(1f, 1500f);
        Fraction fraction3 = new Fraction(1f,2f);
        Fraction fraction4 = new Fraction(2.68f, 6.8f);
        Fraction[] fractions = {fraction1, fraction2, fraction3, fraction4};

        ArrayCalculation arrayCalculation = new ArrayCalculation(fractions);
        System.out.println("List of fraction: \n" + arrayCalculation + "\n");
        System.out.println("Array addition: " + arrayCalculation.add());
        System.out.println("Array subtraction: " + arrayCalculation.minus());
        System.out.println("Array multiplication: " + arrayCalculation.multi());
        System.out.println("Array division: " + arrayCalculation.divide());
        System.out.println("Position 3 in array: " + arrayCalculation.get(3));
        SortArrayFraction sortArrayFraction = new SortArrayFraction();
        sortArrayFraction.sort(fractions);
        System.out.println("Sorted Fraction Array: " + arrayCalculation);
    }
}
