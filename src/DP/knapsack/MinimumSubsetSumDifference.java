package DP.knapsack;

/*
Partition a set into two subsets such that the difference of subset sums is minimum

Example:
Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        System.out.println(minimumSubsetSumDiff(new int[]{1, 6, 11, 5}));
    }

    /*
    S2 – S1 should be minimum ----- (1)
	S1 + S2 = k (total sum)
	S2 = k – S1 ----- (2)
	Put (2) into (1)
		k – S1 – S1 should be minimum
		k – 2S1 should be minimum
		Notes: S1 will not be more than half of Sum i.e. k,
			As k – 2(k/2) = 0 (Minimum)

     */
    public static int minimumSubsetSumDiff(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int min = Integer.MIN_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) { // only last row will have result with all sums
                min = sum - 2 * j; // k - 2s1
                break; // no need to go left as minimum diff will be near to mid sum
            }
        }
        return min;
    }

}
