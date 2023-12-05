package Bai6;

class LinkedList {

    static class Node {

        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public LinkedList() {
        top = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(-1);
        }
        return this.getNodeByIndex(index).data;
    }

    public void addAtHead(int val) {
        Node currentNode = new Node(val, top);
        this.top = currentNode;
        size++;
    }

    public void addAtTail(int val) {
        if (this.size == 0) {
            top = new Node(val, null);
            size++;
        } else {
            Node lastNode = this.getNodeByIndex(size - 1);
            Node newNode = new Node(val, null);
            lastNode.setNext(newNode);
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node prevNode = this.getNodeByIndex(index - 1);
            Node currentNode = this.getNodeByIndex(index);
            Node newNode = new Node(val, currentNode);
            prevNode.setNext(newNode);
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (size == 0) {
            top = null;
        }
        if (index == 0) {
            top = top.next;
            size--;
        } else if (index == size - 1) {
            Node prevNode = this.getNodeByIndex(size - 1);
            prevNode.setNext(null);
            size--;
        } else {
            Node prevNode = this.getNodeByIndex(index - 1);
            Node nextNode = this.getNodeByIndex(index + 1);
            prevNode.setNext(nextNode);
            size--;
        }
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(-1);
        }
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

