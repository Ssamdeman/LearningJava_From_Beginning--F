/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package myAlgs4Collection;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class MyEdgeWeightGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    // creating edge weighted graph using adjacency list representation

    private final int V; //number vertexs
    private int E; //number of edges
    private final MyBag<edgeThatWeighted>[] adj;

    public MyEdgeWeightGraph(int V) {
        this.V = V;
        this.E = 0;
        //making bag that is contains
        adj = (MyBag<edgeThatWeighted>[]) new MyBag[V];//initialzing the bag
        for (int v = 0; v < V; v++) {
            adj[v] = new MyBag<edgeThatWeighted>();
        }

    }

    ///getting thing from file.
    public MyEdgeWeightGraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");

        /// no Idea what try does.
        //I learned that Try and catch is good for detecting errors.
        try {
            V = in.readInt();
            adj = (MyBag<edgeThatWeighted>[]) new MyBag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new MyBag<edgeThatWeighted>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Edges cannot contain negative number");

            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                //we ignore the validate Vertex function.
                double weight = in.readDouble();
                myAlgs4Collection.edgeThatWeighted e = new edgeThatWeighted(v, w, weight);
                addEdge(e);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Invalid Format for EdgeWeightedGraph");
        }


    }


    //-----------------------------------------------------
    //Method that adds two vertex edge and weight.
    public void addEdge(edgeThatWeighted e) {
        //get two vertext
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /// I have no idea this thing works. I have no knowledge Iterator even they are very important.
    public Iterable<myAlgs4Collection.edgeThatWeighted> adj(int v) {
        return adj[v];
    }

    public Iterable<myAlgs4Collection.edgeThatWeighted> edge() {
        myAlgs4Collection.MyBag<myAlgs4Collection.edgeThatWeighted> list = new MyBag<>();

        for (int v = 0; v < V; v++) {
            int sefLoops = 0;
            for (myAlgs4Collection.edgeThatWeighted e : adj(v)) {
                //no idea that this does haha
                if (e.other(v) > v) {
                    list.add(e);
                }
                else if (e.other(v) == v) {
                    if (sefLoops % 2 == 0) list.add(e);
                    sefLoops++;
                }
            }
        }
        return list;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (myAlgs4Collection.edgeThatWeighted e : adj(v)) {
                s.append(e + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();


    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        //EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        MyEdgeWeightGraph G = new MyEdgeWeightGraph(in);
        StdOut.println(G);


    }
}
