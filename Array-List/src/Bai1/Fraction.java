package Bai1;

public class Fraction {

    private float numerator;
    private float denominator;

    public Fraction (float numerator, float denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator is 0! Enter a again");
        }
        if(denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add (Fraction c) {
        float num = this.numerator * c.denominator + c.numerator * this.denominator;
        float den = this.denominator * c.denominator;
        return normalize(new Fraction(num, den));
    }

    public Fraction divi (Fraction c) {
        float num = this.numerator * c.denominator;
        float den = this.denominator * c.numerator;
        return normalize(new Fraction(num, den));
    }

    public Fraction minus (Fraction c) {
        float num = this.numerator * c.denominator - c.numerator * this.denominator;
        float den = this.denominator * c.denominator;
        return normalize(new Fraction(num, den));
    }

    public Fraction multi (Fraction c) {
        float num = this.numerator * c.numerator;
        float den = this.denominator * c.denominator;
        return normalize(new Fraction(num, den));
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public float getReal() {
        return numerator / denominator;
    }

    public Fraction realToFraction(Fraction real) {
        float numerator = real.numerator;
        float denominator = real.denominator;

        String numString = String.valueOf(numerator);
        String denString = String.valueOf(denominator);

        int strLength = Math.max((numString.length() - 1 - numString.indexOf('.')),
                (denString.length() - 1 - denString.indexOf('.')));

        for (int i = 0; i < strLength; i++) {
            numerator *= 10;
            denominator *= 10;
        }
        return new Fraction(Math.round(numerator), Math.round(denominator));
    }

    public Fraction normalize (Fraction c) {
        Fraction fraction = realToFraction(c);
        int gcd = gcd((int) fraction.numerator,(int) fraction.denominator);
        return new Fraction(fraction.numerator / gcd, fraction.denominator / gcd);
    }

    public int gcd(int numerator, int denominator) {
        if (denominator == 0) {return numerator;}
        return Math.abs(gcd(denominator,numerator % denominator));
    }

    @Override
    public String toString() {
        normalize(this);
        if (numerator % denominator == 0) {
            return Integer.toString((int) (numerator / denominator));
        }
        return (this.numerator) + "/" +  (this.denominator);
    }

}
