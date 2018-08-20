/*
    Created by : Kumar Sudarshan
    Date : 21st Aug 2018
    Given a matrix of dimensions mxn having all entries as 1 or 0, find out the size of maximum size square sub-matrix with all 1s.
 */

package DP;

public class MaximumSizeSquare {

    public static void main(String[] args) {
        int matrix[][] = { { 1, 1, 0, 0, 1, 1 },
                           { 0, 0, 1, 0, 1, 1 },
                           { 1, 1, 1, 1, 1, 0 },
                           { 1, 1, 1, 1, 1, 1 },
                           { 1, 1, 1, 1, 1, 1 },
                           { 0, 1, 1, 1, 1, 1 },
                           { 1, 0, 0, 0, 1, 1 }
        };
        System.out.println(maximumSizeSquareSubmatrixWithAllOnes(matrix));
    }

    private static int maximumSizeSquareSubmatrixWithAllOnes(int[][] matrix) {
        int maxSize = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] table = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i == 0 || j == 0){
                    table[i][j] = matrix[i][j];
                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
                }
                else if(matrix[i][j] == 0){
                    table[i][j] = 0;
                }
                else{
                    table[i][j] = min(table[i-1][j-1],table[i-1][j],table[i][j-1]) + 1;
                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
                }
            }
        }
        return maxSize;
    }
    private static int min(int i, int j, int k) {
        return i <= j && i <= k ? i : (j <= i && j <= k ? j : k);
    }

}
