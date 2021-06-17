package DP.lcs;

/*
Longest Repeating Subsequence:
Given a string, find length of the longest repeating subsequence such that the
two subsequence don’t have same string character at same position,
i.e., any i’th character in the two subsequences shouldn't’t have the same index in the original string.
Input: str = "abc"
Output: 0
There is no repeating subsequence

Input: str = "aab"
Output: 1
The two subsequence are 'a'(first) and 'a'(second).
Note that 'b' cannot be considered as part of subsequence
as it would be at same index in both.

Input: str = "aabb"
Output: 2
 */
public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        System.out.println(lrs("abc"));
        System.out.println(lrs("aab"));
        System.out.println(lrs("aabbk"));
    }

    /*
    X = “AABEBCDD”
	X = “AABEBCDD”
	LCS(X, X) = “AABEBCDD”
		Here, we will not consider only one occurrences of character.
    0	1	2	 3	 4	 5	 6	 7
    A	A	B	'E'	 B	'C'	 D	 D
    A	A	B	'E'	 B	'C'	 D	 D
    In Both the string, E will match when (i == j), so we remove this item.
     */
    public static int lrs(String X) {
        int N = X.length();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (X.charAt(i - 1) == X.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[N][N];
    }
}
