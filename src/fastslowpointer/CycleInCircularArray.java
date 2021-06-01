package fastslowpointer;

/*
Cycle in a Circular Array (hard) #
We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices. You should assume that the array is circular which means two things:

If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.

Input: [1, 2, -1, 2, 2]
Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0

Input: [2, 2, -1, 2]
Output: true
Explanation: The array has a cycle among indices: 1 -> 3 -> 1

Input: [2, 1, -1, -2]
Output: false
Explanation: The array does not have any cycle.
 */

public class CycleInCircularArray {
    public static void main(String[] args) {
        System.out.println(loopExists(new int[]{2, -1, 1, 2, 2}));
    }

    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0; // if we are moving forward or backward.
            int slow = i, fast = i;

            // if slow or fast becomes -1, means there is no cycle for this number 'i'.
            do {
                slow = findNextIndex(arr, isForward, slow); // move 1 step for slow pointer
                fast = findNextIndex(arr, isForward, fast); // move 1 step for fast pointer
                if (fast != -1) {
                    fast = findNextIndex(arr, isForward, fast); // move 1 step for fast pointer
                }

            } while (slow != -1 && fast != -1 && slow != fast);
            if (slow != -1 && slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction) {
            return -1; // change in the direction
        }

        // calculate next index
        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        // wrap around for negative numbers
        // example 2, -3, 1, 2, 2 -> let at position 1 --- value is -3. nextIndex = (1-3)%5 = -2(5 is size of arr)
        // -2 backward direction means 3 forward direction. so -2 + 5 = 3
        if (nextIndex < 0) {
            nextIndex += arr.length;
        }

        // one element cycle
        if (nextIndex == currentIndex) {
            nextIndex = -1;
        }
        return nextIndex;
    }
}
