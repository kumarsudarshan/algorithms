package DP.lcs;

/*
Minimum number of Insertion and Deletion
Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Examples:
Input : str1 = "heap", str2 = "pea"
Output : Minimum Deletion = 2 and
         Minimum Insertion = 1
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.

Input : str1 = "geeksforgeeks", str2 = "geeks"
Output : Minimum Deletion = 8
         Minimum Insertion = 0
 */
public class MinimumNumberInsertionDeletion {
    public static void main(String[] args) {
        minInsertDelete("heap", "pea");
        minInsertDelete("geeksforgeeks", "geeks");
    }

    /*
    X = "heap", Y = "pea" , LCS(X, Y) = “ea”
    Minimum of Deletion = X.length() – LCS(X, Y) – h and p
    Minimum of Insertion = Y.length() – LCS(X, Y) – p
     */
    public static void minInsertDelete(String X, String Y) {
        int lcs = lcs(X, Y);
        System.out.println("Minimum no of Deletion : " + (X.length() - lcs));
        System.out.println("Minimum no of Insertion : " + (Y.length() - lcs));
    }


    // Top down approach
    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base condition
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }

        // choice diagram
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
