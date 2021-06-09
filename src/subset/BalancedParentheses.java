package subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Balanced Parentheses (hard)
For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
Input: N=2
Output: (()), ()()
Input: N=3
Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class BalancedParentheses {


    public static void main(String[] args) {
        System.out.println(generateBalancedParentheses(3));
        List<String> result = new ArrayList<>();
        char[] parenthesesString = new char[2 * 3];
        generateBalancedParenthesesRecursive(3, 0, 0, parenthesesString, 0, result);
        System.out.println(result);
    }

    public static List<String> generateBalancedParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            // if we have reached maximum number of open and closed parentheses, then add it to the answers
            if (ps.openCount == num && ps.closedCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) { // if we can add open parentheses, add it
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closedCount));
                }
                if (ps.openCount > ps.closedCount) { // if we can add closed parentheses, add it
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closedCount + 1));
                }
            }
        }
        return result;
    }

    public static void generateBalancedParenthesesRecursive(int num, int openCount, int closedCount, char[] parenthesesString, int index, List<String> result) {
        // if we have reached maximum number of open and closed parentheses, then add it to the answers
        if (openCount == num && closedCount == num) {
            result.add(new String(parenthesesString));
        } else {
            if (openCount < num) { // if we can add open parentheses, add it
                parenthesesString[index] = '(';
                generateBalancedParenthesesRecursive(num, openCount + 1, closedCount, parenthesesString, index + 1, result);
            }
            if (openCount > closedCount) { // if we can add closed parentheses, add it
                parenthesesString[index] = ')';
                generateBalancedParenthesesRecursive(num, openCount, closedCount + 1, parenthesesString, index + 1, result);
            }
        }
    }

}

class ParenthesesString {
    String str;
    int openCount;
    int closedCount;

    public ParenthesesString(String str, int openCount, int closedCount) {
        this.str = str;
        this.openCount = openCount;
        this.closedCount = closedCount;
    }
}
