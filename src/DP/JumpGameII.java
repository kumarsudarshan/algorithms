package DP;

/*
Jump Game II
https://leetcode.com/problems/jump-game-ii/
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
 */

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        int n = nums.length, maxReachable = 0, lastJumpedPos = 0, jumps = 0;
        for (int i = 0; i < n - 1; i++) { // loop till last jump hasn't taken us till the end
            maxReachable = Math.max(maxReachable, i + nums[i]); // furthest index reachable on the next level from current level
            if (i == lastJumpedPos) { // current level has been iterated & maxReachable position on next level has been finalised
                lastJumpedPos = maxReachable; // so just move to that maxReachable position
                jumps++;  // and increment the level
            }
            // Key: jump  only gets updated after we iterate all possible jumps from previous level  This ensures jumps will only store minimum jump required to reach lastJumpedPos
        }
        return jumps;
    }
}
