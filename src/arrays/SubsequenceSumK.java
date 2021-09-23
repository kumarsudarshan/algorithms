package arrays;

/*
Given an array arr[]and an integer K, the task is to find the sum of all K length subsequences from the given array.

Input: arr[] = {2, 3, 4}, K = 2 , Output: 18
Explanation:
There are 3 possible subsequences of length 2 which are {2, 3}, {2, 4} and {3, 4}
The sum of all 2 length subsequences is 5 + 6 + 7 = 18

Input: arr[] = {7, 8, 9, 2}, K = 2 , Output: 78
Explanation:
There are 6 subsequences of length 2 which are {7, 8}, {7, 9}, {7, 2}, {8, 9}, {8, 2} and {9, 2}.
The sum of all 2 length sub sequences is 15 + 16 + 9 + 17 + 10 + 11 = 78
 */
public class SubsequenceSumK {
    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 2};
        int n = arr.length;
        System.out.print(sumSubsequences(arr, n, 2));
    }

    // Function for finding sum of all K length subsequences
    // The count of total element in all K length subsequences is k * nCk, possibility of appearing of each element is same.
    // So each element appears((k * nCk) / n ) times and it contributes arr[i] * ( (k*nCk)/n ) in the result.
    // Hence, the sum of all K length subsequence is sum(array) * ((k * nCk) / n)
    static int sumSubsequences(int arr[], int n, int k) {
        int sum = 0;
        // Calculate the sum of array
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int kLengthSubSequence;
        // Calculate nCk
        kLengthSubSequence = nCr(n, k);
        int ans = sum * ((k * kLengthSubSequence) / n);
        // Return the final result
        return ans;
    }

    static int nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
