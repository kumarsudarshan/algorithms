package heap.topkelements;

import java.util.PriorityQueue;

/*
Sum of Elements (medium)
Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.
Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23
Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
between 5 and 15 is 23 (11+12).
Input: [3, 5, 8, 7], and K1=1, K2=4
Output: 12
Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest
number (8) is 12 (5+7).
 */
public class SumOfElements {
    public static void main(String[] args) {
        System.out.println(findSumOfElements(new int[]{1, 3, 12, 5, 15, 11}, 3, 6));
        System.out.println(findSumOfElements(new int[]{3, 5, 8, 7}, 1, 4));
        // alternate solution
        System.out.println(findSumOfElementsAlternate(new int[]{1, 3, 12, 5, 15, 11}, 3, 6));
        System.out.println(findSumOfElementsAlternate(new int[]{3, 5, 8, 7}, 1, 4));
    }

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        // insert all numbers to min heap
        for (int num : nums) {
            minHeap.offer(num);
        }
        // remove k1 small numbers from min heap
        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }
        int elementSum = 0;
        // sum k2 - k1 - 1 numbers
        for (int i = 0; i < k2 - k1 - 1; i++) {
            elementSum += minHeap.poll();
        }
        return elementSum;
    }

    public static int findSumOfElementsAlternate(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        // keep smallest k2 numbers in the max heap
        for (int i = 0; i < nums.length; i++) {
            if (i < k2 - 1) {
                maxHeap.add(nums[i]);
            } else if (nums[i] < maxHeap.peek()) {
                maxHeap.poll(); // as we are interested only in the smallest k2 numbers
                maxHeap.add(nums[i]);
            }
        }

        // get the sum of numbers between k1 and k2 indices
        // these numbers will be at the top of the max heap
        int elementSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++)
            elementSum += maxHeap.poll();

        return elementSum;
    }

}
