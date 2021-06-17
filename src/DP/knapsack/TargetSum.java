package DP.knapsack;

/*
Target Sum:  You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.
Example 1:
Input: nums is [1, 1, 2, 3], Sum is 1.
Output: 3
Explanation:
+1-1-2+3 = 1
-1+1-2+3 = 1
+1+1+2-3 = 1
There are 3 ways to assign symbols to make the sum of nums be target 1.
 */
public class TargetSum {
    public static void main(String[] args) {
        System.out.println(targetSum(new int[]{1, 1, 2, 3}, 1));
    }

    /*
    example
                +1 -1 -2 +3
              /               \
		(1+3)					(-1 -2)
	Plus sign separate		Minus sign separate
		(4)						-(3)
		S1 			-			S2
    Which finally becomes same question. Count the number of subset in a given difference. 
     */
    public static int targetSum(int[] arr, int sum) {
        return countSubsetDifference(arr, sum);
    }

    /*
    S1 - S2 = diff (given) -- (1)
    S1 + S2 = total_sum -- (2)
    add both equation
    2s1 = diff + total_sum
    s1 = (diff + total_sum)/2
     */
    public static int countSubsetDifference(int[] arr, int diff) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return countSubset(arr, (diff + sum) / 2);
    }

    public static int countSubset(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

}
