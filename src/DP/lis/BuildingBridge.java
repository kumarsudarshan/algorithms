package DP.lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Consider a 2-D map with a horizontal river passing through its center.
There are n cities on the southern bank with x-coordinates a(1) … a(n) and
n cities on the northern bank with x-coordinates b(1) … b(n).
You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross.
When connecting cities, you can only connect city a(i) on the northern bank to city b(i) on the southern bank.
Maximum number of bridges that can be built to connect north-south pairs with the aforementioned constraints.
Input : 6 4 2 1
        2 3 6 5
Output : Maximum number of bridges = 2
Explanation: Let the north-south x-coordinates
be written in increasing order.

1  2  3  4  5  6
  \  \
   \  \        For the north-south pairs
    \  \       (2, 6) and (1, 5)
     \  \      the bridges can be built.
      \  \     We can consider other pairs also,
       \  \    but then only one bridge can be built
        \  \   because more than one bridge built will
         \  \  then cross each other.
          \  \
1  2  3  4  5  6

Input : 8 1 4 3 5 2 6 7
        1 2 3 4 5 6 7 8
Output : Maximum number of bridges = 5
 */
public class BuildingBridge {
    public static void main(String[] args) {
        int[] x1 = {8, 1, 4, 3, 5, 2, 6, 7};
        int[] y1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(numberOfBridges(x1, y1));

        int[] x2 = {6, 4, 2, 1};
        int[] y2 = {2, 3, 6, 5};
        System.out.println(numberOfBridges(x2, y2));

        int[] x3 = {0, 2, 1, 1};
        int[] y3 = {1, 4, 4, 3};
        System.out.println(numberOfBridges(x3, y3));
    }

    /*
    Algorithm Insights:

1.	Sort the points w.r.t. to south coordinates.
2.	Find Longest Increasing Subsequence of north coordinates.
3.	Length of LIS is the maximum number of bridges that can be built

Example:
Given :  6 4 2 1		            	6 4 1 2  LIS is (1,2) length 2
	     2 3 6 5		sorting	        2 3 5 6 (sorted on south coordinates)
	     Output : 2

Another Example:
Given:  0 2 1 1			                0 1 1 2 	OR      0 1 2 1
	    1 4 4 3		    sorting		    1 3 4 4	            1 3 4 4
					                LISnorth = 4 (0,1,1,2)	LISnorth = 3 (0,1,2)
				            if South coordinates matches, then will sort the North coordinates for max result.
        Output: 4
     */
    public static int numberOfBridges(int[] x, int[] y) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            pairs.add(new Pair(x[i], y[i]));
        }

        Collections.sort(pairs, (b1, b2) -> {

            if (b1.y == b2.y) {
                return b1.x - b2.x;
            } else {
                return b1.y - b2.y;
            }
        });

        int[] xArr = new int[pairs.size()];
        for (int i = 0; i < pairs.size(); i++) {
            xArr[i] = pairs.get(i).x;
        }
        return lis(xArr);
    }

    public static int lis(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < n; j++) {
                // >= sign for array having duplicates and we are including that too.
                // ex {0, 1, 1, 2} = 4
                if (nums[j] >= nums[i]) {
                    max = Math.max(max, 1 + dp[j]);
                }
            }
            dp[i] = max;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
