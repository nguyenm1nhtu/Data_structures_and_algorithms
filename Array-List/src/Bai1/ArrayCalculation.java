package Bai1;

import java.util.Arrays;

public class ArrayCalculation {

    private Fraction[] fractions;

    public ArrayCalculation() {
        fractions = null;
    }

    public ArrayCalculation(Fraction[] fractions) {
        this.fractions = fractions;
    }


    public Fraction add() {
        Fraction result = fractions[0];
        for (int i = 1; i < this.fractions.length; i++) {
            result = result.add(this.fractions[i]);
        }
        return result;
    }

    public Fraction minus() {
        Fraction result = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            result = result.minus(this.fractions[i]);
        }
        return result;
    }

    public Fraction multi() {
        Fraction result = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            result = result.multi(this.fractions[i]);
        }
        return result;
    }

    public Fraction divide() {
        Fraction result = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            result = result.divi(this.fractions[i]);
        }
        return result;
    }

    public Fraction get(int index) {
        return fractions[index - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(fractions);
    }
}
