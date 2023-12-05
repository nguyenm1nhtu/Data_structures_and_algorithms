package Bai4;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {

    class Node {

        Node next;
        E element;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        if (isEmpty()) {
            head = new Node(element, null);
        } else {
            tail = this.getNodeByIndex(size - 1);
            Node newNode = new Node(element, null);
            tail.setNext(newNode);
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node oldData = this.getNodeByIndex(0);
        head = head.next;
        size--;
        return oldData.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty()) {return null;}
        return head.element;
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
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator<>();
    }

    class StackIterator<E> implements Iterator<E> {

        //private int num = 0;
        private Node node=head;

        @Override
        public boolean hasNext() {
            return head!=null;
        }

        @Override
        public E next() {
            E val= (E) node.element;
            node = node.next;
            return val;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getNodeByIndex(0).element);
        for (int i = 1; i < size; i++) {
            sb.append(", ").append(String.format("%s", this.getNodeByIndex(i).element));
        }
        return sb.toString();
    }
}
