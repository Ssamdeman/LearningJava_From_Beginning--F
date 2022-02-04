/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Foursort {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);

        if (b < a) {
            int t = a;
            a = b;
            b = t;
        }
        if (c < a) {
            int t = a;
            a = c;
            c = t;
        }
        if (d < a) {
            int t = a;
            a = d;
            d = t;
        }
        if (c < b) {
            int t = b;
            b = c;
            c = t;
        }
        if (d < b) {
            int t = d;
            b = d;
            d = t;
        }
        if (d < c) {
            int t = d;
            c = d;
            d = t;
        }
        System.out.println(a + ", " + b + ", " + c + ", " + d);


    }
}
