/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week1;

///TODO Watch this: https://www.youtube.com/watch?v=Gz-K8HLkzeM

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] matrix;
    private int size_Matrix;

    WeightedQuickUnionUF full;
    WeightedQuickUnionUF perc;


    public Percolation(int N) {

        if (N < 0) throw new IllegalArgumentException("");

        matrix = new boolean[N][N];
        size_Matrix = N;
        full = new WeightedQuickUnionUF(N * N);
        perc = new WeightedQuickUnionUF((N * N) + 2);


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

        //opening sites with randomly.
        //  matrix[row][col] = true;//Testing purposes
        for (int i = 0; i < size_Matrix; i++) {
            for (int j = 0; i < size_Matrix; i++) {
                if (StdRandom.bernoulli()) matrix[i][j] = true;

            }

        }

    }

    ///converting perc into the 2d system
    private int encode(int row, int col) {


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
