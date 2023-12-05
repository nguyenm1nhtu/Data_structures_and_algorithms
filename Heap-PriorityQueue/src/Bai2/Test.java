package Bai2;

public class Test {

    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> minPriQueue = new MinHeapPriorityQueue<>();
        minPriQueue.insert(1500, "Chair");
        minPriQueue.insert(2000, "Table");
        minPriQueue.insert(300, "Carpet");
        minPriQueue.insert(250, "Door");
        minPriQueue.insert(1000, "Bed");
        minPriQueue.insert(4000, "Washing machine");
        minPriQueue.insert(20, "Pillow");
        System.out.println(minPriQueue);
        minPriQueue.remove();
        System.out.println(minPriQueue);
    }
}
