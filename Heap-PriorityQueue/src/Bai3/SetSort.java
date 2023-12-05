package Bai3;

public class SetSort {

    private long end;
    private long start;

    public SetSort() {
    }

    public void setSort(Sort sort, int[] arr) {
        this.start = System.nanoTime();
        sort.sort(arr);
        this.end = System.nanoTime();
    }

    public long getTime() {return this.end - this.start;}
}
