/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int item) {
            this.value = item;
        }
    }

    private Node first = null;
    private Node last = null;

    public void addLast(int item) {
        Node node = new Node(item);

        //check list empty
        if (first == null) {
            first = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }

    }

    public static void main(String[] args) {

    }
}
