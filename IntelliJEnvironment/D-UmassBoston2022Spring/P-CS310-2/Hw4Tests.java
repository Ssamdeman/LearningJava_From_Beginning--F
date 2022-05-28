/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Hw4Tests {
    //basic function that give values;

    public static int hashCount(int letter, int value) {
        //System.out.println(31 % 11);
        return ((letter - 65) + value) % 11;
    }


    public static void main(String[] args) {

        // A29 =  65-29 = 7
        //C42 = 67 - 42 = 0
        // E12 = 69 - 12 = 5
        // D31 = 68 - 31 = 1
        // F08 = 70 - 08 = 2
        // G34 = 71 - 34 = 7 +1
        // B10 = 66 - 10 = 0+1
        System.out.println(hashCount(66, 10));

    }
}
