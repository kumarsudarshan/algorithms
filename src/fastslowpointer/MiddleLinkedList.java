package fastslowpointer;

/*
Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.

Input: 1 -> 2 -> 3 -> 4 -> 5 -> null, Output: 3

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, Output: 4

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null, Output: 4
 */

public class MiddleLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);
        head.next.next.next.next.next.next = new ListNode(70);
        head.next.next.next.next.next.next.next = new ListNode(80);
        head.next.next.next.next.next.next.next.next = new ListNode(90);
        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
