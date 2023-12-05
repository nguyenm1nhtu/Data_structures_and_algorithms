package Bai2;

public class Test {

    public static void main(String[] args) {
        ListInterface<String> strings = new SimpleArrayList<>();
        strings.add("Ăn");
        strings.add("Chuối");
        strings.add("Chấm");
        strings.add("Muối");
        strings.add("Ớt");

        for (int i = 0; i < strings.size(); i++) {
            System.out.printf("%s ",strings.get(i));
        }
        System.out.println();
        System.out.println(strings.isContain("Muối"));
        strings.set(4, "Muối");
        for (int i = 0; i < strings.size(); i++) {
            System.out.printf("%s ",strings.get(i));
        }
        System.out.println();
        strings.remove("Muối");
        for (int i = 0; i < strings.size(); i++) {
            System.out.printf("%s ",strings.get(i));
        }
        System.out.println();
        System.out.println(strings.isEmpty());
    }

}
