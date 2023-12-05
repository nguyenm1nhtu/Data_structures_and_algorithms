package Bai1;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

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

    ArrEntry<K, E>[] heapPQ;
    int size = 0;
    int defaultSize = 1000;

    public SortedArrayPriorityQueue() {
        heapPQ = new ArrEntry[defaultSize];
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
        heapPQ[size++] = new ArrEntry<>(k, e);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> oldEntry = heapPQ[0];
        for (int i = 0; i < this.size; i++) {
            if (heapPQ[i] == min()) {
                oldEntry = heapPQ[i];
                for (int j = i; j < this.size - 1; j++) {
                    heapPQ[j] = heapPQ[j + 1];
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
        return heapPQ[0];
    }

    private void sortedArray(){
        int indexMin;
        for (int i = 0; i < this.size - 1; i++){
            indexMin = i;
            for (int j = i+1; j < this.size; j++){
                if (heapPQ[indexMin].getKey().compareTo(heapPQ[j].getKey()) > 0){
                    indexMin = j;
                }
            }
            if (i != indexMin){
                ArrEntry<K, E> temp = heapPQ[i];
                heapPQ[i] = heapPQ[indexMin];
                heapPQ[indexMin] = temp;
            }
        }
    }

    private String printQueue() {
        sortedArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (heapPQ[i] == null) {continue;}
            sb.append("[").append(heapPQ[i].getKey()).append("  ").
                    append(heapPQ[i].getValue()).append("]").append("\s");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return printQueue();
    }

    private void larger() {
        ArrEntry<K, E>[] newData = new ArrEntry[size() * 2];
        System.arraycopy(heapPQ, 0, newData, 0, size());
        this.size = size() * 2;
        this.heapPQ = newData;
    }
}
