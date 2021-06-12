package graph.topologicalsort;

import java.util.*;

/*
Alien Dictionary (hard)
There is a dictionary containing words from an alien language for which we don’t know the ordering of the characters.
Write a method to find the correct order of characters in the alien language.
Input: Words: ["ba", "bc", "ac", "cab"]
Output: bac
Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
from the given words we can conclude the following ordering among its characters:

1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'

From the above two points, we can conclude that the correct character order is: "bac"
Input: Words: ["cab", "aaa", "aab"]
Output: cab
Explanation: From the given words we can conclude the following ordering among its characters:

1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'

From the above two points, we can conclude that the correct character order is: "cab"
Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
Output: ywxz
Explanation: From the given words we can conclude the following ordering among its characters:

1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'

From the above five points, we can conclude that the correct character order is: "ywxz"

 */
public class AlienDictionary {

    public static void main(String[] args) {
        System.out.println(findOrder(new String[]{"ba", "bc", "ac", "cab"}));
        System.out.println(findOrder(new String[]{"cab", "aaa", "aab"}));
        System.out.println(findOrder(new String[]{"ywx", "wz", "xww", "xz", "zyy", "zwz"}));
    }

    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        // 1. initialize the graph
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        // 2. build th graph
        for (int i = 0; i < words.length - 1; i++) {
            // find ordering of characters from adjacent words
            String w1 = words[i];
            String w2 = words[i + 1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if (parent != child) { // if two characters are different
                    inDegree.put(child, inDegree.get(child) + 1);
                    graph.get(parent).add(child);
                    break; // only first characters will help us on this.
                }
            }
        }

        // 3. Find all source, that have 0 indegree
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // 4. for each source add it to the sorted order result and subtract one form all of it's children indegree.
        // if it's children indegree becomes zero, add it to the queue.
        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
            char vertex = sources.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex); // get the node children to decrement their indegree
            for (char child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        // if sortedOrder doesn't contains all the characters, this is a cyclic dependency.
        return sortedOrder.length() == inDegree.size() ? sortedOrder.toString() : "";
    }

}
