package Bai3;

public class SimpleLinkedList<T> {

    class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        if (top == null) {
            top = new Node(data, null);
            bot = top;
        } else {
            bot.next = new Node(data, null);
            bot = bot.next;
        }
        n++;
    }

    public boolean isContain (T data) {
        Node list = top;
        while (list != null) {
            if (list.data.equals(data)) {
                return true;
            } else {
                list = list.next;
            }
        }
        return false;
    }

    public void set(int i, T data) {
        Node list = top;
        for (int j = 0; j < i; j++) {
            list = list.next;
        }
        list.data = data;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        Node list = top;
        for (int j = 0; j < index; j++) {
            list = list.next;
        }
        return list.data;
    }

    public int size() {
        return n;
    }

    public T removeBot() {
        if (this.n == 0) {
            return null;
        }
        T oldData;
        if (this.n == 1) {
            oldData = this.top.getData();
            this.top = null;
        } else {
            oldData = this.bot.getData();
            Node prevNode = this.getNodeByIndex(size() - 1);
            prevNode.setNext(null);
            if (this.n > 2) {
                this.bot = prevNode;
            }
        }
        n--;
        return oldData;
    }
    public T removeTop() {
        if (this.n == 0) {
            return null;
        }
        T oldData = this.top.getData();
        if (this.n > 1) {
            this.top = top.getNext();
            if (this.n == 2) {
                this.bot = null;
            }
        } else {
            this.top = null;
        }
        n--;
        return oldData;
    }

    public void remove(T data) {
        Node list = top;
        Node previous = null;
        while (list != null) {
            if (list.data.equals(data)) {
                if (previous == null) {
                    top = top.next;
                } else {
                    previous.next = list.next;
                }
                list.data = null;
                n--;
            }
            previous = list;
            list = list.next;
        }
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
        sb.append("[");
        for (int i = 0; i < size() - 1; i++) {
            sb.append(String.format("%s", get(i).toString())).append(", ");
        }
        sb.append(get(size() - 1)).append("]");
        return sb.toString();
    }
}
