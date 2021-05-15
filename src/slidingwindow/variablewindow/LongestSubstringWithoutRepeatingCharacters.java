package slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0

 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int j = 0, i = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                int count = map.get(s.charAt(j));
                map.put(s.charAt(j), count + 1);
            } else {
                map.put(s.charAt(j), 1);
            }
            if(map.size() > (j - i + 1)){
                j++;
            } else if(map.size() == (j - i + 1)) {
                ans = Math.max(ans, map.size());
                j++;
            } else if(map.size() < (j - i + 1)){
                while(map.size() < (j - i + 1)){
                    if(map.containsKey(s.charAt(i))){
                        int count = map.get(s.charAt(i));
                        if(count == 1){
                            map.remove(s.charAt(i));
                        } else {
                            map.put(s.charAt(i), count-1);
                        }
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
