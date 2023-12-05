package Bai2;

import Bai1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {

    ArrEntry<K, E>[] heapPQ;
    private int size;

    public MinHeapPriorityQueue() {
        this.heapPQ = new ArrEntry[100];
        size = 0;
    }

    private int parent(int i) {
        if (i < 0 || i > this.size) {
            System.out.println("Out of index");
            return -1;
        }
        return (i - 1) / 2;
    }

    private int left(int i) {
        if (i < 0 || i > this.size) {
            System.out.println("Out of index");
            return -1;
        }
        return 2 * i + 1;
    }

    private int right(int i) {
        if (i < 0 || i > this.size) {
            System.out.println("Out of index");
            return -1;
        }
        return 2 * i + 2;
    }

    private boolean hasLeft(int parent) {
        if (parent < 0 || parent > this.size) {
            System.out.println("Out of index");
            return false;
        }
        return this.heapPQ[left(parent)] != null;
    }

    private boolean hasRight(int parent) {
        if (parent < 0 || parent > this.size) {
            System.out.println("Out of index");
            return false;
        }
        return this.heapPQ[right(parent)] != null;
    }

    private void swap(int children, int parent) {
        ArrEntry<K, E> temp = this.heapPQ[children];
        this.heapPQ[children] = this.heapPQ[parent];
        this.heapPQ[parent] = temp;
    }

    protected void upHeap() {
        int child = this.size - 1;
        while (child > 0) {
            int parentPos = parent(child);
            if (this.heapPQ[child].getKey().compareTo(this.heapPQ[parentPos].getKey()) > 0) {
                break;
            }
            swap(child, parentPos);
            child = parentPos;
        }
    }

    protected void downHeap() {
        int index = 0;
        while (index < this.size) {
            if (hasRight(index)) {
                if (this.heapPQ[index].getKey().compareTo(this.heapPQ[left(index)].getKey()) < 0
                        && this.heapPQ[index].getKey().compareTo(this.heapPQ[right(index)].getKey()) < 0) {
                    break;
                } else {
                    if (this.heapPQ[left(index)].getKey().compareTo(this.heapPQ[right(index)].getKey()) > 0) {
                        swap(index, right(index));
                        index = right(index);
                    } else {
                        swap(index, left(index));
                        index = left(index);
                    }
                }
            } else if (hasLeft(index)) {
                if (this.heapPQ[index].getKey().compareTo(this.heapPQ[left(index)].getKey()) > 0) {
                    swap(index, left(index));
                }
                break;
            } else {
                break;
            }
        }
    }

    public void remove() {
        for (int i = 0; i < this.size; i++) {
            this.heapPQ[i] = this.heapPQ[i + 1];
        }
        downHeap();
    }

    public void insert(K k, E e) {
        this.heapPQ[size++] = new ArrEntry<>(k, e);
        upHeap();
    }

    private void printTree(int currentIdx, int height) {
        if (this.heapPQ[currentIdx] == null) {return;}

        printTree(right(currentIdx), height + 1);

        for (int i = 0; i < height; i++) {
            System.out.print("\s\s\s\s\s\s\s\s\s");
        }
        System.out.println(this.heapPQ[currentIdx]);

        printTree(left(currentIdx), height + 1);
    }

    @Override
    public String toString() {
        System.out.println("Here is your binary tree: ");
        printTree(0, 0);
        return "";
    }
}
