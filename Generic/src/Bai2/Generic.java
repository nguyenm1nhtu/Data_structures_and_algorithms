package Bai2;

public class Generic<T> {

    private T[] object;

    public Generic() {}

    public T[] getObject() {
        return object;
    }

    public void setObject(T[] object) {
        this.object = object;
    }

    public void set(T[] object) {
        this.object = object;
    }
}
