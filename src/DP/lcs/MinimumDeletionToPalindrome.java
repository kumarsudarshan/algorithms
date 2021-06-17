package DP.lcs;
/*
Minimum number of deletions in a string to make it palindrome.
S = “agbcba”
O/P = 1 (remove ‘g’) - "abcba"
 */
public class MinimumDeletionToPalindrome {
    public static void main(String[] args) {
        System.out.println(minDeletionToPalindrome("agbcba"));
    }

    /*
    S = “agbcba”
		O/P = 1 (remove ‘g’)
		return S.length - LPS(S)
	also,
		return S.length – LCS(S, reverse(S))
     */
    public static int minDeletionToPalindrome(String X){
        StringBuilder Y = new StringBuilder(X);
        Y.reverse();
        return X.length() - lcs(X, Y.toString());
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
