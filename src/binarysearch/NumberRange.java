package binarysearch;

/*
Number Range (medium)
Given an array of numbers sorted in ascending order, find the range of a given number ‘key’. The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
Input: [4, 6, 6, 6, 9], key = 6
Output: [1, 3]
Input: [1, 3, 8, 10, 15], key = 10
Output: [3, 3]
Input: [1, 3, 8, 10, 15], key = 12
Output: [-1, -1]
 */
public class NumberRange {
    public static void main(String[] args) {
        int[] ans = numberRange1(new int[]{4, 6, 6, 6, 9}, 6);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
        ans = numberRange1(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
        ans = numberRange1(new int[]{1, 3, 8, 10, 15}, 12);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");

        ans = numberRange2(new int[]{4, 6, 6, 6, 9}, 6);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
        ans = numberRange2(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
        ans = numberRange2(new int[]{1, 3, 8, 10, 15}, 12);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
    }

    public static int[] numberRange1(int[] nums, int key) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == nums[mid]) {
                int i = mid;
                while (i > 0 && nums[i] == nums[i - 1]) {
                    i--;
                }
                int j = mid;
                while ((j < nums.length + 1) && nums[j] == nums[j + 1]) {
                    j++;
                }
                return new int[]{i, j};
            }
            if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] numberRange2(int[] nums, int key) {
        int[] result = {-1, -1};
        result[0] = numberRange2Helper(nums, key, false);
        if (result[0] != -1) { // no need to search again, if key is not present in input array
            result[1] = numberRange2Helper(nums, key, true);
        }
        return result;
    }

    // modified binary search
    public static int numberRange2Helper(int[] nums, int key, boolean findMaxIndex) {
        int keyIndex = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == nums[mid]) {
                keyIndex = mid;
                if (findMaxIndex) {
                    start = mid + 1; // search ahead to find last index of key
                } else {
                    end = mid - 1; // search ahead to find first index of key
                }
            } else if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return keyIndex;
    }

}
