package Bai3;

public class MyComplex {

    private int image;
    private int real;

    public MyComplex() {}

    public MyComplex(int real, int image) {
        this.image = image;
        this.real = real;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }


    public MyComplex addition(MyComplex another) {
        MyComplex myComplex = new MyComplex();
        myComplex.real = this.real + another.real;
        myComplex.image = this.image + another.image;
        return myComplex;
    }

    public MyComplex addition(int real, int image) {
        MyComplex myComplex = new MyComplex();
        myComplex.real = this.real + real;
        myComplex.image = this.image + image;
        return myComplex;
    }

    public MyComplex subtraction(MyComplex another) {
        MyComplex myComplex = new MyComplex();
        myComplex.real = this.real - another.real;
        myComplex.image = this.image - another.image;
        return myComplex;
    }

    public MyComplex subtraction(int real, int image) {
        MyComplex myComplex = new MyComplex();
        myComplex.real = this.real - real;
        myComplex.image = this.image - image;
        return myComplex;
    }

    public MyComplex multiplication(MyComplex another) {
        MyComplex myComplex = new MyComplex();
        myComplex.real = this.real * another.real - this.image * another.image;
        myComplex.image = this.real * another.image + this.image * another.real;
        return myComplex;
    }

    public MyComplex multiplication(int real, int image) {
        MyComplex myComplex = new MyComplex();
        myComplex.real = this.real * real - this.image * image;
        myComplex.image = this.real * image + this.image * real;
        return this;
    }

    @Override
    public String toString() {
        if (image > 0) {
            return real + "+" + image + "i";
        } else if (image < 0) {
            return real + "" + image + "i";
        } if (image == 0) {
            return real + "";
        } else {
            return image + "i";
        }
    }
}
