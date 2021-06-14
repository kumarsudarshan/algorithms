package stack;

import java.util.Stack;

/*
Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Example
Consider the array {3, 0, 2, 0, 4}, three units of water can be stored three indexes 1 and 2, and one unit of water at index 3, and three units of water at index 4.
For Array[] = {3, 0, 2, 0, 4}
Water stored = 0 + 3 + 1 + 3 + 0 = 7
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        System.out.println(maxWaterBruteForce(arr)); // 7
        System.out.println(maxWaterDP(arr));
        System.out.println(maxWaterStack(arr));
        System.out.println(maxWaterTwoPointer(arr));
        int[] arr1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(maxWaterBruteForce(arr1)); // 6
        System.out.println(maxWaterDP(arr1));
        System.out.println(maxWaterStack(arr1));
        System.out.println(maxWaterTwoPointer(arr1));
    }

    // Approach 1: brute force - Time: O(n^2), Space O(1)
    public static int maxWaterBruteForce(int[] arr) {
        int n = arr.length;
        // To store the maximum water
        // that can be stored
        int res = 0;

        // For every element of the array
        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, arr[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

    // Approach 2: Dynamic Programming - Time: O(n), Space O(n)
    static int maxWaterDP(int[] arr) {
        int n = arr.length;
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

        return water;
    }

    // Approach 3: Using stacks : Time O(n), Space O(n)
    public static int maxWaterStack(int[] height) {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // size of the array
        int n = height.length;

        // Stores the final result
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack
            // until the condition holds
            while ((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {

                // store the height of the top
                // and pop it.
                int pop_height = height[stack.peek()];
                stack.pop();

                // If the stack does not have any
                // bars or the the popped bar
                // has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the
                // left and right boundary of
                // popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height
                        = Math.min(height[stack.peek()],
                        height[i])
                        - pop_height;

                ans += distance * min_height;
            }

            // If the stack is either empty or
            // height of the current bar is less than
            // or equal to the top bar of stack
            stack.push(i);
        }
        return ans;
    }

    // Approach 4 : using two pointer Time: O(n), Space : O(1)
    public static int maxWaterTwoPointer(int[] height) {
        int n = height.length;
        // initialize output
        int result = 0;

        // maximum element on left and right
        int leftMaxForCurrentBar = 0, rightMaxForCurrentBar = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (height[lo] < height[hi]) {
                if (height[lo] > leftMaxForCurrentBar)

                    // update max in left
                    leftMaxForCurrentBar = height[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += leftMaxForCurrentBar - height[lo];
                lo++;
            } else {
                if (height[hi] > rightMaxForCurrentBar)

                    // update right maximum
                    rightMaxForCurrentBar = height[hi];

                else
                    result += rightMaxForCurrentBar - height[hi];
                hi--;
            }
        }
        return result;
    }
}
