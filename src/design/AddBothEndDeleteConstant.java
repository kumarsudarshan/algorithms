package design;

import java.util.*;

/*
Design the data structure such we can perform following operation
insertFirst(value):- value inserted head of the list Time Complexity O(1)
insertLast(value):- value inserted last of the list Time Complexity O(1)
deleteValue(val):- delete the value from the list if the list contains multiple values
then it should delete only the first occurrence expected time complexity O(1).
printList():- print the list elements
 */
public class AddBothEndDeleteConstant {
    DoublyLinkedList doublyLinkedList;
    Map<Integer, List<DLLNode>> map;

    AddBothEndDeleteConstant() {
        doublyLinkedList = new DoublyLinkedList();
        map = new HashMap<>();
    }

    public void insertFirst(int value) {
        DLLNode newNode = new DLLNode(value);
        doublyLinkedList.addAtHead(newNode);
        List<DLLNode> nodeList = new ArrayList<>();
        if (map.containsKey(value)) {
            nodeList = map.get(value);
            nodeList.add(newNode);
            Collections.swap(nodeList, 0, nodeList.size() - 1);
            map.put(value, nodeList);
        } else {
            nodeList.add(newNode);
        }
        map.put(value, nodeList);
    }

    public void insertLast(int value) {
        DLLNode newNode = new DLLNode(value);
        doublyLinkedList.addAtEnd(newNode);
        List<DLLNode> nodeList = new ArrayList<>();
        if (map.containsKey(value)) {
            nodeList = map.get(value);
        }
        nodeList.add(newNode);
        map.put(value, nodeList);
    }

    public void deleteValue(int value) {
        List<DLLNode> tempNodeList = map.get(value);
        if (tempNodeList == null) {
            return;
        }
        if (tempNodeList.size() == 1) {
            map.remove(value);
            doublyLinkedList.deleteNode(tempNodeList.get(0));
        } else {
            Collections.swap(tempNodeList, 0, tempNodeList.size() - 1);
            doublyLinkedList.deleteNode(tempNodeList.get(tempNodeList.size() - 1));
            tempNodeList.remove(tempNodeList.size() - 1);
        }
    }

    public void printList() {
        doublyLinkedList.print();
    }

    public static void main(String[] args) {
        AddBothEndDeleteConstant ds = new AddBothEndDeleteConstant();
        ds.insertFirst(2);
        ds.insertFirst(3);
        ds.insertFirst(2);
        ds.insertFirst(4);
        ds.insertLast(7);
        ds.printList(); // 4, 2, 3, 2, 7
        ds.deleteValue(2);
        System.out.println();
        ds.printList(); // 4, 3, 2, 7
        ds.deleteValue(2);
        System.out.println();
        ds.printList(); // 4, 3, 7
    }

}

class DoublyLinkedList {
    private DLLNode head;
    private DLLNode last;

    DoublyLinkedList() {
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