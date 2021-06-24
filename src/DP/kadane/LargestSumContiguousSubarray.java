package DP.kadane;

/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
Input : arr[] : {-2, -3, 4, -1, -2, 1, 5, -3}
Output : 7, (4 + (-1) + (-2) + 1 + 5)
 */
public class LargestSumContiguousSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    public static int maxSubArraySum(int arr[]) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        for (int i = 0; i < arr.length; i++) {
            localMax = Math.max(arr[i], arr[i] + localMax);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
