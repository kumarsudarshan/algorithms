/*
    Created by : Kumar Sudarshan
    Date : 29th June 2018
    Rotate a linked list by k times
    11 -> 22 -> 33 -> 44 -> 55 -> 66 -> 77 -> 88 -> 99
    k = 4
    55 -> 66 -> 77 -> 88 -> 99 -> 11 -> 22 -> 33 -> 44
 */


package LinkedList;

public class RotateLinkedList {

    static ListNode start = null;

    public static void main(String[] args) {
        start = SingleLinkedList.createLinkedList(start);
        SingleLinkedList.printLinkedList(start);
        start = rotateLinkedList(start,4);
        SingleLinkedList.printLinkedList(start);
    }

    static ListNode rotateLinkedList(ListNode head, int k) {
        ListNode temp = head;
        while(temp != null && temp.getNext() != null){
            temp = temp.getNext();
        }

        while(k > 0){
            ListNode temp2 = head;
            head = head.getNext();
            temp2.setNext(null);
            temp.setNext(temp2);
            temp = temp2;
            k--;
        }
        return head;
    }



}
