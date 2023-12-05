package Bai1;

import java.util.Objects;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E>{

    protected static class NodeEntry<K, E> implements Entry<K, E> {

        K key;
        E element;
        NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            this.next = null;
        }

        public void setNext(NodeEntry<K, E> next) {
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }

        private String strNode() {
            return "[" + this.key + "\s\s\s" + this.element + "]";
        }

        @Override
        public String toString() {
            return strNode();
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K ,E> tail;
    private int size;

    public SortedLinkedPriorityQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (head == null && tail == null) || this.size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (isEmpty()) {
            this.head = newNode;
        } else if (this.size == 1) {
            this.tail = newNode;
            this.head.next = this.tail;
        } else {
            this.tail.setNext(newNode);
            this.tail = this.tail.next;
        }
        size++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        NodeEntry<K, E> oldNode = head;
        if (this.size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return oldNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return this.getNodeByIndex(0);
    }

    private NodeEntry<K, E> sortedMerge(NodeEntry<K, E> leftNode, NodeEntry<K, E> rightNode) {
        NodeEntry<K, E> newNode;

        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }

        if (leftNode.getKey().compareTo(rightNode.getKey()) < 0) {
            newNode = leftNode;
            newNode.next = sortedMerge(leftNode.next, rightNode);
        }
        else {
            newNode = rightNode;
            newNode.next = sortedMerge(leftNode, rightNode.next);
        }

        return newNode;
    }

    private NodeEntry<K, E> sortedLinkedList(NodeEntry<K, E> node) {
        if (node == null || node.next == null) {
            return node;
        }

        NodeEntry<K, E> middle = getMiddle(node);
        assert middle != null;
        NodeEntry<K, E> nexToMiddle = middle.next;

        middle.next = null;

        NodeEntry<K, E> left = sortedLinkedList(node);

        NodeEntry<K, E> right = sortedLinkedList(nexToMiddle);

        return sortedMerge(left, right);
    }

    private NodeEntry<K, E> getMiddle(NodeEntry<K, E> head) {
        if (isEmpty()) return null;

        NodeEntry<K, E> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private NodeEntry<K, E> getNodeByIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Out of index");
            return null;
        }
        NodeEntry<K, E> tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    private String printQueue() {
        this.head = sortedLinkedList(this.head);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(Objects.requireNonNull(this.getNodeByIndex(i))).append("\s");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return printQueue();
    }
}
