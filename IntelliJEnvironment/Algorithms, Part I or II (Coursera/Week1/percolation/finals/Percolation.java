/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int TOP = 0;
    private int BOTTOM;
    private int openSites; //open sites given the matrix.
    private boolean[][] matrix;
    private int size_Matrix;
    private WeightedQuickUnionUF qf;


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
        //corner cases
        if (row < 0 || row > size_Matrix) {
            throw new IllegalArgumentException("");
        }
        if (col < 0 || col > size_Matrix) {
            throw new IllegalArgumentException("");
        }

        matrix[row - 1][col - 1] = true;
        openSites++;

        //edge case: if anu top row are opend
        if (row == 1)
            qf.union(encode(row, col), TOP);

        //edge case: if anu bottom row are opened
        if (row == size_Matrix)
            qf.union(encode(row, col), BOTTOM);

        //check if the middle open by comarering neighbourings on top for rows.
        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(encode(row, col), encode(row - 1, col));
        }
        //check if the middle open by comarering neighbourings on top for col.
        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(encode(row, col), encode(row, col - 1));
        }


        //check if the middle open by comarering neighbourings on bottom.
        if (row < size_Matrix && isOpen(row + 1, col)) {
            qf.union(encode(row, col), encode(row + 1, col));
        }

        if (col < size_Matrix && isOpen(row, col + 1)) {

            qf.union(encode(row, col), encode(row, col + 1));
        }

    }

    ///converting perc into the 2d system
    private int encode(int row, int col) {
        //corner cases
        if (row < 0 || row > size_Matrix) {
            throw new IllegalArgumentException("");
        }
        if (col < 0 || col > size_Matrix) {
            throw new IllegalArgumentException("");
        }

        return size_Matrix * (row - 1) + col;


    }

    public boolean isFull(int row, int col) {
        //corner cases
        if (row < 0 || row > size_Matrix) {
            throw new IllegalArgumentException("");
        }
        if (col < 0 || col > size_Matrix) {
            throw new IllegalArgumentException("");
        }

        if ((row > 0 && row <= size_Matrix) && col > 0 && col <= size_Matrix) {
            return qf.find(TOP) == qf.find(encode(row, col));
        }
        else {
            throw new IllegalArgumentException();

        }
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
        return matrix[row - 1][col - 1];

    }


    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return qf.find(TOP) == qf.find(BOTTOM);
    }


   /* //testing things
    public void print() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }*/


    public static void main(String[] args) {
        In in = new In(args[0]);      // input file
        int n = in.readInt();
        Percolation perc = new Percolation(n);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        System.out.println(perc.percolates());

    }
}
