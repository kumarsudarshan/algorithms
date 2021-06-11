package bitwise;

/*
Single Number (easy)
In a non-empty array of integers, every number appears twice except for one, find that single number.
Input: 1, 4, 2, 1, 3, 2, 3
Output: 4
Input: 7, 9, 7
Output: 9
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
        System.out.println(findSingleNumber(new int[]{7, 9, 7}));
    }

    public static int findSingleNumber(int[] nums) {
        int missing = nums[0];
        for (int i = 1; i < nums.length; i++) {
            missing ^= nums[i];
        }
        return missing;
    }
}
