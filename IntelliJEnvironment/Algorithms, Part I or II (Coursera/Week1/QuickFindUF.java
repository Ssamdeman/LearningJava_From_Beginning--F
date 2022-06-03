/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week1;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N]; //setting the number of items;

        //initisialzing the id array to it self.
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /// checking connectivity of two items;

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    //connecting two items;
    public void union(int p, int q) {
        //getting id of p and q and save temp values
        //id = {0,1,2,3,4,5,6,7,8,9}
        int pid = id[p];  // = pid = 4
        int qid = id[q];  // = qid = 3

        //goals it change id[4] = 3

        //TODO need paper run testing.----D
        for (int i = 0; i < id.length; i++) {
            //itererate throw the id array and find the qid and pid.
            if (id[i] == pid) id[i] = qid;
        }
        //final result will be for union (4,3)
        //pid = 4
        //qid = 3
        //id[4] = 3
        /////id = {0,1,2,3,3,5,6,7,8,9}
        //next final result will be for union (3,8)
        //pid = 3
        //qid = 8.
        //id[3]= 8.
        //id[3] 8.
        ///////id = {0,1,2,8,8,5,6,7,8,9}


        //Run some hand on test. This is works but the run time is n^2 which is really bad.


    }


    public static void main(String[] args) {

    }
}
