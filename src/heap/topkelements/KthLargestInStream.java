package heap.topkelements;

import java.util.PriorityQueue;

/*
Kth Largest Number in a Stream (medium)
Design a class to efficiently find the Kth largest element in a stream of numbers.
The class should have the following two things:
1.	The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
2.	The class should expose a function add(int num) which will store the given number and return the Kth largest number.
Input: [3, 1, 5, 12, 2, 11], K = 4
1. Calling add(6) should return '5'.
2. Calling add(13) should return '6'.
2. Calling add(4) should still return '6'.
 */
public class KthLargestInStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    int k;

    public KthLargestInStream(int[] nums, int k) {
        this.k = k;
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }

    public int add(int num) {
        minHeap.offer(num);
        if (minHeap.size() > this.k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestInStream ob = new KthLargestInStream(new int[]{3, 1, 5, 12, 2, 11}, 4);
        System.out.println(ob.add(6));
        System.out.println(ob.add(13));
        System.out.println(ob.add(4));
    }
}
