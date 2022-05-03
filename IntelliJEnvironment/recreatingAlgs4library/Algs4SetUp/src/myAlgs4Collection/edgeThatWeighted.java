/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package myAlgs4Collection;

//This implementation from Aalgs4 prinstone.

import edu.princeton.cs.algs4.StdOut;

public class edgeThatWeighted implements Comparable<edgeThatWeighted> {

    private final int v, w;
    private final double weight;


    //contructor has two vertex as int and weight as double
    public edgeThatWeighted(int v, int w, double weight) {

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() { // this return either vertex v or w.
        return v;

    }

    public int other(int vertex) { //return the other vertext given the either.
        if (vertex == v) return w;
        else {
            return v;
        }
    }

    public double weight() {
        return this.weight;
    }

    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);

    }

    public int compareTo(
            edgeThatWeighted that) { // we using the compare so we have to implements what is compare means
        // if other/that is bigger then the compares to return 1;
        if (this.weight < that.weight)
            return -1;
        else if (this.weight > that.weight)
            return 1;
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        edgeThatWeighted e = new edgeThatWeighted(12, 34, 5.67);
        StdOut.println(e);

    }


}
