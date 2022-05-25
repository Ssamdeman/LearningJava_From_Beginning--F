package pa3;

import edu.princeton.cs.algs4.In;

/**
 * Skeleton match class
 */


public class Match {
    public Path path = new Path();


    public Match() {
    }

    //original is: public Path match(String x, String y)
    public Path match(String x, String y) {


        //Tracking the cost
        //if (x == null || y = null)
        int m = x.length(); /// length of string 1 = a; i = x
        int n = y.length(); /// length of string 2 =b; j is the y

        //The mMatrix we need to get the optimal solution
        int[][] opt = new int[m + 1][n + 1];
        opt[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            opt[i][0] = opt[i - 1][0] + 2;
        }
        for (int j = 1; j <= n; j++) {
            opt[0][j] = opt[0][j - 1] + 2;
        }

        // CHECK OF THE XI == XJ
        /* OPT[i][j] = MIN(isEqual(x,i,y,j) + OPT(I-1,J-1), OPT(i-1,j) + 2, OPT(i, j-1 ) +2)
         *   0  1 2 3 4 5  6 index J
         *      p a l a t  e
         0   0  2 4 6 8 10 12
         1 p 2  0
         2 a 4
         3 l 6
         4 e 8
         5 t 10
         6 t 12
         7 e 14
         I
         * */

        //temp variable
        int w = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    w = 0;
                else {
                    w = 1;
                }
                opt[i][j] =
                        Integer.min(Integer.min(w + opt[i - 1][j - 1], opt[i - 1][j] + 2),
                                    opt[i][j - 1] + 2);
            }
        }


       /* for (int i = 0; i <= m; i++) {
            System.out.println();
            for (int j = 0; j <= n; j++) {
                System.out.print(opt[i][j] + " ");

            }
        }*/
      /*  System.out.println();
        System.out.println("OutPut Number is " + opt[m][n]);*/

        path = new pa3.Path();
        path.setCost(opt[m][n]);
        path.setRow(m); //m is row
        path.setCol(n); ///n is the column.
        pa3.Path revers = path;

        int longest = 0;

        if (m > n) longest = m;
        else longest = n;

        //opt[m][n-1] = moving to back horizonally
        //opt[m-1][n] = moving to vertically
        /*System.out
                .println(
                        "Everytime creating path and priting path: " + " Cost " + path.getCost()
                                + " Col " + path.getCol() + " Row " + path.getRow());*/
        for (int i = 1; i < longest; i++) {
            ///checking if the diognal is the same as the next diognal.
            if (path.getCost() == opt[path.getRow() - 1][path.getCol() - 1] &&
                    x.charAt(path.getRow() - 1) == y.charAt(path.getCol() - 1)) {

                path.setNext(new Path(opt[path.getRow() - 1][path.getCol() - 1], path.getRow() - 1,
                                      path.getCol() - 1));
                path = path.getNext();
            }
            else if (path.getCost() == 1 + opt[path.getRow() - 1][path.getCol() - 1]) {
                path.setNext(new Path(opt[path.getRow() - 1][path.getCol() - 1], path.getRow() - 1,
                                      path.getCol() - 1));
                path = path.getNext();
            }
            //check the horizontal
            else if (path.getCost() == 2 + opt[path.getRow()][path.getCol() - 1]) {
                path.setNext(new Path(opt[path.getRow()][path.getCol() - 1], path.getRow(),
                                      path.getCol() - 1));
                path = path.getNext();
            }
            //opt[m-1][n] = moving to vertically
            else if (path.getCost() == 2 + opt[path.getRow() - 1][path.getCol()]) {
                path.setNext(new Path(opt[path.getRow() - 1][path.getCol()], path.getRow() - 1,
                                      path.getCol()));
                path = path.getNext();
            }
            /*System.out
                    .println(
                            "Everytime creating path and priting path: " + " Cost " + path.getCost()
                                    + " Col " + path.getCol() + " Row " + path.getRow());
*/
        }


        return revers;


        //return new pa3.Path();


        //return new Path();
    }


    public static void main(String[] args) {
        String s = args[0];
        String str1 = "";
        String str2 = "";
        In data = new In(s);
        //Getting the data
        while (!data.isEmpty()) {
            if (data.hasNextLine()) {
                str1 = data.readString();
            }
            str2 = data.readString();
        }

        Match matching = new Match();
        matching.match(str1, str2);
        Path priting = new Path();
        //priting = matching.match(str1, str2);


        // System.out.println(str1); // string one
        //System.out.println(str2); /// string two.


    }

}

/* // return the optimal match between the strings a and b
    // return null if either string is null or if either string is length 0
    public Path match(String x, String y) {

        //checking the corner cases.
        if (x.length() == 0 || y.length() == 0) return null;
        if (x == null) return null;
        if (y == null) return null;
        //getting size as m to x and n to y.
        int m = x.length(); /// length of string 1 = a; i = x
        int n = y.length(); /// length of string 2 =b; j is the y

        //building the table:
        //The mMatrix we need to get the optimal solution
        int[][] opt = new int[m + 1][n + 1];
        opt[0][0] = 0;

        //setting the corners as the 2+ on every interationn
        for (int i = 1; i <= m; i++) {
            opt[i][0] = opt[i - 1][0] + 2;
        }
        for (int j = 1; j <= n; j++) {
            opt[0][j] = opt[0][j - 1] + 2;
        }
        //feeling the table.
        int w = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    w = 0;
                else {
                    w = 1;
                }
                opt[i][j] =
                        Integer.min(Integer.min(w + opt[i - 1][j - 1], opt[i - 1][j] + 2),
                                    opt[i][j - 1] + 2);
            }
        }


        return new Path();
    }*/
