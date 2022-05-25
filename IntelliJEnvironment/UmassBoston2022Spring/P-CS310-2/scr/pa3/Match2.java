/**
 * Skeleton match class
 */

package pa3;

public class Match2 {

    public Match2() {

    }


    // return the optimal match between the strings a and b
    // return null if either string is null or if either string is length 0
    public void match() {
        String x = "AACAGTTACC";
        String y = "TAAGGTCA";
      /*  if (x.length() == 0 || y.length() == 0) return null;
        if (x == null) return null;
        if (y == null) return null;*/

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


        for (int i = 0; i <= m; i++) {
            System.out.println();
            for (int j = 0; j <= n; j++) {
                System.out.print(opt[i][j] + " ");

            }
        }
        System.out.println();
        System.out.println("OutPut Number is " + opt[m][n]);


        // return new pa3.Path();
    }

    /*
    public int isEqual(String x, int x1, String y, int y1) {
        if (x.charAt(x1) == y.charAt(y1))
            return 0;
        else return 1;

    }
    */

    public static void main(String[] args) {
        Match2 d = new Match2();
        d.match();

    }

}




        /*// we need to set the opt[i][0] and opt[0][j]
        /// example: we have x: palette and y: palate
        //x:
        *//*
 *  0 1 2 3 4 5 6--index j
 *    p a l a t e
 * 0
 * 1 p
 * 2 a
 * 3 l
 * 4 e
 * 5 t
 * 6 t
 * 7 e
 *
 * (i)index
 * *//*
        for (int i = 1; i <= m; i++) {
            opt[i][0] = i;
        }
        */
/*
 *  0 1 2 3 4 5 6 index j
 *    p a l a t e
 *
 *  p
 *  a
 *  l
 *  e
 *  t
 *  t
 *  e
 *
 * */
/*
        for (int j = 1; j <= n; j++) {
            opt[0][j] = j;
        }
*/

/* //filling the opt.
        for (int i = 0; i < n + 1; i++) Arrays.fill(opt[i], 0);

        for (int i = 0; i <= n + m; i++) {
            opt[i][0] = i * 2;
            opt[0][i] = i * 2;
        }
        //Bottom up process;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(i - 1)) {
                    opt[i][j] = opt[i - 1][j - 1];
                }
                else {
                    opt[i][j] = Math.min(Math.min(opt[i - 1][j - 1] + 1, opt[i - i][j] + 2),
                                         opt[i][j - 2] + 2);
                }

            }

        }*/
