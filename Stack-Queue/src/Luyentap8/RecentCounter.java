package Luyentap8;

import Bai4.*;

public class RecentCounter {

    LinkedListQueue<Integer> recentCalls;

    public RecentCounter() {
        recentCalls = new LinkedListQueue<>();
    }

    public int ping(int t) {
        recentCalls.enqueue(t);
        while (recentCalls.peek() <= t - 3000) {
            recentCalls.dequeue();
        }
        return recentCalls.size();
    }
}
