/*
    Created by : Kumar Sudarshan
    Date : 10th Feb 2018
    Delete at 6th position
    input : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    output : 1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 9
 */

package LinkedList;

public class DeleteNodeAtPosition {
    static ListNode start = null;

    public static void main(String[] args) {
        start = SingleLinkedList.createLinkedList(start);
        SingleLinkedList.printLinkedList(start);
        start = deleteAtPosition(start, 4);
        SingleLinkedList.printLinkedList(start);
    }

    static ListNode deleteAtPosition(ListNode head, int position) {
        if (position < 1 || head == null) {
            return head;
        }
        ListNode temp = head;
        if (position == 1 && head != null) {
            head = temp.getNext();
        }
        for (int i = 0; i < position - 2 && temp.getNext() != null; i++) {
            temp = temp.getNext();
        }
        if (temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
        }
        return head;
    }
}
