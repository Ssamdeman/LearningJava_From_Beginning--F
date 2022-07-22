/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size;


    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        queue = (Item[]) new Object[1];


    }


    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;

    }

    // return the number of items on the randomized queue
    public int size() {
        return size;

    }

    private void resize(int capacity) {

        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            copy[i] = queue[i];
        }
        queue = copy;
    }


    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException(""); // corner cases;

        queue[size] = item;
        size++;
        if (size == queue.length) resize(2 * queue.length);


    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new IllegalArgumentException();

        int r = StdRandom.uniform(size);
        Item item = queue[r]; //get the randome item

        queue[r] = queue[size - 1];
        size--;
        queue[size] = null;

        if (size > 0 && size == queue.length / 4) resize(queue.length / 2);
        return item;

    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) throw new IllegalArgumentException();
        int r = StdRandom.uniform(size);
        return queue[r];

    }


    public Iterator<Item> iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<Item> {

        int counter;
        Item[] relist;

        public listIterator() {
            counter = size;
            relist = queue;
            StdRandom.shuffle(relist);
        }

        public boolean hasNext() {
            return counter != 0;

        }

        public void remove() {
            // [UncommentedEmptyMethodBody]

        }

        public Item next() {
            if (counter == 0) throw new IllegalArgumentException();
            counter--;
            return relist[counter];

        }

    }

    public static void main(String[] args) {

    }
}
