package design;

import java.util.*;

/*
Design a data structure for LRU Cache. It should support the following operations: get and put.
get(key) – Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) – Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

class LRUCache {

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 10);
        lru.put(2, 20);
        System.out.println(lru.get(1)); // 10
        lru.put(3, 30);
        System.out.println(lru.get(2)); // -1
        lru.put(4, 40);
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 30
        System.out.println(lru.get(4)); // 40
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        last = new Node(0, 0);
        head.next = last;
        last.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addAtHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addAtHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (map.size() > capacity) {
                map.remove(last.prev.key);
                deleteNode(last.prev);
            }
            addAtHead(node);
        }
    }

    private void addAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}