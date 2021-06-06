package cyclicsort;

import java.util.Arrays;

/*
We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence. This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.

Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]

Input: [2, 6, 4, 3, 1, 5]
Output: [1, 2, 3, 4, 5, 6]

Input: [1, 5, 6, 4, 3, 2]
Output: [1, 2, 3, 4, 5, 6]
 */

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }

    public static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int j = arr[i] - 1;
            if (arr[i] != arr[j]) {
                swap(arr, i, j);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
