/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package myAlgs4Collection;

///I have no and no idea what this does. I need to explore this more.
public class MyUF {

    private int[] parent;
    private byte[] rank;
    private int count;


    public MyUF(int n) {
        //corner case
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];

        // Assumed: we are assingning the on each array it self
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    //-------------------------------------------------------------------------------
    // this Returns the canonical element of the set containing element p.
    public int find(int p) {
        while (p != parent[p]) {
            //// path compression by halving? I have not idea does this mean
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    ///Returns true if the two elements are in the same set.
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //Merges the set containing element p with the the set containing element q.
    //I can read the description but no idea what it is haha.
    public void union(int p, int q) {

        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        // make root of smaller rank point to root of larger rank
        //Again I am reading it but still not got haha
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }
        else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;

        }
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;

        }
        count--;
    }


    public static void main(String[] args) {

    }
}
