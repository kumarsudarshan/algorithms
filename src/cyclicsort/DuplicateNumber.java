package cyclicsort;

/*
We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
Input: [1, 4, 4, 3, 2]
Output: 4
Input: [2, 1, 3, 3, 5, 4]
Output: 3
Input: [2, 4, 1, 4, 4]
Output: 4
 */

public class DuplicateNumber {

    public static void main(String[] args) {
        System.out.println(findDuplicateNumber(new int[]{1, 4, 4, 3, 2}));
        System.out.println(findDuplicateNumber(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(findDuplicateNumber(new int[]{2, 4, 1, 4, 4}));

        System.out.println("Using other approach");
        System.out.println(findDuplicateNumber1(new int[]{1, 4, 4, 3, 2}));
        System.out.println(findDuplicateNumber1(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(findDuplicateNumber1(new int[]{2, 4, 1, 4, 4}));
    }

    public static int findDuplicateNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (i != (arr[i] - 1)) {
                if (arr[i] == arr[arr[i] - 1]) { // found the duplicate
                    return arr[i];
                } else {
                    swap(arr, i, arr[arr[i] - 1]);
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    // this approach do not modify the array.
    public static int findDuplicateNumber1(int[] arr) {
        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        return slow;
    }


    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
