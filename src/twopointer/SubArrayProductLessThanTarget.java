package twopointer;

import java.util.ArrayList;
import java.util.List;

/*
Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
Example:
Input: [2, 5, 3, 10], target=30 , Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.
Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.
 */

public class SubArrayProductLessThanTarget {
    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(findSubarrays(new int[]{8, 2, 6, 5}, 50));
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product = product * arr[right];

            // if product > target, then sliding the window from left side removing the item form calculated product.
            while (product >= target && left < arr.length) {
                product = product / arr[left];
                left++;
            }

            List<Integer> tempList = new ArrayList<Integer>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]); // moving from right to left, so adding at begin. templist.add(0, items)
                subarrays.add(new ArrayList<>(tempList));
            }
        }
        return subarrays;
    }
}
