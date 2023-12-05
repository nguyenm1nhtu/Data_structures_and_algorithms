package Bai2;

public class BinarySearch<T extends Comparable<T>> extends MyArrayList<T> {

    @Override
    int search(T data) {
        sort();
        return binarySearch(data, 0, size() - 1);
    }

    private int binarySearch(T data, int first, int last) {
        if (get(first).equals(data)) {
            return first;
        } else if (get(last).equals(data)) {
            return last;
        } else {
            int middleIndex = (first + last) / 2;

            if (get(middleIndex).equals(data)) {
                return middleIndex;
            } else if (data.compareTo(get(middleIndex)) < 0) {
                return binarySearch(data, first, middleIndex - 1);
            } else if (data.compareTo(get(middleIndex)) > 0) {
                return binarySearch(data, middleIndex + 1, last);
            }
        }
        return -1;
    }

    private void sort() {
        for (int i = 0; i < size(); i++) {
            for (int j = i + 1; j < size() - 1; j++) {
                if (get(i).compareTo(get(j)) > 0) {
                    T temp = get(i);
                    set(i, get(j));
                    set(j, temp);
                }
            }
        }
    }
}
