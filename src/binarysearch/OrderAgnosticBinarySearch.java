package binarysearch;

/*
Order-agnostic Binary Search (easy)
Given a sorted array of numbers, find if a given number ‘key’ is present in the array. Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.
Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
Input: [4, 6, 10], key = 10
Output: 2
Input: [1, 2, 3, 4, 5, 6, 7], key = 5
Output: 4
Input: [10, 6, 4], key = 10
Output: 0
Input: [10, 6, 4], key = 4
Output: 2
 */
public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{4, 6, 10}, 10));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(binarySearch(new int[]{10, 6, 4}, 10));
        System.out.println(binarySearch(new int[]{10, 6, 4}, 4));
    }

    public static int binarySearch(int[] nums, int key) {
        int start = 0, end = nums.length - 1;
        boolean isAscending = nums[start] < nums[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                return mid;
            }
            if (isAscending) { // ascending order
                if (key < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // descending order
                if (key < nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
