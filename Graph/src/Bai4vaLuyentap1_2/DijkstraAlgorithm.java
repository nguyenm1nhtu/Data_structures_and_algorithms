package Bai4vaLuyentap1_2;

import Bai4vaLuyentap1_2.Luyentap1_2.*;
import java.util.*;

public class DijkstraAlgorithm<V, E extends Comparable<? super E>> {
    private final DirectedWeightedGraph<V, E> graph;

    public DijkstraAlgorithm(DirectedWeightedGraph<V, E> graph) {
        this.graph = graph;
    }

    private void initializeDijkstra(Vertical<V> source, Map<Vertical<V>, Integer> distance,
                                    Map<Vertical<V>, Vertical<V>> predecessors) {
        for (Vertical<V> vertex : graph.vertices()) {
            distance.put(vertex, Integer.MAX_VALUE);
            predecessors.put(vertex, null);
        }
        distance.put(source, 0);
    }

    private Vertical<V> getMinimumDistanceVertex(Map<Vertical<V>, Integer> distance, Set<Vertical<V>> visited) {
        Vertical<V> minVertex = null;
        int minDistance = Integer.MAX_VALUE;

        for (Vertical<V> vertex : distance.keySet()) {
            if (!visited.contains(vertex) && distance.get(vertex) < minDistance) {
                minDistance = distance.get(vertex);
                minVertex = vertex;
            }
        }

        return minVertex;
    }

    private void relaxNeighbors(Vertical<V> current, Map<Vertical<V>, Integer> distance,
                                Map<Vertical<V>, Vertical<V>> predecessors, Set<Vertical<V>> visited) {
        for (Edge<E> edge : graph.outgoingEdges(current)) {
            Vertical<V> neighbor = graph.opposite(current, edge);
            if (!visited.contains(neighbor)) {
                int newDistance = distance.get(current) +  ((WeightedEdge<Integer>) edge).getValue();

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    predecessors.put(neighbor, current);
                }
            }
        }
    }

    private List<Vertical<V>> getShortestPath(Vertical<V> destination, Map<Vertical<V>, Vertical<V>> predecessors) {
        List<Vertical<V>> path = new ArrayList<>();
        Vertical<V> current = destination;

        while (current != null) {
            path.add(current);
            current = predecessors.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    public List<Vertical<V>> findShortestPath(Vertical<V> source, Vertical<V> destination) {
        Map<Vertical<V>, Integer> distance = new HashMap<>();
        Map<Vertical<V>, Vertical<V>> predecessors = new HashMap<>();
        Set<Vertical<V>> visited = new HashSet<>();
        initializeDijkstra(source, distance, predecessors);

        while (visited.size() < graph.numVertices()) {
            Vertical<V> current = getMinimumDistanceVertex(distance, visited);
            visited.add(current);
            relaxNeighbors(current, distance, predecessors, visited);
        }

        return getShortestPath(destination, predecessors);
    }

    public static void main(String[] args) {
        DirectedWeightedGraph<String, Integer> graph = new DirectedWeightedGraph<>();
        Vertical<String> A = graph.insertVertex("A");
        Vertical<String> B = graph.insertVertex("B");
        Vertical<String> C = graph.insertVertex("C");
        Vertical<String> D = graph.insertVertex("D");

        graph.insertEdge(A, B, 10);
        graph.insertEdge(A, C, 3);
        graph.insertEdge(B, C, 1);
        graph.insertEdge(B, D, 4);
        graph.insertEdge(C, D, 1);

        DijkstraAlgorithm<String, Integer> dijkstra = new DijkstraAlgorithm<>(graph);
        System.out.println("Shortest path from A to D is: " + dijkstra.findShortestPath(A, D));
    }
}

