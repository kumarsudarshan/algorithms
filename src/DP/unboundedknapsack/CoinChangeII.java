package DP.unboundedknapsack;

/*
Coin change problem (Type 2) – Minimum number of coins.
Example:
	Coin[]: {1,2,3}
	Sum: 5
Total no of ways:
	2+3 = 5
	1+2+2 = 5
	1+1+1+2 = 5
	1+1+3 = 5
	1+1+1+1+1 = 5
Total 5 number of ways, but (2+3) uses minimum number of coins i.e. 2 coins
 */
public class CoinChangeII {
    public static void main(String[] args) {
        // Time Complexity : O(n*sum) , Space Complexity : O(n*sum)
        System.out.println(minimumCoins1(new int[]{1, 2, 3}, 3, 5)); // 2
        System.out.println(minimumCoins1(new int[]{1, 2, 5}, 3, 11)); // 3

        // Space optimized
        // Time Complexity : O(n*sum) , Space Complexity : O(sum)
        System.out.println(minimumCoins2(new int[]{1, 2, 3}, 3, 5)); // 2
        System.out.println(minimumCoins2(new int[]{1, 2, 5}, 3, 11)); // 3
    }

    /*
    Initialization is important here,
	dp[n+1][sum+1] = dp[4][6]
    1.	If coin[] is empty and sum is 0 or 1 or 2 or 3 …. Then it should be ∞
    2.	This is a unique question as we are initializing two rows here because we check 1st occurrences
        of coins in array  or divisibility of coins available in array.
        4 and 5 coins not present in problems that is why, dp[1][4] and dp[1][5] is ∞.
     */

    // Time Complexity : O(n*sum) , Space Complexity : O(n*sum)
    static int minimumCoins1(int coin[], int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) { // initializing 1st column
            dp[i][0] = 0;
        }
        for (int i = 0; i < sum + 1; i++) { // initializing 1st row
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < sum + 1; i++) { // initializing 2nd row
            if (i % coin[0] == 0) {
                dp[1][i] = i / coin[0];
            } else {
                dp[1][i] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] <= j) {
                    // 1 + dp[i][j - coin[i - 1]] here 1 is added to include that coin.
                    // also for 1 is added , we took Integer.MAX_VALUE - 1, to prevent from overflow.
                    dp[i][j] = Math.min(
                            1 + dp[i][j - coin[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    // Time Complexity : O(n*sum) , Space Complexity : O(sum)
    public static int minimumCoins2(int coin[], int n, int sum) {
        int[] dp = new int[sum + 1];
        for (int i = 0; i < sum + 1; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] <= j) {
                    dp[j] = Math.min(1 + dp[j - coin[i - 1]], dp[j]);
                }
            }
        }

        return dp[sum] == Integer.MAX_VALUE - 1 ? -1 : dp[sum];
    }
}
