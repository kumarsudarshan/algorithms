package cyclicsort;

import java.util.ArrayList;
import java.util.List;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some duplicates, find all the duplicate numbers without using any extra space.

Input: [3, 4, 4, 5, 5]
Output: [4, 5]

Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]
 */

public class AllDuplicateNumbers {

    public static void main(String[] args) {
        System.out.println(findAllDuplicateNumber(new int[]{3, 4, 4, 5, 5}));
        System.out.println(findAllDuplicateNumber(new int[]{5, 4, 7, 2, 3, 5, 3}));
    }

    public static List<Integer> findAllDuplicateNumber(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            if(arr[i] != arr[arr[i] - 1]){
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
        for(i = 0; i < arr.length; i++){
            if(arr[i] != i + 1){
                duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
