package Bai12;

public class Test {

    public static void main(String[] args) {
        RemoveDuplicates<Integer> list = new RemoveDuplicates<>();
        list.add(1);
        list.add(70);
        list.add(-12);
        list.add(0);
        list.add(42,0);
        list.add(67, list.size() - 1);
        list.add(456, 3);
        list.add(70);
        list.add(42, list.size() - 1);
        list.add(1, 0);
        System.out.println(list);
        list.removeDuplicate();
        System.out.println(list);
    }
}
