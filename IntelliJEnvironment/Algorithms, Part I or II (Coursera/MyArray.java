/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class MyArray {

    //global variabels
    private int[] items;
    private int count;

    //contsructor
    public MyArray() {
        throw new IllegalArgumentException("Empty array is not allow.");
    }

    public MyArray(int length) {
        items = new int[length];
        count = 0;

    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newArray = new int[count * 3];
            for (int i = 0; i < count; i++) {
                newArray[i] = items[i];
            }
            items = newArray;
        }
        items[count] = item;
        count++;

    }

    public int indexOf(int item) {

        for (int i = 0; i < count; i++) {
            if (items[i] == item) return i;
        }
        return -1;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("");
        }
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;

    }


    public static void main(String[] args) {


    }
}
