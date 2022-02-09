/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class CollectionRandomFunc {

    //implementing math.sqrt();
    static void sqrt(double x) {
        Double EPS = 1E-15;/// error tolarance up to 15 placess
        Double c = x;
        Double t = c;

        while (Math.abs(t - (c / t)) > t * EPS) {
            t = ((c / t) + t) / 2.0;
        }
        System.out.println(t);
    }

    //compute  sum 1 to N;
    static int computeSum(int x) {
        int sum = 0;
        for (int i = 1; i <= x; i++) sum += 1;
        return sum;
    }

    //compute N!;
    static long sumFactorial(int N) {
        long product = 1;
        for (int i = 1; i <= N; i++) product *= i;
        return product;
    }

    //Creating ruler with a loop
    static void advancedruler(int N) {
        String ruler = " ";
        for (int i = 1; i <= N; i++) ruler = ruler + i + ruler;

        System.out.println(ruler);

    }

    //priing fibbanachin number
    static void PQfor(int x) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= x; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }


    public static void main(String[] args) {
     

    }
}
