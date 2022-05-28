/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.Point2D;

public class EuclideanGraphV1 {

    private int V;            // number of vertices
    private int E;            // number of edges
    /// private Node[] adj;      // adjacency lists---> this is old method.
    //here is the new method for adjacency list:
    private Bag<Edge>[] adj; /// TODO why this is edge???
    private Point2D[] points;   // points in the plane which is else the whieghts.

    /*
        ///This is code we never use: TODO: Ignore this Code.
        // we use in the contructore given vertext and edges
        public EuclideanGraph(int V) {
            if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
            this.V = V;
            this.E = 0;
            adj = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Edge>();
            }
        }


        /// Initializes a RANDOM edge-weighted graph with {@code V} vertices and <em>E</em> edges.
        public EuclideanGraph(int V, int E) { ///TODO we do not use this code.

            this(V); // call constructore to create graphs with V vertex.
            if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");

            for (int i = 0; i < E; i++) {

                int v = StdRandom.uniform(V); // get randome value
                int w = StdRandom.uniform(V); // get randome value
                double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
                Edge e = new Edge(v, w, weight);
                addEdge(e);
            }
        }


         * Initializes an edge-weighted graph from an input stream.
         * The format is the number of vertices <em>V</em>,
         * followed by the number of edges <em>E</em>,
         * followed by <em>E</em> pairs of vertices and edge weights,
         * with each entry separated by whitespace.
         */

   /* public EuclideanGraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");

        int
        *//*try {
            V = in.readInt();// 2 and 4 vertext.  has x and y each.
            adj = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Edge>();
            }

            int E = in.readInt(); // 1;
            if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");

            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                double weight = in.readDouble();
                Edge e = new Edge(v, w, weight);
                addEdge(e);
            }*//*
    }
        catch(
    NoSuchElementException e)

    {
        throw new IllegalArgumentException(
                "invalid input format in EdgeWeightedGraph constructor", e);
    }

}*/


    //adding addEdge between two vertex:
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    // Euclidean distance from v to w vertexs.
    public double distance(int v, int w) {
        return points[v].distanceTo(points[w]);
    }


    //Checking/validating all the vertex are valid:

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }


    public static void main(String[] args) {


    }
}
