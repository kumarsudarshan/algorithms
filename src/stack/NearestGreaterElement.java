package stack;

import java.util.Arrays;
import java.util.Stack;

/*
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1.
Examples:
1.	For an array, the rightmost element always has the next greater element as -1.
2.	For an array that is sorted in decreasing order, all elements have the next greater element as -1.
3.	For the input array [4, 5, 2, 25], the next greater elements for each element are as follows.
Element       NGE (Right)   NGE (Left)
   4      -->   5           -1
   5      -->   25          -1
   2      -->   25           5
   25     -->   -1          -1
d)

 */
public class NearestGreaterElement {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElementRight(new int[]{4, 5, 2, 25})).forEach(i -> System.out.print(i + "  ")); // 5, 25, 25, -1
        System.out.println();
        Arrays.stream(nextGreaterElementLeft(new int[]{4, 5, 2, 25})).forEach(i -> System.out.print(i + "  ")); // -1, -1, 5, -1
    }

    public static int[] nextGreaterElementRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek() > arr[i]) {
                result[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static int[] nextGreaterElementLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek() > arr[i]) {
                result[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
