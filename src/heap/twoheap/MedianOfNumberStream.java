package heap.twoheap;

import java.util.PriorityQueue;

/*
Design a class to calculate the median of a number stream. The class should have the following two methods:
1.	insertNum(int num): stores the number in the class
2.	findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
Example 1:
1. insertNum(3)
2. insertNum(1)
3. findMedian() -> output: 2
4. insertNum(5)
5. findMedian() -> output: 3
6. insertNum(4)
7. findMedian() -> output: 3.5
 */

public class MedianOfNumberStream {

    PriorityQueue<Integer> maxHeap; // containing first half of stream
    PriorityQueue<Integer> minHeap; // containing 2nd half of stream

    public MedianOfNumberStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // either both heap will have equal number or maxHeap will have 1 more number.
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        // if even number of elements
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // maxHeap will have 1 element more than minHeap.
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfNumberStream median = new MedianOfNumberStream();
        median.insertNum(3);
        median.insertNum(1);
        System.out.println(median.findMedian()); // 2.0
        median.insertNum(5);
        System.out.println(median.findMedian()); // 3.0
        median.insertNum(4);
        System.out.println(median.findMedian()); // 3.5
    }

}
