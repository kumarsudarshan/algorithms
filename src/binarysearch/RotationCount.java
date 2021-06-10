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

Similar Problems
How do we find the rotation count of a sorted and rotated array that has duplicates too?

Input: [3, 3, 7, 3]
Output: 3
Explanation: The array has been rotated 3 times
 */
public class RotationCount {
    public static void main(String[] args) {
        System.out.println(rotationCount(new int[]{10, 15, 1, 3, 8}));
        System.out.println(rotationCount(new int[]{4, 5, 7, 9, 10, -1, 2}));
        System.out.println(rotationCount(new int[]{1, 3, 8, 10}));

        System.out.println(rotationCountDuplicates(new int[]{3, 3, 7, 3}));
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

    public static int rotationCountDuplicates(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) // if element at mid is greater than the next element
                return mid + 1;
            if (mid > start && arr[mid - 1] > arr[mid]) // if element at mid is smaller than the previous element
                return mid;

            // this is the only difference from the previous solution
            // if numbers at indices start, mid, and end are same, we can't choose a side
            // the best we can do is to skip one number from both ends if they are not the smallest number
            if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                if (arr[start] > arr[start + 1]) // if element at start+1 is not the smallest
                    return start + 1;
                ++start;
                if (arr[end - 1] > arr[end]) // if the element at end is not the smallest
                    return end;
                --end;
                // left side is sorted, so the pivot is on right side
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else { // right side is sorted, so the pivot is on the left side
                end = mid - 1;
            }
        }

        return 0; // the array has not been rotated
    }

}