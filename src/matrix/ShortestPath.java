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


import java.util.*;

public class ShortestPath {
    private static int N = 0;

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
        Node node = findShortestPath(matrix);
        System.out.println(node.level);
    }

    private static Node findShortestPath(int[][] matrix) {
        Node src = new Node(0, 0, 0);
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(src);

        Set<String> visited = new HashSet<String>();
        visited.add(0 + "," + 0);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int i = curr.x;
            int j = curr.y;
            int level = curr.level;
            if (i == N - 1 && j == N - 1) {
                return curr;
            }
            if (isValid(i - matrix[i][j], j)) {
                Node next = new Node(i - matrix[i][j], j, level + 1);
                String key = next.x + "," + next.y;
                if (!visited.contains(key)) {
                    q.add(next);
                    visited.add(key);
                }
            }
            if (isValid(i + matrix[i][j], j)) {
                Node next = new Node(i + matrix[i][j], j, level + 1);
                String key = next.x + "," + next.y;
                if (!visited.contains(key)) {
                    q.add(next);
                    visited.add(key);
                }
            }
            if (isValid(i , j - matrix[i][j])) {
                Node next = new Node(i , j - matrix[i][j], level + 1);
                String key = next.x + "," + next.y;
                if (!visited.contains(key)) {
                    q.add(next);
                    visited.add(key);
                }
            }
            if (isValid(i , j + matrix[i][j])) {
                Node next = new Node(i , j + matrix[i][j], level + 1);
                String key = next.x + "," + next.y;
                if (!visited.contains(key)) {
                    q.add(next);
                    visited.add(key);
                }
            }
        }
        return null;
    }

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < N) & (y >= 0 && y < N);
    }
}

class Node {
    int x;
    int y;
    int level;

    Node(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}
