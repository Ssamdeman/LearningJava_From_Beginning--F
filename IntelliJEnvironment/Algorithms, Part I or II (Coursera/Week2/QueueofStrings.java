/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week2;


//linked list implementation;


public class QueueofStrings {

    private Node first, last;


    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {

        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else
            oldlast.next = last;

    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    public static void main(String[] args) {

    }
}
