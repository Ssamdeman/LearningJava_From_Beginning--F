/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ThreeSort {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int smallest1 = (int) Math.min(a, b);
        int smallest2 = (int) Math.min(smallest1, c);
        //int smallest3 = Math.min(smallest1, smallest2);

        int biggest1 = (int) Math.max(a, b);
        int biggest2 = (int) Math.max(biggest1, c);

        //how to find middle of the number.
        // 3 1 2
        // 1 2 3
        int median = (a + b + c) - (smallest2 + biggest2);
        System.out.println(smallest2); //smallest

        System.out.println(median);

        System.out.println(biggest2);


    }
}
