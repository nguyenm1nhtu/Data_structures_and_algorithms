package Bai4vaLuyentap1_2.Luyentap1_2;

import java.util.Arrays;

public class DWG_Test {

    public static void main(String[] args) {
        Graph<String, String> dwg = new DirectedWeightedGraph<>();
        Vertical<String> a = dwg.insertVertex("A");
        Vertical<String> b = dwg.insertVertex("B");
        Vertical<String> c = dwg.insertVertex("C");
        Vertical<String> d = dwg.insertVertex("D");
        dwg.insertEdge(a, b, "AB");
        dwg.insertEdge(b, a, "BA");
        dwg.insertEdge(c, d, "CD");
        dwg.insertEdge(a, d, "AD");
        dwg.insertEdge(d, b, "DB");

        System.out.println("______________DIRECTED_WEIGHTED_GRAPH_TEST__________________________\n");
        System.out.println("The number of vertices in the graph is: " + dwg.numVertices());
        System.out.println("All of the vertices in graph are: ");
        for (Vertical<String> vertex : dwg.vertices()) {
            System.out.println("-> " + vertex.getValue());
        }
        System.out.println("The number of edges in the graph is: " + dwg.numEdges());
        System.out.println("All of the edges in graph are: ");
        for (Edge<String> edge : dwg.edges()) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The in-degree of vertex A is: " + dwg.inDegree(a));
        System.out.println("The out-degree of vertex A is: " + dwg.outDegree(a));
        System.out.println("The in-degree of vertex C is: " + dwg.inDegree(c));
        System.out.println("The out-degree of vertex C is: " + dwg.outDegree(c));
        System.out.println("The degree of graph is: " + dwg.deg());
        System.out.println("Check if there is an edge between two vertices A and C: " + dwg.isEdge(a, c));
        System.out.println("Check if there is an edge between two vertices A and B: " + dwg.isEdge(a, b));
        System.out.println("The outgoing edges adjacent to vertex A are:");
        for (Edge<String> edge : dwg.outgoingEdges(a)) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The incoming edges adjacent to vertex A are:");
        for (Edge<String> edge : dwg.incomingEdges(a)) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The incoming edges adjacent to vertex D are:");
        for (Edge<String> edge : dwg.incomingEdges(d)) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The outgoing edges adjacent to vertex D are:");
        for (Edge<String> edge : dwg.outgoingEdges(d)) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The vertex adjacent to vertex A are: ");
        for (Vertical<String> vertex : dwg.linked(a)) {
            System.out.println("-> " + vertex.getValue());
        }
        System.out.println("Remove vertex C: ");
        dwg.removeVertex(c);
        System.out.println("1) All of the vertices in graph after remove vertex C: ");
        for (Vertical<String> vertex : dwg.vertices()) {
            System.out.println("-> " + vertex.getValue());
        }
        System.out.println("2) All of the edges in graph after remove vertex C: ");
        for (Edge<String> edge : dwg.edges()) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("Remove edge AB: ");
        dwg.removeEdge(dwg.getEdge(a, b));
        System.out.println("All of the edges in graph after remove edge AB:");
        for (Edge<String> edge : dwg.edges()) {
            System.out.println("-> " + edge.getValue());
        }
        System.out.println("The two vertices of an edge AD are: " + Arrays.toString(dwg.endVertices(dwg.getEdge(a, d))));
    }
}
