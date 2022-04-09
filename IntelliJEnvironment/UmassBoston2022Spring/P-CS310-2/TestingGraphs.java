/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

//create Beareadth-First Search algorithms

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class TestingGraphs {

    static boolean[] marked;
    static int[] edgeTo;/// 1
    static int[] distTo;

    // we are create Graph data type called G.
    // G is created

    private static void bfs(Graph G, int s, int t) {
        Queue<Integer> q = new Queue<Integer>(); /// original .
        //Queue<Integer> p = new Queue<Integer>();// keep tracks of path.
        q.enqueue(s);
        marked[s] = true;
        distTo[s] = 0;
        int shortPathNumber = 0;
        //int counter = 0;

        while (!q.isEmpty()) {
            int v = q.dequeue();// in first 1 run the q is empty.
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    //p.enqueue(w);//if we add everytime when see it's way.
                    marked[w] = true;
                    //edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
                //if(w.haspathto(t) && Distance != Distance)
                increment:


            }
        }
        //return -1;
    }

   /* private static void bsfBipartite(Graph G, int s, int t) {
        Queue<Integer> q = new Queue<Integer>();
        // Queue<Integer> p = new Queue<Integer>();// keep tracks of path.
        q.enqueue(s);
        marked[s] = true;
        distTo[s] = 0;//layer numbers
        //int counter = 0;

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    //p.enqueue(w);//if we add everytime when see it's way.
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;

                }

            }
        }
        return -1;
    }
*/

    public static void main(String[] args) {

        In in = new In(args[0]);
        Graph graphs = new Graph(in);
        //StdOut.println(graphs);
        //System.out.println();
        //System.out.println(bsf(graphs, 0, 6));
        BreadthFirstPaths bfs = new BreadthFirstPaths(graphs, 0);


    }
}

 /*
 % java Graph tinyG.txt
         *  13 vertices, 13 edges
         *  0: 6 2 1 5
         *  1: 0
         *  2: 0
         *  3: 5 4
         *  4: 5 6 3
         *  5: 3 4 0
         *  6: 0 4
         *  7: 8
         *  8: 7
         *  9: 11 10 12
         *  10: 9
         *  11: 9 12
         *  12: 11 9
 */


/* Graph graphs = new Graph(13);
        graphs.addEdge(0, 6);
        graphs.addEdge(0, 2);
        graphs.addEdge(0, 1);
        graphs.addEdge(0, 5);

        graphs.addEdge(1, 0);

        graphs.addEdge(2, 0);

        graphs.addEdge(3, 5);
        graphs.addEdge(3, 4);

        graphs.addEdge(4, 5);
        graphs.addEdge(4, 6);
        graphs.addEdge(4, 3);

        graphs.addEdge(5, 3);
        graphs.addEdge(5, 4);
        graphs.addEdge(5, 0);

        graphs.addEdge(6, 4);
        graphs.addEdge(6, 0);

        graphs.addEdge(7, 8);

        graphs.addEdge(8, 7);

        graphs.addEdge(9, 11);
        graphs.addEdge(9, 10);
        graphs.addEdge(9, 12);

        graphs.addEdge(10, 9);

        graphs.addEdge(11, 9);
        graphs.addEdge(11, 12);

        graphs.addEdge(12, 11);
        graphs.addEdge(12, 9);*/
