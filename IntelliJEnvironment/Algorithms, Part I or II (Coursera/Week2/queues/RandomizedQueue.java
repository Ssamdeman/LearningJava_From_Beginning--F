/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week2.queues;

import java.util.Iterator;
import java.util.function.Consumer;

public class RandomizedQueue<Item> implements Iterable<Item> {

    // construct an empty randomized queue
    public RandomizedQueue()

    // is the randomized queue empty?
    public boolean isEmpty()

    // return the number of items on the randomized queue
    public int size()

    // add the item
    public void enqueue(Item item)

    // remove and return a random item
    public Item dequeue()

    // return a random item (but do not remove it)
    public Item sample()


    public Iterator<Item> iterator() {
        return null;
    }

    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    public static void main(String[] args) {

    }
}
