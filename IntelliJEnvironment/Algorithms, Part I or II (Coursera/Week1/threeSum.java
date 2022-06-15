/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week1;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class threeSum {


    //Run time is n^3.
    public static int count(int[] a) {
        int N = a.length;
        int count = 0; //keep track of adding 3 number equals to 0;

        //finding the 3sum equal to0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) count++;
                }
            }
        }
        return count;


    }

    ///Run time is n^2 log(n)
    // this return the number of 3 sums that equal to 0.
    public static int count_version_two(int[] a) {
        Arrays.sort(a);

        int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j)
                    count++;
            }
        }
        return count;


    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 30, -40, -20, -10, 40, 0, 10, 5 };
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(count(test1));
        double time = stopwatch.elapsedTime();
        System.out.println(time);
    }
}
