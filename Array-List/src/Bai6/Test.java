package Bai6;

public class Test {

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.addAtHead(2);
        System.out.println(obj);

        obj.addAtHead(2);
        System.out.println(obj);

        obj.addAtHead(7);
        System.out.println(obj);

        obj.addAtHead(3);
        System.out.println(obj);

        obj.addAtHead(2);
        System.out.println(obj);

        obj.addAtHead(5);
        System.out.println(obj);

        obj.addAtTail(5);
        System.out.println(obj);

        System.out.println(obj.get(5));

        obj.deleteAtIndex(6);
        System.out.println(obj);

        obj.deleteAtIndex(4);
        System.out.println(obj);
    }
}
