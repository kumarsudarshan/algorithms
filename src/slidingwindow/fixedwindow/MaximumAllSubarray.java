package slidingwindow.fixedwindow;

import java.util.*;

/*
https://leetcode.com/problems/sliding-window-maximum/
Maximum of all subarrays of size k
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

public class MaximumAllSubarray {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        Arrays.stream(maxSlidingWindow(arr, 3)).forEach(e->System.out.print(e + " "));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int i = 0, j = 0;
        int[] result = new int[N - k + 1];
        Deque<Integer> queue = new LinkedList<Integer>();
        while (j < N) {
            while (queue.size() > 0 && queue.getLast() < nums[j]) {
                queue.pollLast();
            }
            queue.add(nums[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                result[i] = queue.peek();
                if (queue.peek() == nums[i]) {
                    queue.poll();
                }
                i++;
                j++;
            }
        }
        return result;
    }
}
