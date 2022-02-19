/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class hwthree {


    public static void aToB(char x) {
        if (x >= 65 && x <= 90) {
            System.out.println(x + "--> " + ((int) x - 65));
        }
        else {
            System.out.println(x + "--> " + ((int) x - 97));
        }
    }

    public static void aaTobb(char x, char y) {
        System.out.println((char) x + (char) y + "--> " + (x - 97) * 26 + (y - 97));
    }

    public static void numTolet(int x) {
        System.out.println((x + "-->" + (char) (x / 26 + 97) + (char) (x % 26 + 97)));
    }

    public static String str(int i) {
        return i < 0 ? "" : str((i / 26) - 1) + (char) (97 + i % 26);
    }

    public static void main(String[] args) {

      /*  char z = 'a';
        System.out.println(((int) z));
        */
        aaTobb('a', 'a');
        System.out.println(str(0));
    }

}
