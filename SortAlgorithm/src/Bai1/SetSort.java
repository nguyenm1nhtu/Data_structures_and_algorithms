package Bai1;

public class SetSort {

    private Sort sort;
    private long end;
    private long start;

    public SetSort() {
    }

    public void setSort(Sort sort, int[] arr) {
        this.start = System.nanoTime();
        this.sort = sort;
        sort.sort(arr);
        this.end = System.nanoTime();
    }

    public long getTime() {return this.end - this.start;}
}
