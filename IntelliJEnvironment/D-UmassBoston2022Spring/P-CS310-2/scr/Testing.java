/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import pa1.LinearProbingHashST2;

public class Testing {
    public static void main(String[] args) {
        LinearProbingHashST2<String, Integer> testingProfile
                = new LinearProbingHashST2<String, Integer>();

        testingProfile.put("A", 1);
        testingProfile.put("B", 2);
        testingProfile.put("C", 3);
        testingProfile.put("D", 4);
        System.out.println(testingProfile.size());
        // print keys and values
        for (String s : testingProfile.keys())
            StdOut.println(s + " " + testingProfile.get(s));

        testingProfile.delete("A");

        System.out.println();
        System.out.println(testingProfile.size());

        for (Object s : testingProfile.keys())
            StdOut.println(s + " " + testingProfile.get((String) s));

       /* for (int i = 0; i < testingProfile.size(); i++) {
            System.out.print(testingProfile.flags[i] + " ");

        }*/
        //testing:
        //testingProfile.display();
    }

}
