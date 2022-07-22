/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        int counter = Integer.parseInt(args[0]);
        RandomizedQueue<String> rqueue = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            rqueue.enqueue(StdIn.readString());
        }

        //printing
        for (int i = 0; i < counter; i++) {
            StdOut.println(rqueue.dequeue());

        }

    }
}
