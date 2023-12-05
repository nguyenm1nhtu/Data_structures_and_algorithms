package Bai10;

public class ReverseLinkedList<T> {

    class Node {

        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public ReverseLinkedList() {
        top = null;
        size = 0;
    }

    public void add(T data, int index) {
        invalid(index);
        if (index == 0) {
            this.top = new Node(data, top);
        } else if (index == size - 1) {
            this.add(data);
            size--;
        } else {
            Node prevNode = this.getNodeByIndex(index - 1);
            Node currentNode = this.getNodeByIndex(index);
            Node newNode = new Node(data, currentNode);
            prevNode.setNext(newNode);
        }
        size++;
    }

    public void add(T data) {
        if (size == 0) {
            this.top = new Node(data, null);
        } else {
            Node lastNode = this.getNodeByIndex(size - 1);
            Node newNode = new Node(data, null);
            lastNode.setNext(newNode);
        }
        size++;
    }

    public void reverse() {
        Node prevNode = null;
        Node currentNode = top;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        top = prevNode;
    }

    public T get(int index) {
        Node getNode = getNodeByIndex(index);
        return getNode.data;
    }

    public int size() {
        return size;
    }

    private void invalid(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Error");
        }
    }

    private Node getNodeByIndex(int index) {
        invalid(index);
        Node tempNode = top;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(String.format("%s", get(i))).append(", ");
        }
        sb.append(get(size - 1)).append("]");
        return sb.toString();
    }
}