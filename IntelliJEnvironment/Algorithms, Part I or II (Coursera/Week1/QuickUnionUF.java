/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week1;


public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N) {

        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }


    //TODO run the test on this on hand.---D

    private int root(int k) {
        //4 == id[4] = 3
        //3 == id[3];= 8
        //8 == id[8] = true
        while (k != id[k]) k = id[k];

        return k;

    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }


    public static void main(String[] args) {
       /*
       id = {0,1,2,3,4,5,6,7,8,9}
       1) union(4,3)
            i = 4,
            j = 3
                root(4) = 4
                root(3) = 3
            id[4] = 3;
      index= {0,1,2,3,4,5,6,7,8,9}
        id = {0,1,2,3,3,5,6,7,8,9}
        2)union(3,8)
            i = 3,
            j = 8
                root (3) = 3
                root(8) = 8
            id[3] = 8;
          id = {0,1,2,3,4,5,6,7,8,9}
          id = {0,1,2,8,3,5,6,7,8,9}
      3)union(6,5)
            i = 6,
            j = 5
                root (6) = 6
                root(5) = 5
            id[5] = 6;
          id = {0,1,2,3,4,5,6,7,8,9}
          id = {0,1,2,8,3,5,5,7,8,9}
        4)union(9,4)
            i = 9,
            j = 4
                root (9) = 9
                root(4) = 5
            id[5] = 6;
          id = {0,1,2,3,4,5,6,7,8,9}
          id = {0,1,2,8,3,5,5,7,8,9}

        */

    }
}
