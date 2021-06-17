package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are give a number of boxes (n-boxes) and number of identical items (r-items).
You are required to place the items in those boxes and print all such configurations possible.
 */
public class Combinations {
    public static void main(String[] args) {
        int nboxes = 5;
        int ritems = 3;
        List<List<Integer>> result = new ArrayList<>();
        combinations(new int[nboxes], 1, nboxes, 0, ritems, result);
        System.out.println(result.size());
        System.out.println(result);
    }

    public static void combinations(int[] boxes, int currentBox, int totalBox, int selectedSoFar, int totalSelection, List<List<Integer>> result) {
        if (currentBox > totalBox) {
            if (selectedSoFar == totalSelection) {
                List<Integer> temp = new ArrayList<>();
                Arrays.stream(boxes).forEach(i -> temp.add(i));
                result.add(temp);
            }
            return;
        }
        boxes[currentBox - 1] = 1;
        combinations(boxes, currentBox + 1, totalBox, selectedSoFar + 1, totalSelection, result);
        boxes[currentBox - 1] = 0;
        combinations(boxes, currentBox + 1, totalBox, selectedSoFar, totalSelection, result);
    }
}