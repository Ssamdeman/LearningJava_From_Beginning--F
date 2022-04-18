/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        

        boolean rightTriangle = ((a > -1) && (b > -1) && (c > -1))
                && ((a * a) + (b * b) == (c * c));

        System.out.println(rightTriangle);
    }
}
