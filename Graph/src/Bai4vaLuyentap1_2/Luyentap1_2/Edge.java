package Bai4vaLuyentap1_2.Luyentap1_2;

public interface Edge<E> {

    E getValue();

    void setValue(E value);

    Vertical[] endVertical();

    Vertical<?> getOtherVertex(Vertical<?> v);

    @Override
    String toString();
}
