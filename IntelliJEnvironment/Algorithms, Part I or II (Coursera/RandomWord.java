/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {

        //System.out.println(" I am here");
        String currentWord = " ";
        String previousWord = " ";
        boolean checker;
        int i = 0; //tracking ith word
        // int p = 1; // getting probability of 1/i


        while (!StdIn.isEmpty()) {
            currentWord = StdIn.readString();
            i++; /// this first word.
            checker = StdRandom.bernoulli(
                    1 / i); // getting true or false given probability of 1/i for the CurrentWord.
            System.out.println("checking checker: " + checker);
            if (checker) previousWord = currentWord;

            //System.out.println(previousWord);
        }
        /*System.out.println(previousWord);
        System.out.println(currentWord);*/


    }
}
