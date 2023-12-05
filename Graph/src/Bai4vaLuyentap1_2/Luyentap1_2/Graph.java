package Bai4vaLuyentap1_2.Luyentap1_2;

public interface Graph<V,E> {

    /**
     * Returns the number of vertices of the graph
     */
    int numVertices();

    /**
     * Returns the number of edges of the graph
     */
    int numEdges();

    /**
     * Returns the vertices of the graph as an iterable collection
     */
    Iterable<Vertical<V>> vertices();

    /**
     * Returns the edges of the graph as an iterable collection
     */
    Iterable<Edge<E>> edges();

    /**
     * Returns the deg of the graph
     */
    int deg();

    /**
     * Return the vertices connected to the vertex v
     */
    Iterable<Vertical<V>> linked(Vertical<V> v);

    /**
     * Returns the number of edges leaving vertex v
     */
    int outDegree(Vertical<V> v);

    /**
     * Returns the number of edges for which vertex v is the destination
     */
    int inDegree(Vertical<V> v);

    /**
     * Returns an iterable collection of edges for which vertex v is the origin
     */
    Iterable<Edge<E>> outgoingEdges(Vertical<V> v);

    /**
     * Returns an iterable collection of edges for which vertex v is the destination
     */
    Iterable<Edge<E>> incomingEdges(Vertical<V> v);

    /**
     * Returns the edge from u to v
     */
    Edge<E> getEdge(Vertical<V> u, Vertical<V> v);

    /**
     * Return the two vertices of an edge
     */
    Vertical<V>[] endVertices(Edge<E> e);

    /**
     * Returns the vertex that is opposite vertex v on edge e
     */
    Vertical<V> opposite(Vertical<V> v, Edge<E> e);

    /**
     * Inserts and returns a new vertex with the given element
     */
    Vertical<V> insertVertex(V element);

    /**
     * Inserts and returns a new edge between vertices u and v, storing given element
     */
    void insertEdge(Vertical<V> u, Vertical<V> v, E element);

    /**
     * Removes a vertex and all its incident edges from the graph
     */
    void removeVertex(Vertical<V> v);

    /**
     * Removes an edge between two vertices
     */
    void removeEdge(Edge<E> e);

    /**
     * Check if there is an edge between two vertices
     */
    boolean isEdge(Vertical<V> u, Vertical<V> v);
}
