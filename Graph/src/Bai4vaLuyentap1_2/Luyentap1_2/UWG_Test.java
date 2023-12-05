package Bai4vaLuyentap1_2.Luyentap1_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UWG_Test {

    public static void main(String[] args) {
        Graph<String, String> uwg = new UndirectedWeightedGraph<>();
        Vertical<String> a = uwg.insertVertex("A");
        Vertical<String> b = uwg.insertVertex("B");
        Vertical<String> c = uwg.insertVertex("C");
        Vertical<String> d = uwg.insertVertex("D");
        uwg.insertEdge(a, b, "AB");
        uwg.insertEdge(c, d, "CD");
        uwg.insertEdge(a, d, "AD");

        System.out.println("______________UNDIRECTED_WEIGHTED_GRAPH_TEST__________________________\n");
        System.out.println("The number of vertices in the graph is: " + uwg.numVertices());
        System.out.println("All of the vertices in graph are: ");
        printVertices(uwg);
        System.out.println("The number of edges in the graph is: " + uwg.numEdges());
        System.out.println("All of the edges in graph are: ");
        printEdges(uwg);
        System.out.println("The degree of vertex A is: " + uwg.outDegree(a));
        System.out.println("The degree of vertex C is: " + uwg.inDegree(c));
        System.out.println("The degree of graph is: " + uwg.deg());
        System.out.println("Check if there is an edge between two vertices A and C: " + uwg.isEdge(a, c));
        System.out.println("Check if there is an edge between two vertices A and B: " + uwg.isEdge(a, b));
        System.out.println("The edges adjacent to vertex A are:");
        for (Edge<String> edge : uwg.outgoingEdges(a)) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The edges adjacent to vertex D are:");
        for (Edge<String> edge : uwg.incomingEdges(d)) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The vertex adjacent to vertex B are: ");
        for (Vertical<String> vertex : uwg.linked(b)) {
            System.out.println("-> " + vertex.getValue());
        }
        System.out.println("Remove vertex C: ");
        uwg.removeVertex(c);
        System.out.println("1) All of the vertices in graph after remove vertex C: ");
        printVertices(uwg);
        System.out.println("2) All of the edges in graph after remove vertex C: ");
        printEdges(uwg);
        System.out.println("Remove edge AB: ");
        uwg.removeEdge(uwg.getEdge(a, b));
        System.out.println("All of the edges in graph after remove edge AB:");
        printEdges(uwg);
        System.out.println("The two vertices of an edge AD are: " + Arrays.toString(uwg.endVertices(uwg.getEdge(a, d))));
    }

    private static void printVertices(Graph<String, String> uwg) {
        for (Vertical<String> vertex : uwg.vertices()) {
            System.out.println("-> " + vertex.getValue());
        }
    }

    private static void printEdges(Graph<String, String> uwg) {
        Set<Edge<String>> set = new HashSet<>();
        for (Edge<String> edge : uwg.edges()) {
            set.add(edge);
        }
        for (Edge<String> edge : set) {
            System.out.println("-> " + edge.getValue());
        }
    }
}
