package pa2;
/*************************************************************************
 *  Compilation:  javac EuclideanGraph.java
 *  Execution:    java EuclideanGraph
 *  Dependencies: In.java IntIterator.java
 *
 *  Undirected graph of points in the plane, where the edge weights
 *  are the Euclidean distances.
 *
 *************************************************************************/

//@TODO Working Version

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;

public class EuclideanGraph {

    private static String NEWLINE = System.getProperty("line.separator");


    private int V;
    private int E;
    private Bag<Edge>[] adj;
    private Point2D[] points;   // points in the plane


    /*******************************************************************
     *  Read in a graph from a file, bare bones error checking.
     *  V E
     *  node: id x y
     *  edge: from to
     *******************************************************************/
    public EuclideanGraph(In in) {
        V = Integer.parseInt(in.readString());
        E = Integer.parseInt(in.readString());

        //array of pointes 2d size fo vertices.
        points = new Point2D[V];

        for (int i = 0; i < V; i++) {

            int v = Integer.parseInt(in.readString()); // vertex and
            int x = Integer.parseInt(in.readString()); //x cordinates
            int y = Integer.parseInt(in.readString()); //y cornidates.
            if (v < 0 || v >= V) throw new RuntimeException("Illegal vertex number");
            points[v] = new Point2D(x, y);
        }

        //read and insert edges

        adj = new Bag[V];
        for (int k = 0; k < V; k++) {
            adj[k] = new Bag<Edge>();
        }
        for (int i = 0; i < E; i++) {
            int v = Integer.parseInt(in.readString()); // one vertex and has connec to
            int w = Integer.parseInt(in.readString()); // second vertex and
            if (v < 0 || v >= V) throw new RuntimeException("Illegal vertex number");
            if (w < 0 || w >= V) throw new RuntimeException("Illegal vertex number");
            double weight = distance(v, w);
            Edge e = new Edge(v, w, weight);
            adj[v].add(e);
            adj[w].add(e);
        }


    }

    // Euclidean distance from v to w
    public double distance(int v, int w) {
        return points[v].distanceTo(points[w]);
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /*Returns the edges incident on vertex v.
     Params: v – the vertex
    Returns: the edges incident on vertex v as an Iterable*/

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }


    // string representation - takes quadratic time because of string concat
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);

        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    // test client
    public static void main(String args[]) {
        In in = new In(args[0]);
        EuclideanGraph G = new EuclideanGraph(in);
        System.out.println(G);

       /* System.out.println(G.V);
        System.out.println(G.E);*/

    }
}
