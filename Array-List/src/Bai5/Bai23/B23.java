package Bai5.Bai23;

public class B23 {

    static class Node {

        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
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

    public void remove(int index) {
        if (size == 0) {
            this.top = null;
        }
        if (index == 0) {
            this.top = top.getNext();
            if (size == 2) {
                this.bot = null;
            }
            size--;
            return;
        } else if (index == size() - 1) {
            Node prevNode = this.getNodeByIndex(size() - 1);
            prevNode.setNext(null);
            size--;
            return;
        }
        Node prevNode = this.getNodeByIndex(index - 1);
        Node nextNode = this.getNodeByIndex(index + 1);
        prevNode.setNext(nextNode);
        size--;
    }


    private Node getNodeByIndex(int index) {
        Node tempNode = top;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }
        return tempNode;
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
