/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RandInt {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        double d = Math.random();
        int t = (int) (d * N);

        System.out.println(t);

    }
}
