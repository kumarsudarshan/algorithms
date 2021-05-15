package slidingwindow.variablewindow;

/*
Problem Description:

Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.

For Input:
1
7 5
4 1 1 1 2 3 5
your output is:
4
 */

public class LongestSubarrayOfSumK {

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
//        System.out.println(maxSubarraySum(arr, 5));
        System.out.println(maxLen(arr, 5));
    }

    public static int maxSubarraySum(int[] nums, int k) {
        int N = nums.length;
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        while (j < N) {
            currentSum = currentSum + nums[j];
            if (currentSum < k) {
                j++;
            } else if (currentSum == k) {
                //System.out.println(j - i + 1);
                max = Math.max(max, j - i + 1);
                j++;
            }
            if (currentSum > k) {
                while (currentSum > k) {
                    currentSum = currentSum - nums[i];
                    i++;
                }
                j++;
            }

        }
        return max;
    }

    static int maxLen(int arr[], int k) {
        int n = arr.length;
        int i = 0, j = 0, sum = 0, res = 0;
        while (j < n) {
            sum += arr[j];
            if (sum < k)
                j++;
            else if (sum == k) {
                System.out.println(j - i + 1);
                res = Math.max(res, j - i + 1);
                sum = 0;
                i++;
            } else {
                res = Math.max(res, j - i);
                i = j;
                j++;
            }
        }
        return res;
    }

}
