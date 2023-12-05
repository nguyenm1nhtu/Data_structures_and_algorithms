package Bai2;

public class Test {

    public static void main(String[] args) {
        ArrayStack<String> animals = new ArrayStack<>();
//        LinkedListStack<String> animals = new LinkedListStack<>();
        animals.push("Dog");
        System.out.println(animals);
        System.out.println(animals.isEmpty());
        animals.push("Cat");
        animals.push("Wolf");
        animals.push("Cheetah");
        animals.push("Monkey");
        animals.push("Lion");
        System.out.println(animals.pop());
        System.out.println(animals);
        System.out.println(animals.top());
    }
}
