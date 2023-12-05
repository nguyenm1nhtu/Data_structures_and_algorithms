package Bai4vaLuyentap1_2.Luyentap1_2;

public class CopyGraph<V, E extends Comparable<? super E>> extends UndirectedWeightedGraph<V, E> {

    public CopyGraph(UndirectedWeightedGraph<V, E> originalGraph) {
        super();
        for (Vertical<V> vertex : originalGraph.vertices) {
            Vertical<V> newVertex = insertVertex(vertex.getValue());
        }
        for (Vertical<V> vertex : originalGraph.vertices) {
            for (Edge<E> edge : originalGraph.adjacencyList.get(vertex)) {
                Vertical<V> u = vertices.get(originalGraph.vertices.indexOf(edge.endVertical()[0]));
                Vertical<V> v = vertices.get(originalGraph.vertices.indexOf(edge.endVertical()[1]));
                insertEdge(u, v, edge.getValue());
            }
        }
    }

    public static void main(String[] args) {
        UndirectedWeightedGraph<Integer, Integer> originalGraph = new UndirectedWeightedGraph<>();
        CopyGraph<Integer, Integer> copiedGraph = new CopyGraph<>(originalGraph);
    }
}

