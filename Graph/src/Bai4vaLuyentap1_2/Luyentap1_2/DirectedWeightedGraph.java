package Bai4vaLuyentap1_2.Luyentap1_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedWeightedGraph<V, E extends Comparable<? super E>> implements Graph<V, E> {

    protected Map<Vertical<V>, List<Edge<E>>> adjacencyList;
    protected List<Vertical<V>> vertices;

    public DirectedWeightedGraph() {
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
        return count;
    }

    @Override
    public Iterable<Vertical<V>> vertices() {
        return this.vertices;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        List<Edge<E>> listOfEdge = new ArrayList<>();
        for (List<Edge<E>> edges : adjacencyList.values()) {
            listOfEdge.addAll(edges);
        }
        return listOfEdge;
    }

    @Override
    public int deg() {
        int maxDeg = 0;
        for (Vertical<V> vertex : vertices) {
            int deg = inDegree(vertex) + outDegree(vertex);
            if (maxDeg < deg) {
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
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        int count = 0;
        for (Vertical<V> vertex : vertices) {
            for (Edge<E> edge : adjacencyList.get(vertex)) {
                if (edge.getOtherVertex(vertex).equals(v)) {
                    count++;
                }
            }
        }
        return count;
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
        List<Edge<E>> listOfIncomingEdges = new ArrayList<>();
        for (Vertical<V> vertex : vertices) {
            for (Edge<E> edge : adjacencyList.get(vertex)) {
                if (edge.getOtherVertex(vertex).equals(v)) {
                    listOfIncomingEdges.add(edge);
                }
            }
        }
        return listOfIncomingEdges;
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
        if (!(e instanceof WeightedEdge)) {
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
        Vertical<V> newVertex = new Vertical<>(element);
        vertices.add(newVertex);
        adjacencyList.put(newVertex, new ArrayList<>());
        return newVertex;
    }

    @Override
    public void insertEdge(Vertical<V> u, Vertical<V> v, E element) {
        if (!adjacencyList.containsKey(v) || !adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        Edge<E> edge = new WeightedEdge<>(u, v, element);
        adjacencyList.get(u).add(edge);
    }

    @Override
    public void removeVertex(Vertical<V> v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        adjacencyList.remove(v);
        vertices.remove(v);
    }

    @Override
    public void removeEdge(Edge<E> e) {
        if (!(e instanceof WeightedEdge<E>)) {
            throw new IllegalArgumentException("Unidentified edge!");
        }
        Vertical<V>[] endPoint = e.endVertical();
        Vertical<V> firstPoint = endPoint[0];
        adjacencyList.get(firstPoint).remove(e);
    }

    @Override
    public boolean isEdge(Vertical<V> u, Vertical<V> v) {
        if (!adjacencyList.containsKey(v) || !adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException("Unidentified vertex!");
        }
        return getEdge(u, v) != null;
    }
}
