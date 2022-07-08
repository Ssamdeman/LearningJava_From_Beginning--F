/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week2.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size_items;

    private class Node {
        Item data;
        Node next;

    }

    // construct an empty deque
    public Deque() {
        first = null;
        size_items = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;

    }

    // return the number of items on the deque
    public int size() {
        return size_items;

    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException(""); // corner cases;

        Node newData = new Node();
        newData.data = item;

        Node temp = first;

        newData.next = temp;
        first = newData;
        size_items++;


    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("");// corner cases

        Node oldLast = last;
        last = new Node();
        last.data = item;
        last.next = null;

        if (isEmpty())
            last = first;
        else
            oldLast.next = last;

        size_items++;

    }

    // remove and return the item from the front
    public Item removeFirst() {

        if (isEmpty()) throw new NoSuchElementException("");

        Node temp = first;
        first = first.next;
        temp.next = null;

        size_items--;

        return temp.data;


    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("");

        Item tempData = last.data;
        //find the previous of the last;
        Node prev = null;
        Node curr = first;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        last = prev;


        return tempData;


    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new listIterator();

    }

    public class listIterator<Item> implements Iterator<Item> {
        

    }

    // unit testing (required)
    public static void main(String[] args) {

    }
}
