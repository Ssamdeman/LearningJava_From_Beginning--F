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
    //Neeed to check if my add lost is working.
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("");// corner cases

        Node prev;
        Node curr = first;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        last = curr;
        Node newLast = new Node();
        newLast.data = item;
        newLast.next = null;
        last.next = newLast;

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


        //find the previous of the last;
        Node prev = null;
        Node curr = first;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        Item tempData = curr.data;
        last = prev;
        size_items--;
        return tempData;


    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new listIterator();

    }

    public class listIterator<Item> implements Iterator<Item> {
        private Node curr = first;


        public boolean hasNext() {
            return curr != null;
        }

        public void remove() {
        }

        public Item next() {
            Node temp = curr;
            curr = curr.next;
            return (Item) temp.data;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque myDeque = new Deque();
        System.out.println(myDeque.isEmpty());
        System.out.println(myDeque.size());
        myDeque.addFirst(3);
        myDeque.addFirst(2);
        myDeque.addFirst(1);
        System.out.println(myDeque.isEmpty());
        System.out.println(myDeque.size());

        for (Object x : myDeque) {
            System.out.print(x + " ");
        }
        System.out.println();
        myDeque.addLast(4);
        myDeque.addLast(5);

        for (Object x : myDeque) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(myDeque.size());

        System.out.println("Testing removing functions");

        System.out.println(myDeque.removeFirst());
        for (Object x : myDeque) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(myDeque.size());
        System.out.println("@2 Testing removing functions");


        System.out.println(myDeque.removeLast());
        for (Object x : myDeque) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(myDeque.size());


    }
}
