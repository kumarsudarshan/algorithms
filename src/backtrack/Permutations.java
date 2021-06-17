package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are give a number of boxes (n-boxes) and number of non-identical items (r-items).
You are required to place the items in those boxes and print all such configurations possible.
 */
public class Permutations {
    public static void main(String[] args) {
        int nboxes = 5;
        int ritems = 3;
        List<List<Integer>> result = new ArrayList<>();
        permutations(new int[nboxes], 1, ritems, result);
        System.out.println(result.size());
        System.out.println(result);
    }

    public static void permutations(int[] boxes, int currentItems, int totalItems, List<List<Integer>> result) {
        if (currentItems > totalItems) {
            List<Integer> temp = new ArrayList<>();
            Arrays.stream(boxes).forEach(i -> temp.add(i));
            result.add(temp);
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = currentItems;
                permutations(boxes, currentItems + 1, totalItems, result);
                boxes[i] = 0;
            }
        }
    }
}
