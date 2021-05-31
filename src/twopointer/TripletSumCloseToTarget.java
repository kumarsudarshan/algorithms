package twopointer;

import java.util.Arrays;

/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.
Example: Input: nums = [-1,2,1,-4], target = 1, Output: 2, Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(tripletSumCloseToTarget(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(tripletSumCloseToTarget(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(tripletSumCloseToTarget(new int[]{1, 0, 1, 1}, 100));
        System.out.println(tripletSumCloseToTarget(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int tripletSumCloseToTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && diff != 0; i++) { // if diff == 0 means already we have the answer. no need to proceed
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(diff)) {  // not use (diff = target - currentSum) here, chance of overflow, as initially diff = Integer.MAX_VALUE
                    diff = target - currentSum;
                }
                if (currentSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        // diff here is number near by target, but answer is sum of triplets, so target - diff.
        // example {1, 0, 1, 1}, target = 100. here diff is 97(1+1+1) near to 100, but answer is 100 - 97 = 3.
        return target - diff;
    }

}
