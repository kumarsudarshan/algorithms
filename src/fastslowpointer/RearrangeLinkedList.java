package fastslowpointer;

/*
Rearrange a LinkedList (medium)
Given the head of a Singly LinkedList,
write a method to modify the LinkedList such that
the nodes from the second half of the LinkedList are inserted alternately
to the nodes from the first half in reverse order.
So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.

Your algorithm should not use any extra space and the input LinkedList should be modified in-place.

Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null, Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null

Input: 2 -> 4 -> 6 -> 8 -> 10 -> null, Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 */

public class RearrangeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(40);
        head.next.next.next.next.next.next = new ListNode(30);
        head.next.next.next.next.next.next.next = new ListNode(20);
        head.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
        System.out.println();
        reorder(head);
        temp = head;
        while(temp != null){
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
    }

    public static void reorder(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        // here slow will be at middle of the linked list.
        ListNode slow = head, fast = head;
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;

        }

        // reverse 2nd half of the linked list
        ListNode secondHalfHead = reverseLink(slow);
        ListNode firstHalfHead = head;

        // reorder the linked list
        while(firstHalfHead != null && secondHalfHead != null){
            ListNode temp = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            firstHalfHead = temp;

            temp = secondHalfHead.next;
            secondHalfHead.next = firstHalfHead;
            secondHalfHead = temp;
        }

        // set null to last node of the linked list
        if(firstHalfHead != null){
            firstHalfHead.next = null;
        }
    }

    public static ListNode reverseLink(ListNode head){
        ListNode temp = null;
        while(head !=  null){
            ListNode nex = head.next;
            head.next = temp;
            temp = head;
            head = nex;
        }
        return temp;
    }
}
