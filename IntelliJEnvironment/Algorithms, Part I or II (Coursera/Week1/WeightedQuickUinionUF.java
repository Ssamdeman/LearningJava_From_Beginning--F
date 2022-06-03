package Week1;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

//TODO Run this program in paper.
public class WeightedQuickUinionUF {

    private int[] id;
    private int[] sz;

    public WeightedQuickUinionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int k) {

        while (k != id[k]) k = id[k];

        return k;

    }


    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }


    public void union(int p, int q) {

        int i = root(p);
        int j = root(q);

        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }

    }


    public static void main(String[] args) {

    }
}
