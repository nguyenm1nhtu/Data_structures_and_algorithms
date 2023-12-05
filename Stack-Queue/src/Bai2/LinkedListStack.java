package Bai2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E>{

    class Node {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node stack;
    private int size;

    public LinkedListStack() {
        stack = null;
        size = 0;
    }

    @Override
    public void push(E element) {
        if (isEmpty()) {
            stack = new Node(element, null);
        } else {
            Node lastNode = this.getNodeByIndex(size - 1);
            Node newNode = new Node(element, null);
            lastNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E oldData = this.getNodeByIndex(size - 1).element;
        if(size == 1) {
            stack = null;
        } else {
            Node lastNode = this.getNodeByIndex(size - 2);
            lastNode.setNext(null);
        }
        size--;
        return oldData;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (isEmpty()) {return null;}
        return this.getNodeByIndex(size - 1).element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private Node getNodeByIndex(int index) {
        Node node = stack;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    class StackIterator implements Iterator<E> {

        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

    @Override
    public String toString() {
        StackIterator iterator = new StackIterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(String.format("%s", iterator.next())).append(" ");
        }
        return sb.toString();
    }
}
