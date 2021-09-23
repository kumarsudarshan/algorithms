package backtrack;

import java.util.*;

/*
https://leetcode.com/problems/word-break-ii/
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each
word is a valid dictionary word. Return all such possible sentences in any order.

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"], Output: []
 */
public class AllSentences {

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"))); // [cat sand dog, cats and dog]
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList();
        Set<String> dictionary = new HashSet();

        helper(s, wordDict, sentences, dictionary, new StringBuilder(""));

        return sentences;
    }

    private static void helper(String s, List<String> wordDict, List<String> sentences, Set<String> dictionary, StringBuilder sentence) {
        if (s.length() == 0) {
            sentences.add(sentence.toString().substring(1, sentence.length()));
            return;
        }
        if (dictionary.contains(s)) {
            return;
        }
        boolean add = true;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                sentence.append(" " + word);
                helper(s.substring(word.length(), s.length()), wordDict, sentences, dictionary, sentence);
                sentence.delete(sentence.length() - word.length() - 1, sentence.length());
                add = false;
            }
        }
        if (add) {
            dictionary.add(s);
        }
    }
}
