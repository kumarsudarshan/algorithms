package DP;

/*
Jump Game
https://leetcode.com/problems/jump-game/

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    //We use greedy algorithm here, instead of trying to reach to end(which is global optimum)
    // we try to reach the target(which is local optimum).
    // If we can reach the target from current position then current position is the new target.
    // In the end , if target is 0 then we can go to end, otherwise not.
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i + nums[i] >= target)
                target = i;
        }
        return target == 0;
    }
}
