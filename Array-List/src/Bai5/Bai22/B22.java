package Bai5.Bai22;

public class B22 {

    static class Node {

        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node top;
    private Node bot;
    private int size;

    public int size() {
        return size;
    }

    public int get(int i) {
        Node list = top;
        for (int j = 0; j < i; j++) {
            list = list.next;
        }
        return list.data;
    }

    public void add(int data) {
        if (top == null) {
            top = new Node(data, null);
            bot = top;
        } else {
            bot.next = new Node(data, null);
            bot = bot.next;
        }
        size++;
    }

    public void add(int index, int data) {
        if (index == 0) {
            top = new Node(data, top);
        } else if (index == size) {
            bot.next = new Node(data, bot);
            bot = bot.next;
        } else {
            Node list = top;
            for (int k = 0; k < index - 1; k++) {
                list = list.next;
            }
            list.next = new Node(data, list.next);
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size() - 1; i++) {
            sb.append(String.format("%s", get(i))).append(" ");
        }
        sb.append(get(size() - 1));
        return sb.toString();
    }
}
