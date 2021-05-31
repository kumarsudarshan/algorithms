package twopointer;

/*
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
Input: [1, 2, 5, 3, 7, 10, 9, 12], Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
Input: [1, 3, 2, 0, -1, 7, 10], Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
Input: [1, 2, 3], Output: 0
Explanation: The array is already sorted
Input: [3, 2, 1], Output: 3
Explanation: The whole array needs to be sorted.
 */

public class MinimumWindowSort {
    public static void main(String[] args) {
        System.out.println(minimumWindowSort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(minimumWindowSort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(minimumWindowSort(new int[]{1, 2, 3}));
        System.out.println(minimumWindowSort(new int[]{3, 2, 1}));
    }

    public static int minimumWindowSort(int[] arr) {
        int low = 0, high = arr.length - 1;
        // find first number out of sorting order form the beginning
        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }
        if (low == arr.length - 1) { // arr is already sorted.
            return 0;
        }
        // find first number out of sorting order form the end
        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        // find the max and min of the sub array
        int subArrMax = Integer.MIN_VALUE, subArrMin = Integer.MIN_VALUE;
        for (int k = low; k <= high; k++) {
            subArrMax = Math.max(subArrMax, arr[k]);
            subArrMin = Math.min(subArrMin, arr[k]);
        }

        // extend the subarray towards left to include if any number is bigger than subArrMin
        while (low > 0 && arr[low - 1] > subArrMin) {
            low--;
        }

        // extend the subarray towards right to include if any number is smaller than subArrMax
        while (high < arr.length - 1 && arr[high + 1] < subArrMax) {
            high++;
        }
        return high - low + 1;
    }
}
