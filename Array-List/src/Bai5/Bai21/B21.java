package Bai5.Bai21;

public class B21 {

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

