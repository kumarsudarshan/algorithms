package binarysearch;

/*
Minimum Difference Element (medium)
Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
Input: [4, 6, 10], key = 7
Output: 6
Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
Input: [4, 6, 10], key = 4
Output: 4
Input: [1, 3, 8, 10, 15], key = 12
Output: 10
Input: [4, 6, 10], key = 17
Output: 10
 */
public class MinimumDifferenceElement {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{4, 6, 10}, 7));
        System.out.println(minimumDifference(new int[]{4, 6, 10}, 4));
        System.out.println(minimumDifference(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(minimumDifference(new int[]{4, 6, 10}, 17));
    }

    public static int minimumDifference(int[] nums, int key) {
        if (key < nums[0]) {
            return nums[0];
        }
        if (key > nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (key == nums[mid]) {
                return nums[mid];
            }
            if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // at the end of the while loop, start > end
        // we are not able to find the answers, then minimum diff will lei between end and start (start > end)
        // return the element which is closet to key.
        if (nums[start] - key < key - nums[end]) {
            return nums[start];
        }
        return nums[end];
    }

}
