package design;

import java.util.Stack;

/*
Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
•	MinStack() initializes the stack object.
•	void push(val) pushes the element val onto the stack.
•	void pop() removes the element on the top of the stack.
•	int top() gets the top element of the stack.
•	int getMin() retrieves the minimum element in the stack
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

        MinStackUsingLinkedList minStackUsingLinkedList = new MinStackUsingLinkedList();
        minStackUsingLinkedList.push(-2);
        minStackUsingLinkedList.push(0);
        minStackUsingLinkedList.push(-3);
        System.out.println(minStackUsingLinkedList.getMin()); // return -3
        minStackUsingLinkedList.pop();
        System.out.println(minStackUsingLinkedList.top());    // return 0
        System.out.println(minStackUsingLinkedList.getMin()); // return -2

    }

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || (x <= minStack.peek())) {
            minStack.push(x);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if (!minStack.isEmpty() && popped == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return 0;
        return minStack.peek();
    }
}

class MinStackUsingLinkedList {

    private class Node {
        int val;
        int min;
        Node next;

        private Node() {
            this.val = 0;
            this.min = Integer.MAX_VALUE;
            this.next = null;
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

    Node head;

    public MinStackUsingLinkedList() {
        head = new Node();
    }

    public void push(int val) {
        head = new Node(val, Math.min(head.min, val), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}