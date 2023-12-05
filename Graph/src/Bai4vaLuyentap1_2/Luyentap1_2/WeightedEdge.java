package Bai4vaLuyentap1_2.Luyentap1_2;

public class WeightedEdge<E extends Comparable<? super E>> implements Edge<E>, Comparable<Edge<E>> {

    private final Vertical<?>[] endpoints;
    private E element;

    public WeightedEdge(Vertical<?> a, Vertical<?> b, E element) {
        this.endpoints = new Vertical[]{a, b};
        this.element = element;
    }

    @Override
    public E getValue() {
        return element;
    }

    @Override
    public void setValue(E value) {
        this.element = value;
    }

    @Override
    public Vertical[] endVertical() {
        return endpoints;
    }

    @Override
    public Vertical<?> getOtherVertex(Vertical<?> v) {
        if (v.equals(endpoints[0])) {
            return endpoints[1];
        } else if (v.equals(endpoints[1])) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("Unidentified vertex");
        }
    }

    @Override
    public int compareTo(Edge<E> anotherEdge) {
        return element.compareTo(anotherEdge.getValue());
    }
}
