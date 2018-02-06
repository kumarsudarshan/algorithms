/*
    Created by : Kumar Sudarshan
    Date : 7th Feb 2018
    Nth Node from end of a linked list
 */

package LinkedList;

import java.util.Scanner;

public class NthNodeFromEnd {

    static ListNode start = null;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        start = SingleLinkedList.createLinkedList(start);
        SingleLinkedList.printLinkedList(start);
        System.out.println("\n\t Nth Node from End : " + nthNodeFromEnd(start,4));
    }

    static int nthNodeFromEnd(ListNode head,int n){
        ListNode temp1 = head,temp2 = head;
        int count = 0;
        for(int i=0;i<n;i++){
            if(temp2 != null){
                temp2 = temp2.getNext();
                count++;
            }
        }
        while(temp2 != null){
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
            count++;
        }
            return temp1.getData();
    }
}
