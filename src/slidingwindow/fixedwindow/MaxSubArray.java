package slidingwindow.fixedwindow;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
Find maximum (or minimum) sum of a subarray of size k
Difficulty Level : Easy
Given an array of integers and a number k, find maximum sum of a subarray of size k.

Examples :

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

Input  : arr[] = {2, 3}
         k = 3
Output : Invalid
There is no subarray of size 3 as size of whole
array is 2.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSubArray(arr, 4));
    }

    public static int maxSubArray(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0, max = Integer.MIN_VALUE;
        while (j < n) {
            if (j - i + 1 < k) {
                sum = sum + arr[j];
                j++;
            } else if (j - i + 1 == k) {
                sum = sum + arr[j];
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return max;
    }


}
