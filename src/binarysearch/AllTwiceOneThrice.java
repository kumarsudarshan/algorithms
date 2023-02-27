package binarysearch;

/*
Given a sorted array having where all elements are repeated twice but one is repeated thrice,
 find the element repeated thrice in O(logn) time.
 */
public class AllTwiceOneThrice {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7};
        System.out.println(findThrice(nums));
    }

    public static int findThrice(int nums[]) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkThrice(nums, mid)) {
                return nums[mid];
            } else if (nums[mid] == nums[mid - 1]) { // mid == mid-1
                // if mid+1(bcoz zero based index array) is even,
                // that means till mid we have 2 occurrences of each number
                if ((mid + 1) % 2 == 0) { // if mid+1 is even, answer must be on right side of the array.
                    low = mid + 1;
                } else {
                    // high can be either mid or mid - 2,
                    // bcoz every time we have to skip both the occurrences of the number
                    high = mid;
                }
            } else if (nums[mid] == nums[mid + 1]) { // mid == mid + 1
                // if mid+2 is even (bcoz we are at 1st occurrence of twice occurred number, mid + 1 + 1(zero based array))
                if ((mid + 2) % 2 == 0) { // low can be either mid or mid + 2,
                    // bcoz every time we have to skip both the occurrences of the number, or we can take both number
                    low = mid;
                } else {
                    high = mid - 1; // mid + 2 is not even then answer must be on left side of array
                }
            }
        }
        return -1;
    }

    private static boolean checkThrice(int[] nums, int mid) {
        // condition 1: mid-1 == mid == mid+1
        return ((mid - 1) >= 0 && (mid + 1) < nums.length && nums[mid] == nums[mid - 1] && nums[mid] == nums[mid + 1])
                || // condition 2: mid-2 == mid-1 == mid
                ((mid - 2) >= 0 && nums[mid] == nums[mid - 1] && nums[mid] == nums[mid - 2])
                || // condition 3: mid == mid+1 == mid+2
                ((mid + 2) < nums.length && nums[mid] == nums[mid + 1] && nums[mid] == nums[mid + 2]);
    }


}
