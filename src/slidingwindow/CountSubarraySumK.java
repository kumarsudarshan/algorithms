package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Number of subarrays having sum exactly equal to k
https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

Examples:

Input : arr[] = {10, 2, -2, -20, 10},
        k = -10
Output : 3
Subarrays: arr[0...3], arr[1...4], arr[3..4]
have sum exactly equal to -10.

Input : arr[] = {9, 4, 20, 3, 10, 5},
            k = 33
Output : 2
Subarrays : arr[0...2], arr[2...4] have sum
exactly equal to 33.
 */
public class CountSubarraySumK {
    public static void main(String[] args) {
        System.out.println(countNumberOfSubarrays(Arrays.asList(10, 2, -2, -20, 10), -10));
    }

    public static long countNumberOfSubarrays(List<Integer> nums, int target) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        for (Integer element : nums) {
            currentSum += element;
            if (currentSum == target) {
                count++;
            }
            // if currentSum - target i.e. remaining sum already present in the map, then add it to the count
            if (map.containsKey(currentSum - target)) {
                count += map.get(currentSum - target);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
