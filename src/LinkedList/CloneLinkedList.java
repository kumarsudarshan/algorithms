package LinkedList;

/*
Copy List with Random Pointer
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list.
The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

 */

public class CloneLinkedList {
    public static void main(String[] args) {
        ListNodeRandom head = new ListNodeRandom(11);
        head.next = new ListNodeRandom(22);
        head.next.next = new ListNodeRandom(33);
        head.next.next.next = new ListNodeRandom(44);
        head.next.next.next.next = new ListNodeRandom(55);

        head.random = head.next.next;

        print(head);

        ListNodeRandom cloned = clone(head);

        System.out.println();
        print(cloned);
    }

    // This algo has 3 main steps
    // 1. create each node copy value and append next to each other
    // e.g. 11->22->33->44 will become 11->11->22->22->33->33->44->44
    // 2. Now construct random pointer
    // e.g. say node 11 random points to 33, copied 11 ramdom points to 33's next which is also 33 a new copy of original 33
    // 3. extract 2 different copies and return head of new copy
    public static ListNodeRandom clone(ListNodeRandom head) {
        // Base Condition
        if (head == null) {
            return null;
        }
        ListNodeRandom current = head;

        while (current != null) {
            ListNodeRandom temp = current.next;
            current.next = new ListNodeRandom(current.val);
            current.next.next = temp;
            current = temp;
        }

        current = head;
        while (current != null) {
            current.next.random = current.random != null ? current.random.next : current.random;
            current = current.next.next;
        }

        ListNodeRandom original = head;
        ListNodeRandom copy = head.next;
        ListNodeRandom newHead = copy;
        while (original != null && copy != null) {
            original.next = original.next.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }

        return newHead;
    }

    public static void print(ListNodeRandom head) {
        while (head != null) {
            System.out.println(head.random + " : " + head.hashCode());
            head = head.next;
        }
    }
}

class ListNodeRandom {
    int val;
    ListNodeRandom next;
    ListNodeRandom random;

    ListNodeRandom(int val) {
        this.val = val;
    }
}
