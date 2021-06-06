package cyclicsort;
/*
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.

Input: [2, 4, 1, 2]
Output: 3
 */

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumber {

    public static void main(String[] args) {
        System.out.println(findAllMissingNumber(new int[]{2, 3, 1, 8, 2, 3, 5, 1}));
        System.out.println(findAllMissingNumber(new int[]{2, 4, 1, 3}));
    }

    public static List<Integer> findAllMissingNumber(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (j != (nums[j] - 1)) {
                missingNumbers.add(j + 1);
            }
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
