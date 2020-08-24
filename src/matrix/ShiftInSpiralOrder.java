package matrix;

//For example. // shift by 1 unit
//        {1, 2, 3, 4, 5},
//        {16, 17, 18, 19, 6},
//        {15, 24, 25, 20, 7},
//        {14, 23, 22, 21, 8},
//        {13, 12, 11, 10, 9}
//        Output:
//        {25, 1, 2, 3, 4},
//        {15, 16, 17, 18, 5},
//        {14, 23, 24, 19, 6},
//        {13, 22, 21, 20, 7},
//        {12, 11, 10, 9, 8}


public class ShiftInSpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        shiftInSpiralOrder(matrix, matrix.length, matrix[0].length);

        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void shiftInSpiralOrder(int[][] matrix, int row, int col) {
        int top = 0, bottom = row - 1;
        int left = 0, right = col - 1;
        int prev = matrix[0][0];
        while (true) {
            if (left > right) {
                break;
            }

            // top row
            for (int i = left; i <= right; i++) {
                int temp = matrix[top][i];
                matrix[top][i] = prev;
                prev = temp;
            }
            top++;
            if (top > bottom) {
                break;
            }

            // right column
            for (int i = top; i <= bottom; i++) {
                int temp = matrix[i][right];
                matrix[i][right] = prev;
                prev = temp;
            }
            right--;
            if (left > right) {
                break;
            }

            // bottom row
            for (int i = right; i >= left; i--) {
                int temp = matrix[bottom][i];
                matrix[bottom][i] = prev;
                prev = temp;
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            // left row
            for (int i = bottom; i >= top; i--) {
                int temp = matrix[i][left];
                matrix[i][left] = prev;
                prev = temp;
            }
            left++;
        }
        matrix[0][0] = prev;
    }
}
