/*
    Created by : Kumar Sudarshan
    Date : 6th Jan 2019
    Given an unsorted array of integers, find the length of longest increasing subsequence.
        Example:
            Input: [10,9,2,5,3,7,101,18]
            Output: 4
            Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

package DP.lis;

public class LIS {

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lis(nums));
    }

    public static int lis(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, 1 + dp[j]);
                }
            }
            dp[i] = max;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }


    /*
    Recursive Approach(Brute Force):
    LIS(i) = 1 + LIS(j), where 0<j<I and arr[j] < arr[i],
    Or
    LIS(i) = 1
     */
    static int max_ref;

    static int lisRecursion(int arr[], int n) {
        // base case
        if (n == 1)
            return 1;

        // 'max_ending_here' is length of LIS ending with
        // arr[n-1]
        int res, max_ending_here = 1;

        /* Recursively get all LIS ending with arr[0],
           arr[1] ... arr[n-2]. If   arr[i-1] is smaller
           than arr[n-1], and max ending with arr[n-1] needs
           to be updated, then update it */
        for (int i = 1; i < n; i++) {
            res = lisRecursion(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here) {
                max_ending_here = res + 1;
            }
        }

        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;

        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }
}
