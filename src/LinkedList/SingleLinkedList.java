package LinkedList;

import java.util.Scanner;

public class SingleLinkedList {

    static ListNode start = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = createLinkedList(start);
        printLinkedList(start);
    }

    static ListNode createLinkedList(ListNode start) {
        start = insertAtEnd(start, 11);
        start = insertAtEnd(start, 22);
        start = insertAtEnd(start, 33);
        start = insertAtEnd(start, 44);
        start = insertAtEnd(start, 55);
        start = insertAtEnd(start, 66);
        start = insertAtEnd(start, 77);
        start = insertAtEnd(start, 88);
        start = insertAtEnd(start, 99);
        return start;
    }

    static void printLinkedList(ListNode node) {
        System.out.println();
        while (node != null) {
            System.out.print("\t" + node.data);
            node = node.next;
        }
    }

    static ListNode insertAtEnd(ListNode head, int data) {
        ListNode temp = new ListNode(data);
        if (head == null) {
            head = temp;
        } else {
            ListNode temp1 = head;
            while (temp1.getNext() != null) {
                temp1 = temp1.getNext();
            }
            temp1.setNext(temp);
        }
        return head;
    }

    static ListNode insertAtBegin(ListNode head, int data) {
        ListNode temp = new ListNode(data);
        temp.setNext(head);
        head = temp;
        return head;
    }
}
