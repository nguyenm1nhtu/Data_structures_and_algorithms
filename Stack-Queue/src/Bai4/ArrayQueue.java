package Bai4;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue() {
        this.queue = (E[]) new Object[default_size];
        this.n = default_size;
    }

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (n == queue.length) {
            larger();
        }
        queue[count] = element;
        count  = (count + 1) % queue.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E oldData = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length;
        return oldData;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E data = queue[top];
        top = (top + 1) % queue.length;
        return data;
    }

    private void larger() {
        E[] newData = (E[]) new Object[size() * 2];
        System.arraycopy(queue, 0, newData, 0, n);
        this.n = size() * 2;
        this.queue = newData;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator<>();
    }

    class StackIterator<E> implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = (E) queue[(current + num) % n];
            num++;
            return data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int head = top;
        if (head != count)
        {
            sb.append(queue[head]);
            head = (head + 1) % n;
            while (head != count)
            {
                sb.append(", ").append(String.format("%s", queue[head]));
                head = (head + 1) % n;
            }
        }
        return sb.toString();
    }
}
