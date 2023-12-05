package Bai5.Bai23;

public class Test {

    public static void main(String[] args) {
        B23 list = new B23();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(36);
        list.add(81);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}
