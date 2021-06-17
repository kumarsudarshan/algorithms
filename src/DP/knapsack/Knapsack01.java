package DP.knapsack;

import java.util.Arrays;

/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack
Given :
Weight[] : {1,3,4,5}
Value[] : {1,4,5,7}
W = 7 (Max weight sack can hold)
output: 9 (weight - (3,4), value - (4,5) - 9)
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        // using recursion
        System.out.println(knapsackRecursive(wt, val, 7, wt.length));

        // recursion + memoization
        System.out.println(knapsackRecursiveMemoization(wt, val, 7, wt.length));

        // topdown
        System.out.println(knapsack(wt, val, 7, wt.length));
    }

    public static int knapsackRecursive(int wt[], int val[], int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(
                    val[n - 1] + knapsackRecursive(wt, val, W - wt[n - 1], n - 1),
                    knapsackRecursive(wt, val, W, n - 1)
            );
        } else {
            return knapsackRecursive(wt, val, W, n - 1);
        }
    }

    static int[][] dp = new int[102][1002]; // max limit

    public static int knapsackRecursiveMemoization(int wt[], int val[], int W, int n) {
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return knapsackRecursiveMemoizationHelper(wt, val, W, n);
    }

    public static int knapsackRecursiveMemoizationHelper(int wt[], int val[], int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(val[n - 1] + knapsackRecursive(wt, val, W - wt[n - 1], n - 1), knapsackRecursive(wt, val, W, n - 1));
        } else {
            dp[n][W] = knapsackRecursive(wt, val, W, n - 1);
        }
        return dp[n][W];
    }

    // top down
    public static int knapsack(int wt[], int val[], int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, 0);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

}
