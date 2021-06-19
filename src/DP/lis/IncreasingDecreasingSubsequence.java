package DP.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Length of Longest Subsequence
Problem Description
Given an 1D integer array A of length N, find the length of longest subsequence which is first increasing then decreasing.

Example Input
Input 1: A = [1, 2, 1], Output 1: 3
Input 2: A = [1, 11, 2, 10, 4, 5, 2, 1], Output 2: 6

Example Explanation
Explanation 1:
 [1, 2, 1] is the longest subsequence.
Explanation 2:
 [1 2 10 4 2 1] is the longest subsequence.

 */
public class IncreasingDecreasingSubsequence {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        System.out.println(longestSubsequenceLength(A));

        List<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(11);
        B.add(2);
        B.add(10);
        B.add(4);
        B.add(5);
        B.add(2);
        B.add(1);
        System.out.println(longestSubsequenceLength(B));
    }

    /*
    Return LIS(A) + LDS(A) – 1; // longest increasing subsequence + longest decreasing subsequence – 1;
     */
    public static int longestSubsequenceLength(final List<Integer> A) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result = Math.max(result, lis(A, i) + lds(A, i) - 1);
        }
        return result;
    }

    private static int lis(List<Integer> nums, int a) {
        if (nums == null || nums.size() == 0)
            return 0;

        int[] max = new int[a + 1];
        Arrays.fill(max, 1);

        int result = 1;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j)) {
                    max[i] = Math.max(max[i], max[j] + 1);

                }
            }
            result = Math.max(max[i], result);
        }
        return result;
    }

    private static int lds(List<Integer> nums, int a) {
        if (nums == null || nums.size() == 0)
            return 0;

        int[] max = new int[nums.size()];
        Arrays.fill(max, 1);

        int result = 1;
        for (int i = nums.size() - 1; i >= a; i--) {
            for (int j = nums.size() - 1; j >= i; j--) {
                if (nums.get(i) > nums.get(j)) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
            result = Math.max(max[i], result);
        }
        return result;
    }
}
