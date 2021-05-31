package twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 */
public class FindPairSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        Arrays.stream(findPair1(arr, 6)).forEach(i -> System.out.println(i));
        Arrays.stream(findPair2(arr, 6)).forEach(i -> System.out.println(i));
    }

    // using two pointer approach
    public static int[] findPair1(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int pairSum = arr[i] + arr[j];
            if (pairSum == target) { // matches, found answer
                return new int[]{arr[i], arr[j]};
            } else if (pairSum < target) { // increment start pointer
                i++;
            } else if (pairSum > target) { // decrement end pointer
                j--;
            }
        }
        return new int[]{-1, -1};
    }

    // using hashtable approach
    public static int[] findPair2(int[] arr, int target) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return new int[]{target - arr[i], arr[i]};
            } else {
                set.add(target - arr[i]);
            }
        }
        return new int[]{-1, -1};
    }
}
