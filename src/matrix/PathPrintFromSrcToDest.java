package matrix;


//Given a N x N matrix of positive integers, find shortest path from the first cell of the matrix to its last cell that satisfies given constraints. We can move exactly k steps from any cell in the matrix where k is the value of that cell. i.e. from any cell M[i][j] in the matrix M, we can move to location...
//
//        M[i + M[i][j]][j] or M[i – M[i][j]][j] or M[i][j + M[i][j]] or M[i][j – M[i][j]]
//
//        Given:
//        [ 7  1  3  5  3  6  1  1  7  5 ]
//        [ 2  3  6  1  1  6  6  6  1  2 ]
//        [ 6  1  7  2  1  4  7  6  6  2 ]
//        [ 6  6  7  1  3  3  5  1  3  4 ]
//        [ 5  5  6  1  5  4  6  1  7  4 ]
//        [ 3  5  5  2  7  5  3  4  3  6 ]
//        [ 4  1  4  3  6  4  5  3  2  6 ]
//        [ 4  4  1  7  4  3  3  1  4  2 ]
//        [ 4  4  5  1  5  2  3  5  3  5 ]
//        [ 3  6  3  5  2  2  6  4  2  1 ]
//
//        Output:
//        Shortest Path length is 6
//        Shortest Path is: (0, 0) (0, 7) (0, 6) (1, 6) (7, 6) (7, 9) (9, 9)

import java.util.ArrayList;
import java.util.List;

public class PathPrintFromSrcToDest {
    private static int N = 0;
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    public static void main(String[] args) {
        int matrix[][] = {
                {7, 1, 3, 5, 3, 6, 1, 1, 7, 5},
                {2, 3, 6, 1, 1, 6, 6, 6, 1, 2},
                {6, 1, 7, 2, 1, 4, 7, 6, 6, 2},
                {6, 6, 7, 1, 3, 3, 5, 1, 3, 4},
                {5, 5, 6, 1, 5, 4, 6, 1, 7, 4},
                {3, 5, 5, 2, 7, 5, 3, 4, 3, 6},
                {4, 1, 4, 3, 6, 4, 5, 3, 2, 6},
                {4, 4, 1, 7, 4, 3, 3, 1, 4, 2},
                {4, 4, 5, 1, 5, 2, 3, 5, 3, 5},
                {3, 6, 3, 5, 2, 2, 6, 4, 2, 1}
        };
        N = matrix.length;
        List<Pair> path = new ArrayList<Pair>();
        findPath(matrix, path);
    }

    static void findPath(int[][] matrix, List<Pair> path) {
        findPath(matrix, new Pair(0,0), path);
        System.out.println(path);
    }

    private static boolean findPath(int[][] matrix, Pair curr, List<Pair> path) {

        path.add(curr);
        int n = matrix.length;
        if ((curr.x == n - 1) && (curr.y == n - 1)) {
            return true;
        }
        Pair pair = new Pair(curr.x - matrix[curr.x][curr.y], curr.y);
        if (isValid(path, pair) && findPath(matrix, pair, path)) {
            return true;
        }
        pair = new Pair(curr.x + matrix[curr.x][curr.y], curr.y);
        if (isValid(path, pair) && findPath(matrix, pair, path)) {
            return true;
        }
        pair = new Pair(curr.x, curr.y - matrix[curr.x][curr.y]);
        if (isValid(path, pair) && findPath(matrix, pair, path)) {
            return true;
        }
        pair = new Pair(curr.x, curr.y + matrix[curr.x][curr.y]);
        if (isValid(path, pair) && findPath(matrix, pair, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    private static boolean isValid(List<Pair> path, Pair pair) {
        return (pair.x >= 0 && pair.x < N) && (pair.y >= 0 && pair.y < N) && !path.contains(pair);
    }


}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object ob) {
        Pair node = (Pair) ob;
        return (x == node.x && y == node.y);
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
