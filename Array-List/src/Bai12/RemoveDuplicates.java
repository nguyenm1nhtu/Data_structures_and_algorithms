package Bai12;

public class RemoveDuplicates<T extends Comparable<T>> {

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

    public RemoveDuplicates() {
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

    public void removeDuplicate() {
        Node current = top;
        if(top == null) {
            return;
        }
        else {
            while(current != null){
                Node temp = current;
                Node index = current.next;
                while(index != null) {
                    if(current.data == index.data) {
                        temp.next = index.next;
                    }
                    else {
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    private void sort() {
        Node currentNode = top;
        if (size == 0) {
            return;
        } else {
             while (currentNode != null) {
                 Node nextNode = currentNode.next;
                 while(nextNode != null) {
                    if (currentNode.data.compareTo(nextNode.data) > 0) {
                        T temp = currentNode.data;
                        currentNode.data = nextNode.data;
                        nextNode.data = temp;
                    }
                    nextNode = nextNode.next;
                }
                currentNode = currentNode.next;
             }
        }
    }

    public T get(int index) {
        invalid(index);
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
        sort();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(String.format("%s", get(i))).append(", ");
        }
        sb.append(get(size - 1)).append("]");
        return sb.toString();
    }
}
