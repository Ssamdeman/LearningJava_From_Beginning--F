package pa0;

// Import here as needed

import edu.princeton.cs.algs4.In;

public class LineReport {
    // Variables here
    static pa0.LineUsage terminal[];


    // Constructor
    public LineReport() {

    }

    // read input data, put facts into lines array
    static void loadData(String fname) {
        In in = new In(fname);
        int term = in.readInt();
        System.out.println(term);


    }

    // given loaded lines array, generate report on lines
    void generateReport() {


    }

    public static void main(String[] args) {

        terminal = new pa0.LineUsage[500];
        for (int i = 0; i < 500; i++) {
            terminal[i] = new pa0.LineUsage();
        }
        int x = Integer.parseInt(args[0]);
        System.out.println(x);

        ///loadData(args[0]);
    }
}
