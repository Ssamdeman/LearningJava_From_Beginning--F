package RandomExploring;

public class myArrayList {
    private int[] items;
    private int counter;


    public myArrayList(int length) {
        items = new int[length];

    }

    public void print() {
        for (int i = 0; i < counter; i++) {
            System.out.println(items[i]);

        }
    }

    public void insert(int item) {

        //incraesing the size of array of it is full
        if (items.length == counter) {
            int[] newItems = new int[counter * 2];
            for (int i = 0; i < counter; i++) {
                newItems[i] = items[i];

            }
            items = newItems;
        }
        items[counter] = item;
        counter++;
    }

    public void removeAt(int index) {
        if (index >= items.length || index < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < counter; i++) {
            items[i] = items[i + 1];

        }
        counter--;


    }

    public


    public static void main(String[] args) {

    }
}
