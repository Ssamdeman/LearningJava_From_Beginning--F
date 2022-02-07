package pa0;
// Import here as needed

import edu.princeton.cs.algs4.StdIn;

public class LineReport {
    // Variables here
    static pa0.LineUsage terminal[];


    // Constructor
    public LineReport() {
        terminal = new pa0.LineUsage[500];
    }

    // read input data, put facts into lines array
    void loadData(String fname) {
        while (!StdIn.isEmpty()) {
            int temp = StdIn.readInt();
        }


    }

    // given loaded lines array, generate report on lines
    void generateReport() {


    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            terminal[i] = new pa0.LineUsage();
        }


    }
}
