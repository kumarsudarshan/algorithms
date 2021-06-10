package binarysearch;

/*
Given an array of numbers which is sorted in ascending order and also rotated by some arbitrary number,
find if a given ‘key’ is present in it.
Write a function to return the index of the ‘key’ in the rotated array. If the ‘key’ is not present, return -1.
You can assume that the given array does not have any duplicates.

Input: [10, 15, 1, 3, 8], key = 15
Output: 1
Explanation: '15' is present in the array at index '1'.

Input: [4, 5, 7, 9, 10, -1, 2], key = 10
Output: 4
Explanation: '10' is present in the array at index '4'.

Similar Problems:
How do we search in a sorted and rotated array that also has duplicates?
Example 1:
Input: [3, 7, 3, 3, 3], key = 7
Output: 1
Explanation: '7' is present in the array at index '1'.

 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        System.out.println(searchRotatedArray(new int[]{10, 15, 1, 3, 8}, 15));
        System.out.println(searchRotatedArray(new int[]{4, 5, 7, 9, 10, -1, 2}, 10));

        System.out.println(searchRotatedArrayDuplicates(new int[]{3, 7, 3, 3, 3}, 7));
    }

    public static int searchRotatedArray(int[] nums, int key) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                return mid;
            }
            if (nums[start] < nums[mid]) { // left side is sorted in ascending order
                if (key >= nums[start] && key < nums[mid]) {
                    end = mid - 1;
                } else { // key > num[mid]
                    start = mid + 1;
                }
            } else { // right side is sorted in ascending order
                if (nums[mid] < key && key <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        // key not found in the array
        return -1;
    }

    public static int searchRotatedArrayDuplicates(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;

            // the only difference from the previous solution,
            // if numbers at indexes start, mid, and end are same, we can't choose a side
            // the best we can do, is to skip one number from both ends as key != arr[mid]
            if ((arr[start] == arr[mid]) && (arr[end] == arr[mid])) {
                ++start;
                --end;
            } else if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1;
                } else { //key > arr[mid]
                    start = mid + 1;
                }
            } else { // right side is sorted in ascending order
                if (key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // we are not able to find the element in the given array
        return -1;
    }

}
