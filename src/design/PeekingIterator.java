package design;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
Design an iterator that supports the peek operation on a list in addition to the hasNext and the next operations.
Implement the PeekingIterator class:
PeekingIterator(int[] nums) Initializes the object with the given integer array nums.
int next() Returns the next element in the array and moves the pointer to the next element.
bool hasNext() Returns true if there are still elements in the array.
int peek() Returns the next element in the array without moving the pointer.

Input
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 2, 2, 3, false]

Explanation
PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
peekingIterator.hasNext(); // return False
 */

class PeekingIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        Iterator itr = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator peekingIterator = new PeekingIterator(itr); // [1,2,3]
        System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext()); // return False
    }

    Iterator<Integer> it;
    Integer current;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        current = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (current == null) current = it.next();
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = current;
        current = it.hasNext() ? it.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }
}

// Other approach using min heap
class PeekingIterator1 implements Iterator<Integer> {

    public static void main(String[] args) {
        Iterator itr = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator1 peekingIterator = new PeekingIterator1(itr); // [1,2,3]
        System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext()); // return False
    }

    private PriorityQueue<Pair> minHeap;
    private int order = 0;

    public PeekingIterator1(Iterator<Integer> iterator) {
        minHeap = new PriorityQueue<Pair>((a, b) -> a.x - b.x);
        while (iterator.hasNext()) {
            minHeap.add(new Pair(order++, iterator.next()));
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return minHeap.peek().y;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return minHeap.poll().y;
    }

    @Override
    public boolean hasNext() {
        return minHeap.size() > 0;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}