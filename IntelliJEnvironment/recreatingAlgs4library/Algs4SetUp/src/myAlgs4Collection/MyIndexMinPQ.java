/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package myAlgs4Collection;

import java.util.NoSuchElementException;

public class MyIndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int MaxN; ///max number of elements in PQ.
    private int n; //number of elements on PQ.
    private int[] pq; // bineary heap using 1 based indexing;
    private int[] qp; //inverse of pq.
    private Key[] keys; //keys[i]= priority of i.

    //Contructactor. Initialized emptu PQ.

    public MyIndexMinPQ(int MaxN) {
        //corner case
        if (MaxN < 0) throw new IllegalArgumentException();

        this.MaxN = MaxN;
        n = 0;
        keys = (Key[]) new Comparable[MaxN + 1]; /// I dont know that it is this.
        pq = new int[MaxN + 1];
        qp = new int[MaxN + 1];

        //we making all the qp to be be -1. // I dont know why should I do that.
        for (int i = 0; i <= MaxN; i++) {
            qp[i] = -1;
        }

    }

    //methods;
    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) { // it is unsually way way to check if it contains.
        return qp[i] != -1; // if the element is not contains in qp which is inverse of pb.
        //I dont undestand how this should work
    }

    public int size() {
        return n;
    }

    //insert key with index.
    public void insert(int i, Key key) {
        //corner case
        if (contains(i)) throw new IllegalArgumentException();
        n++;
        qp[i] = n; /// what it is ?
        pq[n] = i;/// what it is doing?
        keys[i] = key;
        swim(n);
    }

    //returns the minimum key
    public Key minKey() {
        if (n == 0)
            throw new NoSuchElementException("Priority queue underflow"); //the queue is empty;
        return keys[pq[1]];
    }
    //removes the minimum Key


    //----------------------------------------
    //Heap Helper function
    public void swim(int k) {
        while (k > 1 && greater(k / 2, k))
            exch(k, (k / 2));
        k = k / 2;
    }

    //----------------------------------------
    //helper functions
    public boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;

    }

    public void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


  /*  public Iterator<Integer> iterator() {
        return new HeapIterator();
    }*/


    public static void main(String[] args) {

    }
}
