package DP.lis;

/*
Maximum Sum Increasing Subsequence
Given an array of n positive integers.
Write a program to find the sum of maximum sum subsequence
of the given array such that the integers in the subsequence are sorted in increasing order.
For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
and if the input array is {10, 5, 4, 3}, then output should be 10
 */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(maxSumIS(new int[]{1, 101, 2, 3, 100, 4, 5}));
        System.out.println(maxSumIS(new int[]{3, 4, 5, 10}));
        System.out.println(maxSumIS(new int[]{10, 5, 4, 3}));
    }

    public static int maxSumIS(int[] arr) {
        int n = arr.length;
        int max = 0;
        int maxIS[] = new int[n];

        // Initialize maxIS values for all indexes
        for (int i = 0; i < n; i++) {
            maxIS[i] = arr[i];
        }

        // Compute maximum sum values in bottom up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && maxIS[i] < maxIS[j] + arr[i]) {
                    maxIS[i] = maxIS[j] + arr[i];
                }
            }
        }

        // Pick maximum of all maxIS values
        for (int i = 0; i < n; i++) {
            if (max < maxIS[i]) {
                max = maxIS[i];
            }
        }

        return max;
    }

}
