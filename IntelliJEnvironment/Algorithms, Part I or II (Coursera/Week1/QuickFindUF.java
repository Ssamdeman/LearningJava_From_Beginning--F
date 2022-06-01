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
        int pid = id[p];
        int qid = id[q];


        //TODO need paper run testing.
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }

    }


    public static void main(String[] args) {

    }
}
