/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week1;

public class binarySearch {
    static int[] array;
    static int looking;

    public binarySearch(int[] a, int key) {
        this.array = a;
        this.looking = key;

    }

    public binarySearch() {
        this.array = null;
        this.looking = 0;

    }

    public static int binarySearch(int[] data, int key) {
        array = data;
        looking = key;

        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (looking < array[mid])
                hi = mid - 1;
            if (looking > array[mid])
                lo = mid + 1;
            else return mid;
        }
        return -1;


    }


    public static void main(String[] args) {

    }
}
