/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 *
 *
 * Running the code: javac -cp pa1/lib/algs4.jar pa1/*.java  to compile.
 *              java -cp pa1/lib/args4.jar pa1/TestPerf.java TinySt.txt
                java -cp pa1/lib/args4.jar pa1/TestPerf.java TinySt.txt

 *Do i put the startingTimer before the loop or inside of the loop????
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.SequentialSearchST;

public class TestPerf {
    ST<String, Integer> sortedTable = new ST<String, Integer>();
    SeparateChainingHashST<String, Integer> seperatedChaining
            = new SeparateChainingHashST<String, Integer>();
    LinearProbingHashST<String, Integer> linearProbing = new LinearProbingHashST<String, Integer>();
    SequentialSearchST<String, Integer> sequentialSearch
            = new SequentialSearchST<String, Integer>();

    int totalWords; // number of total words;
    String mostUsedWord = "hello";/// most used word
    long endedTimerST_ReturnDif; //timer for ST;
    long endedTimerSeperatedChain_ReturnDif; //time for Sepreated Chain
    long endedSequentailSearch_ReturnDif; //timer for Sequential Search
    long endedLinearPorbing_ReturnDif; //timer for linearProbing

    //need a test.--D
    //construct should read from the main and build the tables.---D
    public TestPerf(String fileName) {

        In allIn = new In(fileName);
        String[] dataArray = allIn.readAllStrings();/// return array of word.
        totalWords = dataArray.length;

        // how to read all the files in the constructore and save it in thr tables.
        long startingSTtimer = System.currentTimeMillis();
        for (int i = 0; i < dataArray.length - 1; i++) {
            //Sorted Table aka ST.
            if (!sortedTable.contains(dataArray[i])) { /// for ST. which return Null if empty.
                sortedTable.put(dataArray[i], 1);
            }
            else {
                sortedTable.put(dataArray[i], sortedTable.get(dataArray[i]) + 1);
            }
        }
        endedTimerST_ReturnDif = System.currentTimeMillis() - startingSTtimer;
        // -------------------------------------------------------------
        long startingSeperatedChainTimer = System.currentTimeMillis();
        for (int i = 0; i < dataArray.length - 1; i++) {
            /// seperetedChaingning table.
            if (!seperatedChaining.contains(dataArray[i])) {
                seperatedChaining.put(dataArray[i], 1);
            }
            else {
                seperatedChaining.put(dataArray[i], seperatedChaining.get(dataArray[i]) + 1);
            }
        }
        endedTimerSeperatedChain_ReturnDif = System.currentTimeMillis()
                - startingSeperatedChainTimer;

        // -------------------------------------------------------------
        long startingSequenTialSearchTimer = System.currentTimeMillis();
        for (int i = 0; i < dataArray.length - 1; i++) {
            ///sequentialSearch table
            if (!sequentialSearch.contains(dataArray[i])) {
                sequentialSearch.put(dataArray[i], 1);
            }
            else {
                sequentialSearch.put(dataArray[i], seperatedChaining.get(dataArray[i]) + 1);
            }
        }
        endedSequentailSearch_ReturnDif = System.currentTimeMillis()
                - startingSequenTialSearchTimer;
        // -------------------------------------------------------------
        long startingLinearPorbingTimer = System.currentTimeMillis();
        for (int i = 0; i < dataArray.length - 1; i++) {
            if (!linearProbing.contains(dataArray[i])) {
                linearProbing.put(dataArray[i], 1);
            }
            else {
                linearProbing.put(dataArray[i], linearProbing.get(dataArray[i]) + 1);
            }

        }
        endedLinearPorbing_ReturnDif = System.currentTimeMillis() - startingLinearPorbingTimer;
        // -------------------------------------------------------------

        //testing place.
       /* for (String s : sortedTable.keys())
            System.out.println("-" + s + " " + sortedTable.get(s));
            */
    }


    public int getTotalWords() {
        return totalWords;

    }

    public int getUniqueWords() {
        return sortedTable.size();
    }

    public int getMostUsedWord() {
        int tempholder_counter = 0;
        for (String s : sortedTable.keys()) {
            if (tempholder_counter < sortedTable.get(s)) {
                tempholder_counter = sortedTable.get(s);
                mostUsedWord = s;/// this line is not working.
            }
        }
        return tempholder_counter;

    }

    public String getMaxOccurrence() {
        return mostUsedWord;
    }

    public void printStats() {
        System.out.println(endedTimerST_ReturnDif);
        System.out.println(endedTimerSeperatedChain_ReturnDif);
        System.out.println(endedLinearPorbing_ReturnDif);
        System.out.println(endedSequentailSearch_ReturnDif);
        System.out.println(getTotalWords());
        System.out.println(getUniqueWords());
        System.out.println(getMaxOccurrence() + ' ' + getMostUsedWord());

    }

    public static void main(String[] args) {

        TestPerf loadData = new TestPerf(args[0]);
        loadData.printStats();

    }


}
