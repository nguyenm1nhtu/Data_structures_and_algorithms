package Bai1;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected static class ArrEntry<K, E> implements Entry<K, E> {

        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }

        @Override
        public String toString() {
            return "[" + this.key + "\s\s" + this.element + "]";
        }
    }

    ArrEntry<K, E> [] array;
    int size = 0;
    int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        if (size() == defaultSize) {
            larger();
        }
        array[size++] = new ArrEntry<>(k, e);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> oldEntry = array[0];
        for (int i = 0; i < this.size; i++) {
            if (array[i] == min()) {
                oldEntry = array[i];
                for (int j = i; j < this.size - 1; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
        size--;
        return oldEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        Entry<K ,E> min = array[0];
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    private void larger() {
        ArrEntry<K, E>[] newData = new ArrEntry[size() * 2];
        System.arraycopy(array, 0, newData, 0, size());
        this.size = size() * 2;
        this.array = newData;
    }

    private String printQueue() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (array[i] == null) {continue;}
            sb.append("[").append(array[i].getKey()).append("  ").
                    append(array[i].getValue()).append("]").append("\s");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return printQueue();
    }
}
