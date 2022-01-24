/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class UniformRandom {
    public static void main(String[] args) {
        int a = (int) (10 * Math.random());
        int b = (int) (10 * Math.random());
        int c = (int) (10 * Math.random());
        int d = (int) (10 * Math.random());
        int e = (int) (10 * Math.random());


        int sumAverage = (a + b + c + d + e) / 5;
       /* int SmallestNum = Math.min(a, b, c, d, e);
        int biggestNum = Math.max(a, b, c, d, e);*/
        int small1 = Math.min(a, b);
        int small2 = Math.min(small1, c);
        int small3 = Math.min(small2, d);
        int small4 = Math.min(small3, e);
        //System.out.println(small4);
        int biggest1 = Math.max(a, b);
        int biggest2 = Math.max(biggest1, c);
        int biggest3 = Math.max(biggest2, d);
        int biggest4 = Math.max(biggest3, e);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println(sumAverage);
        System.out.println(small4);
        System.out.println(biggest4);

    }
}
