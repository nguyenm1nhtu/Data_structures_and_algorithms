package Bai2;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        this.array = (T[]) new Object[defaultSize];
    }


    @Override
    public void add(T data) {
        if (this.n >= this.defaultSize) {
            grow();
        }
        this.array[n] = data;
        n++;
    }

    private void grow() {
        int newCapacity = this.defaultSize * 2;
        T[] newData = (T[]) new Object[newCapacity];
        if (this.n >= 0) System.arraycopy(this.array, 0, newData, 0, this.n);
        this.defaultSize = newCapacity;
        this.array = newData;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= this.n) {
            System.out.println("Error");
            return null;
        } else {
            return this.array[i];
        }
    }

    @Override
    public void set(int i, T data) {
        if (i < 0 || i >= this.n) {
            System.out.println("Error");
        } else {
            this.array[i] = data;
        }
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < this.n; i++) {
            if (this.array[i].equals(data)) {
                for (int j = i; j < this.n - 1; j++) {
                    this.array[j] = this.array[j + 1];
                }
                this.array[n - 1] = null;
                break;
            }
        }
        this.n--;
    }

    @Override
    public boolean isContain(T data) {
        for (int i = 0; i < this.n; i++) {
            if (this.array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }

    @Override
    public int indexOf(T data) {
        for (int i = 0; i < this.n; i++) {
            if (this.array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.array, this.n);
    }
}