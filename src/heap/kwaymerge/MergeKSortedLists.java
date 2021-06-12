package heap.kwaymerge;

import LinkedList.ListNode;

import java.util.PriorityQueue;

/*
Merge K Sorted Lists (medium)
Given an array of ‘K’ sorted Linked Lists, merge them into one sorted list.
Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
Input: L1=[5, 8, 9], L2=[1, 7]
Output: [1, 5, 7, 8, 9]
 */

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(6);
        list1.next.next = new ListNode(8);

        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(7);

        ListNode list3 = new ListNode(1);
        list3.next = new ListNode(3);
        list3.next.next = new ListNode(4);

        ListNode[] lists = new ListNode[]{list1, list2, list3};
        ListNode result = mergeKSortedLists(lists);
        while (result != null) {
            System.out.print(result.data + "\t");
            result = result.next;
        }
    }

    public static ListNode mergeKSortedLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.data - l2.data);
        for (ListNode root : lists) {
            if (root != null) {
                minHeap.add(root);
            }
        }

        ListNode resultHead = null, resultTail = null;
        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            if (resultHead == null) {
                resultHead = current;
                resultTail = current;
            } else {
                resultTail.next = current;
                resultTail = resultTail.next;
            }
            if (current.next != null) {
                minHeap.add(current.next);
            }
        }
        return resultHead;
    }

}
