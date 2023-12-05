package Bai4;

public class Test {

    public static void main(String[] args) {
//        ArrayQueue<Integer> primeNumbers = new ArrayQueue<>();
        LinkedListQueue<Integer> primeNumbers = new LinkedListQueue<>();
        primeNumbers.enqueue(2);
        primeNumbers.enqueue(3);
        primeNumbers.enqueue(5);
        System.out.println(primeNumbers);
        System.out.println(primeNumbers.dequeue());
        System.out.println(primeNumbers);
        primeNumbers.enqueue(7);
        primeNumbers.enqueue(11);
        primeNumbers.enqueue(13);
        primeNumbers.enqueue(17);
        System.out.println(primeNumbers);
        primeNumbers.dequeue();
        System.out.println(primeNumbers);
    }
}
