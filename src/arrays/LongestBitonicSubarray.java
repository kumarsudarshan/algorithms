package arrays;

import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
Maximum Length Bitonic Subarray
 */
public class LongestBitonicSubarray {
    public static void main(String[] args) {
        System.out.println(longestBitonicSubArray(Arrays.asList(20, 4, 1, 2, 3, 4, 2, 10))); // 5
    }

    public static int longestBitonicSubArray(List<Integer> list) {
        int n = list.size();
        int[] increasingList = new int[n];
        int[] decreasingList = new int[n];

        // count increasing element till ith index
        for (int i = 0; i < n; i++) {
            if (i > 0 && list.get(i - 1) <= list.get(i)) {
                increasingList[i] = increasingList[i - 1] + 1;
            } else {
                increasingList[i] = 1;
            }
        }

        // count decreasing element till ith index from end
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && list.get(i + 1) <= list.get(i)) {
                decreasingList[i] = decreasingList[i + 1] + 1;
            } else {
                decreasingList[i] = 1;
            }
        }

        // calculate for any ith index increasing + decreasing - 1 (for current element taken 2 times)
        int maxSubArray = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSubArray = Math.max(maxSubArray, increasingList[i] + decreasingList[i] - 1);
        }
        return maxSubArray;
    }
}
