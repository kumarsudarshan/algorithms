package twopointer;

import java.util.Arrays;

/*
Problem Statement #
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Example 2:
Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]
 */

public class SquaringSortedArray {
    public static void main(String[] args) {
        Arrays.stream(squaringSortedArray(new int[]{-2, -1, 0, 2, 3})).forEach(i -> System.out.print(i + "    "));
        System.out.println();
        Arrays.stream(squaringSortedArray(new int[]{-3, -1, 0, 1, 2})).forEach(i -> System.out.print(i + "    "));
    }

    public static int[] squaringSortedArray(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int left = 0, right = n - 1;
        int highestSquareIndex = n - 1;

        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIndex] = leftSquare;
                left++;
            } else {
                squares[highestSquareIndex] = rightSquare;
                right--;
            }
            highestSquareIndex--;
        }
        return squares;
    }
}
