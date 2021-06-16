package DP.lcs;

/*
Longest Common Substring:
		X = “abcde”
		Y = “abfce”
		O/P = 2 (ab)
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(lcsTopDown("abcde", "abfce"));
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

        int result = Integer.MIN_VALUE;
        // choice diagram
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }

}
