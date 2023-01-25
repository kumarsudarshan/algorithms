package heap.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Frequency Sort (medium)
Given a string, sort it based on the decreasing frequency of its characters.
Input: "Programming"
Output: "rrggmmPiano"
Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
Input: "abcbab"
Output: "bbbaac"
Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.
 */
public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("Programming"));
        System.out.println(frequencySort("abcbab"));
    }

    public static String frequencySort(String str) {
        // find the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        // add all characters to the max heap
        maxHeap.addAll(frequencyMap.entrySet());

        // build a string, appending most occurring characters first
        StringBuilder sortedString = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(int i = 0; i< entry.getValue(); i++){
                sortedString.append(entry.getKey());
            }
        }
        return sortedString.toString();
    }
}
