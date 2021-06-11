package heap.topkelements;

import java.util.PriorityQueue;

/*
Kth Smallest Number (easy)
Given an unsorted array of numbers, find Kth smallest number in it.
Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.
Input: [1, 5, 12, 2, 11, 5], K = 3
Output: 5
Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
Input: [1, 5, 12, 2, 11, 5], K = 4
Output: 5
Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].
Input: [5, 12, 11, -1, 12], K = 3
Output: 11
Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
 */
public class KthSmallestNumber {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{1, 5, 12, 2, 11, 5}, 3));
        System.out.println(kthSmallest(new int[]{1, 5, 12, 2, 11, 5}, 4));
        System.out.println(kthSmallest(new int[]{5, 12, 11, -1, 12}, 3));
    }

    public static int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }
        return maxHeap.poll();
    }

}
