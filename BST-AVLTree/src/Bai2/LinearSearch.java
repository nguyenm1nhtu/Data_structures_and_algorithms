package Bai2;

public class LinearSearch<T> extends MyArrayList<T>{

    @Override
    public int search(T data) {
        if (!isEmpty()) {
            for (int i = 0; i < size(); i++) {
                if (data.equals(get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

}
