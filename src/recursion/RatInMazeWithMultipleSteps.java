package recursion;
/*
Rat in a Maze with multiple steps or jump allowed
A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
In the maze matrix, 0 means the block is dead end and non-zero number means the block can be used in the path from source to destination. The non-zero value of mat[i][j] indicates number of maximum jumps rat can make from cell mat[i][j].
In this variation, Rat is allowed to jump multiple steps at a time instead of 1.
Examples:


Input : { {2, 1, 0, 0},
         {3, 0, 0, 1},
         {0, 1, 0, 1},
          {0, 0, 0, 1}
        }
Output : { {1, 0, 0, 0},
           {1, 0, 0, 1},
           {0, 0, 0, 1},
           {0, 0, 0, 1}
         }

Explanation
Rat started with M[0][0] and can jump upto 2 steps right/down.
Let's try in horizontal direction -
M[0][1] won't lead to solution and M[0][2] is 0 which is dead end.
So, backtrack and try in down direction.
Rat jump down to M[1][0] which eventually leads to solution.

Input : {
      {2, 1, 0, 0},
      {2, 0, 0, 1},
      {0, 1, 0, 1},
      {0, 0, 0, 1}
    }
Output : Solution doesn't exist
 */
public class RatInMazeWithMultipleSteps {
    public static void main(String[] args) {
        int[][] input = {
                {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}
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
        for(int i = 1; i <= input[x][y]; i++){
            boolean result = ratInMaze(input, x+i, y, solution) || ratInMaze(input, x, y+i, solution);
            if(result){
                solution[x][y] = 1;
                return true;
            }
        }
        return false;
    }
}
