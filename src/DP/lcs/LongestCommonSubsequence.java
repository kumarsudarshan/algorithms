package DP.lcs;

import java.util.Arrays;

/*
Longest Common Subsequence:
		Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println(lcsRecursion(str1, str2));
        System.out.println(lcsTopDown(str1, str2));
        str1 = "AGGTAB";
        str2 = "GXTXAYB";
        System.out.println(lcsRecursion(str1, str2));
        System.out.println(lcsTopDown(str1, str2));
    }

    static int[][] dp;

    // Recursive call + cache (memoization)
    public static int lcsRecursion(String x, String y) {
        int m = x.length();
        int n = y.length();
        dp = new int[m + 1][n + 1];
        for (int[] eachRows : dp) {
            Arrays.fill(eachRows, -1);
        }
        return lcsRecursionHelper(x, y, m, n);
    }

    public static int lcsRecursionHelper(String x, String y, int m, int n) {
        // base condition
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        // choice diagram
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            dp[m][n] = 1 + lcsRecursionHelper(x, y, m - 1, n - 1);
        } else {
            dp[m][n] = Math.max(lcsRecursionHelper(x, y, m - 1, n), lcsRecursionHelper(x, y, m, n - 1));
        }
        return dp[m][n];
    }

    // Top down approach
    public static int lcsTopDown(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base condition
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }

        // choice diagram
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
