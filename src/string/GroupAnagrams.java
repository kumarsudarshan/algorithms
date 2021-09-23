package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Group Anagrams
https://leetcode.com/problems/group-anagrams/
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Input: strs = ["eat","tea","tan","ate","nat","bat"], Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Input: strs = [""], Output: [[""]]

Input: strs = ["a"], Output: [["a"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            // calculate hashcode of string after sorting
            if (map.containsKey(newWord)) {

                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        List<List<String>> result = new ArrayList();
        for (String s : map.keySet()) {
            List<String> values = map.get(s);
            result.add(values);
        }
        return result;

    }
}
