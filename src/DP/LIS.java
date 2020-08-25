/*
    Created by : Kumar Sudarshan
    Date : 6th Jan 2019
    Given an unsorted array of integers, find the length of longest increasing subsequence.
        Example:
            Input: [10,9,2,5,3,7,101,18]
            Output: 4
            Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

package DP;

public class LIS {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }


    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0 )
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 1;
        int length = 0;
        for(int i=n-1;i>=0;i--) {
            int max = 1;
            for(int j=i+1;j<n;j++) {
                if(nums[j] > nums[i]) {
                    max = max>1+dp[j]?max:1+dp[j];
                }
            }
            dp[i] = max;
            length = length>dp[i]?length:dp[i];
        }
        return length;
    }
}
