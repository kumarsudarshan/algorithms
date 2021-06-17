package DP.knapsack;

/*
Count of subsets with sum equal to X
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Examples:
Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3. All the possible subsets are {1, 2, 3}, {1, 2, 3} and {3, 3}
 */
public class CountSubsetSum {
    public static void main(String[] args) {
        System.out.println(countSubsetSum(new int[]{1, 2, 3, 3}, 6));
    }

    public static int countSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}