package Bai10;

public class Test {

    public static void main(String[] args) {
        ReverseLinkedList<String> list = new ReverseLinkedList<>();
        list.add("Dog");
        list.add("Cat");
        list.add("Wolf");
        list.add("Rhino");
        list.add("Bat",1);
        list.add("Bird",0);
        list.add("Deer", list.size() - 1);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
