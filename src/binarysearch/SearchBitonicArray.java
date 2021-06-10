package binarysearch;

/*
Search Bitonic Array (medium) #
Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
Input: [1, 3, 8, 4, 3], key=4
Output: 3
Input: [3, 8, 3, 1], key=8
Output: 1
Input: [1, 3, 8, 12], key=12
Output: 3
Input: [10, 9, 8], key=10
Output: 0
 */
public class SearchBitonicArray {
    public static void main(String[] args) {
        System.out.println(searchBitonicArray(new int[]{1, 3, 8, 4, 3}, 4));
        System.out.println(searchBitonicArray(new int[]{3, 8, 3, 1}, 8));
        System.out.println(searchBitonicArray(new int[]{1, 3, 8, 12}, 12));
        System.out.println(searchBitonicArray(new int[]{10, 9, 8}, 10));
    }

    public static int searchBitonicArray(int[] nums, int key) {
        int max = findMax(nums);
        int keyIndex = binarySearch(nums, key, 0, max);
        if (keyIndex != -1) {
            return keyIndex;
        }
        return binarySearch(nums, key, max + 1, nums.length - 1);
    }

    public static int findMax(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int binarySearch(int[] nums, int key, int start, int end) {
        boolean isAscending = nums[start] < nums[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == nums[mid]) {
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
