package heap.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Top 'K' Numbers (easy)
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
Input: [3, 1, 5, 12, 2, 11], K = 3
Output: [5, 12, 11]
Input: [5, 12, 11, -1, 12], K = 3
Output: [12, 11, 12]
 */
public class KLargestNumbers {
    public static void main(String[] args) {
        System.out.println(kLargestNumbers1(new int[]{3, 1, 5, 12, 2, 11}, 3));
        System.out.println(kLargestNumbers1(new int[]{5, 12, 11, -1, 12}, 3));

        System.out.println(kLargestNumbers2(new int[]{3, 1, 5, 12, 2, 11}, 3));
        System.out.println(kLargestNumbers2(new int[]{5, 12, 11, -1, 12}, 3));
    }

    // using max heap
    public static List<Integer> kLargestNumbers1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    // using min heap
    public static List<Integer> kLargestNumbers2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }
}
