

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;


public class EuclideanGraphV2 {

    // for portability
    //private final static String NEWLINE = System.getProperty("line.separator");

    private int V;            // number of vertices
    private int E;            // number of edges
    private Node[] adj;      // adjacency lists
    private Point2D[] points;   // points in the plane arrays


    // node helper class for adjacency list
    private static class Node {
        int v;
        Node next;

        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }


   /* // iterator for adjacency list class.
    public class AdjListIterator implements IntIterator {
        private Node x;

        AdjListIterator(Node x) {
            this.x = x;
        }

        public boolean hasNext() {
            return x != null;
        }

        public int next() {
            int v = x.v;
            x = x.next;
            return v;
        }
    }
*/

    /*******************************************************************
     *  Read in a graph from a file, bare bones error checking.
     *  V E
     *  node: id x y
     *  edge: from to
     *******************************************************************/
    public EuclideanGraphV2(In in) {

        V = Integer.parseInt(in.readString());
        E = Integer.parseInt(in.readString());

        // read in and insert vertices
        points = new Point2D[V];
        for (int i = 0; i < V; i++) {
            int v = Integer.parseInt(in.readString());
            int x = Integer.parseInt(in.readString());
            int y = Integer.parseInt(in.readString());
            if (v < 0 || v >= V) throw new RuntimeException("Illegal vertex number");
            points[v] = new Point2D(x, y);
        }

        // read in and insert edges
        adj = new Node[V];
        for (int i = 0; i < E; i++) {
            int v = Integer.parseInt(in.readString());
            int w = Integer.parseInt(in.readString());
            if (v < 0 || v >= V) throw new RuntimeException("Illegal vertex number");
            if (w < 0 || w >= V) throw new RuntimeException("Illegal vertex number");

            adj[v] = new Node(w, adj[v]);
            adj[w] = new Node(v, adj[w]);
        }
    }


    // accessor methods
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Point2D point(int i) {
        return points[i];
    }


    // Euclidean distance from v to w
    public double distance(int v, int w) {
        return points[v].distanceTo(points[w]);
    }


    // return iterator for list of neighbors of v
   /* public Iterator neighbors(int v) {
        return new AdjListIterator(adj[v]);
    }*/


    // string representation - takes quadratic time because of string concat
    public String toString() {
        String s = "";
        s += "V = " + V;
        s += "E = " + E;
        for (int v = 0; v < V && v < 100; v++) {
            String t = v + " " + points[v] + ": ";
            for (Node x = adj[v]; x != null; x = x.next)
                t += x.v + " ";
            s += t;
        }
        return s;
    }


// draw the graph in turtle graphics
    /*public void draw() {
        for (int v = 0; v < V; v++) {
            points[v].draw();
            for (Node x = adj[v]; x != null; x = x.next) {
                int w = x.v;
                points[v].drawTo(points[w]);
            }
        }
        Turtle.render();
    }*/


   /* public static void main(String[] args) {
        In in = new In(args[0]);
        EuclideanGraph G = new EuclideanGraph(in);

    }
}*/
