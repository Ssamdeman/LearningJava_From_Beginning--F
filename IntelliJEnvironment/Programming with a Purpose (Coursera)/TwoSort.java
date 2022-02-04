/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TwoSort {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        //My goal is here to do get the sort of two numbers
        if (b < a) {
            int t = a;
            a = b;
            b = t;
        }
        System.out.println(a + " , " + b);
    }
}
