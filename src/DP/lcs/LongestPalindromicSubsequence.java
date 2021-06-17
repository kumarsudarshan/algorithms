package DP.lcs;

/*
Longest Palindromic Subsequence:
Given a sequence, find the length of the longest palindromic subsequence in it.
If the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subsequence in it.
“BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(lps("BBABCBCAB"));
    }

    /*
    S: “agbcba”
	P: “abcbga” -- reverse(S)
	LCS(S, P) = “abcba” – size 5
	LPS(S,n) = return LCS(S, reverse(S), n, n)
     */
    public static int lps(String X) {
        StringBuilder Y = new StringBuilder(X);
        Y.reverse();
        return lcs(X, Y.toString());
    }

    // Top down approach
    public static int lcs(String str1, String str2) {
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
