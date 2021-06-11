package heap.twoheap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Sliding Window Median (hard)
Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.
Example 1:
Input: nums=[1, 2, -1, 3, 5], k = 2
Output: [1.5, 0.5, 1.0, 4.0]
Explanation: Let’s consider all windows of size ‘2’:
•	[1, 2, -1, 3, 5] -> median is 1.5
•	[1, 2, -1, 3, 5] -> median is 0.5
•	[1, 2, -1, 3, 5] -> median is 1.0
•	[1, 2, -1, 3, 5] -> median is 4.0
Example 2:
Input: nums=[1, 2, -1, 3, 5], k = 3
Output: [1.0, 2.0, 3.0]
Explanation: Let’s consider all windows of size ‘3’:
•	[1, 2, -1, 3, 5] -> median is 1.0
•	[1, 2, -1, 3, 5] -> median is 2.0
•	[1, 2, -1, 3, 5] -> median is 3.0
 */

public class SlidingWindowMedian {

    public static void main(String[] args) {
        Arrays.stream(median(new int[]{1, 2, -1, 3, 5}, 2)).forEach(i -> System.out.print(i + "\t"));
    }

    public static double[] median(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // maxHeap containing 1st half of k sized array
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b); // minHeap containing 2nd half of k sized array
        double[] ans = new double[arr.length - k + 1];
        int i = 0, j = 0;
        while (j < arr.length) {
            // maintain the heap
            if (maxHeap.isEmpty() || maxHeap.peek() >= arr[j]) {
                maxHeap.add(arr[j]);
            } else {
                minHeap.add(arr[j]);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) { // window size
                // calculate median
                if (maxHeap.size() == minHeap.size()) {
                    ans[i] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    ans[i] = maxHeap.peek();
                }

                // remove item from left before sliding the window
                if (maxHeap.contains(arr[i])) {
                    maxHeap.remove(arr[i]);
                } else {
                    minHeap.remove(arr[i]);
                }
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }

                // slide the window
                i++;
                j++;
            }
        }
        return ans;
    }

}
