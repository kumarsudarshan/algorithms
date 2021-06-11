package heap.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Maximum Distinct Elements (medium)
Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.
Input: [7, 3, 5, 8, 5, 3, 3], and K=2
Output: 3
Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have
to skip 5 because it is not distinct and occurred twice.
Another solution could be to remove one instance of '5' and '3' each to be left with three
distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.
Input: [3, 5, 12, 11, 12], and K=3
Output: 2
Explanation: We can remove one occurrence of 12, after which all numbers will become distinct. Then
we can delete any two numbers which will leave us 2 distinct numbers in the result.
Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
Output: 3
Explanation: We can remove one occurrence of '4' to get three distinct numbers.
 */
public class MaximumDistinctNumbers {
    public static void main(String[] args) {
        System.out.println(findMinDistinctNumbers(new int[]{7, 3, 5, 8, 5, 3, 3}, 2));
        System.out.println(findMinDistinctNumbers(new int[]{3, 5, 12, 11, 12}, 3));
        System.out.println(findMinDistinctNumbers(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2));
    }

    public static int findMinDistinctNumbers(int[] nums, int k) {
        int distinctNumbers = 0;
        if (nums.length <= k) {
            return distinctNumbers;
        }

        // find the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        // insert all number with frequency > 1 into min heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                distinctNumbers++;
            } else {
                minHeap.add(entry);
            }
        }

        // following greedy approach, try removing the least frequent numbers first from min-heap.
        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            // to make an element distinct, we need to remove all occurrences except one.
            k -= entry.getValue() - 1;
            if (k >= 0) {
                distinctNumbers++;
            }
        }
        // if k > 0, this means we still need to remove something and the remaining is only distinct numbers
        if (k > 0) {
            distinctNumbers -= k;
        }

        return distinctNumbers;
    }
}
