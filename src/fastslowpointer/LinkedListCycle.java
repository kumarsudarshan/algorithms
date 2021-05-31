package fastslowpointer;

/*
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
also find the length of cycle.
 */

public class LinkedListCycle {
    private static int cycleLength = 0;
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);
        head.next.next.next.next.next.next = new ListNode(70);
        head.next.next.next.next.next.next.next = new ListNode(80);
        head.next.next.next.next.next.next.next.next = head;
        System.out.println(hasCycle(head));
        System.out.println(cycleLength);
    }

    public static boolean hasCycle(ListNode head){
        ListNode slowPtr = head, fastPtr = head.next;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                calculateLength(slowPtr);
                return true;
            }
        }
        return false;
    }

    private static void calculateLength(ListNode slowPtr) {
        ListNode current = slowPtr;
        do{
            current = current.next;
            cycleLength++;
        } while(current != slowPtr);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
