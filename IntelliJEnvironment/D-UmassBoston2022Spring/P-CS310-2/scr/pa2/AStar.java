package pa2;

import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.In;
/*import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.LinkedQueue;*/


// A* algorithm
//member of class.
public class AStar {

    private int h; // Regular dijkstra or A*
    pa2.EuclideanGraph graph;


    public AStar(String s, int h) {
        // should be s as file name.
        //File a = new File(s);
        In a = new In(s);

        graph = new pa2.EuclideanGraph(a);

        //do something if the h > 1;
        if (h >= 1) {

        }
        else {

            DijkstraUndirectedSP originalSp = new DijkstraUndirectedSP(graph, h);


        }


    }

    // Reset dists for new query
    public void reset() {

    }


    // Perform a query on specific start and target nodes
    public int route(int s, int t) {
        this.graph =;


        return -1;
    }


    // The function that biases the search
    private double heuristic(pa2.EuclideanGraph G, int v, int w) {

        return 0.0;
    }

    /**
     * Returns the length of a shortest path between the source vertex {@code s} and
     * vertex {@code v}.
     *
     * @param v the destination vertex
     * @return the length of a shortest path between the source vertex {@code s} and
     * the vertex {@code v}; {@code Double.POSITIVE_INFINITY} if no such path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public double distTo(int v) {
        return -1.0;
    }

    /**
     * Returns true if there is a path between the source vertex {@code s} and
     * vertex {@code v}.
     *
     * @param v the destination vertex
     * @return {@code true} if there is a path between the source vertex
     * {@code s} to vertex {@code v}; {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {

        return false;
    }

    /**
     * Returns a shortest path between the source vertex {@code s} and vertex {@code v}.
     *
     * @param v the destination vertex
     * @return a shortest path between the source vertex {@code s} and vertex {@code v};
     * {@code null} if no such path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Edge> path = new Stack<Edge>();
        int x = v;

        //for (Edge e =)

        return path;
    }

    // check optimality conditions:
    // (i) for all edges e = v-w:            distTo[w] <= distTo[v] + e.weight()
    // (ii) for all edge e = v-w on the SPT: distTo[w] == distTo[v] + e.weight()
    private boolean check(pa2.EuclideanGraph G, int s) {

        return false;
    }


    // Main testing
    public static void main(String[] args) {
        // Build the graph
        //args[0] =  Ecluden Graph,
        //args[1] = contains source (s) and end (t) vertex.

        int heuristic = Integer.parseInt(args[2]);
        AStar sp = new AStar(args[0], heuristic); ///
        In paths = new In(args[1]);
        // Now run queries
        int processed = 0;

        long startTime = System.currentTimeMillis();
        while (!paths.isEmpty()) {
            int s = paths.readInt();//source
            int t = paths.readInt(); // finel
            StdOut.println(s + " " + t);

            processed = sp.route(s, t);
            if (sp.hasPathTo(t)) {
                StdOut.printf("Printing path! %d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (Edge e : sp.pathTo(t)) {
                    StdOut.println(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
            sp.reset();
            StdOut.println("Processed " + processed);
        }
        long endTime = System.currentTimeMillis();
        long tm = endTime - startTime;
        StdOut.println(tm);
    }

}

