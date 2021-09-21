package stack;

import java.util.Stack;

/*
Find the next greater element in a Circular Array
https://www.geeksforgeeks.org/find-the-next-greater-element-in-a-circular-array/

Given a circular array arr[] of N integers such that the last element of the given array is adjacent to the first element
of the array, the task is to print the Next Greater Element in this circular array. Elements for which no greater element exist,
consider the next greater element as “-1”.

Input: arr[] = {5, 6, 7}, Output: {6, 7, -1}
Explanation:
Next Greater Element for 5 is 6, for 6 is 7, and for 7 is -1 as we don’t have any element greater than itself so its -1.

Input: arr[] = {4, -2, 5, 8}, Output: {5, 5, 8, -1}
Explanation:
Next Greater Element for 4 is 5, for -2 its 5, for 5 is 8, and for 8 is -1 as we don’t have any element greater than itself so its -1, and for 3 its 4.
 */
public class NextGreaterElementInCircular {
    public static void main(String[] args) {
        int[] result = nextGreaterElement(new int[]{5, 6, 7});

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {

            // Remove all the elements in Stack that are less than arr[i%n]
            while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty())
                    result[i] = stack.peek();
                else
                    result[i] = -1; // When none of elements in Stack are greater than arr[i%n]
            }
            stack.push(arr[i % n]);
        }
        return result;
    }


}
