package subset;

import java.util.ArrayList;
import java.util.List;

/*
Given a set with distinct elements, find all of its distinct subsets.

Input: [1, 3]
Output: [], [1], [3], [1,3]

Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */

public class AllSubsets {
    public static void main(String[] args) {
        System.out.println(generateAllSubsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> generateAllSubsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : arr) {
            // we will take all existing subsets and insert the current number in them to create new subset
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create new subset from existing by adding current number.
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);

            }
        }
        return subsets;
    }
}
