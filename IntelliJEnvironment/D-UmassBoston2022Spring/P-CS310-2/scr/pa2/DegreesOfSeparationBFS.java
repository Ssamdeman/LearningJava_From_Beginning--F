/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package pa2;


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

    //this code some issues. I am not sure what it is.

    public int baconNumber(String sink) {
        //int sinkValue = useSymbolGraph.indexOf(sink);

        if (!useSymbolGraph.contains(sink)) return -1;

        if (bfp.hasPathTo(useSymbolGraph.indexOf(sink))) {
            //if the path is only 1 then return 1;
            if (bfp.distTo(useSymbolGraph.indexOf(sink)) == 1)
                return 1;

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
    public void printPath(String sink) {
        for (int s : graphPath(sink)) {
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
        String filename = args[0];
        String delimiter = args[1];
        String source = args[2];
        String sink = args[3];
        DegreesOfSeparationBFS G = new DegreesOfSeparationBFS(filename, delimiter, source);
        System.out.println(G.baconNumber(sink));
        G.printPath(sink);


    }
}
