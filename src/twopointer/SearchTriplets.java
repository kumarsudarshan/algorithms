package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
 */

public class SearchTriplets {
    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList();
        Arrays.sort(arr); // sort array

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) { // skip if it has duplicates, since arr is sorted it will at neighbour
                continue;
            }
            searchPair(arr, -arr[i], i + 1, triplets); // calculate pair sum as X+Y=-Z(-arr[i])
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { // found triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left - 1]){
                    left++; // skip to avoid duplicates
                }
                while(left < right && arr[right] == arr[right + 1]){
                    right--; // skip to avoid duplicates
                }
            } else if (currentSum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
    }
}
