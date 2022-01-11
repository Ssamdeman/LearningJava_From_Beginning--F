/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Exchnage {
    public static void main(String[] args) {
        //we want to exhcange a value of a and b;
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int t; //temp value
        t = a;
        a = b;
        b = t;
        System.out.println(a); // pring value of A
        System.out.println(b);//pring value of B

    }
}
