package stack;

import java.util.Stack;

/*
The Celebrity Problem
In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} }
Output:id = 2
Explanation: The person with ID 2 does not
know anyone but everyone knows him

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 1, 0, 0},
           {0, 0, 1, 0} }
Output: No celebrity
Explanation: There is no celebrity.
 */
public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };
        System.out.println(isCelebrity(matrix));

        int[][] matrix1 = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        };
        System.out.println(isCelebrity(matrix1));
    }

    public static int isCelebrity(int[][] matrix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < matrix.length; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (matrix[a][b] == 1) {
                // if first a knows b, means 'a' is not a celebrity
                stack.push(b);
            } else {
                // if a doesn't know b, means 'b' is not a celebrity
                stack.push(a);
            }
        }
        int index = stack.pop();
        System.out.println(index);
        for (int i = 0; i < matrix.length; i++) {
            if (i != index) { // diagonal case
                if (matrix[i][index] == 0 || matrix[index][i] == 1) {
                    return -1;
                }
            }
        }
        return index;
    }

}
