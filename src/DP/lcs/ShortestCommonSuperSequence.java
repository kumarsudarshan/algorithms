package DP.lcs;

import java.util.Arrays;
import java.util.List;

/*
Shortest Common Super sequence:
	Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
Examples :
Input:   X = "geek",  Y = "eke"
Output: "geeke"

Input:   X = "AGGTAB",  Y = "GXTXAYB"
Output:  "AGXGTXAYB"
 */
public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSuperSequence("geek", "eke"));
        System.out.println(shortestCommonSuperSequence("AGGTAB", "GXTXAYB"));
    }

    /*
    Approach we take here is to merge the two string and remove LCS of the given two string because LCS came here two times.
    i.e. the LCS part exists in both the strings, so we need to remove the LCS 1 time.

	Merge : X + Y = “AGGTABGXTXAYB”

	LCS(X,Y) = “GTAB”

	Required result is  : X + Y – LCS(X,Y)

	To return the length of shortest common super sequence:
		n + m – LCS(X, Y)
     */
    public static int shortestCommonSuperSequence(String str1, String str2) {
        String lcs = printLCS(str1, str2);
        return str1.length() + str2.length() - lcs.length();
    }

    public static String printLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //Here for any index we came there diagonally if both character were equal if not then we were taken max of 1 left and 1 up neighbour.
        int i = m;
        int j = n;
        String ans = "";
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans = str1.charAt(i - 1) + ans;
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return ans;
    }
}
