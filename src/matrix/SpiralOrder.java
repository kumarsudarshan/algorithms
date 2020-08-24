package matrix;

public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        printSpiralOrder(matrix, matrix.length, matrix[0].length);
        System.out.println();
        printSpiralOrderRecursive(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private static void printSpiralOrder(int[][] matrix, int row, int col) {
        int top = 0, bottom = row - 1;
        int left = 0, right = col - 1;
        while (true) {
            if (left > right) {
                break;
            }

            // top row
            for (int i = 0; i <= right; i++) {
                System.out.print(matrix[top][i] + "  ");
            }
            top++;
            if (top > bottom) {
                break;
            }

            // right column
            for (int i = 0; i <= bottom; i++) {
                System.out.print(matrix[i][right] + "  ");
            }
            right--;
            if (left > right) {
                break;
            }

            // bottom row
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + "  ");
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            // left row
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + "  ");
            }
            left++;
        }
    }

    private static void printSpiralOrderRecursive(int[][] matrix, int top, int bottom, int left, int right) {
        if (left > right) {
            return;
        }

        // top row
        for (int i = 0; i <= right; i++) {
            System.out.print(matrix[top][i] + "  ");
        }
        top++;
        if (top > bottom) {
            return;
        }

        // right column
        for (int i = 0; i <= bottom; i++) {
            System.out.print(matrix[i][right] + "  ");
        }
        right--;
        if (left > right) {
            return;
        }

        // bottom row
        for (int i = right; i >= left; i--) {
            System.out.print(matrix[bottom][i] + "  ");
        }
        bottom--;
        if (top > bottom) {
            return;
        }
        // left row
        for (int i = bottom; i >= top; i--) {
            System.out.print(matrix[i][left] + "  ");
        }
        left++;
        printSpiralOrderRecursive(matrix, top, bottom, left, right);
    }
}
