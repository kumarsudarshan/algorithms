package DP;

import java.util.LinkedList;
import java.util.Queue;

/*
Jump Game III
https://leetcode.com/problems/jump-game-iii/
Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

 */
public class JumpGameIII {
    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(canReachBFS(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    }

    public static boolean canReach(int[] arr, int start) {
        int len = arr.length;
        boolean[] vis = new boolean[len];
        return dfs(arr, len, start, vis);
    }

    private static boolean dfs(int[] arr, int len, int i, boolean[] vis) {
        if (i < 0 || i >= len || vis[i]) return false;
        if (arr[i] == 0)
            return true;
        vis[i] = true;
        boolean left = dfs(arr, len, i - arr[i], vis);
        boolean right = dfs(arr, len, i + arr[i], vis);
        return left || right;
    }

    public static boolean canReachBFS(int[] arr, int start) {
        int len = arr.length;
        boolean[] vis = new boolean[len];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (vis[cur]) continue;
                if (arr[cur] == 0) return true;
                vis[cur] = true;
                //for left lim
                if (cur - arr[cur] >= 0) {
                    q.add(cur - arr[cur]);
                }
                if (cur + arr[cur] < len) {
                    q.add(cur + arr[cur]);
                }
            }
        }
        return false;
    }

}
