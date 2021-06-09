package subset;

import java.util.HashMap;
import java.util.Map;

/*
Count of Structurally Unique Binary Search Trees (hard) #
Given a number ‘n’, write a function to return the count of structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.

Input: 2
Output: 2
Explanation: As we saw in the previous problem, there are 2 unique BSTs storing numbers from 1-2.

Input: 3
Output: 5
Explanation: There will be 5 unique BSTs that can store numbers from 1 to 5.
 */
public class CountUniqueBST {
    public static void main(String[] args) {
        System.out.println(countBST(2)); // 2
        System.out.println(countBST(3)); // 5
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    public static int countBST(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making i as the root
            int leftSubtreeCount = countBST(i - 1);
            int rightSubtreeCount = countBST(n - i);
            count += (leftSubtreeCount * rightSubtreeCount);
        }
        map.put(n, count);
        return count;
    }
}
