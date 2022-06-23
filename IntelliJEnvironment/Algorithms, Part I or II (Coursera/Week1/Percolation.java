/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week1;

///TODO Watch this: https://www.youtube.com/watch?v=Gz-K8HLkzeM

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int TOP = 0;
    private int BOTTOM;
    private int openSites; //open sites given the matrix.
    private boolean[][] matrix;
    private int size_Matrix;
    private WeightedQuickUnionUF qf;


    WeightedQuickUnionUF full;
    WeightedQuickUnionUF perc;


    public Percolation(int N) {

        if (N < 0) throw new IllegalArgumentException("");

        matrix = new boolean[N][N];
        openSites = 0; // # of open sites in the matrix
        size_Matrix = N;//matrix size;
        BOTTOM = size_Matrix * size_Matrix + 1;// keep tracks if the matrix Percolats or not
        qf = new WeightedQuickUnionUF((size_Matrix * size_Matrix) + 2);
    }

    //open thing given the 1-p
    public void open(int row, int col) {

        //edge case: if anu top row are opend
        if (row == 1)
            qf.union(encode(row, col), TOP);

    }

    ///converting perc into the 2d system
    private int encode(int row, int col) {
        return size_Matrix * (row - 1) + col;


    }

    //1 2 3
    //0,0, 0,1 0,2

    public boolean isOpen(int row, int col) {
        //corner cases
        if (row < 0 || row > size_Matrix) {
            throw new IllegalArgumentException("");
        }
        if (col < 0 || col > size_Matrix) {
            throw new IllegalArgumentException("");
        }
        return matrix[row][col];


    }


    //testing things
    public void print() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        Percolation persolation = new Percolation(3);
        persolation.open(1, 1);
        persolation.print();


    }
}
