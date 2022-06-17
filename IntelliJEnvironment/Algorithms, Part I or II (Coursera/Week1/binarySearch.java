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

    //binary search for finding maximum value in an array which is first increasing and then decreasing
    public static int findMaxNumber(int[] a, int low, int high) {


        //corner cases
        if (low == high) return a[low];
        if ((high == low + 1) && a[low] >= a[high]) return a[low];
        if ((high == low + 1) && a[low] < a[high]) return a[high];

        // getting the middle.
        int mid = (low + high) / 2;

        if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1])
            return a[mid];

        if (a[mid] > a[mid + 1] && a[mid] < a[mid - 1])
            return findMaxNumber(a, low, mid + 1);
        else
            return findMaxNumber(a, mid + 1, high);

    }


    public static void main(String[] args) {

    }
}
