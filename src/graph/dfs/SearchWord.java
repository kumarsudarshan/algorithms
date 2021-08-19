package graph.dfs;

/*
https://www.geeksforgeeks.org/check-if-a-word-exists-in-a-grid-or-not/
Check if a word exists in a grid or not
Given a 2D grid of characters and a word, the task is to check if that word exists in the grid or not.
A word can be matched in 4 directions at any point.
The 4 directions are, Horizontally Left and Right, Vertically Up and Down.

Input:  grid[][] = {"axmy",
                    "bgdf",
                    "xeet",
                    "raks"};
Output: Yes

a x m y
b g d f
x e e t
r a k s

Input: grid[][] = {"axmy",
                   "brdf",
                   "xeet",
                   "rass"};
Output : No
 */

public class SearchWord {
    public static void main(String[] args) {
        char grid[][] = {
                "akmb".toCharArray(),
                "bgdf".toCharArray(),
                "xeft".toCharArray(),
                "raks".toCharArray()
        };
        System.out.println(searchWord(grid, "bgea"));
    }

    public static boolean searchWord(char[][] grid, String word) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                if (word.charAt(0) == grid[i][j] && doDFS(grid, i, j, visited, word, 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean doDFS(char[][] grid, int i, int j, boolean[][] visited, String word, int wordIndex) {
        int row = grid.length;
        int col = grid[0].length;
        if (word.length() == (wordIndex)) {
            return true;
        }
        visited[i][j] = true;
        if (isValid(row, col, i + 1, j) && !visited[i + 1][j] && word.charAt(wordIndex) == grid[i + 1][j]) {
            return doDFS(grid, i + 1, j, visited, word, wordIndex + 1);
        } else if (isValid(row, col, i - 1, j) && !visited[i - 1][j] && word.charAt(wordIndex) == grid[i - 1][j]) {
            return doDFS(grid, i - 1, j, visited, word, wordIndex + 1);
        } else if (isValid(row, col, i, j + 1) && !visited[i][j + 1] && word.charAt(wordIndex) == grid[i][j + 1]) {
            return doDFS(grid, i, j + 1, visited, word, wordIndex + 1);
        } else if (isValid(row, col, i, j - 1) && !visited[i][j - 1] && word.charAt(wordIndex) == grid[i][j - 1]) {
            return doDFS(grid, i, j - 1, visited, word, wordIndex + 1);
        }
        return false;
    }

    private static boolean isValid(int row, int col, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }
        return true;
    }
}
