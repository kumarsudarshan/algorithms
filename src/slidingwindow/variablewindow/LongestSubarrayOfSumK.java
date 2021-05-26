package slidingwindow.variablewindow;

/*
Problem Description:

Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.

For Input:
1
7 5
4 1 1 1 2 3 5
your output is:
4
 */

public class LongestSubarrayOfSumK {

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        longestSubArraySumK(arr, 5);
    }

    public static int longestSubArraySumK(int[] arr, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int maxLen = 0;

        while (j < arr.length) {
            sum = sum + arr[j];
            if (sum < k) {
                j++;
            } else {
                while(sum >= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                    sum = sum - arr[i];
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }

}
