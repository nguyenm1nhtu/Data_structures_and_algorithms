package Bai1;

public class Test {

    public static void main(String[] args) {
        PriorityQueueInterface<Integer, String> roadToHaNoiByKm = new UnsortedArrayPriorityQueue<>();
        roadToHaNoiByKm.insert(104, "Thai Binh");
        roadToHaNoiByKm.insert(668, "Hue");
        roadToHaNoiByKm.insert(1688, "Tp Hcm");
        roadToHaNoiByKm.insert(765, "Ca Mau");
        roadToHaNoiByKm.insert(38, "Hung Yen");
        roadToHaNoiByKm.insert(1979, "Ca Mau");
        roadToHaNoiByKm.insert(84, "Nam dinh");
        roadToHaNoiByKm.insert(1086, "Kon Tum");
        System.out.println("Here is your queue: " + roadToHaNoiByKm);
        System.out.println("Smallest distance to Hanoi: " + roadToHaNoiByKm.min());
        roadToHaNoiByKm.removeMin();
        System.out.println("Queue after delete smallest distance: " + roadToHaNoiByKm);
        System.out.println("Smallest distance to Hanoi: " + roadToHaNoiByKm.min());

        System.out.println("\n===================================================================================================\n");

        PriorityQueueInterface<Integer, Integer> primeNumbers = new UnsortedArrayPriorityQueue<>();
        primeNumbers.insert(2, 1);
        primeNumbers.insert(3, 2);
        primeNumbers.insert(5, 3);
        primeNumbers.insert(7, 4);
        primeNumbers.insert(11, 5);
        primeNumbers.insert(13, 6);
        primeNumbers.insert(17, 7);
        primeNumbers.insert(23, 8);
        System.out.println("Here is your queue: " + primeNumbers);
        System.out.println("Smallest prime number: " + primeNumbers.min());
        primeNumbers.removeMin();
        System.out.println("Queue after delete smallest prime number: " + primeNumbers);
        System.out.println("Smallest prime number: " + primeNumbers.min());

        System.out.println("\n===================================================================================================\n");

        PriorityQueueInterface<Integer, Integer> randomNumbers = new SortedArrayPriorityQueue<>();
        randomNumbers.insert(2000, 1);
        randomNumbers.insert(31, 2);
        randomNumbers.insert(59, 3);
        randomNumbers.insert(79856, 4);
        randomNumbers.insert(110, 5);
        randomNumbers.insert(138, 6);
        randomNumbers.insert(17, 7);
        randomNumbers.insert(230, 8);
        System.out.println("Here is your queue: " + randomNumbers);
        System.out.println("Smallest number: " + randomNumbers.min());
        randomNumbers.removeMin();
        System.out.println("Queue after delete smallest number: " + randomNumbers);
        System.out.println("Smallest number: " + randomNumbers.min());

        System.out.println("\n===================================================================================================\n");

        PriorityQueueInterface<Integer, String> bookPrice = new SortedArrayPriorityQueue<>();
        bookPrice.insert(900, "Sherlock Holmes");
        bookPrice.insert(344, "No way home");
        bookPrice.insert(1000, "Harry Potter");
        bookPrice.insert(100, "The killing machine");
        System.out.println("Here is your queue: " + bookPrice);
        System.out.println("Smallest price: " + bookPrice.min());
        bookPrice.removeMin();
        System.out.println("Queue after delete smallest price: " + bookPrice);
        System.out.println("Smallest price: " + bookPrice.min());

        System.out.println("\n===================================================================================================\n");

        PriorityQueueInterface<Integer, String> studentHeight = new UnsortedLinkedPriorityQueue<>();
        studentHeight.insert(154, "Nguyen Ha An");
        studentHeight.insert(195, "Nguyen Trung Nghia");
        studentHeight.insert(155, "Tran Bao Ngoc");
        studentHeight.insert(174, "Nguyen Minh Tu");
        studentHeight.insert(169, "Doan Trung Hieu");
        studentHeight.insert(162, "Nguyen Phuong Anh");
        System.out.println("Here is your queue: " + studentHeight);
        System.out.println("Lowest height: " + studentHeight.min());
        studentHeight.removeMin();
        System.out.println("Queue after delete lowest height: " + studentHeight);
        System.out.println("Lowest height: " + studentHeight.min());

        System.out.println("\n===================================================================================================\n");

        PriorityQueueInterface<Integer, Integer> randomNum = new UnsortedLinkedPriorityQueue<>();
        randomNum.insert(200, 1);
        randomNum.insert(3, 2);
        randomNum.insert(9, 3);
        randomNum.insert(856, 4);
        randomNum.insert(10, 5);
        randomNum.insert(18, 6);
        randomNum.insert(7, 7);
        randomNum.insert(0, 8);
        System.out.println("Here is your queue: " + randomNum);
        System.out.println("Smallest number: " + randomNum.min());
        randomNum.removeMin();
        System.out.println("Queue after delete smallest number: " + randomNum);
        System.out.println("Smallest number: " + randomNum.min());

        System.out.println("\n===================================================================================================\n");

        PriorityQueueInterface<Integer, String> studentAge = new SortedLinkedPriorityQueue<>();
        studentAge.insert(15, "Nguyen Ha Anh Truc");
        studentAge.insert(19, "Nguyen Trung Nghia");
        studentAge.insert(12, "Tran Bao Ngoc Mai");
        studentAge.insert(17, "Nguyen Minh Tu");
        studentAge.insert(16, "Doan Trung Hieu");
        studentAge.insert(18, "Nguyen Phuong Anh");
        System.out.println("Here is your queue: " + studentAge);
        System.out.println("Lowest age price: " + studentAge.min());
        studentAge.removeMin();
        System.out.println("Queue after delete lowest age: " + studentAge);
        System.out.println("Lowest height age: " + studentAge.min());
    }
}
