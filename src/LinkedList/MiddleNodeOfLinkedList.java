/*
    Created by : Kumar Sudarshan
    Date : 6th Feb 2018
    Middle Node of Linked List
 */

package LinkedList;

public class MiddleNodeOfLinkedList {
    static ListNode start = null;

    public static void main(String[] args){
        start = SingleLinkedList.createLinkedList(start);
        SingleLinkedList.printLinkedList(start);
        System.out.println("\n\tMiddle Node : " + middleNodeOfLinkedList(start));

    }

    static int middleNodeOfLinkedList(ListNode head){
        ListNode fastPtr = head,slowPtr = head;
        while(slowPtr != null && fastPtr != null){
                fastPtr = fastPtr.getNext();
                if(fastPtr != null){
                    fastPtr = fastPtr.getNext();
                    slowPtr = slowPtr.getNext();
                }
            }

        return slowPtr.getData();
    }
}
