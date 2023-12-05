package Bai4vaLuyentap1_2.Luyentap1_2;

public class Vertical<V> {

    V value;

    public Vertical(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
