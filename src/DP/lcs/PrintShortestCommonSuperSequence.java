package DP.lcs;

/*
Print shortest common super sequence
	X = “acbcf”
	Y = “abcdaf”
	O/P = “acbcdaf”
 */
public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        System.out.println(scs("acbcf", "abcdaf"));
    }

    static String scs(String x, String y) {
        int n = x.length();
        int m = y.length();
        // base condition
        if (x == null) {
            return y;
        }
        if (y == null) {
            return x;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = n;
        int j = m;
        String result = "";
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                result = x.charAt(i - 1) + result;
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    result = y.charAt(j - 1) + result;
                    j--;
                } else {
                    result = x.charAt(i - 1) + result;
                    i--;
                }
            }
        }
        if (i > 0) { // this logic added because if other string becomes empty then will include the remaining of the first string
            result = x.substring(0, i) + result;
        }
        if (j > 0) { // same applies here also.
            result = y.substring(0, j) + result;
        }
        return result;
    }

}
