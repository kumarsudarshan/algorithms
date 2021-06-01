package fastslowpointer;

public class PalindromeLinkedList {

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
        System.out.println("Is Palindrome: " + isPalindrome(head));
        System.out.println();
        temp = head;
        while(temp != null){
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        // first find the middle of the linked list.
        // Then reverse 2nd half of the linked list
        // then compare one by one from middle and start.
        ListNode slow = head;
        ListNode fast = head;

        if(head == null || head.next == null){
            return true;
        }
        // here slow will at middle of the linked list.
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;

        }
        // reverse 2nd half of the linked list
        slow = reverseLink(slow);
        ListNode copy2ndHalfHead = slow; // making copy of this node to reconstruct the linked list
        fast = head;
        while(slow != null){
            if(fast.val != slow.val){ // if not matching, then there is no palindrome
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        // reconstrct to original form
        reverseLink(copy2ndHalfHead);

        return true;
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
