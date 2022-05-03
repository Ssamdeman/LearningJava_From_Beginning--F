/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package myAlgs4Collection;

//Create Minimum Spannig Forrest Using Kruskal's Algorithsm
//Why it called forrest rather tree?
//Tree are acycle, connected, include all the vertices
/*
The edge weights can be positive, zero, or negative and need not be distinct.
If the graph is not connected, it computes a minimum spanning forest, which is the union of minimum spanning trees in each connected component.
The weight() method returns the weight of a minimum spanning tree and the edges() method returns its edges
*/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MyKruskalMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12; //tie breaker between two weights

    private double weight;

    private myAlgs4Collection.MyQueue<myAlgs4Collection.edgeThatWeighted> mst
            = new MyQueue<myAlgs4Collection.edgeThatWeighted>();

    // computing minimum spanning tree.
    public MyKruskalMST(myAlgs4Collection.MyEdgeWeightGraph G) {

        //edges into array.
        myAlgs4Collection.edgeThatWeighted[] edges = new edgeThatWeighted[G.E()];
        int t = 0;

        //filling the edge arrays with my edges
        for (myAlgs4Collection.edgeThatWeighted e : G.edge()) {
            edges[t] = e;
            t++;
        }

        /// we are sorting in ascending order
        Arrays.sort(edges);
        
        ///run the gredy algorithsm using the Union Find. BUt still I dont get it
        MyUF uf = new MyUF(G.V());
        for (int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) {
            edgeThatWeighted e = edges[i];
            int v = e.either();
            int w = e.other(v);


            // v-w does not create a cycle. Sure but I did not get it.
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w); //merge
                mst.enqueue(e);
                weight += e.weight();
            }

        }
        // check optimality conditions
        assert check(G);

    }

    public Iterable<edgeThatWeighted> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    //checking optimality conditions

    private boolean check(MyEdgeWeightGraph G) {

        //check total weight
        double total = 0.0;
        for (edgeThatWeighted e : edges()) {
            total += e.weight();
        }

        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total,
                              weight());
            return false;
        }
        //check if it acyclic. // still i did not get.
        MyUF uf = new MyUF(G.V());
        for (edgeThatWeighted e : edges()) {
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) == uf.find(w)) {
                System.err.printf("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (myAlgs4Collection.edgeThatWeighted e : G.edge()) {
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) != uf.find(w)) {
                System.err.println("Not a spanning forest");
                return false;
            }

        }
        // check that it is a minimal spanning forest (cut optimality conditions)
        for (myAlgs4Collection.edgeThatWeighted e : edges()) {

            //all edges in MST exept e;
            uf = new MyUF(G.V());
            for (myAlgs4Collection.edgeThatWeighted f : mst) {
                int x = f.either();
                int y = f.other(x);
                if (f != e) {
                    uf.union(x, y);
                }
            }
            /// check that e is min weight edge in crossing cut
            for (myAlgs4Collection.edgeThatWeighted f : G.edge()) {
                int x = f.either();
                int y = f.other(x);
                if (uf.find(x) != uf.find(y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        myAlgs4Collection.MyEdgeWeightGraph G = new MyEdgeWeightGraph(in);
        MyKruskalMST mst = new MyKruskalMST(G);
        for (myAlgs4Collection.edgeThatWeighted e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }

}
