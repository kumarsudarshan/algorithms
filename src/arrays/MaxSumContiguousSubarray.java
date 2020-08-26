package arrays;

/*
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 * Input:
    A = [1, 2, 3, 4, -10]
Output:
    10
Explanation:
    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6
Explanation:
    The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, -10};
		System.out.println(new MaxSumContiguousSubarray().maxSubArray(arr));
		int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(new MaxSumContiguousSubarray().maxSubArray(arr1));
		
	}

	public int maxSubArray(final int[] a) {
		int max = Integer.MIN_VALUE;
		int end = 0;
		for (int i = 0; i < a.length; i++) {
			end += a[i];
			if(max < end) {
				max = end;
			}
			if(end < 0) {
				end = 0;
			}
		}
		return max;
	}
}
