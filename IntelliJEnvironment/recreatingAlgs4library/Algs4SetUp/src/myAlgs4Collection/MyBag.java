/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package myAlgs4Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

// this a bag that using using single-linkec-list of generic items.
public class MyBag<Item> implements Iterable<Item> {

    private Node<Item> first;
            // this beginning of bag using linked list. We making a linked list inside
    private int n; // number of elements in the bag

    //LinkedList;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    //making empty bag
    public MyBag() {
        first = null;
        n = 0;
    }

    //checking if bag empty
    public boolean isEmpty() {
        return first == null;
    }

    //return the size of the bag;
    public int size() {
        return n;
    }

    //adding to the bag.
    public void add(Item item) {
        Node<Item> oldFirst = first; // saving the old first
        first
                = new Node<Item>(); /// making the new first as first. This works using first in and first out.
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    ///In honesty, I have no clue where this came from.
    // making an interator.
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        //checker for corner cases
        public boolean hasNext() {
            return current != null;
        }

        //we dont suppor remove from the bag.
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }


    }


    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }


    public static void main(String[] args) {

    }


}
