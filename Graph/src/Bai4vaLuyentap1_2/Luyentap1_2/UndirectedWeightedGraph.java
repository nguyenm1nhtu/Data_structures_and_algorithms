package Bai4vaLuyentap1_2.Luyentap1_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedWeightedGraph<V, E extends Comparable<? super E>> implements Graph<V,E>{

    protected Map<Vertical<V>, List<Edge<E>>> adjacencyList;
    protected List<Vertical<V>> vertices;

    public UndirectedWeightedGraph() {
        this.adjacencyList = new HashMap<>();
        this.vertices = new ArrayList<>();
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public int numEdges() {
        int count = 0;
        for (List<Edge<E>> edges : adjacencyList.values()) {
            count += edges.size();
        }
        return count / 2;
    }

    @Override
    public Iterable<Vertical<V>> vertices() {
        return this.vertices;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        List<Edge<E>> listOfEdges = new ArrayList<>();
        for (List<Edge<E>> edges : adjacencyList.values()) {
            listOfEdges.addAll(edges);
        }
        return listOfEdges;
    }

    @Override
    public int deg() {
        int maxDeg = 0;
        for (Vertical<V> vertex : vertices) {
            int deg = outDegree(vertex);
            if (deg > maxDeg) {
                maxDeg = deg;
            }
        }
        return maxDeg;
    }

    @Override
    public Iterable<Vertical<V>> linked(Vertical<V> v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        List<Vertical<V>> linkedVertical = new ArrayList<>();
        for (Edge<E> edge : adjacencyList.get(v)) {
            linkedVertical.add(opposite(v, edge));
        }
        return linkedVertical;
    }

    @Override
    public int outDegree(Vertical<V> v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        int count = 0;
        for (Edge<E> edge : adjacencyList.get(v)) {
            if (edge != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int inDegree(Vertical<V> v) {
        return outDegree(v);
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertical<V> v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        return adjacencyList.get(v);
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertical<V> v) {
        return outgoingEdges(v);
    }

    @Override
    public Edge<E> getEdge(Vertical<V> u, Vertical<V> v) {
        if (!adjacencyList.containsKey(v) || !adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        for (Edge<E> edge : adjacencyList.get(u)) {
            if (edge.getOtherVertex(u).equals(v)) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public Vertical<V>[] endVertices(Edge<E> e) {
        if (!(e instanceof WeightedEdge<E>)) {
            throw new IllegalArgumentException("Unidentified edge!");
        }
        return e.endVertical();
    }

    @Override
    public Vertical<V> opposite(Vertical<V> v, Edge<E> e) {
        if (!(e instanceof WeightedEdge) || !adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Unidentified edge or vertex!");
        }
        return (Vertical<V>) e.getOtherVertex(v);
    }

    @Override
    public Vertical<V> insertVertex(V element) {
        Vertical<V> vertex = new Vertical<>(element);
        vertices.add(vertex);
        adjacencyList.put(vertex, new ArrayList<>());
        return vertex;
    }

    @Override
    public void insertEdge(Vertical<V> u, Vertical<V> v, E element) {
        if (!adjacencyList.containsKey(v) || !adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        Edge<E> edge = new WeightedEdge<>(v, u, element);
        adjacencyList.get(u).add(edge);
        adjacencyList.get(v).add(edge);
    }

    @Override
    public void removeVertex(Vertical<V> v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        for (Edge<E> edge : adjacencyList.get(v)) {
            Vertical<V> oppositeVertex = opposite(v, edge);
            adjacencyList.get(oppositeVertex).remove(edge);
        }
        adjacencyList.remove(v);
        vertices.remove(v);
    }

    @Override
    public void removeEdge(Edge<E> e) {
        if (!(e instanceof WeightedEdge<E>)) {
            throw new IllegalArgumentException("Unidentified edge!");
        }
        Vertical<V>[] endVertical = e.endVertical();
        Vertical<V> firstPoint = endVertical[0];
        Vertical<V> secondPoint = endVertical[1];
        adjacencyList.get(firstPoint).remove(e);
        adjacencyList.get(secondPoint).remove(e);
    }

    @Override
    public boolean isEdge(Vertical<V> u, Vertical<V> v) {
        if (!adjacencyList.containsKey(v) || !adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        return getEdge(u, v) != null;
    }
}
