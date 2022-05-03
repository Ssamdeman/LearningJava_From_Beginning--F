/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
/*
The Queue class represents a first-in-first-out (FIFO) queue of generic items.
It supports the usual enqueue and dequeue operations, along with methods for peeking at the first item,
    testing if the queue is empty, and iterating through the items in FIFO order.
This implementation uses a singly linked list with a static nested class for linked-list nodes.
See LinkedQueue for the version from the textbook that uses a non-static nested class.
See ResizingArrayQueue for a version that uses a resizing array.
The enqueue, dequeue, peek, size, and is-empty operations all take constant time in the worst case.
*/


package myAlgs4Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<Item> implements Iterable<Item> {

    private Node<Item> first; //beginning of the queue
    private Node<Item> last; //last of the queue
    private int n; //number of queues

    //helper class sinse we are using the Node.

    public static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    //constructor

    public MyQueue() {
        first = null;
        last = null;
        n = 0;

    }

    //-----------------------------------------------------------------------
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    //return the recently added item to this queue.
    public Item peek() {
        //corner case
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return first.item;
    }

    // adding item into the queues
    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        n++;
    }

    ///Removes and returns the item on this queue that was least recently added.
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    //---------------------------------------------------------------------------
    /// This is confusing. I have no idea what is happening to Iterable interface.
    public Iterator<Item> iterator() {
        // this is the method of the queue. Since we are using interface of iterator we have to implement all the functions of iteretor;
        return new LinkedIterator(first);
    }

    //implementing the Iterator as it is own class.
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;

        }

        public void remove() {
            throw new NoSuchElementException();

        }

        public Item next() {
            if (!hasNext()) throw new UnsupportedOperationException();
            Item item = current.item;
            current = current.next;
            return item;
        }


    }


    public static void main(String[] args) {

    }
}
