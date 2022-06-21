/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week2;

// implementaion stack with Arrays.

public class StackStringVersionTwo {

    private String[] s;
    private int N = 0;

    public StackStringVersionTwo(int capacity) {
        s = new String[capacity];

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {

        if (N == s.length) resize(2 * s.length);

        s[N++] = item;
    }

    public String pop() {
        //return s[N--];
        //Loitering issues.
        String item = s[N--];
        s[N] = null;
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
        return item;

    }

    public void resize(int new_capcity) {
        String[] copy = new String[new_capcity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }


    public static void main(String[] args) {

    }
}
