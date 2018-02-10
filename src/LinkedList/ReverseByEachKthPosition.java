/*
    Created by : Kumar Sudarshan
    Date : 6th Feb 2018
    Reverse by each Kth Position
    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 9 -> 8 -> 7 ( k = 3)
 */

package LinkedList;

public class ReverseByEachKthPosition {

    static ListNode start = null;

    public static void main(String[] args) {
        start = SingleLinkedList.createLinkedList(start);
        SingleLinkedList.printLinkedList(start);
        start = reverseByEachKthPosition(start, 3);
        SingleLinkedList.printLinkedList(start);
    }

    static ListNode reverseByEachKthPosition(ListNode head, int k) {
        int[] arr = new int[k];
        ListNode temp1 = head;
        while (temp1 != null) {
            ListNode temp2 = temp1;
            int i = 0;
            for (i = 0; i < k && temp2 != null; i++) {
                arr[i] = temp2.getData();
                temp2 = temp2.getNext();
            }
            for (int j = 0; j < k && temp1 != null; j++) {
                temp1.setdata(arr[i - j - 1]);
                temp1 = temp1.getNext();
            }
        }
        return head;
    }
}
