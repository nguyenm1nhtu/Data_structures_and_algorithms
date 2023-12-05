package Bai2;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private final T[] array;
    private int position;

    private final int size;

    public MyIterator(T[] array, int size) {
        this.array = array;
        this.size = size;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return this.position < this.size;
    }

    @Override
    public T next() {
        return array[position++];
    }
}
