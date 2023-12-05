package Bai5.Bai22;

import Bai5.Bai21.B21;

public class Test {

    public static void main(String[] args) {
        B22 list = new B22();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(36);
        list.add(81);
        System.out.println(list);

        list.add(3, 17);
        list.add(list.size(), 10);
        list.add(0, 22);
        System.out.println(list);
    }
}
