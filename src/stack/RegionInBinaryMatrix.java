package stack;

import java.util.Stack;

/*
Maximum size rectangle binary sub-matrix with all 1s

Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
Example:
Input:
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
Output : 8
1 1 1 1
1 1 1 1
Explanation :
The largest rectangle with only 1's is from
(1, 0) to (2, 3) which is
1 1 1 1
1 1 1 1
 */
public class RegionInBinaryMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        System.out.println(maxRectangle(matrix));
    }

    public static int maxRectangle(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = mah(matrix[0]);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            result = Math.max(result, mah(matrix[i]));
        }
        return result;
    }

    public static int mah(int[] hist) {
        int n = hist.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        int[] width = new int[n];
        Stack<Pair> stack = new Stack<>();
        // calculating nearest smaller to left
        for (int i = 0; i < hist.length; i++) {
            if (stack.size() == 0) {
                nsl[i] = -1;
            } else if (stack.size() > 0 && stack.peek().x < hist[i]) {
                nsl[i] = stack.peek().y;
            } else if (stack.size() > 0 && stack.peek().x >= hist[i]) {
                while (stack.size() > 0 && stack.peek().x >= hist[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    nsl[i] = -1;
                } else {
                    nsl[i] = stack.peek().y;
                }
            }
            stack.push(new Pair(hist[i], i));
        }
        // calculating nearest smaller to right
        stack.clear();
        for (int i = hist.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                nsr[i] = n;
                stack.push(new Pair(nsr[i], i));
            } else if (stack.size() > 0 && stack.peek().x < hist[i]) {
                nsr[i] = stack.peek().y;
            } else if (stack.size() > 0 && stack.peek().x >= hist[i]) {
                while (stack.size() > 0 && stack.peek().x >= hist[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    nsr[i] = n;
                } else {
                    nsr[i] = stack.peek().y;
                }
            }
            stack.push(new Pair(hist[i], i));
        }
        // calculating area = width[i]*height[i], width[i] = nsr[i] - nsl[i] - 1;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (nsr[i] - nsl[i] - 1) * hist[i]);
        }
        return maxArea;
    }
}
