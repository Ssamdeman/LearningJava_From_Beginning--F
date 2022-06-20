/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week2;
//one way of linked list. single linked list.

public class linkedListMy {

    Node head; //head of the linked list as global variable

    static class Node {
        String data;
        Node next;

        //creating contructor
        Node(String input) {
            data = input;
            next = null;
        }

    }

    public void printList() {

        Node n = head;

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

    }

    // add the data at the beggining of the linked list
    public void push(String new_data) {

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;

    }

    public void insertAfter(Node prev_node, String new_data) {
        if (prev_node == null) {
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void append(String new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;


    }

    public void deletePush() {

        Node temp = head.next;
        head = temp;


    }


    public static void main(String[] args) {

        linkedListMy llist = new linkedListMy();

        llist.head = new Node("Hello");
        Node second = new Node("Word");
        Node third = new Node("!");

        //linking all the data
        llist.head.next = second;
        second.next = third;

        System.out.print("origina: ");
        llist.printList();

        System.out.println();

        llist.append("I am Ssam");
        llist.printList();

        System.out.println();

        llist.deletePush();
        llist.printList();

        System.out.println();

        llist.push("Hi");
        llist.printList();
    }
}
