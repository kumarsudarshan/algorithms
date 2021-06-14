package stack;

import java.util.PriorityQueue;

public class StackUsingHeap {
    public static void main(String[] args) {
        StackUsingHeap stack = new StackUsingHeap();
        stack.push(5);
        stack.push(17);
        stack.push(13);
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

    PriorityQueue<Pair> maxHeap = null;
    int order = 1;

    public StackUsingHeap() {
        maxHeap = new PriorityQueue<>((a, b) -> b.x - a.x);
    }

    public void push(int val) {
        maxHeap.add(new Pair(order++, val));
    }

    public int pop() {
        return maxHeap.poll().y;
    }

    public int top() {
        return maxHeap.peek().y;
    }
}
