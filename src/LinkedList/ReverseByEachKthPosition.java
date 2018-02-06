package LinkedList;

import java.util.Scanner;


public class ReverseByEachKthPosition {

    static ListNode start = null;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        start = SingleLinkedList.createLinkedList(start);
        SingleLinkedList.printLinkedList(start);
        start = reverseByEachKthPosition(start,3);
        SingleLinkedList.printLinkedList(start);
    }

    static ListNode reverseByEachKthPosition(ListNode head, int k){
        int[] arr = new int[k];
        ListNode temp1 = head;
        while(temp1 != null){
            ListNode temp2 = temp1;
            int i = 0;
            for(i=0;i<k && temp2 != null;i++) {
                arr[i] = temp2.getData();
                temp2=temp2.getNext();
            }
            for(int j=0;j<k && temp1 != null;j++) {
                temp1.setdata(arr[i-j-1]);
                temp1=temp1.getNext();
            }
        }
        return head;
    }
}
