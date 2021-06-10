package binarysearch;

/*
Rotation Count (medium)
Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
You can assume that the array does not have any duplicates.
Input: [10, 15, 1, 3, 8]
Output: 2
Explanation: The array has been rotated 2 times.
Input: [4, 5, 7, 9, 10, -1, 2]
Output: 5
Explanation: The array has been rotated 5 times.
Input: [1, 3, 8, 10]
Output: 0
Explanation: The array has not been rotated.
 */
public class RotationCount {
    public static void main(String[] args) {
        System.out.println(rotationCount(new int[]{10, 15, 1, 3, 8}));
        System.out.println(rotationCount(new int[]{4, 5, 7, 9, 10, -1, 2}));
        System.out.println(rotationCount(new int[]{1, 3, 8, 10}));
    }

    public static int rotationCount(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) { // if mid is greater than next element
                return mid + 1;
            }
            if (mid > start && nums[mid - 1] > nums[mid]) { // if mid is smaller than previous element
                return mid;
            }
            if (nums[start] < nums[mid]) { // left side is sorted, so pivot element is on right side
                start = mid + 1;
            } else { // right side is sorted, so pivot element is on left side
                end = mid - 1;
            }
        }
        return 0; // the array has not been rotated.
    }
}
