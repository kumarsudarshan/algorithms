package math;

/*
https://leetcode.com/problems/next-permutation/solution/
Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.

Input: nums = [1,2,3], Output: [1,3,2]

Input: nums = [3,2,1], Output: [1,2,3]

Input: nums = [1,1,5], Output: [1,5,1]

Input: nums = [1], Output: [1]
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        } // 1, 3, 2
    }

    // Time : O(n), Space : O(1)
    public static void nextPermutation(int[] nums) {
        // find 2 successive number from right which satisfy nums[i] >= nums[i + 1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // finding number smallest larger than number at ith index and then swap it
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // since it is decreasing from step 1, so we need to reverse it
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
