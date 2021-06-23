package LinkedList;
/*
Reverse Linked List II
https://leetcode.com/problems/reverse-linked-list-ii/
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Input: head = [5], left = 1, right = 1
Output: [5]
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }

        System.out.println();
        temp = reverseBetween(head, 2, 4);
        while(temp != null){
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode nodeBeforeReversedSublist = dummy;
        int pos = 1;
        while(pos < left){
            nodeBeforeReversedSublist = nodeBeforeReversedSublist.next;
            pos++;
        }

        ListNode workingPtr = nodeBeforeReversedSublist.next;

        while(left < right){
            // cut the node
            ListNode nodeToBeExtracted = workingPtr.next;
            workingPtr.next = nodeToBeExtracted.next;

            // paste it to the front
            nodeToBeExtracted.next = nodeBeforeReversedSublist.next;
            nodeBeforeReversedSublist.next = nodeToBeExtracted;
            left++;
        }
        return dummy.next;
    }
}
