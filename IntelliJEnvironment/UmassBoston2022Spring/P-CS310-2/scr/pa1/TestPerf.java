/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.SequentialSearchST;

import java.io.File;

public class TestPerf {
    ST<String, Integer> sortedTable = new ST<String, Integer>();
    SeparateChainingHashST<String, Integer> seperatedChaining
            = new SeparateChainingHashST<String, Integer>();
    //This need clearifications for thisL:  /// LinearProbingHashST<String, Integer> linearProbing = new LinearProbingHashST<String, Integer>();
    SequentialSearchST<String, Integer> sequentialSearch
            = new SequentialSearchST<String, Integer>();

    //need a test.
    //construct should read from the main and build the tables.
    public TestPerf(String fileName) {

        File dataFile = new File(fileName);
        In allIn = new In(dataFile);
        String[] dataArray = allIn.readAllStrings();/// return array of word.

        // how to read all the files in the constructore and save it in thr tables.
        for (int i = 0; i < dataArray.length; i++) {
            //Sorted Table aka ST.
            if (!sortedTable.contains(dataArray[i])) { /// for ST. which return Null if empty.
                sortedTable.put(dataArray[i], 1);
            }
            else {
                sortedTable.put(dataArray[i], sortedTable.get(dataArray[i]) + 1);
            }
            /// seperetedChaingning table.
            if (!seperatedChaining.contains(dataArray[i])) {
                seperatedChaining.put(dataArray[i], 1);
            }
            else {
                seperatedChaining.put(dataArray[i], seperatedChaining.get(dataArray[i]) + 1);
            }
            ///sequentialSearch table
            if (!sequentialSearch.contains(dataArray[i])) {
                sequentialSearch.put(dataArray[i], 1);
            }
            else {
                sequentialSearch.put(dataArray[i], seperatedChaining.get(dataArray[i]) + 1);
            }
            //Add linear probing later.

            for (String s : sortedTable.keys())
                System.out.println(s + " " + sortedTable.get(s));

        }

    }

    public static void main(String[] args) {

        TestPerf loadData = new TestPerf(args[0]);


    }


}
