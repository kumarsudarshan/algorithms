package slidingwindow.variablewindow;

/*
https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
Longest K unique characters substring
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest
substring with K distinct characters.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharactersSubstring {

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe", 3)); // 7
        System.out.println(longestkSubstr("aaaa", 1)); // 4
    }

    public static int longestkSubstr(String s, int k) {
        int j = 0, i = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                int count = map.get(s.charAt(j));
                map.put(s.charAt(j), count + 1);
            } else {
                map.put(s.charAt(j), 1);
            }
            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (map.size() > k) {
                while (map.size() > k && i < j) {
                    int count = map.get(s.charAt(i));
                    map.put(s.charAt(i), count - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

}
