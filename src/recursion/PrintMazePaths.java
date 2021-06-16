package recursion;

import java.util.ArrayList;
import java.util.List;
/*
Print all possible paths from top left to bottom right of a mXn matrix
The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down.

Input : 1 2 3
        4 5 6
Output : 1 4 5 6
         1 2 5 6
         1 2 3 6

Input : 1 2
        3 4
Output : 1 2 4
         1 3 4
 */
public class PrintMazePaths {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        ArrayList<Integer> path = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length + matrix[0].length - 1; i++) {
            path.add(0);
        }
        printMaze(matrix, 0, 0, matrix.length, matrix[0].length, path, 0);
        System.out.println(allPaths);
    }

    static List<List<Integer>> allPaths = new ArrayList<>();

    public static void printMaze(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> path, int index) {
        if (x1 >= x2 || y1 >= y2) {
            return;
        }
        // if reach last row, only option is to move right
        if (x1 == x2 - 1) {
            for (int k = y1; k < y2; k++) {
                path.set(index + k - y1, matrix[x1][k]);
            }
            allPaths.add(new ArrayList<>(path));
            return;
        }
        // if reach last column, only option is to move down
        if (y1 == y2 - 1) {
            for (int k = x1; k < x2; k++) {
                path.set(index + k - x1, matrix[k][y1]);
            }
            allPaths.add(new ArrayList<>(path));
            return;
        }

        path.set(index, matrix[x1][y1]);
        printMaze(matrix, x1 + 1, y1, x2, y2, path, index + 1);

        printMaze(matrix, x1, y1 + 1, x2, y2, path, index + 1);
    }
}
