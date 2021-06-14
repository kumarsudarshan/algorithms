package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        Arrays.stream(nextSmallerElementRight(new int[]{4, 5, 2, 25})).forEach(i -> System.out.print(i + "  ")); // 2, 2, -1, -1
        System.out.println();
        Arrays.stream(nextSmallerElementLeft(new int[]{4, 5, 2, 25})).forEach(i -> System.out.print(i + "  ")); // -1, 4, -1, 2
    }

    public static int[] nextSmallerElementRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek() < arr[i]) {
                result[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
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

    public static int[] nextSmallerElementLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek() < arr[i]) {
                result[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
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
