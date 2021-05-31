package fastslowpointer;

/*
Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */

public class StartOfLinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);
        head.next.next.next.next.next.next = new ListNode(70);
        head.next.next.next.next.next.next.next = new ListNode(80);
        head.next.next.next.next.next.next.next.next = head.next.next.next;
        System.out.println(findCycleStart(head).val);
    }

    public static ListNode findCycleStart(ListNode head) {
        int cycleLength = 0;
        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                cycleLength = calculateLength(slowPtr); // calculate cycle length
                break;
            }
        }
        return findStart(head, cycleLength);
    }

    private static int calculateLength(ListNode slowPtr) {
        ListNode current = slowPtr;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slowPtr);
        return cycleLength;
    }

    public static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;

        // move pointer2 ahead to cycleLength nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointer parallely until they meet.
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }


}
