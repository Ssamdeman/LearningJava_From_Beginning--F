/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week1;


public class Percolation {
    private boolean[][] matrix;


    public Percolation(int N) {

        if (N < 0) throw new IllegalArgumentException("");

        matrix = new boolean[N][N];

    }

    //open thing given the 1-p
    public void open(int row, int col) {

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
        persolation.print();


    }
}
