/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Quadratic {
    public static void main(String[] args) {
        //Get the coeficients from  Comandline
        double b = Double.parseDouble(args[0]);
        double c = Double.parseDouble(args[1]);
        //get the root; x*x + b*x+c;
        double discriminant = b * b - 4.0 * c;
        double d = Math.sqrt(discriminant);
        double root1 = (-b + d) / 2.0;
        double root2 = (-b - d) / 2.0;

        System.out.println(root1);
        System.out.println(root2);


    }
}
