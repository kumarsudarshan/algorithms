package arrays;

import java.util.ArrayList;

/*
 * Maximum Absolute Difference
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
For example,
A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
 */

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		int[] arr = {1, 3, -1};
		System.out.println(new MaximumAbsoluteDifference().maxArr(arr));
	}
	
	public int maxArr(int[] A) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int size = A.length;
        for (int i = 0; i<size; ++i)
        {
            max1 = Math.max(max1, A[i] + i);
            max2 = Math.max(max2, -A[i] + i);
            max3 = Math.max(max3, A[i] - i);
            max4 = Math.max(max4, -A[i] - i);
        }
        for (int i = 0; i<size; ++i)
        {
            ans = Math.max(ans, max1 - A[i] - i);
            ans = Math.max(ans, max2 + A[i] - i);
            ans = Math.max(ans, max3 - A[i] + i);
            ans = Math.max(ans, max4 + A[i] + i);
        }
        return ans;
    }
}
