package heap.topkelements;

import java.util.*;

/*
Top 'K' Frequent Numbers (medium)
Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
Input: [1, 3, 5, 12, 11, 12, 11], K = 2
Output: [12, 11]
Explanation: Both '11' and '12' appeared twice.
Input: [5, 12, 11, 3, 11], K = 2
Output: [11, 5] or [11, 12] or [11, 3]
Explanation: Only '11' appeared twice, all other numbers appeared once.
 */
public class TopKFrequentNumbers {
    public static void main(String[] args) {
        System.out.println(kFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 2));
        System.out.println(kFrequentNumbers(new int[]{5, 12, 11, 3, 11}, 2));
    }

    public static List<Integer> kFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        // find frequency of each number
        for (int num : nums) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }
        // create min heap which takes map entry object and sort according to map value (not key) i.e. frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        // go all numbers in map and push it to minHeap, if heap size > k, we need to remove the top element.
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }

}
