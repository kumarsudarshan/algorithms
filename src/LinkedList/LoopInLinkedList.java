/*
    Created by : Kumar Sudarshan
    Date : 7th Feb 2018
    Find Loop in Linked List
    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
                             |     |  true
                             9 <- 8
 */
package LinkedList;

public class LoopInLinkedList {

    static ListNode start = null;

    public static void main(String[] args){
        // Creating LinkedList with Loop
        start = SingleLinkedList.insertAtEnd(start,11);
        start = SingleLinkedList.insertAtEnd(start,22);
        start = SingleLinkedList.insertAtEnd(start,33);
        start = SingleLinkedList.insertAtEnd(start,44);
        start = SingleLinkedList.insertAtEnd(start,55);
        start.next.next.next.next = SingleLinkedList.insertAtEnd(start,99); // creating loop
        boolean result = LoopInLinkedList(start);
        if(result == true)
                System.out.println("Loop exists!!!");
        else
                System.out.println("No Loop exists!!!");
    }

    static boolean LoopInLinkedList(ListNode head){
        ListNode slowPtr = head, fastPtr = head;
        while(slowPtr != null && fastPtr != null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext();
            if(fastPtr != null)
                fastPtr = fastPtr.getNext();
            if(slowPtr == fastPtr) return true;
        }
        return false;
    }

}
