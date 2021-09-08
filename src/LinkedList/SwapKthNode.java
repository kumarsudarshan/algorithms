package LinkedList;

public class SwapKthNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(22);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(44);
        head.next.next.next.next = new ListNode(55);

        print(head);
        swapNodes(head, 2);
        System.out.println();
        print(head);

    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode current = head, first = head, second = head;
        int count = 1;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        first = current;
        while (current.next != null) {
            second = second.next;
            current = current.next;

        }
        // swap first.data and second.data
        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }


}
