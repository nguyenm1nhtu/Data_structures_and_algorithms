package Bai2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {


    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return t + 1;
    }

    @Override
    public void push(E element) {
        if (size() == data.length) {
            larger();
        }
        data[++t] = element;
    }

    @Override
    public E top() {
        if (isEmpty()) {return null;}
        return data[t];
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public E pop() {
        if (isEmpty()) {return null;}
        E dataTop = data[t];
        data[t] = null;
        t--;
        return dataTop;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private void larger() {
        E[] newData = (E[]) new Object[size() * 2];
        System.arraycopy(data, 0, newData, 0, size());
        this.t = size() * 2;
        this.data = newData;
    }

    class MyIterator<E> implements Iterator<E> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return this.position < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException("Null");
            }
            return (E) data[position++];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    @Override
    public String toString() {
        MyIterator<E> iterator = new MyIterator<>();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(String.format("%s", iterator.next())).append(" ");
        }
        return sb.toString();
    }
}
