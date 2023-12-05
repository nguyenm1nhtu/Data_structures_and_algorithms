package Bai3;

public class Test {

    public static void main(String[] args) {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add("Dog");
        simpleLinkedList.add("Cat");
        simpleLinkedList.add("Cow");
        simpleLinkedList.add("Bird");
        simpleLinkedList.add("Lion");
        System.out.println(simpleLinkedList);

        System.out.println("\nChange Lion to Fox: ");
        simpleLinkedList.set(4, "Fox");
        System.out.println(simpleLinkedList);

        System.out.print("\nContain Bird: ");
        System.out.println(simpleLinkedList.isContain("Bird"));

        System.out.print("\nCheck if List is null: ");
        System.out.println(simpleLinkedList.isEmpty());

        System.out.print("\nGet data at position 2: ");
        System.out.println(simpleLinkedList.get(2));

        System.out.println("\nRemove bot: ");
        simpleLinkedList.removeBot();
        System.out.println(simpleLinkedList);

        System.out.println("\nRemove top: ");
        simpleLinkedList.removeTop();
        System.out.println(simpleLinkedList);

        System.out.println("\nRemove Cow: ");
        simpleLinkedList.remove("Cow");
        System.out.println(simpleLinkedList);
    }
}
