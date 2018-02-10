/*
    Created by : Kumar Sudarshan
    Date : 7th Feb 2018
    Reverse of a linked list
    1 -> 2 -> 3 -> 4 -> 5
    5 -> 4 -> 3 -> 2 -> 1
 */

package LinkedList;

public class ReverseLinkedList {

    static ListNode start = null;

    public static void main(String[] args) {
        start = SingleLinkedList.createLinkedList(start);
        SingleLinkedList.printLinkedList(start);
        start = reverseLinkedListIterative(start);
        SingleLinkedList.printLinkedList(start);
        start = reverseLinkedListRecursive(start);
        SingleLinkedList.printLinkedList(start);
    }

    static ListNode reverseLinkedListIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    static ListNode reverseLinkedListRecursive(ListNode head) {
        if (head == null) return null;
        if (head.getNext() == null) return head;
        ListNode temp = head.getNext();
        head.setNext(null);
        ListNode reverseRest = reverseLinkedListRecursive(temp);
        temp.setNext(head);
        return reverseRest;
    }
}
