package Bai1;

import java.util.Objects;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

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

    public UnsortedLinkedPriorityQueue() {
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
        return (this.head == null && this.tail == null) || this.size == 0;
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
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {

            for (int i = 0; i < size; i++) {
                if (this.getNodeByIndex(i) == min()) {
                    oldNode = this.getNodeByIndex(i);

                    if (i == 0) {
                        head = head.next;
                        size--;
                    } else if (i == size - 1) {
                        NodeEntry<K, E> prevLastNode = this.getNodeByIndex(size - 2);
                        assert prevLastNode != null;
                        prevLastNode.next = null;
                        this.tail = prevLastNode;
                        size--;
                    } else {
                        NodeEntry<K, E> prevNode = this.getNodeByIndex(i - 1);
                        NodeEntry<K, E> nextNode = this.getNodeByIndex(i + 1);
                        assert prevNode != null;
                        prevNode.setNext(nextNode);
                        size--;
                    }
                    break;
                }
            }
        }
        return oldNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        if (size == 1) return head;

        NodeEntry<K, E> min = head;
        for (int i = 0; i < size; i++) {
            assert min != null;
            if (Objects.requireNonNull(this.getNodeByIndex(i)).getKey().compareTo(min.getKey()) < 0) {
                min = this.getNodeByIndex(i);
            }
        }
        return min;
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
