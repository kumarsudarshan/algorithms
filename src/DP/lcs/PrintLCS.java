package DP.lcs;

/*
Print LCS between two strings
Input:
	string X = "AGTGATG"
	string Y = "GTTAG"
Output:
	GTAG
	GTTG
 */
public class PrintLCS {
    public static void main(String[] args) {
        System.out.println(printLCS("AGTGATG", "GTTAG"));
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
