package arrays;

/*
Maximum difference between two elements such that larger element appears after the smaller number
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
Given an array arr[] of integers, find out the maximum difference between any two elements
such that larger element appears after the smaller number.

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.
 */
public class MaximumDifferenceWithSmallerElementComesFirst {
    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{2, 3, 10, 6, 4, 8, 1}));
        System.out.println(maximumDifference(new int[]{7, 9, 5, 6, 3, 2}));
    }

    // Time Complexity: O(n), Space : O(1)
    public static int maximumDifference(int[] arr) {
        int maxDifference = arr[1] - arr[0];
        int minimum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - minimum > maxDifference) {
                maxDifference = arr[i] - minimum;
            }
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return maxDifference;
    }
}
