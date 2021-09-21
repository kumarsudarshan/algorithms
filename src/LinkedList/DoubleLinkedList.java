package LinkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addAtHead(new DLLNode(55));
        dll.addAtHead(new DLLNode(44));
        dll.addAtHead(new DLLNode(33));
        dll.addAtHead(new DLLNode(22));
        dll.addAtEnd(new DLLNode(66));
        dll.addAtHead(new DLLNode(11));
        dll.print();
    }
    private DLLNode head;
    private DLLNode last;

    DoubleLinkedList() {
        head = new DLLNode(0);
        last = new DLLNode(0);
        head.next = last;
        last.prev = head;
    }

    public void addAtHead(DLLNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void addAtEnd(DLLNode node) {
        node.next = last;
        last.prev.next = node;
        node.prev = last.prev;
        last.prev = node;
    }

    public void deleteNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void print() {
        DLLNode temp = head.next;
        while (temp != last) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}

class DLLNode {
    int value;
    DLLNode next;
    DLLNode prev;

    DLLNode(int value) {
        this.value = value;
    }
}
