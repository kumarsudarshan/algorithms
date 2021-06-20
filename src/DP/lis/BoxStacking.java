package DP.lis;

import java.util.Arrays;

/*
Maximum Height by Stacking Cuboids
Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed).
Choose a subset of cuboids and place them on each other.

You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj.
You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

Return the maximum height of the stacked cuboids.
Example 1:
Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
Output: 190
Explanation:
Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
Cuboid 0 is placed next with the 45x20 side facing down with height 50.
Cuboid 2 is placed next with the 23x12 side facing down with height 45.
The total height is 95 + 50 + 45 = 190.
Example 2:

Input: cuboids = [[38,25,45],[76,35,3]]
Output: 76
Explanation:
You can't place any of the cuboids on the other.
We choose cuboid 1 and rotate it so that the 35x3 side is facing down and its height is 76.
Example 3:

Input: cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
Output: 102
Explanation:
After rearranging the cuboids, you can see that all cuboids have the same dimension.
You can place the 11x7 side down on all cuboids so their heights are 17.
The maximum height of stacked cuboids is 6 * 17 = 102.
 */
public class BoxStacking {

    public static void main(String[] args) {
//        int[][] cuboids1 = {
//                {50, 45, 20},
//                {95, 37, 53},
//                {45, 23, 12}
//        };
//        System.out.println(maxHeight(cuboids1));
//
//        int[][] cuboids2 = {
//                {38, 25, 45},
//                {76, 35, 3}
//        };
//
//        System.out.println(maxHeight(cuboids2));
        int[][] cuboids3 = {
                {7, 11, 17},
                {7, 17, 11},
                {11, 7, 17},
                {11, 17, 7},
                {17, 7, 11},
                {17, 11, 7}
        };
        System.out.println(maxHeight(cuboids3));
    }

    /*
        We have to sort the cuboids based on height.
        We can chose max of all 3 elements in array as height and remaining two as length and width.
        We have to chose max as height since we want to maximize the final height
        We sort them based on height. Now we build from smaller block to largest block iteratively.
        Once we sort them based on height, we can apply what we learn from Longest Increasing Subsequence but with different condition.
        In LIS we chose the ones which are less than our current element in each iteration.
        In this one, we chose the ones whose length and width are smaller than or equal to our current element, height is already in sorted order.
        So the condition that all lenght, width and height are to be less than or equal to satisfies.
        One more thing is since we want to take larger element as height, if we sort dimensions of each of cuboid,
        we can directly take cuboid[i][2] as height and remaining two as length and width.
    */
    public static int maxHeight(int[][] c) {
        for (int[] cu : c) {
            Arrays.sort(cu);
        }
        Arrays.sort(c,
                (a, b) -> {
                    int e = Integer.compare(a[2], b[2]); // sorting based on height
                    if (e == 0) { //if largest elements i.e. height are equal, check other two elements
                        int l = Integer.compare(a[0], b[0]);
                        if (l == 0) {
                            return Integer.compare(a[1], b[1]);
                        }
                        return l;
                    }
                    return e;
                });

        //here onwards very similar to LIS
        int[] dp = new int[c.length];
        int ans = 0;
        for (int i = 0; i < c.length; i++) {
            dp[i] = c[i][2]; //this cuboid's height is the max height it can achieve at this point
            for (int j = 0; j < i; j++) {
                if (c[j][0] <= c[i][0] && c[j][1] <= c[i][1]) {
                    dp[i] = Math.max(dp[i], c[i][2] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
