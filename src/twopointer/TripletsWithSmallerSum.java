package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

Input: [-1, 0, 2, 3], target=3 , Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Input: [-1, 4, 2, 1, 3], target=5 , Output: 4
Explanation: There are four triplets whose sum is less than the target: [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */

public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        List<List<Integer>> triplets = new ArrayList();
        System.out.println(tripletsWithSmallerSum(new int[]{-1, 0, 2, 3}, 3, triplets));
        System.out.println(triplets);
        triplets = new ArrayList();
        System.out.println(tripletsWithSmallerSum(new int[]{-1, 4, 2, 1, 3}, 5, triplets));
        System.out.println(triplets);
    }

    public static int tripletsWithSmallerSum(int[] arr, int target, List<List<Integer>> triplets) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum < target) { // found the triplet
                    // arr is sorted and since arr[right] >= arr[left],
                    // then all values less than arr[right] is also satifies the condition.
                    // to include add (right - left) to count variable.
                    count = count + right - left;

                    // to print the actual list .... iterate from right to left and include in list.
                    for(int j = right; j > left; j-- ){
                        triplets.add(Arrays.asList(arr[i], arr[left], arr[j]));
                    }

                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
