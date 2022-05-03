/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test2;


public class DPTestings {
    /*//Java program for Tabulated version
     */
    int fib(int n) {
        int f[] = new int[n + 1]; //we do n+1 since we are running ffrom 1 to n
        f[0] = 0; // base case
        f[1] = 1; // base case.

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }












    /*//
    Java program for
    Memoized version
    int NIL = -1; //base case for Fibonacci.

    int lookup[] = new int[100];
    *//* Function to initialize NIL values in lookup table *//*

    void _initialize() {
        for (int i = 0; i < 100; i++)
            lookup[i] = NIL;
    }

    //finding n's Fibnacci number:
    int fib(int n) {

        if (lookup[n] == NIL) {
            //base case
            if (n <= 1) {
                lookup[n] = n; // return the n
            }
            else
                lookup[n] = fib(n - 1) + fib(n - 2);
        }
        return lookup[n];
    }*/

    public static void main(String[] args) {
        //testing fibannacci
        DPTestings f = new DPTestings();
        int n = 6;
        //f._initialize();

        System.out.println(f.fib(n));

    }
}
