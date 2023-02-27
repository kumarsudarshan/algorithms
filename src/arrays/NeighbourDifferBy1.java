package arrays;

/*
Given an array of integers where each neighboring element
differs by a value of +-1,
find a given number.
arr[] = {-2, -1, 0, -1, 0, 1, 2, 3, 4}
K = 4
return : true
 */
public class NeighbourDifferBy1 {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 0, -1, 0, 1, 2, 3, 4};
        System.out.println(checkKey(arr, 4)); // true
        System.out.println(checkKey(new int[]{-2, -1, 0, -1, 0, 1, 2, 3}, 4)); // false

    }

    public static boolean checkKey(int arr[], int k) {
        int i = 0;
        while (i >= 0 && i < arr.length && arr[i] != k) {
            i += Math.abs(arr[i] - k);
        }
        if (i < arr.length && arr[i] == k) {
            return true;
        }
        return false;
    }
}
