/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SymbolGraph;

public class DegreesOfSeparationBFS {
    public SymbolGraph useSymbolGraph;
    public Graph graphVersion; //making the SymbolGraph to Graph
    public BreadthFirstPaths bfp;
    public int int_as_center; /// center string but in ingeter version.
    // String Test:

    public DegreesOfSeparationBFS(String data, String delimiter, String center) {

        useSymbolGraph = new SymbolGraph(data, delimiter);

        graphVersion = useSymbolGraph.graph();//making the SymbolGraph to Graph
        int_as_center = useSymbolGraph.indexOf(center); //Getting center as integer.


        bfp = new BreadthFirstPaths(useSymbolGraph.graph(), int_as_center);

    }

    public SymbolGraph getSymbolGraph() {
        return useSymbolGraph;
    }

    public BreadthFirstPaths getBreadthFirstPaths() {
        return bfp;
    }

    public int baconNumber(String sink) {
        if (bfp.hasPathTo(useSymbolGraph.indexOf(sink))) {
            return bfp.distTo(useSymbolGraph.indexOf(sink)) / 2;
        }
        else
            return -1;
    }

    public Stack<Integer> graphPath(String sink) {
        Stack<Integer> holder = new Stack<>();
        int temp = useSymbolGraph.indexOf(sink);

        for (int i : bfp.pathTo(temp)) {
            holder.push(i);

        }
        return holder;

    }

    // priting test:
    public void printPath() {
        for (int s : graphPath("Kidman, Nicole")) {
            System.out.print(useSymbolGraph.nameOf(s) + "--> ");

        }
    }








    /*
    public int baconNumber(String sink) {
        int tempHolder = -1;
        int center = useSymbolGraph.indexOf(sink);
        bfp.distTo(center);



    }*/

    public static void main(String[] args) {
       /* String filename = args[0];
        String delimiter = args[1];
        String source = args[2];*/


    }
}
