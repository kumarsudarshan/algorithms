package DP.pattern.optimumpath;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Input: grid = [
    [1,3,1],
    [1,5,1],
    [4,2,1]
]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */
public class MinimumSumPath {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) { // 1st row, only left item
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && i > 0) { // 1st column, only 1 up item
                    dp[i][j] = dp[i - 1][j];
                } else if (i > 0 && j > 0) { // min of 1 left and 1 up
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
                dp[i][j] += grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
