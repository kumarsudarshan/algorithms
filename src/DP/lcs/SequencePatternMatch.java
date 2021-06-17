package DP.lcs;
/*
Sequence pattern matching:
		x = “AXY”
		y = “ADXCPY”
	to check if x is sequence in y.
 */
public class SequencePatternMatch {
    public static void main(String[] args) {
        System.out.println(spm("AXY", "ADXCPY"));
        System.out.println(spm("AKXY", "ADXCPY"));
    }

    /*
    Let find LCS first,
	LCS(x, y) = 3 (AXY), here if LCS length matches with x.length() then will return true, else false.
     */
    public static boolean spm(String x, String y) {
        int l = lcs(x, y);
        if(x.length() == l) {
            return true;
        } else {
            return false;
        }
    }

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
