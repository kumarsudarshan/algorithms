package backtrack;

/*
N Queen Problem
Let us discuss N Queen as another example problem that can be solved using Backtracking.
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
For example, following is a solution for 4 Queen problem.
The expected output is a binary matrix which has 1s for the blocks where queens are placed.
For example, following is the output matrix for above 4 queen solution.

              { 0,  1,  0,  0}
              { 0,  0,  0,  1}
              { 1,  0,  0,  0}
              { 0,  0,  1,  0}
 */
public class NQueens {
    public static void main(String[] args) {
        int N = 4;
        int[][] board = new int[N][N];
        if(nQueens(board, 0) == false){
            System.out.println("No solution possible");
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean nQueens(int[][] board, int column) {
        int N = board.length;
        // base case: If all queens are placed then return true
        if (column >= N) {
            return true;
        }

        // Consider this column and try placing this queen in all rows one by one
        for (int i = 0; i < N; i++) {
            // Check if the queen can be placed on board[i][col]
            if (isSafe(board, i, column)) {
                // Place this queen in board[i][column]
                board[i][column] = 1;

                // recur to place rest of the queens
                if (nQueens(board, column + 1)) {
                    return true;
                }

                // BACKTRACK
                board[i][column] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        // check this row on left side.
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal on left side
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
