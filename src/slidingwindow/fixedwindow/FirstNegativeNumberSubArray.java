package slidingwindow.fixedwindow;

import java.util.*;

/*
https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/

First negative integer in every window of size k
Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.

Examples:
Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
Output : -8 0 -6 -6
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6

Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
Output : -1 -1 -7 -15 -15 0
 */
public class FirstNegativeNumberSubArray {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        System.out.println(firstNegativeNumberSubArray(arr, 3));
    }

    public static List<Integer> firstNegativeNumberSubArray(int[] arr, int k) {
        int n = arr.length;
        List<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;
        Queue<Integer> temp = new LinkedList<Integer>();
        while (j < n) {
            if (arr[j] < 0) {
                temp.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (temp.size() > 0) {
                    result.add(temp.peek());
                    if (temp.contains(arr[i])) {
                        temp.poll();
                    }
                } else {
                    result.add(0);
                }
                j++;
                i++;
            }
        }
        return result;
    }
}
