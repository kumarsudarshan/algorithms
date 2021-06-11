package heap.topkelements;

import java.util.*;

/*
Rearrange String K Distance Apart (hard)
Given a string and a number ‘K’, find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.
Input: "mmpp", K=2
Output: "mpmp" or "pmpm"
Explanation: All same characters are 2 distance apart.
Input: "Programming", K=3
Output: "rgmPrgmiano" or "gmringmrPoa" or "gmrPagimnor" and a few more
Explanation: All same characters are 3 distance apart.
Input: "aab", K=2
Output: "aba"
Explanation: All same characters are 2 distance apart.
Input: "aappa", K=3
Output: ""
Explanation: We cannot find an arrangement of the string where any two 'a' are 3 distance apart.
 */
public class RearrangeStringKDistantApart {
    public static void main(String[] args) {
        System.out.println(rearrangeStringKDistantApart("mmpp", 2));
        System.out.println(rearrangeStringKDistantApart("Programming", 3));
        System.out.println(rearrangeStringKDistantApart("aab", 2));
        System.out.println(rearrangeStringKDistantApart("aappa", 3));
    }

    public static String rearrangeStringKDistantApart(String str, int k) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        // add characters to the max heap
        maxHeap.addAll(frequencyMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // append character to the result and decrement its count.
            result.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.add(currentEntry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    maxHeap.add(entry);
                }
            }
        }
        return result.length() == str.length() ? result.toString() : "";
    }

}
