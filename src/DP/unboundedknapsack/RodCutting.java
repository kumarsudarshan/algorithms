package DP.unboundedknapsack;

/*
Unbound Knapsack (Repetition of items allowed)
Unbound Knapsack allow multiple occurrences of item.
	Code variation from 0/1 Knapsack problems
		if(wt[i-1]<=j)
        	dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
    	else
        	dp[i][j] = dp[i - 1][j];
    here (i-1) not taken as we can choose that item multiple times.

   Problem: Rod Cutting Problem
Given a rod of length n, and an array that contains the prices of all the pieces smaller than n,
determine the maximum profit you could obtain from cutting up the rod and selling its pieces.
Suppose that we have a rod of length 5, and an array containing the length(1,2,3 and 4 ) and price(2,5,7 and 8 ) of the pieces.
There are various ways to cut the rod into sub-rods, each way results in a certain profit.
The answer should be 12 (selling the sub-rods of length 1+2+2 gives a 2+5+5 profit).
 */
public class RodCutting {

    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4};
        int[] price = {2, 5, 7, 8};
        System.out.println(rodCuttingProblem(price, length, 5));
    }

    public static int rodCuttingProblem(int price[], int length[], int n) {
        int[][] dp = new int[length.length + 1][n + 1];

        for (int i = 0; i < length.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < length.length + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[length.length][n];
    }
}
