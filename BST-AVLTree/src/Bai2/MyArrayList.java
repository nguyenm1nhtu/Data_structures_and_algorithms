package Bai2;

public abstract class MyArrayList<T> {

    protected T[] array;
    protected int size;
    private final int DEFAULT_SIZE = 10000;

    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public void add(T data) {
        if (this.size >= this.DEFAULT_SIZE) {
            larger();
        }
        if (isEmpty()) return;
        this.array[size++] = data;
    }

    private void larger() {
        T[] newData = (T[]) new Object[size() * 10];
        System.arraycopy(array, 0, newData, 0, size());
        this.size = size() * 2;
        this.array = newData;
    }

    public T get(int i) {
        if (i < 0 || i >= this.size) {
            System.out.println("Out of limit!");
            return null;
        } else {
            return this.array[i];
        }
    }

    public void set(int i, T data) {
        if (i < 0 || i >= this.size) {
            System.out.println("Out of limit");
        } else {
            this.array[i] = data;
        }
    }

    abstract int search(T data);

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 && this.array == null;
    }

    public long getTime(T data) {
        long start = System.nanoTime();
        int index = search(data);
        long end = System.nanoTime();
        if (index == -1) {
            System.out.printf("Can't find this element!\nTime: %.3f ms\n", (end - start) / 1000000.0);
        } else {
            System.out.printf("Find the element at position %s!\nTime: %.3f ms\n",index, (end - start) / 1000000.0);
        }
        return (long) ((end - start) / 1000000.0);
    }

}
