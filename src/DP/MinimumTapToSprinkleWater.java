package DP;

/*
Minimum Number of Taps to Open to Water a Garden
https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
(i.e The length of the garden is n). There are n + 1 taps located at points [0, 1, ..., n] in the garden.
Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water
the area [i - ranges[i], i + ranges[i]] if it was open.
Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.

Example 1:
Input: n = 5, ranges = [3,4,1,1,0,0]
Output: 1
Explanation: The tap at point 0 can cover the interval [-3,3]
The tap at point 1 can cover the interval [-3,5]
The tap at point 2 can cover the interval [1,3]
The tap at point 3 can cover the interval [2,4]
The tap at point 4 can cover the interval [4,4]
The tap at point 5 can cover the interval [5,5]
Opening Only the second tap will water the whole garden [0,5]

Example 2:
Input: n = 3, ranges = [0,0,0,0]
Output: -1
Explanation: Even if you activate all the four taps you cannot water the whole garden.

Example 3:
Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
Output: 3

Example 4:
Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
Output: 2

Example 5:
Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
Output: 1
 */
public class MinimumTapToSprinkleWater {
    public static void main(String[] args) {
        System.out.println(minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
        System.out.println(minTaps1(5, new int[]{3, 4, 1, 1, 0, 0}));
    }

    // Time : nlog(n)
    public static int minTaps(int n, int[] ranges) {
        int min = 0;
        int max = 0;
        int count = 0;

        while (max < n) {
            for (int i = 0; i < ranges.length; i++) {
                if ((i - ranges[i]) <= min && (i + ranges[i]) > max) {
                    max = i + ranges[i];
                }
            }
            if (min == max) {
                return -1;
            }
            count++;
            min = max;
        }
        return count;
    }

    // optimized - Time: O(n)
    public static int minTaps1(int n, int[] ranges) {
        int[] realRange = new int[ranges.length];
        //Calculating the max range a tap can sprinkle at each of the n + 1 points
        for (int i = 0; i < ranges.length; i++) {
            // All we care about is 0 to n range
            // So, we will calculate the max range for each tap if put at Math.max(0, i - ranges[i])
            int left = Math.max(0, i - ranges[i]);
            realRange[left] = Math.max(i + ranges[i] - left, realRange[left]);
        }
        // same as  //https://leetcode.com/problems/jump-game-ii/solution/
        int jumps = 0;
        int farthestJump = 0;
        int currentJump = 0;
        for (int i = 0; i < realRange.length - 1; i++) {
            farthestJump = Math.max(farthestJump, i + realRange[i]);
            //case where there are no more jumps possible
            if (i == farthestJump && realRange[i] == 0) return -1;
            if (i == currentJump) {
                jumps++;
                currentJump = farthestJump;
            }
        }

        return jumps;
    }
}
