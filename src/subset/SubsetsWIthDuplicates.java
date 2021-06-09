package subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Subsets with Duplicates (easy)
Given a set of numbers that might contain duplicates, find all of its distinct subsets.
Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]
Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 */
public class SubsetsWIthDuplicates {
    public static void main(String[] args) {
        System.out.println(generateAllSubsets(new int[]{1, 3, 3}));
    }

    public static List<List<Integer>> generateAllSubsets(int[] arr) {
        // sort the array to handle duplicates
        Arrays.sort(arr);
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding empty subset
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            startIndex = 0;
            // if current and previous elements are same then create new subsets only from the subsets added from the previous step
            if (i > 0 && arr[i] == arr[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create subset from existing subsets and add current element to it.
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(arr[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
