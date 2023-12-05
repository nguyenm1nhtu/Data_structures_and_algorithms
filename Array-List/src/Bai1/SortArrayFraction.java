package Bai1;

public class SortArrayFraction {

    public void sort(Fraction[] fractions) {
        for (int i = 0; i < fractions.length; i++) {
            for (int j = i + 1; j < fractions.length; j++) {
                if (fractions[i].getReal() > fractions[j].getReal()) {
                    Fraction temp = fractions[i];
                    fractions[i] = fractions[j];
                    fractions[j] = temp;
                }
            }
        }
    }
}
