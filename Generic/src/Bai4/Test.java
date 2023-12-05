package Bai4;

public class Test {

    public static void main(String[] args) {
        MySphere mySphere1 = new MySphere(1,1,2,4);
        MySphere mySphere2 = new MySphere(-1,2,-1,3);
        System.out.println(mySphere1);

        System.out.println("Volume: " + mySphere1.volume());
        System.out.println("Area: " + mySphere1.area());

        System.out.println(mySphere2);
        System.out.println("Intersect: " + mySphere1.intersect(mySphere2));
        System.out.println("Cover: " + mySphere1.cover(mySphere2));
    }
}
