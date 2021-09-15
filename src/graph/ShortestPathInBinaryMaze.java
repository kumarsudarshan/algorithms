package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
Shortest path in a Binary Maze
Given a MxN matrix where each element can either be 0 or 1.
We need to find the shortest path between a given source cell to a destination cell.
The path can only be created out of a cell if its value is 1.
Expected time complexity is O(MN).

Input:
mat[ROW][COL]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                  {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                  {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                  {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                  {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                  {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                  {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
Source = {0, 0};
Destination = {3, 4};

Output:
Shortest Path is 11
 */
public class ShortestPathInBinaryMaze {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
                };

        System.out.println(shortestPath(matrix, new Point(0, 0), new Point(3, 4)));
    }

    // for all 4 direction
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};

    public static int shortestPath(int[][] matrix, Point source, Point destination) {
        int row = matrix.length;
        int col = matrix[0].length;


        if (matrix[source.x][source.y] != 1 || matrix[destination.x][destination.y] != 1) {
            return -1;
        }

        boolean[][] visited = new boolean[row][col];
        visited[source.x][source.y] = true;

        Queue<NodePath> queue = new LinkedList<>();

        queue.add(new NodePath(source, 0));

        while (!queue.isEmpty()) {
            NodePath tempNode = queue.poll();

            if (tempNode.point.x == destination.x && tempNode.point.y == destination.y) {
                return tempNode.dist;
            }
            for (int i = 0; i < dx.length; i++) {
                if (isValid(row, col, tempNode.point.x + dx[i], tempNode.point.y + dy[i]) &&
                        matrix[tempNode.point.x + dx[i]][tempNode.point.y + dy[i]] == 1 &&
                        !visited[tempNode.point.x + dx[i]][tempNode.point.y + dy[i]]) {
                    visited[tempNode.point.x + dx[i]][tempNode.point.y + dy[i]] = true;
                    queue.add(new NodePath(new Point(tempNode.point.x + dx[i], tempNode.point.y + dy[i]), tempNode.dist + 1));
                }
            }
        }
        return -1;

    }

    private static boolean isValid(int row, int col, int i, int j) {
        return (i >= 0 && i < row && j >= 0 && j < col);
    }
}

class NodePath {
    int dist;
    Point point;

    public NodePath(Point point, int dist) {
        this.point = point;
        this.dist = dist;
    }
}


class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}