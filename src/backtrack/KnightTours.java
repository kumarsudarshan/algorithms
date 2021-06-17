package backtrack;
/*
The Knight’s tour problem
Given a N*N board with the Knight placed on the first block of an empty board.
Moving according to the rules of chess knight must visit each square exactly once.
Print the order of each the cell in which they are visited.

Input :
N = 8
Output:
0  59  38  33  30  17   8  63
37  34  31  60   9  62  29  16
58   1  36  39  32  27  18   7
35  48  41  26  61  10  15  28
42  57   2  49  40  23   6  19
47  50  45  54  25  20  11  14
56  43  52   3  22  13  24   5
51  46  55  44  53   4  21  12
 */

public class KnightTours {
    public static void main(String[] args) {
        int N = 8;
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        if (!knightTour(board, 0, 0, 8, 1)) {
            System.out.println("Not possible");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static int[] xi = {-2, -1, +1, +2, +2, +1, -1, -2};
    static int[] yi = {-1, -2, -2, -1, +1, +2, +2, +1};

    public static boolean knightTour(int[][] board, int x, int y, int N, int move) {
        if (move == N * N) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int dx = x + xi[i];
            int dy = y + yi[i];
            if (isSafe(dx, dy, board, N)) {
                board[dx][dy] = move;
                if (knightTour(board, dx, dy, N, move + 1)) {
                    return true;
                }
                board[dx][dy] = -1;
            }
        }
        return false;
    }

    static boolean isSafe(int x, int y, int[][] board, int N) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }
}
