package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/find-all-subsequences-with-sum-equals-to-k/
Find all subsequences with sum equals to K
Given an array arr[] of length N and a number K, the task is to find all the subsequences of the array whose sum of elements is K

Input: arr[] = {1, 2, 3}, K = 3, Output:
1 2
3

Input: arr[] = {17, 18, 6, 11, 2, 4}, K = 6, Output:
2 4
6
 */
public class AllSubsequenceSumEqualK {
    public static void main(String[] args) {
        int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        List<List<Integer>> ans = new ArrayList<>();
        subSequenceSum(ans, arr, new ArrayList<Integer>(), 6, 0);
        System.out.println(ans);
    }

    public static void subSequenceSum(List<List<Integer>> ans, int a[], List<Integer> temp, int k, int start) {
        // Here we have used ArrayList of ArrayList in in Java for implementation of Jagged Array
        // if k < 0 then the sum of the current subsequence in temp is greater than K
        if (start > a.length || k < 0) {
            return;
        }
        // if(k==0) means that the sum of this subsequence is equal to K
        if (k == 0) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        } else {
            for (int i = start; i < a.length; i++) {
                // Adding a new element into temp
                temp.add(a[i]);

                // After selecting an element from the array we subtract K by that value
                subSequenceSum(ans, a, temp, k - a[i], i + 1);

                // Remove the lastly added element
                temp.remove(temp.size() - 1);
            }
        }
    }

}
