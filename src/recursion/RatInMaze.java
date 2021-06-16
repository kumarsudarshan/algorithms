package recursion;
/*
We have discussed Backtracking and Knight’s tour problem in Set 1.
Let us discuss Rat in a Maze as another example problem that can be solved using Backtracking.

A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1].
A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.

In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination.
Note that this is a simple version of the typical Maze problem.
For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with a limited number of moves.
input:
{1, 0, 0, 0}
{1, 1, 0, 1}
{0, 1, 0, 0}
{1, 1, 1, 1}

Following is the solution matrix (output of program) for the above input matrix.
{1, 0, 0, 0}
{1, 1, 0, 0}
{0, 1, 0, 0}
{0, 1, 1, 1}
All entries in solution path are marked as 1.
 */
public class RatInMaze {
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int[][] solution = new int[input.length][input[0].length];
        System.out.println(ratInMaze(input, 0, 0, solution));
        for(int i = 0 ; i < solution.length; i++){
            for (int j = 0; j < solution[0].length; j++){
                System.out.print(solution[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // Time Complexity: O(2^(n^2)), Space Complexity: O(n^2)
    public static boolean ratInMaze(int[][] input, int x, int y, int[][] solution){
        int m = input.length;
        int n = input[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || input[x][y] == 0){
            return false;
        }
        if(x == m-1 && y == n-1){
            solution[x][y] = 1;
            return true;
        }
        boolean result = ratInMaze(input, x+1, y, solution) || ratInMaze(input, x, y+1, solution);
        if(result){
            solution[x][y] = 1;
        }
        return result;
    }

}
